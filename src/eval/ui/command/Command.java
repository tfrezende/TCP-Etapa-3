package eval.ui.command;

import eval.data.Database;
import eval.ui.CatalogueInterface;
import eval.ui.TextManager;
import eval.ui.UIAction;
import eval.ui.UIUtils;

public abstract class Command implements UIAction {

	private CatalogueInterface catalogueInterface;
	protected Database database;
	private boolean isEnabled;

	public Command(CatalogueInterface catalogueInterface, Database database) {
		this(catalogueInterface, database, false);
	}

	public Command(CatalogueInterface catalogueInterface, Database database,
			boolean isEnabled) {
		this.setCatalogueInterface(catalogueInterface);
		this.isEnabled = isEnabled;
		this.database = database;
	}

	protected TextManager getTextManager() {
		return UIUtils.INSTANCE.getTextManager();
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public CatalogueInterface getCatalogueInterface() {
		return catalogueInterface;
	}

	public void setCatalogueInterface(CatalogueInterface catalogueInterface) {
		this.catalogueInterface = catalogueInterface;
	}
		
}
