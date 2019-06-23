package eval;

import java.io.FileNotFoundException;

import eval.ui.CatalogueInterface;

public class Eval {

	public static void main(String[] args) throws FileNotFoundException {        
		
		CatalogueInterface catalogueInterface = new CatalogueInterface();
		
		catalogueInterface.showMenu();
	}
	
	public Eval() {
		
	}

}
