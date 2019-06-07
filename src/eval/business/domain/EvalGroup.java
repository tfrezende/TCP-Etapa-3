package eval.business.domain;
 // vamo inter
public class EvalGroup {
	
	private String name;
	private Map<Product, List<Evaluation>> evaluations;
	private List<Reviewer> members;
	private List<Product> products;
	
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
