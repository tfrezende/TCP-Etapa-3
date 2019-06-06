package eval.business.domain;

public class Reviewer {
	
	private String name;
	private String state;
	private int id;
	private Map<Reviewer, List<Evaluation>> evaluations;
	private List<ProductCategory> productCategory;
	
	public void addEvaluation(Evaluation evaluation) {
		
	}
	
	public boolean canEvaluate(Product product) {
		
	}
}
