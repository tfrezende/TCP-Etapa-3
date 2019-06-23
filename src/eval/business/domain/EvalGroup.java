package eval.business.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import eval.business.BusinessException;
import eval.ui.UIUtils;

public class EvalGroup {
	
	private String name;
	private Map<Product, List<Evaluation>> evaluations;
	private List<Reviewer> members;
	private List<Product> products;
	private List<Product> acceptableProducts;
	private List<Product> notAcceptableProducts;
	private Collection<Integer> productIds;
	final double MIN_VALUE = 0.0;
	private List<Reviewer> allocatedReviewers;
	private List<Product> allocatedProducts;
		
	public EvalGroup(String name, Map<Product, List<Evaluation>> evaluations, List<Reviewer> members,
			List<Product> products) {
		this.name = name;
		this.evaluations = evaluations;
		this.members = members;
		this.products = products;
	}

	private List<Reviewer> getOrderedCandidates(Product product){
		List<Reviewer> orderedCandidates = this.members;
		Collections.sort(orderedCandidates, new SortByNumProds());
		
		return orderedCandidates;
	}
	
	public List<Product> getAcceptableProducts(){		
		for(Product prod : this.products) {
			if (prod.getAverageScore() >= MIN_VALUE) {
				acceptableProducts.add(prod);
			}			
		}	
		SortByScore sort = new SortByScore();
		Collections.sort(acceptableProducts, sort.reversed());
		
		return acceptableProducts;		
	}
	
	public List<Product> getNotAcceptableProducts(){
		for(Product prod : this.products) {
			if (prod.getAverageScore() < MIN_VALUE) {
				notAcceptableProducts.add(prod);
			}
		}
		Collections.sort(acceptableProducts, new SortByScore());
		
		return notAcceptableProducts;
	}	
	
	private void addEvaluation(Product product, Reviewer reviewer) {
		Evaluation eval = new Evaluation(this, product, reviewer);
		product.addEvaluation(eval);
		reviewer.addEvaluation(eval);
	}
	
	public void allocate(int numMembers) throws Exception {		
		List<Product> totalProducts = getProducts();
		
		int i = 0;
		
		System.out.println(UIUtils.INSTANCE.getTextManager().getText("allocation.start") + "/n");
		
		Reviewer admin = Login(this);
		
		while(i < numMembers) {
			Product currentProduct = getSmallestValue(totalProducts);
			
			while(!totalProducts.isEmpty()) {	
				List<Reviewer> candidates = getOrderedCandidates(currentProduct);
				for(Reviewer candidate : candidates) {
					if(!candidate.canEvaluate(currentProduct) || 
							candidate == admin || 
							candidate.getState() == admin.getState()) {
						candidates.remove(candidate);
					}
				}
				if(!candidates.isEmpty()) {
					addEvaluation(currentProduct, candidates.get(0));
					System.out.println("Produto id " + currentProduct.getId() +
							" alocado ao avaliador id " + candidates.get(0).getId());
					
					allocatedReviewers.add(candidates.get(0));
					allocatedProducts.add(totalProducts.get(0));
					candidates.remove(0);
				}
				totalProducts.remove(0);
			}
			i++;
		}
		System.out.println(UIUtils.INSTANCE.getTextManager().getText("allocation.end") + "/n");
		System.out.println(UIUtils.INSTANCE.getTextManager().getText("allocation.num.alloc") + "/n");
		
		for(int j = 0; j < allocatedReviewers.size(); j++) {
			System.out.println(allocatedProducts.get(j).getName() + " --> " +
					allocatedReviewers.get(j).getName());
		}
	}
	
	public boolean isAllocated() {
		if(getEvaluations().isEmpty()) {
			return false;
		}		
		return true;
	}
	
	public boolean isEvaluationDone() {
		boolean isDone = true;
		
		for(Product prod: products) {
			if (prod.isEvaluationDone() == false)
				isDone = false;
		}
		
		return isDone;
	}
	
	public Collection<List<Evaluation>> getEvaluations() {
		return this.evaluations.values();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Reviewer> getMembers() {
		return members;
	}

	public void setMembers(List<Reviewer> members) {
		this.members = members;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public void setEvaluations(Map<Product, List<Evaluation>> evaluations) {
		this.evaluations = evaluations;
	}

	class SortByScore implements Comparator<Product> {
		@Override
		public int compare(Product a, Product b) {
			
			return Double.compare(a.getAverageScore(), b.getAverageScore());
		}
	}
	
	class SortByNumProds implements Comparator<Reviewer>{

		@Override
		public int compare(Reviewer a, Reviewer b) {
			int result = a.getEvaluations().size() - b.getEvaluations().size();
			
			if (result == 0) {
				result = a.getId() - b.getId();
			}
			return result;
		}
		
	}
	
	public Reviewer Login(EvalGroup group) throws Exception{
		List<Reviewer> members = group.getMembers();
		String name = UIUtils.INSTANCE.readString("message.ask.admin");
		
		for(Reviewer member : members) {
			if(member.getName() == name) {
				return member;
			}
		}
		
		throw new BusinessException("exception.invalid.admin");		
	}
	
	public Product getSmallestValue(List<Product> products) {
		productIds = null;
		Product product = null;
		
		for(Product prod : products) {
			productIds.add(prod.getId());
		}
		Integer id = Collections.min(productIds);
		
		for(Product prod : products) {
			if(prod.getId() == id)
				product = prod;
		}
		return product;
	}
}
