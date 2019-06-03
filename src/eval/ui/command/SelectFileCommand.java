package eval.ui.command;

import eval.business.OperationService;
import eval.ui.CatalogueInterface;

public class SelectFileCommand extends Command {

	private final OperationService operationService;

	public SelectFileCommand(CatalogueInterface catalogueInterface,
			OperationService operationService) {
		super(catalogueInterface);
		this.operationService = operationService;
	}

	@Override
	public void execute() throws Exception {
		
	}
}
