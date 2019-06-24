package eval.business.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {

	private String name;
	private int id;
	private EvalGroup group;
	private Reviewer requester;
	private ProductCategory category;
	private Map<Reviewer, Evaluation> evaluations = new HashMap<Reviewer, Evaluation>();

	public Product(String name, int id, ProductCategory category, Reviewer requester) {
		this.name = name;
		this.id = id;
		this.category = category;
		this.requester = requester;
		evaluations.put(requester, null);
	}
	
	public Reviewer getRequester() {
		return requester;
	}

	public void setRequester(Reviewer requester) {
		this.requester = requester;
	}

	public boolean containsReviewer(Reviewer reviewer){
		if(evaluations.containsKey(reviewer)) {
			return true;
		}
		return false;
	}
	
	public void addEvaluation(Evaluation evaluation) {		
		evaluations.put(evaluation.getReviewer(), evaluation);		
	}
	
	public void addScore(Reviewer reviewer, int score) {
		Evaluation eval = evaluations.get(reviewer);
		eval.setScore(score);
		addEvaluation(eval);
	}
	
	public double getAverageScore() {
		List<Integer> scores = new ArrayList<>();		
		double sum = 0.0;
		
		scores = getScores();
		
		for(int score : scores) {
			sum += score;
		}
		
		return sum / scores.size();
	}
	
	public List<Reviewer> getReviewers() {
		List<Reviewer> reviewers = new ArrayList<>();
		
		for(Reviewer reviewer : evaluations.keySet()) {
			reviewers.add(reviewer);
		}

		return reviewers;
	}
	
	public boolean isAcceptable() {
		final double limitValue = 0.0;
		
		if(getAverageScore() < limitValue) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean isEvaluationDone() {		
		List<Evaluation> evals = (List<Evaluation>) getEvaluations();
		boolean isDone = true;
		
		for (Evaluation eval: evals) {
			if (eval.isDone() == false)
				isDone = false;
		}
		return isDone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EvalGroup getGroup() {
		return group;
	}

	public void setGroup(EvalGroup group) {
		this.group = group;
	}

	
	public Collection<Evaluation> getEvaluations() {
		return this.evaluations.values();
	}
	
	public List<Integer> getScores(){
		Collection<Evaluation> evals = new ArrayList<>();
		evals = getEvaluations();
		List<Integer> scores = new ArrayList<>();
		
		for(Evaluation eval : evals) {
			scores.add(eval.getScore());
			
		}
		return scores;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

}

	
	
