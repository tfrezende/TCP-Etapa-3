package eval.business.domain;

public class EvalGroup {
	
	private String name;
	private Map<Product, List<Evaluation>> evaluations;
	
	private void addEvaluation(Product product, Reviewer reviewer) {
		
	}
	
	private List<Reviewer> getOrderedCandidates(Product product){
		
	}
	
	private List<Product> getOrderedProducts(){
		
	}
	
	public List<Product> getAcceptableProducts(){
		
	}
	
	public List<Product> getNotAcceptableProducts(){
		
	}	
	
	public void allocate(int numMembers) {
		
	}
	
	public boolean isAllocated() {
		
	}
	
	public boolean isEvaluationDone() {
		
	}
}
