package eval.business.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import eval.ui.UIUtils;

public class EvalGroup {
	
	private String name;
	private Map<Product, List<Evaluation>> evaluations;
	private List<Reviewer> members = new ArrayList<>();
	private List<Product> products = new ArrayList<>();
	private List<Product> acceptableProducts = new ArrayList<>();
	private List<Product> notAcceptableProducts = new ArrayList<>();
	private final double MIN_VALUE = 0.0;
	private List<Reviewer> allocatedReviewers = new ArrayList<>();
	private List<Product> allocatedProducts = new ArrayList<>();
	
	public List<Product> getAllocatedProducts(){
		return this.allocatedProducts;
	}
	
	public EvalGroup(String name, List<Reviewer> members,
			List<Product> products) {
		this.name = name;
		this.members = members;
		this.products = products;
	}

	private List<Reviewer> getOrderedCandidates(Product product){
		List<Reviewer> orderedCandidates = this.members;
		
		Collections.sort(orderedCandidates, new SortByNumProds());
		
		return orderedCandidates;
	}
	
	public List<Evaluation> getEvaluationsByProduct(Product product){
		return this.evaluations.get(product);
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
	
	private  void addEvaluation(Product product, Reviewer reviewer) {
		Evaluation eval = new Evaluation(this, product, reviewer);
		product.addEvaluation(eval);
		reviewer.addEvaluation(eval);
		List<Evaluation> evals = this.evaluations.get(product);
		evals.add(eval);
		this.evaluations.put(product, evals);
	}
	
	public void allocate(int numMembers) throws Exception {		
		List<Product> totalProducts = getProducts();
		
		int i = 0;
		int k = 0;
		
		System.out.println(UIUtils.INSTANCE.getTextManager().getText("allocation.start") + "\n");
		
		while(i < numMembers) {
			Product currentProduct = getSmallestValue(totalProducts);
			
			if(currentProduct != null) {
			
				while(!totalProducts.isEmpty()) {	
					List<Reviewer> candidates = new ArrayList<>();
					candidates = getOrderedCandidates(currentProduct);
					
					for(k = 0; k < candidates.size(); k++) {
						Reviewer candidate = candidates.get(k);
						if(!candidate.canEvaluate(currentProduct)) {
							candidates.remove(k);
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
			}
			i++;
		}
		System.out.println(UIUtils.INSTANCE.getTextManager().getText("allocation.end") + "\n");
		System.out.println(UIUtils.INSTANCE.getTextManager().getText("allocation.num.alloc") + "\n");
		
		for(int j = 0; j < allocatedReviewers.size(); j++) {
			System.out.println(allocatedProducts.get(j).getName() + " --> " +
					allocatedReviewers.get(j).getName());
		}
	}
	
	public boolean isAllocated() {
		if(this.allocatedProducts.isEmpty()) {
			return false;
		}		
		return true;
	}
	
	public boolean isEvaluationDone() {
		boolean isDone = true;
			
		for(Product prod: products) {
			List<Evaluation> evals = evaluations.get(prod);
				
			for(Evaluation eval : evals) {
				if (eval.isDone() == false) {
					return false;
				}
			}				
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
	
	public Product getSmallestValue(List<Product> products) {
		List<Integer> productIds = new ArrayList<>();
		Collection<Integer> ids = new ArrayList<>();
		Product product = new Product(name, 0, null, null, null);
		if (products.isEmpty()) {
			return null;
		}
		for(Product prod : products) {
			productIds.add(prod.getId());
		}
		ids.addAll(productIds);
		Integer id = Collections.min(ids);
				
		
		for(Product prod : products) {
			if(prod.getId() == id)
				product = prod;
		}
		return product;
	}

	public void setAllocatedReviewers(List<Reviewer> allocatedReviewers) {
		this.allocatedReviewers = allocatedReviewers;
	}

	public void setAllocatedProducts(List<Product> allocatedProducts) {
		this.allocatedProducts = allocatedProducts;
	}
	
	
}
