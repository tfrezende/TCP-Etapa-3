package eval.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eval.business.domain.EvalGroup;
import eval.business.domain.Product;
import eval.business.domain.ProductCategory;
import eval.business.domain.Reviewer;

public class Database {
	
	private Map<String, EvalGroup> groups;
	private Map<Integer, Product> products;
	
	public Database() {
		this(true);
	}
	
	public Database(boolean initData) {
		this.groups = new HashMap<>();
		this.products = new HashMap<>();
		if(initData) {
			initData();
		}
	}
	
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
	
	void initData() {
		// Categories
		List<ProductCategory> categories = new ArrayList<>();
		categories.add(new ProductCategory("BB Cream"));
		categories.add(new ProductCategory("CC Cream"));
		categories.add(new ProductCategory("DD Cream"));
		categories.add(new ProductCategory("Powder Sunscreen"));
		categories.add(new ProductCategory("Foundation+SPF"));
		categories.add(new ProductCategory("Oil Free Matte SPF"));
		
		// Reviewers
		List<Reviewer> reviewers = new ArrayList<>();		
		List<ProductCategory> cat1 = new ArrayList<>();
		List<ProductCategory> cat2 = new ArrayList<>();
		List<ProductCategory> cat3 = new ArrayList<>();
		List<ProductCategory> cat4 = new ArrayList<>();
		List<ProductCategory> cat5 = new ArrayList<>();
		List<ProductCategory> cat6 = new ArrayList<>();
		List<ProductCategory> cat7 = new ArrayList<>();
		List<ProductCategory> cat8 = new ArrayList<>();
		List<ProductCategory> cat9 = new ArrayList<>();
		List<ProductCategory> cat10 = new ArrayList<>();
		
		cat1.add(categories.get(0));
		cat1.add(categories.get(1));
		cat1.add(categories.get(2));
		
		reviewers.add(new Reviewer("João", "RS", 1, cat1));
		
		cat2.add(categories.get(4));
		cat2.add(categories.get(1));
		cat2.add(categories.get(2));
		
		reviewers.add(new Reviewer("Ana", "SP", 2, cat2));
		
		cat3.add(categories.get(0));
		cat3.add(categories.get(5));
		
		reviewers.add(new Reviewer("Manoela", "RS", 3, cat3));
		
		cat4.add(categories.get(0));
		cat4.add(categories.get(1));
		cat4.add(categories.get(3));
		cat4.add(categories.get(4));
		
		reviewers.add(new Reviewer("Joana", "CE", 4, cat4));
		
		cat5.add(categories.get(2));
		cat5.add(categories.get(4));
		cat5.add(categories.get(5));
		
		reviewers.add(new Reviewer("Miguel", "RS", 5, cat5));
		
		cat6.add(categories.get(1));
		cat6.add(categories.get(3));
		cat6.add(categories.get(5));
		
		
		reviewers.add(new Reviewer("Beatriz", "RS", 6, cat6));
		
		cat7.add(categories.get(1));
		cat7.add(categories.get(2));
		cat7.add(categories.get(3));
		
		reviewers.add(new Reviewer("Suzana", "RS", 7, cat7));
		
		cat8.add(categories.get(0));
		cat8.add(categories.get(1));
		cat8.add(categories.get(2));
		
		reviewers.add(new Reviewer("Natasha", "CE", 8, cat8));
		
		cat9.add(categories.get(3));
		cat9.add(categories.get(4));
		
		reviewers.add(new Reviewer("Pedro", "SP", 9, cat9));
		
		cat10.add(categories.get(1));
		cat10.add(categories.get(2));
		cat10.add(categories.get(5));
		
		reviewers.add(new Reviewer("Carla", "SP", 10, cat10));
						
		// Products
		List<Product> prods = new ArrayList<>();
		prods.add(new Product("L’oreal DD Cream", 1, categories.get(2), 
				reviewers.get(0)));
		prods.add(new Product("Avon CC Cream", 2, categories.get(1), 
				reviewers.get(5)));
		prods.add(new Product("Revolution Powder Sunscreeen", 3, categories.get(3), 
				reviewers.get(6)));
		prods.add(new Product("Maybelline BB Cream ", 4, categories.get(0),
				reviewers.get(7)));
		prods.add(new Product("Revlon Foundation+SPF20", 5, categories.get(4),
				reviewers.get(8)));
		prods.add(new Product("Nivea Matte Face SPF", 6, categories.get(5),
				reviewers.get(9)));
		prods.add(new Product("La Roche CC Cream", 7, categories.get(1),
				reviewers.get(5)));
		prods.add(new Product("Yves Rocher Powder+SPF15", 8, categories.get(3),
				reviewers.get(6)));
		prods.add(new Product("Nivea BB Cream", 9, categories.get(0),
				reviewers.get(7)));
		prods.add(new Product("Base O Boticário SPF20", 10, categories.get(4),
				reviewers.get(8)));
		prods.add(new Product("Natura SPF20 Rosto Matte", 11, categories.get(5),
				reviewers.get(9)));
		
		// Groups
		List<EvalGroup> evalGroups = new ArrayList<>();
		List<Reviewer> members1 = new ArrayList<>();
		members1.add(reviewers.get(0));
		members1.add(reviewers.get(1));
		members1.add(reviewers.get(2));
		members1.add(reviewers.get(3));
		members1.add(reviewers.get(4));
		members1.add(reviewers.get(5));
		members1.add(reviewers.get(6));		
		evalGroups.add(new EvalGroup("SPF A", members1, prods));
		
		List<Reviewer> members2 = new ArrayList<>();
		members2.add(reviewers.get(0));
		members2.add(reviewers.get(1));
		members2.add(reviewers.get(2));
		members2.add(reviewers.get(3));
		members2.add(reviewers.get(4));
		members2.add(reviewers.get(5));
		members2.add(reviewers.get(6));
		evalGroups.add(new EvalGroup("SPF B", members2, prods));
		
		List<Reviewer> members3 = new ArrayList<>();
		members3.add(reviewers.get(3));
		members3.add(reviewers.get(4));
		members3.add(reviewers.get(5));
		members3.add(reviewers.get(6));
		members3.add(reviewers.get(7));
		members3.add(reviewers.get(8));
		members3.add(reviewers.get(9));
		evalGroups.add(new EvalGroup("SPF C", members3, prods));
		
		for (Product prod : prods) {
			this.products.put(prod.getId(), prod);
		}
		
		for (EvalGroup group : evalGroups) {
			this.groups.put(group.getName(), group);
		}
		
		//Falta adicionar os evaluations
		
		
	}
	
}

