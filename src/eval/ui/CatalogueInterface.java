package eval.ui;

public class CatalogueInterface {
	
	private final int NUM_OPCOES = 3;
	
	private String showMenu() {
		StringBuffer sb = new StringBuffer(); //poe numa lista o menu
		
		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.1"));
		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.allocation"));
		sb.append("\n");
		
		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.2"));
		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.assign.notes"));
		sb.append("\n");
		
		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.3"));
		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.products.selection"));
		sb.append("\n");
		
		sb.append(UIUtils.INSTANCE.getTextManager().getText("message.ask.option"));
		
		return sb.toString();
	}
	
	public void showUI() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		System.out.print(showMenu());
		Integer option = uiUtils.readInteger(null);
		while (option != 0) {
			if (option > 0 && option <= NUM_OPCOES) {
				this.get(option - 1).createAndShowUI();
			}
			System.out.print(showMenu());			
			option = uiUtils.readInteger(null);
		}
	}

}
