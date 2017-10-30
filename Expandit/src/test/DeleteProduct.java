package test;



import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllerLayer.ProductController;
import controllerLayer.SupplierController;
import modelLayer.ClothingSize;
import modelLayer.Colors;
import modelLayer.SupplierCountry;

public class DeleteProduct {

	private ProductController productController; 
	private SupplierController supllierController;
	private int key = 0;
	@Before
	public void setUp() throws Exception {
		
		productController = new ProductController();
		supllierController = new SupplierController();
		supllierController.createSupplier("d", 44, 33, "d", SupplierCountry.Germany);
	key =	productController.createClothing("d", Colors.Blue, "d", 1, 1, 1, 44, ClothingSize.M);
	}



	@Test
	public void test() throws SQLException {
		int delkey = productController.deleteProductById(key);
		Assert.assertTrue(delkey > 0);
	}
	@After
	public void tearDown() throws Exception {
		
		supllierController.deleteSupplierByCvr(44);
	}
}
