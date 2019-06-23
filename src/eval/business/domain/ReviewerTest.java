package eval.business.domain;

import org.junit.*;
import static org.junit.Assert.*;

public class ReviewerTest {
	Reviewer rev; 
	Product prod; 
	
	@Before
	public void setUp() throws Exception {
		rev = new Reviewer();
	}
	
	@Before
	public void setUpProd() throws Exception {
		prod = new Product(null, 0, null, null);
	}
	
	@Test
	public void testGetCategories() {
		assertNotNull(rev.getCategories());
		assertFalse(rev.getCategories().isEmpty());
	}

	@Test
	public void testGetGroups() {
		assertNotNull(rev.getGroups());
		assertFalse(rev.getGroups().isEmpty());
	}

	@Test
	public void testCanEvaluate() {
		assertNotNull(rev.canEvaluate(prod));
	}
	
	@Test
	public void testGetName() {
		assertNotNull(rev.getName());
		assertFalse(rev.getName() == "");
		assertEquals(rev.getName(), "João");
		assertEquals(rev.getName(), "Ana");
		assertEquals(rev.getName(), "Manoela");
		assertEquals(rev.getName(), "Joana");
		assertEquals(rev.getName(), "Miguel");
		assertEquals(rev.getName(), "Beatriz");
		assertEquals(rev.getName(), "Suzana");
		assertEquals(rev.getName(), "Natasha");
		assertEquals(rev.getName(), "Pedro");
		assertEquals(rev.getName(), "Carla");
	}

	@Test
	public void testGetState() {
		assertNotNull(rev.getState());
		assertFalse(rev.getState() == "");
		assertEquals(rev.getState(), "RS");
		assertEquals(rev.getState(), "SP");
		assertEquals(rev.getState(), "CE");
	}

	@Test
	public void testGetId() {
		assertNotNull(rev.getId());
		assertTrue(rev.getId() == 10);
		assertTrue(rev.getId() == 8);
		assertTrue(rev.getId() == 7);
		assertTrue(rev.getId() == 6);
		assertTrue(rev.getId() == 5);
		assertTrue(rev.getId() == 4);
		assertTrue(rev.getId() == 3);
		assertTrue(rev.getId() == 2);
		assertTrue(rev.getId() == 1);
	}

	@Test
	public void testGetEvaluations() {
		assertNotNull(rev.getEvaluations());
		assertFalse(rev.getEvaluations().isEmpty());
	}
}