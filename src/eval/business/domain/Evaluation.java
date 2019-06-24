package eval.business.domain;

public class Evaluation {

	private EvalGroup group;
	private Reviewer reviewer;
	private Product product;
	private int score;
	private boolean done = false;
	
	public Evaluation(EvalGroup group, Product product, Reviewer reviewer){
		this.setGroup(group);
		this.setProduct(product);
		this.setReviewer(reviewer);
		
	}public Evaluation(EvalGroup group, Product product, Reviewer reviewer, int score){
		this.setGroup(group);
		this.setProduct(product);
		this.setReviewer(reviewer);
		this.score = score;
	}
	
	public Evaluation(Product product, Reviewer reviewer){
		this.setProduct(product);
		this.setReviewer(reviewer);
	}
	
	public void setScore(int score) {
		this.score = score;
		this.done = true;
	}
	
	public int getScore() {
		return score;
	}

	public boolean isDone() {
		return done;
	}

	public EvalGroup getGroup() {
		return group;
	}

	public void setGroup(EvalGroup group) {
		this.group = group;
	}

	public Reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
