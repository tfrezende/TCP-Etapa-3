package eval.ui.command;

import java.util.List;

import eval.business.BusinessException;
import eval.business.domain.EvalGroup;
import eval.business.domain.Product;
import eval.data.Database;
import eval.ui.CatalogueInterface;
import eval.ui.UIUtils;

public class AllocateCommand extends Command {
	
	private EvalGroup evalGroup;

	public AllocateCommand(CatalogueInterface catalogueInterface, Database database) {
		super(catalogueInterface, database);
	}

	@Override
	public void execute() throws Exception {
		
		String group = UIUtils.INSTANCE.readString("message.ask.group");
		evalGroup = database.getGroup(group);
		
		Integer numReviewers = UIUtils.INSTANCE.readInteger("message.ask.num.evaluators");
		
		if (!evalGroup.isAllocated()) {
			throw new BusinessException("exception.allocated.group");
		}
		else {
			List<Product> totalProducts = evalGroup.getProducts();
			
		}
	}
}
