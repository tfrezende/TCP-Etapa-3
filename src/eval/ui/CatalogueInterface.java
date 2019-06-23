package eval.ui;
/*
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
*/

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;

import eval.business.BusinessException;
import eval.data.Database;
import eval.ui.command.AllocateCommand;
import eval.ui.command.Command;
import eval.ui.command.IncludeCommand;
import eval.ui.command.SelectFileCommand;



public class CatalogueInterface {
	
	private final int NUM_OPCOES = 3;
	protected final Map<Integer, UIAction> actions;
	protected Log log;
	//Properties prop = new Properties();
	
	protected CatalogueInterface() { //throws FileNotFoundException
		Database database = new Database();
		this.actions = new LinkedHashMap<>();
		actions.put(1, new AllocateCommand(this, database));
		actions.put(2, new IncludeCommand(this, database));
		actions.put(3, new SelectFileCommand(this, database));
		//InputStream input = new FileInputStream("src/eval/resources/globalMessages.properties");
	}
	
	/*
	private String getMenu() {
		StringBuffer sb = new StringBuffer(); //poe numa lista o menu

		sb.append("MENU");
		sb.append("\n");
		
		sb.append("(1) Alocacao de Produtos a Membros do Comite de Avaliacao");
		sb.append("\n");

		sb.append("(2) Atribuicao de Notas a Produtos");
		sb.append("\n");
		
		sb.append("(3) Selecao de Artigos");
		sb.append("\n");
		
		sb.append("Escolha uma opcao: ");
		
		return sb.toString();
	}
	*/
	
	/*
	private String getMenu() {
		StringBuffer sb = new StringBuffer(); //poe numa lista o menu

		sb.append(prop.getProperty("menu.menu"));
		sb.append("\n");
		
		sb.append(prop.getProperty("menu.1"));
		sb.append(prop.getProperty("menu.allocation"));
		sb.append("\n");
		
		sb.append(prop.getProperty("menu.2"));
		sb.append(prop.getProperty("menu.assign.notes"));
		sb.append("\n");
		
		sb.append(prop.getProperty("menu.3"));
		sb.append(prop.getProperty("menu.products.selection"));
		sb.append("\n");
		
		sb.append(prop.getProperty("message.ask.option"));
		
		return sb.toString();
	}
	*/
	
	private String getMenu() {
		StringBuffer sb = new StringBuffer(); //poe numa lista o menu

		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.menu"));
		sb.append("\n");
		
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
	
	public void showMenu() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		System.out.print(getMenu());
		Integer option = uiUtils.readInteger(null);
		while (option != 0) {
			if (option > 0 && option <= NUM_OPCOES) {
				Command command = (Command) actions.get(option);
				try {
					command.execute();
				} catch (BusinessException be) {
					System.out.println(uiUtils.getTextManager().getText(
							be.getMessage(), be.getArgs()));
					log.warn(be);
				} catch (Exception e) {
					uiUtils.handleUnexceptedError(e);
				}
			}
			System.out.print(getMenu());			
			option = uiUtils.readInteger(null);
		}
	}
	
	

}
