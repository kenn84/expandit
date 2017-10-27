package test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import databaseLayer.DBConnection;

public class ConnectionTest {

	Connection dbConnect = null;
	@Before
	public void setUp() throws Exception {
	dbConnect = DBConnection.getInstance().getConnection();
		
	}

	

	@Test
	public void test() {
	
	assertTrue(dbConnect != null);
		
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
