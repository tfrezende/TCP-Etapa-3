package eval.business.domain;

import org.junit.*;
import static org.junit.Assert.*;

public class ProductCategoryTest {
	ProductCategory prodCat; 
	
	@Before
	public void setUp() throws Exception {
		prodCat = new ProductCategory();
	}
	
	@Test
	public void testName() {
		assertNotNull(prodCat.getName());
		assertTrue(prodCat.getName() == "");
	}
}