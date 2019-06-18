package eval.ui.command;

import eval.business.OperationService;
import eval.business.domain.EvalGroup;
import eval.ui.CatalogueInterface;

public class AllocateCommand extends Command {

	private final OperationService operationService;
	
	EvalGroup evalGroup;

	public AllocateCommand(CatalogueInterface catalogueInterface,
			OperationService operationService) {
		super(catalogueInterface);
		this.operationService = operationService;
	}

	@Override
	public void execute() throws Exception {
		if (!evalGroup.isAllocated()) {
			
		}
	}
}
