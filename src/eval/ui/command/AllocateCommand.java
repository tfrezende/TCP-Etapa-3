package eval.ui.command;

import eval.business.BusinessException;
import eval.business.domain.EvalGroup;
import eval.data.Database;
import eval.ui.CatalogueInterface;
import eval.ui.UIUtils;

public class AllocateCommand extends Command {
	
	private EvalGroup evalGroup;
	private final int MIN_MEMBERS = 2;
	private final int MAX_MEMBERS = 5;

	public AllocateCommand(CatalogueInterface catalogueInterface, Database database) {
		super(catalogueInterface, database);
	}

	public void execute() throws Exception {
		
		String group = UIUtils.INSTANCE.readString("message.ask.group");
		evalGroup = database.getGroup(group);
		
		testAllocation(evalGroup);
		
		Integer numReviewers = UIUtils.INSTANCE.readInteger("message.ask.num.evaluators");
		testNumReviewers(numReviewers);				
		
		evalGroup.allocate(numReviewers);
		
	}
	
	public void testAllocation(EvalGroup group) throws Exception {
		if (!evalGroup.isAllocated()) {
			throw new BusinessException("exception.allocated.group");
		}
	}
	
	public void testNumReviewers(Integer numReviewers) throws Exception {
		if(numReviewers < MIN_MEMBERS || numReviewers > MAX_MEMBERS) {
			throw new BusinessException("exception.invalid.reviewers");
		}
	}
	
}