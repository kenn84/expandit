package test;



import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllerLayer.ProductController;
import controllerLayer.SupplierController;

import modelLayer.Colors;
import modelLayer.ShoesSizeCountry;
import modelLayer.SupplierCountry;

public class CreateShoes {

	 private ProductController productController;
	 private SupplierController supplierController;
	 int key;
	@Before
	public void setUp() throws Exception {
		 productController = new ProductController(); 
		 supplierController = new SupplierController();
		 supplierController.createSupplier("d", 77, 77, "xx", SupplierCountry.Denmark);
	}



	@Test
	public void test() throws SQLException {
		
		 key = productController.createShoes("dd", Colors.Blue, "dj", 1, 1, 1, 77, 1,ShoesSizeCountry.EU );
			Assert.assertTrue("succes", key > 0);
	
	}
	
	@After
	public void tearDown() throws Exception {
		 productController.deleteProductById(key);
			supplierController.deleteSupplierByCvr(77); 
	}

}
