package eval.data;

import java.util.Collection;
import java.util.Map;

import eval.business.domain.EvalGroup;
import eval.business.domain.Product;

public class Database {
	
	private Map<String, EvalGroup> groups;
	private Map<Integer, Product> products;
	
	public EvalGroup getGroup(String name) {
		return groups.get(name);
	}
	
	public Product getProductById(Integer id) {
		return products.get(id);
	}
	
	public Collection<EvalGroup> getAllGroups() {
		return this.groups.values();
	}
	
	public Collection<Product> getAllProducts() {
		return this.products.values();
	}
		
}

