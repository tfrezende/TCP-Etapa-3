package eval.ui.command;

import eval.business.OperationService;
import eval.ui.CatalogueInterface;

public class AllocateCommand extends Command {

	private final OperationService operationService;

	public AllocateCommand(CatalogueInterface catalogueInterface,
			OperationService operationService) {
		super(catalogueInterface);
		this.operationService = operationService;
	}

	@Override
	public void execute() throws Exception {
		
	}
}
