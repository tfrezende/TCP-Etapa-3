package eval.business.domain;

public class EvalGroup {
	
	private String name;
	private Map<Product, List<Evaluation>> evaluations;
	private List<Reviewer> members;
	private List<Product> products;
	
	class SortProductsById implements Comparator<Product>{
		
	}
	
	class SortCandidatesByProducts implements Comparator<Reviewer>{
		
	}	
	
	private List<Reviewer> getOrderedCandidates(Product product){
		List<Reviewer> orderedCandidates = this.members;
		// a fazer
	}
	
	
	
	private List<Product> getOrderedProducts(){
		List<Product> orderedProducts = this.products;
		// a fazer
	}
	
	public List<Product> getAcceptableProducts(){
		
	}
	
	public List<Product> getNotAcceptableProducts(){
		
	}	
	
	private void addEvaluation(Product product, Reviewer reviewer) {
		
	}
	
	public void allocate(int numMembers) {
		
	}
	
	public boolean isAllocated() {
		
	}
	
	public boolean isEvaluationDone() {
		
	}
}
