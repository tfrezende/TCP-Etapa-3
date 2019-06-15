package eval.business.domain;

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
		
	}
	
	public boolean canEvaluate(Product product) {
		// a fazer
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

	public Map<Reviewer, List<Evaluation>> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Map<Reviewer, List<Evaluation>> evaluations) {
		this.evaluations = evaluations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
