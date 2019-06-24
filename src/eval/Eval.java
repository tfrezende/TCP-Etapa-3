package eval;

import org.apache.log4j.BasicConfigurator;

import eval.ui.CatalogueInterface;

public class Eval {

	public static void main(String[] args) throws Exception {    
		
		BasicConfigurator.configure();		
	
		CatalogueInterface catalogueInterface = new CatalogueInterface();
		
		catalogueInterface.showMenu();
		
	}
	

}
