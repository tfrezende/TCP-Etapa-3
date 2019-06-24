package eval.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import eval.business.domain.EvalGroup;
import eval.business.domain.Evaluation;
import eval.business.domain.Product;
import eval.business.domain.ProductCategory;
import eval.business.domain.Reviewer;

public class Database {
	
	private Map<String, EvalGroup> groups;
	private List<EvalGroup> grps;
	private List<Product> products;
	private final Log log;
	
	public Database() {
		this(true);
	}
	
	public Database(boolean initData) {
		this.log = LogFactory.getLog(getClass());
		this.groups = new HashMap<>();
		this.products = new ArrayList<>();
		this.grps = new ArrayList<>();
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
	
	public List<Product> getAllProducts() {
		return this.products;
	}
	
	public void initData() {
		try {
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
			
			initReviewers(reviewers, evalGroups);
			
			prods = initProducts(categories, reviewers, evalGroups);
			
			
			// Allocation
			List<Product> allocatedProducts1 = new ArrayList<>();
			allocatedProducts1.add(prods.get(2));
			allocatedProducts1.add(prods.get(3));
			allocatedProducts1.add(prods.get(4));
			allocatedProducts1.add(prods.get(5));		
			evalGroups.get(1).setAllocatedProducts(allocatedProducts1);
			
			List<Product> allocatedProducts2 = new ArrayList<>();
			allocatedProducts2.add(prods.get(0));		
			evalGroups.get(2).setAllocatedProducts(allocatedProducts2);
			
			// Evaluations
			initEvaluations(prods, reviewers, evalGroups);
			
			
			// Maps
			for (Product prod : prods) {
				products.add(prod);
			}		
			for(EvalGroup group : evalGroups) {
				grps.add(group);
				groups.put(group.getName(), group);
			}
					
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
	}
		
		
	}
	
	private List<Product> initProducts(List<ProductCategory> categories, 
			List<Reviewer> reviewers, List<EvalGroup> groups){
		List<Product> prods = new ArrayList<>();
		
		prods.add(new Product("L’oreal DD Cream", 1, categories.get(2), 
				groups.get(2), reviewers.get(0)));
		prods.add(new Product("Avon CC Cream", 2, categories.get(1), 
				groups.get(1), reviewers.get(5)));
		prods.add(new Product("Revolution Powder Sunscreeen", 3, categories.get(3), 
				groups.get(1), reviewers.get(6)));
		prods.add(new Product("Maybelline BB Cream ", 4, categories.get(0),
				groups.get(1), reviewers.get(7)));
		prods.add(new Product("Revlon Foundation+SPF20", 5, categories.get(4),
				groups.get(1), reviewers.get(8)));
		prods.add(new Product("Nivea Matte Face SPF", 6, categories.get(5),
				groups.get(1), reviewers.get(9)));
		prods.add(new Product("La Roche CC Cream", 7, categories.get(1),
				groups.get(0), reviewers.get(5)));
		prods.add(new Product("Yves Rocher Powder+SPF15", 8, categories.get(3),
				groups.get(0), reviewers.get(6)));
		prods.add(new Product("Nivea BB Cream", 9, categories.get(0),
				groups.get(0), reviewers.get(7)));
		prods.add(new Product("Base O Boticário SPF20", 10, categories.get(4),
				groups.get(0), reviewers.get(8)));
		prods.add(new Product("Natura SPF20 Rosto Matte", 11, categories.get(5),
				groups.get(0), reviewers.get(9)));
			
		return prods;
	}
	
	private void initEvaluations(List<Product> prods, List<Reviewer> reviewers,
			List<EvalGroup> group) {		
		
		Evaluation eval = new Evaluation(prods.get(0).getGroup(), prods.get(0), 
				reviewers.get(7));		
		prods.get(0).addEvaluation(eval);
		reviewers.get(7).addEvaluation(eval);
		
		eval = new Evaluation(prods.get(0).getGroup(), prods.get(0), 
				reviewers.get(7));
		prods.get(0).addEvaluation(eval);
		
		eval = new Evaluation(prods.get(1).getGroup(), prods.get(1), reviewers.get(6));
		prods.get(1).addEvaluation(eval);
		reviewers.get(6).addEvaluation(eval);
		prods.get(1).addScore(reviewers.get(6), 2);		
		
		eval = new Evaluation(prods.get(1).getGroup(), prods.get(1), reviewers.get(1));
		prods.get(1).addEvaluation(eval);
		reviewers.get(1).addEvaluation(eval);
		prods.get(1).addScore(reviewers.get(1), 3);
		
		eval = new Evaluation(prods.get(2).getGroup(),prods.get(2), reviewers.get(3));
		prods.get(2).addEvaluation(eval);
		reviewers.get(3).addEvaluation(eval);
		prods.get(2).addScore(reviewers.get(3), -1);	
		
		eval = new Evaluation(prods.get(2).getGroup(), prods.get(2), reviewers.get(5));
		prods.get(2).addEvaluation(eval);
		reviewers.get(5).addEvaluation(eval);
		prods.get(2).addScore(reviewers.get(5), 1);
		
		eval = new Evaluation(prods.get(3).getGroup(), prods.get(3), reviewers.get(0));
		prods.get(3).addEvaluation(eval);
		reviewers.get(5).addEvaluation(eval);
		prods.get(3).addScore(reviewers.get(0), 1);		
		
		eval = new Evaluation(prods.get(3).getGroup(), prods.get(3), reviewers.get(2));
		prods.get(3).addEvaluation(eval);
		reviewers.get(2).addEvaluation(eval);
		prods.get(3).addScore(reviewers.get(2), 0);
		
		eval = new Evaluation(prods.get(4).getGroup(), prods.get(4), reviewers.get(3));
		prods.get(4).addEvaluation(eval);
		reviewers.get(3).addEvaluation(eval);
		prods.get(4).addScore(reviewers.get(3), -3);
		
		eval = new Evaluation(prods.get(4).getGroup(), prods.get(4), reviewers.get(4));
		prods.get(4).addEvaluation(eval);
		reviewers.get(4).addEvaluation(eval);
		prods.get(4).addScore(reviewers.get(4), -3);
		
		eval = new Evaluation(prods.get(5).getGroup(), prods.get(5), reviewers.get(2));
		prods.get(5).addEvaluation(eval);
		reviewers.get(2).addEvaluation(eval);
		prods.get(5).addScore(reviewers.get(2), -1);	
		
		eval = new Evaluation(prods.get(5).getGroup(), prods.get(5), reviewers.get(5));
		prods.get(5).addEvaluation(eval);
		reviewers.get(5).addEvaluation(eval);
		prods.get(5).addScore(reviewers.get(5), 0);
		
		for(EvalGroup gp : group) {
			Map<Product, List<Evaluation>> evaluations = 
					new HashMap<Product, List<Evaluation>>();
			Collection<Evaluation> evals = new ArrayList<>();
			List<Evaluation> e = new ArrayList<>();
			List<Product> p = new ArrayList<>();
			
			for(Product product : prods) {
				if(product.getGroup() == gp) {
					evals = product.getEvaluations();
					e.addAll(evals);
					evaluations.put(product, e);
					p.add(product);
				}				
			}
			
			gp.setEvaluations(evaluations);
			gp.setProducts(p);
		}
	}
	
	private void initReviewers(List<Reviewer> reviewers, List<EvalGroup> groups) {
		List<EvalGroup> group123 = new ArrayList<>();
		List<EvalGroup> group4567= new ArrayList<>();
		List<EvalGroup> group8910 = new ArrayList<>();

		
		group123.add(groups.get(0));
		group123.add(groups.get(1));
		
		group4567.add(groups.get(0));
		group4567.add(groups.get(1));
		group4567.add(groups.get(2));
		
		group8910.add(groups.get(2));
		
		
		reviewers.get(0).setGroups(group123);
		reviewers.get(1).setGroups(group123);
		reviewers.get(2).setGroups(group123);
		reviewers.get(3).setGroups(group123);
		
		reviewers.get(4).setGroups(group4567);
		reviewers.get(5).setGroups(group4567);
		reviewers.get(6).setGroups(group4567);
		
		reviewers.get(7).setGroups(group8910);
		reviewers.get(8).setGroups(group8910);
		reviewers.get(9).setGroups(group8910);
		
		for(Reviewer rev : reviewers) {
			Map<EvalGroup, List<Evaluation>> evaluations = new HashMap<>();
			for(EvalGroup gp : rev.getGroups()) {
				evaluations.put(gp, new ArrayList<Evaluation>());
			}
			rev.setEvaluations(evaluations);
		}
		
		
		
	}
	
}

