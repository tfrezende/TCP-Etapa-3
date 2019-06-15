package eval.business.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Product {

	private String name;
	private int id;
	private EvalGroup group;
	private ProductCategory category;
	private Map<Reviewer, List<Evaluation>> evaluations;

	public Product(String name, int id, EvalGroup group, ProductCategory category) {
		this.name = name;
		this.id = id;
		this.group = group;
		this.category = category;
	}
	
	public void addEvaluation(Evaluation evaluation) {
		
	}
	
	public void addScore(Reviewer reviewer, int score) {
		
	}
	
	public double getAverageScore() {
		
	}
	
	public boolean isAcceptable() {
		// a fazer
		return false;
	}
	
	public boolean isEvaluationDone() {
		// a fazer
		return false;
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

	public Map<Reviewer, List<Evaluation>> getEvaluations() {
		return evaluations;
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

	
	
