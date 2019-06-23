package eval;

import java.io.FileNotFoundException;

import org.apache.log4j.BasicConfigurator;

import eval.ui.CatalogueInterface;

public class Eval {

	public static void main(String[] args) throws FileNotFoundException {    
		
		BasicConfigurator.configure();
		
		CatalogueInterface catalogueInterface = new CatalogueInterface();
		
		catalogueInterface.showMenu();
	}
	
	public Eval() {
		
	}

}
