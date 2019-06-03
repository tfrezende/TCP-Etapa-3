package eval.ui.command;

import eval.ui.CatalogueInterface;
import eval.ui.TextManager;
import eval.ui.UIAction;
import eval.ui.UIUtils;

public abstract class Command implements UIAction {

	protected final CatalogueInterface catalogueInterface;
	private boolean isEnabled;

	protected Command(CatalogueInterface catalogueInterface) {
		this(catalogueInterface, false);
	}

	protected Command(CatalogueInterface catalogueInterface, boolean isEnabled) {
		this.catalogueInterface = catalogueInterface;
		this.isEnabled = isEnabled;
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
		
}
