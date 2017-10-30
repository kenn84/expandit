package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllerLayer.ProductController;
import controllerLayer.SupplierController;
import modelLayer.ClothingSize;
import modelLayer.Colors;
import modelLayer.Product;

import modelLayer.SupplierCountry;

public class ProductGetByCvr {
	 int key1;
	
	private ProductController productController; 
	 private SupplierController supplierController;

	@Before
	public void setUp() throws Exception {
		productController = new ProductController(); 
		 supplierController = new SupplierController();
		 supplierController.createSupplier("d", 77, 77, "xx", SupplierCountry.Denmark);
		 
		key1 = productController.createClothing("name", Colors.Blue, "d", 23, 23, 23, 77, ClothingSize.XL);
	}

	

	@Test
	public void test() throws SQLException {
	
		Product pro = productController.getProductById(key1);
		assertNotNull(pro);
		
		
	}
	@After
	public void tearDown() throws Exception {
		
		
		 productController.deleteProductById(key1);
	
		
		 supplierController.deleteSupplierByCvr(77); 
	}

}
