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

public class CreateClothing {

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
	
		
		 key = productController.createClothing("name", Colors.Blue, "d", 23, 23, 23, 77, ClothingSize.XL);
		Assert.assertTrue("succes", key > 0);
	}
	@After
	public void tearDown() throws Exception {
		
	 productController.deleteProductById(key);
		supplierController.deleteSupplierByCvr(77); 
	}

}
