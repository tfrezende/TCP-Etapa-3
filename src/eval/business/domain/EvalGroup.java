package eval.business.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class EvalGroup {
	
	private String name;
	private Map<Product, List<Evaluation>> evaluations;
	private List<Reviewer> members;
	private List<Product> products;
	
	private List<Reviewer> getOrderedCandidates(Product product){
		List<Reviewer> orderedCandidates = this.members;
		// a fazer
	}	
	
	private List<Product> getOrderedProducts(){
		List<Product> orderedProducts = this.products;
		// a fazer
	}
	
	public List<Product> getAcceptableProducts(){
		List<Product> acceptableProducts;
		// a fazer
		return acceptableProducts;
		
	}
	
	public List<Product> getNotAcceptableProducts(){
		List<Product> notAcceptableProducts;		
		// a fazer
		return notAcceptableProducts;
	}	
	
	private void addEvaluation(Product product, Reviewer reviewer) {
		Evaluation eval = new Evaluation(this, product, reviewer);
	}
	
	public void allocate(int numMembers) {
		
	}
	
	public boolean isAllocated() {
		
	}
	
	public boolean isEvaluationDone() {
		
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

	public Map<Product, List<Evaluation>> getEvaluations() {
		return evaluations;
	}



	public void setEvaluations(Map<Product, List<Evaluation>> evaluations) {
		this.evaluations = evaluations;
	}
}
