package eval.business.domain;

public class Evaluation {

	private EvalGroup group;
	private Reviewer reviewer;
	private Product product;
	private int score;
	
	public Evaluation(EvalGroup group, Product product, Reviewer reviewer){
		this.setGroup(group);
		this.setProduct(product);
		this.setReviewer(reviewer);
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public boolean isDone() {
		final int NOT_INITIALIZED = 0;
		if (this.score != NOT_INITIALIZED) {			
			return true;
		}
		else {
			return false;
		}
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
