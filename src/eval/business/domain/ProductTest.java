package eval.business.domain;

import org.junit.*;
import static org.junit.Assert.*;

public class ProductTest {
	Product prod; 
	
	@Before
	public void setUp() throws Exception {
		prod = new Product(null, 0, null, null);
	}
	
	@Test
	public void testGetAverageScore() {
		assertNotNull(prod.getAverageScore());
	}
	
	@Test
	public void testGetReviewers() {
		assertNotNull(prod.getReviewers());
		assertTrue(prod.getReviewers().size() <= 5);
		assertTrue(prod.getReviewers().size() >= 2);
		assertFalse(prod.getReviewers().size() < 2);
		assertFalse(prod.getReviewers().size() > 5);
	}
	
	@Test
	public void testIsAcceptable() {
		assertNotNull(prod.isAcceptable());
	}
	
	@Test
	public void testIsEvaluationDone() {
		assertNotNull(prod.isEvaluationDone());
	}

	@Test
	public void testGetName() {
		assertNotNull(prod.getName());
		assertFalse(prod.getName() == "");
	}

	@Test
	public void testGetId() {
		assertNotNull(prod.getId());
		assertFalse(prod.getId() == 0);
	}

	@Test
	public void testGetGroup() {
		assertNotNull(prod.getGroup());
		assertEquals(prod.getGroup(), "SPF A");
		assertEquals(prod.getGroup(), "SPF B");
		assertEquals(prod.getGroup(), "SPF C");
	}

	@Test
	public void testGetEvaluations() {
		assertNotNull(prod.getEvaluations());
	}

	@Test
	public void testGetScores() {
		assertNotNull(prod.getScores());
		assertTrue(prod.getScores().size() <= 3);
		assertTrue(prod.getScores().size() >= -3);
		assertFalse(prod.getScores().size() < -3);
		assertFalse(prod.getScores().size() > 3);
	}
	
	@Test
	public void testGetCategory() {
		assertNotNull(prod.getCategory());
		assertEquals(prod.getCategory(), "BB Cream");
		assertEquals(prod.getCategory(), "CC Cream");
		assertEquals(prod.getCategory(), "DD Cream");
		assertEquals(prod.getCategory(), "Foundation+SPF");
		assertEquals(prod.getCategory(), "Oil Free Matte SPF");
		assertEquals(prod.getCategory(), "Powder Sunscreen");
	}
}