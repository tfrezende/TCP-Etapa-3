package eval.business.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reviewer {
	
	private String name;
	private String state;
	private int id;
	private Map<EvalGroup, List<Evaluation>> evaluations = 
			new HashMap<EvalGroup, List<Evaluation>>();
	private List<ProductCategory> categories = new ArrayList<ProductCategory>();
	private List<EvalGroup> groups = new ArrayList<EvalGroup>();
	
	public Reviewer(String name, String state, int id, List<ProductCategory> categories) {
		this.name = name;
		this.state = state;
		this.id = id;
		this.categories = categories;
	}
	
	public void addEvaluation(Evaluation evaluation) {
		EvalGroup group = evaluation.getGroup();
		List<Evaluation> eval = new ArrayList<>();
				
		eval = evaluation.getGroup().getEvaluationsByProduct(evaluation.getProduct());
		
		eval.add(evaluation);
		
		evaluations.put(group, eval);
	}

	public void setEvaluations(Map<EvalGroup, List<Evaluation>> evaluations) {
		this.evaluations = evaluations;
	}
	

	public List<ProductCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ProductCategory> categories) {
		this.categories = categories;
	}

	public List<EvalGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<EvalGroup> groups) {
		this.groups = groups;
	}

	public boolean canEvaluate(Product product) {
				
		for(ProductCategory category : categories) {
			if (product.getRequester() == this || category != product.getCategory()
					|| product.getRequester().getState() == this.getState()){
				return false;
			}
		}		
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
	
	public Collection<List<Evaluation>> getEvaluations() {
		return this.evaluations.values();
	}
}
