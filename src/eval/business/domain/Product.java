package eval.business.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Product {

	private String name;
	private int id;
	private EvalGroup group;
	private ProductCategory category;
	private Map<Reviewer, List<Evaluation>> evaluations;
	private boolean isDone = false;

	public Product(String name, int id, EvalGroup group, ProductCategory category) {
		this.name = name;
		this.id = id;
		this.group = group;
		this.category = category;
	}
	
	public void addEvaluation(Evaluation evaluation) {
		//List<Evaluation> evalList;		
		//evalList.add(evaluation);
		this.isDone = true;
	}
	
	public void addScore(Reviewer reviewer, int score) {
		List<Evaluation> evalList = evaluations.get(reviewer);		
		Evaluation eval = new Evaluation(group, this, reviewer);
		
		evalList.add(eval);
		evaluations.put(reviewer, evalList);
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
		if (!isDone) {
			return false;
		}
		else {
			return true;
		}
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

	public Collection<List<Evaluation>> getEvaluations() {
		return this.evaluations.values();
	}
	
	public List<Reviewer> getReviewers() {
		List<Reviewer> reviewers = new ArrayList<>();
		
		for(Reviewer eval : evaluations.keySet()) {
			reviewers.add(eval);
		}
		
		return reviewers;
	}
	
	public List<Integer> getScores(){
		Collection<List<Evaluation>> evals = new ArrayList<>();
		List<Integer> scores = new ArrayList<>();
		
		evals = getEvaluations();
		
		for(List<Evaluation> eval : evals) {
			for(Evaluation evaluation : eval) {
				scores.add(evaluation.getScore());
			}
		}
		return scores;
	}

	public void setEvaluations(Map<Reviewer, List<Evaluation>> evaluations) {
		this.evaluations = evaluations;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

}

	
	
