package eval.ui.command;

import java.util.List;

import eval.business.BusinessException;
import eval.business.domain.Evaluation;
import eval.business.domain.Product;
import eval.business.domain.Reviewer;
import eval.data.Database;
import eval.ui.CatalogueInterface;
import eval.ui.UIUtils;

public class IncludeCommand extends Command {
	
	private List<Product> products;
	private List<Reviewer> reviewers;
	

	public IncludeCommand(CatalogueInterface catalogueInterface, Database database) {
		super(catalogueInterface, database);
	}

	@Override
	public void execute() throws Exception {
		final Integer MIN_VALUE = -3;
		final Integer MAX_VALUE = 3;
		
		products = (List<Product>) database.getAllProducts();
		// Exibir aqui todos produtos na tela
		
		Integer productId = UIUtils.INSTANCE.readInteger("message.ask.product");
		Product product = products.get(productId);
		// Testar aqui se productId é valido
		reviewers = product.getReviewers();
		// Exibir aqui todos avaliadores na tela
		
		Integer reviewerId = UIUtils.INSTANCE.readInteger("message.ask.reviewer");
		
		Reviewer reviewer = null;
		
		for(Reviewer rev : reviewers) {
			if(rev.getId() == reviewerId) {
				reviewer = rev;
			}
		}
		
		if(reviewer == null) {
			throw new BusinessException("exception.reviewer.not.found");
		}
		else{
			Integer score = UIUtils.INSTANCE.readInteger("message.ask.score");
			
			if(score <= MIN_VALUE && score >= MAX_VALUE) {
				throw new BusinessException("exception.invalid.score");
			}
			else {
				Evaluation evaluation = new Evaluation(product.getGroup(), product, reviewer);
				product.addEvaluation(evaluation);
				product.addScore(reviewer, score);
			}
			
		}
		
	}
	
}
