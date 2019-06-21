package eval.ui.command;

import eval.business.BusinessException;
import eval.business.domain.EvalGroup;
import eval.ui.CatalogueInterface;

public class AllocateCommand extends Command {
	
	EvalGroup evalGroup;

	public AllocateCommand(CatalogueInterface catalogueInterface) {
		super(catalogueInterface);;
	}

	@Override
	public void execute() throws Exception {
		if (!evalGroup.isAllocated()) {
			throw new BusinessException("exception.already.allocated");
		}
		else {
			
		}
	}
}
