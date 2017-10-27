package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllerLayer.SupplierController;

import modelLayer.SupplierCountry;

public class CreateSupplierTest {

	SupplierController sc = null; 
	@Before
	public void setUp() throws Exception {
		
			sc = new SupplierController();
	 
		
	}
	
	@Test
	public void test() throws SQLException {
	  int created = sc.createSupplier("testCompany" , 5555 , 2 , "kenneth84petersen@hotmail.com" , SupplierCountry.Denmark);

	 assertTrue(created > 0); 
	
	

	}

	@After
	public void tearDown() throws Exception {
	}



}
