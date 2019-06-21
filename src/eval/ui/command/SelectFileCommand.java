package eval.ui.command;

import eval.data.Database;
import eval.ui.CatalogueInterface;

public class SelectFileCommand extends Command {

	public SelectFileCommand(CatalogueInterface catalogueInterface, Database database) {
		super(catalogueInterface, database);
	}

	@Override
	public void execute() throws Exception {
		
	}
}
