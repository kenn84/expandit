package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import modelLayer.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllerLayer.SupplierController;

public class SupplierGetAll {

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
		
	 ArrayList<Supplier> sups = sc.getAll();
	 assertNotNull(sups.get(0));
	 
	 
	 
	}

}
