package eval.business.domain;

public class Evaluation {

	private EvalGroup group;
	private Reviewer reviewer;
	private Product product;
	private int score;
	
	public Evaluation(EvalGroup group, Product product, Reviewer reviewer){
		this.group = group;
		this.product = product;
		this.reviewer = reviewer;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public boolean isDone() {
		if (score != null) {			
			return True;
		}
		else {
			return False;
		}
	}
}
