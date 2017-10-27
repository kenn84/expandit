package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllerLayer.SupplierController;

public class SupplierDelete {
	SupplierController sc = null; 

	@Before
	public void setUp() throws Exception {
		sc = new SupplierController();
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void test() throws SQLException {
		int deleted = sc.deleteSupplierByCvr(32); 
		assertTrue(deleted > 0);
	}

}
