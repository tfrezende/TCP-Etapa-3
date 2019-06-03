package eval.ui.command;

import eval.business.OperationService;
import eval.ui.CatalogueInterface;

public class IncludeCommand extends Command {

	private final OperationService operationService;

	public IncludeCommand(CatalogueInterface catalogueInterface,
			OperationService operationService) {
		super(catalogueInterface);
		this.operationService = operationService;
	}

	@Override
	public void execute() throws Exception {
		
	}
}
