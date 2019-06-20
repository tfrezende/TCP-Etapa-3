package eval.ui;

import java.util.LinkedHashMap;
import java.util.Map;

public class CatalogueInterface {
	
	private final int NUM_OPCOES = 3;
	protected final Map<Integer, UIAction> actions;
	
	protected CatalogueInterface() {
		this.actions = new LinkedHashMap<>();
		actions.put(1, new AllocateCommand());
		actions.put(2, new IncludeCommand());
		actions.put(3, new SelectFileCommand());
	}

	private String showMenu() {
		StringBuffer sb = new StringBuffer(); //poe numa lista o menu

		sb.append("MENU");
		sb.append("\n");
		
		sb.append("(1) Aloca��o de Produtos a Membros do Comit� de Avalia��o");
		sb.append("\n");

		sb.append("(2) Atribui��o de Notas a Produtos");
		sb.append("\n");
		
		sb.append("(3) Sele��o de Artigos");
		sb.append("\n");
		
		sb.append("Escolha uma op��o: ");
		
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
