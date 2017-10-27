package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllerLayer.SupplierController;
import modelLayer.SupplierCountry;

public class UpdateSupplier {

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
		int updated = sc.updateSupplierByCvr(45, "nyt", 4444, 666, "ch", SupplierCountry.Norway);
		assertTrue(updated > 0);
		
	}

}
