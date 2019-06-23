package eval.business.domain;

import org.junit.*;
import static org.junit.Assert.*;

public class EvalGroupTest {
	EvalGroup evalGp;
	
	@Before
	public void setUp() throws Exception {
		evalGp = new EvalGroup(null, null, null, null);
	}
	
	@Test
	public void testGetAcceptableProducts(){		
		assertNotNull(evalGp.getAcceptableProducts());
		assertFalse(evalGp.getAcceptableProducts().isEmpty());
	}
	
	@Test
	public void testGetNotAcceptableProducts(){
		assertNotNull(evalGp.getNotAcceptableProducts());
		assertFalse(evalGp.getNotAcceptableProducts().isEmpty());
	}	
	
	
	@Test
	public void testIsAllocated() {
		assertNotNull(evalGp.isAllocated());
	}
	
	@Test
	public void testIsEvaluationDone() {
		assertNotNull(evalGp.isEvaluationDone());
	}
	
	@Test
	public void testGetEvaluations() {
		assertNotNull(evalGp.getEvaluations());
		assertNotEquals(evalGp.getEvaluations(), "");
		assertEquals(evalGp.getEvaluations(), "SPF A");
		assertEquals(evalGp.getEvaluations(), "SPF B");
		assertEquals(evalGp.getEvaluations(), "SPF C");
	}

	@Test
	public void testGetName() {
		assertNotNull(evalGp.getName());
		assertFalse(evalGp.getName() == "");
	}

	@Test
	public void testGetMembers() {
		assertNotNull(evalGp.getMembers());
		assertFalse(evalGp.getMembers().isEmpty());
	}

	@Test
	public void testGetProducts() {
		assertNotNull(evalGp.getProducts());
		assertFalse(evalGp.getProducts().isEmpty());
	}
	
	@Test
	public void testGetSmallestValue() {
		assertNotNull(evalGp.getSmallestValue(evalGp.getProducts()));
	}
}