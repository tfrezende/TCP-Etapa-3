package eval.business.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Reviewer {
	
	private String name;
	private String state;
	private int id;
	private Map<Reviewer, List<Evaluation>> evaluations;
	private List<ProductCategory> categories;
	private List<EvalGroup> groups;
	
	public void addEvaluation(Evaluation evaluation) {
		Reviewer reviewer = evaluation.getReviewer();
		List<Evaluation> eval = evaluations.get(reviewer);
		
		eval.add(evaluation);
		
		evaluations.put(reviewer, eval);
	}
	
	public boolean canEvaluate(Product product) {
		List<Reviewer> reviewers = product.getReviewers();
		
		for(Reviewer reviewer : reviewers) {
			if (this == reviewer) {
				return true;
			}
		} // ainda não finalizada
		
		return false;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
