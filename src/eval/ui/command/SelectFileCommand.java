package eval.ui.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import eval.business.BusinessException;
import eval.business.domain.EvalGroup;
import eval.business.domain.Product;
import eval.data.Database;
import eval.ui.CatalogueInterface;
import eval.ui.UIUtils;

public class SelectFileCommand extends Command {
	private List<EvalGroup> groups = new ArrayList<>();;

	public SelectFileCommand(CatalogueInterface catalogueInterface, Database database) {
		super(catalogueInterface, database);
	}

	@Override
	public void execute() throws Exception {
		Collection<EvalGroup> grp = new ArrayList<>();
		grp = database.getAllGroups();		
		groups.addAll(grp);
		
		List<Product> acceptableProducts;
		List<Product> notAcceptableProducts;
		
		System.out.println("\n" + UIUtils.INSTANCE.getTextManager().getText("menu.products.selection"));
		
		System.out.println("--- Grupos registrados ---");		
		for(EvalGroup group : groups) {
			System.out.println(group.getName());
		}
		
		String groupName = UIUtils.INSTANCE.readString("message.ask.group");
		database.getGroup(groupName);
		
		EvalGroup evalGroup = database.getGroup(groupName);
		if(evalGroup == null) {
			throw new BusinessException("exception.group.not.found");
		}
				
		if (!isGroupValid(evalGroup)) {
			throw new BusinessException("exception.invalid.group");
		}
		else {
			acceptableProducts = evalGroup.getAcceptableProducts();
			notAcceptableProducts = evalGroup.getNotAcceptableProducts();
			
			System.out.println(UIUtils.INSTANCE.getTextManager().getText("selection.acceptable.quality"));			
			printProducts(acceptableProducts);
			
			System.out.println(UIUtils.INSTANCE.getTextManager().getText("selection.unacceptable.quality"));
			printProducts(notAcceptableProducts);
		}
		
	}
	
	public boolean isGroupValid(EvalGroup group) {		
		return (group.isAllocated() && group.isEvaluationDone());
	}
	
	public void printProducts(List<Product> list) {
		System.out.println("ID\tNOME\t\t\tNOTA MÉDIA");	
		for(Product element : list) {
			System.out.println(element.getId() + "\t" + element.getName() + "\t" +
			element.getAverageScore());
		}
	}
}
