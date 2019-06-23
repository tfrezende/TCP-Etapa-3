package eval.business.domain;

import org.junit.*;
import static org.junit.Assert.*;

public class EvaluationTest {
	Evaluation eval; 
	
	@Before
	public void setUp() throws Exception {
		eval = new Evaluation(null, null, null);
	}
	
	@Test
	public void testGetScore(int score) {
		assertNotNull(eval.getScore());
		assertTrue(eval.getScore() <= 3);
		assertTrue(eval.getScore() >= -3);
		assertFalse(eval.getScore() < -3);
		assertFalse(eval.getScore() > 3);
	}

	@Test
	public void testIsDone() {
		assertNotNull(eval.isDone());
	}

	@Test
	public void testGetGroup() {
		assertNotNull(eval.getGroup());
		assertNotEquals(eval.getGroup(), "");
		assertEquals(eval.getGroup(), "SPF A");
		assertEquals(eval.getGroup(), "SPF B");
		assertEquals(eval.getGroup(), "SPF C");
	}

	@Test
	public void testGetReviewer() {
		assertNotNull(eval.getReviewer());
		assertTrue(eval.getReviewer().getId() == 10);
		assertTrue(eval.getReviewer().getId() == 8);
		assertTrue(eval.getReviewer().getId() == 7);
		assertTrue(eval.getReviewer().getId() == 6);
		assertTrue(eval.getReviewer().getId() == 5);
		assertTrue(eval.getReviewer().getId() == 4);
		assertTrue(eval.getReviewer().getId() == 3);
		assertTrue(eval.getReviewer().getId() == 2);
		assertTrue(eval.getReviewer().getId() == 1);
	}

	@Test
	public void testGetProduct() {
		assertNotNull(eval.getProduct());
		assertFalse(eval.getProduct().getName() == "");
		assertTrue(eval.getProduct().getName() == "L’oreal DD Cream");
		assertTrue(eval.getProduct().getName() == "Avon CC Cream");
		assertTrue(eval.getProduct().getName() == "Revolution Powder Sunscreeen");
		assertTrue(eval.getProduct().getName() == "Maybelline BB Cream");
		assertTrue(eval.getProduct().getName() == "Revlon Foundation+SPF20");
		assertTrue(eval.getProduct().getName() == "Nivea Matte Face SPF");
		assertTrue(eval.getProduct().getName() == "La Roche CC Cream");
		assertTrue(eval.getProduct().getName() == "Yves Rocher Powder+SPF15");
		assertTrue(eval.getProduct().getName() == "Nivea BB Cream");
		assertTrue(eval.getProduct().getName() == "Base O Boticário SPF20");
		assertTrue(eval.getProduct().getName() == "Natura SPF20 Rosto Matte");
	}
}