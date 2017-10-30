package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllerLayer.ProductController;
import controllerLayer.SupplierController;
import junit.framework.Assert;
import modelLayer.ClothingSize;
import modelLayer.Colors;
import modelLayer.Product;
import modelLayer.ShoesSizeCountry;
import modelLayer.SupplierCountry;

public class productGetall {
	 int key1;
	 int key2;
	 int key3;
	 int key4;
	private ProductController productController; 
	 private SupplierController supplierController;
	@Before
	public void setUp() throws Exception {
		productController = new ProductController(); 
		 supplierController = new SupplierController();
		 supplierController.createSupplier("d", 77, 77, "xx", SupplierCountry.Denmark);
		 
		key1 = productController.createClothing("name", Colors.Blue, "d", 23, 23, 23, 77, ClothingSize.XL);
		key2 = productController.createClothing("name", Colors.Blue, "d", 23, 23, 23, 77, ClothingSize.XL);
		 key3 = productController.createShoes("dd", Colors.Blue, "dj", 1, 1, 1, 77, 1,ShoesSizeCountry.EU );
		 key4 = productController.createShoes("dd", Colors.Blue, "dj", 1, 1, 1, 77, 1,ShoesSizeCountry.EU );

		 
		 
	}

	@After
	public void tearDown() throws Exception {
		
		 productController.deleteProductById(key1);
		 productController.deleteProductById(key2);
		 productController.deleteProductById(key3);
		 productController.deleteProductById(key4);
		 supplierController.deleteSupplierByCvr(77); 
		
	

	
	}

	@Test
	public void test() throws SQLException {
		ArrayList<Product> objs	= productController.getAllProducts();
		for(Product obj : objs) 
		{
			System.out.println(obj.getClass().getSimpleName());
		}
		assertTrue(objs.size() == 4) ;
	
	}

}
