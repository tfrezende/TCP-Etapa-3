package eval.business.domain;

import org.junit.*;
import static org.junit.Assert.*;

public class ProductCategoryTest {
	ProductCategory prodCat; 
	
	@Before
	public void setUp() throws Exception {
		prodCat = new ProductCategory(null);
	}
	
	@Test
	public void testName() {
		assertNotNull(prodCat.getName());
		assertFalse(prodCat.getName() == "");
		assertEquals(prodCat.getName(), "BB Cream");
		assertEquals(prodCat.getName(), "CC Cream");
		assertEquals(prodCat.getName(), "DD Cream");
		assertEquals(prodCat.getName(), "Foundation+SPF");
		assertEquals(prodCat.getName(), "Oil Free Matte SPF");
		assertEquals(prodCat.getName(), "Powder Sunscreen");
	}
}