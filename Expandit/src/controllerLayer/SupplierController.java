package controllerLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import modelLayer.Supplier;
import databaseLayer.SupplierDB;
import databaseLayer.SupplierDBIF;
import modelLayer.SupplierCountry;

public class SupplierController implements SupplierDBIF{

	 SupplierDB sDB = null;
	
	public SupplierController() throws SQLException 
	{
		sDB = new  SupplierDB();
	}
	
	public int createSupplier(String companyName, int cvr, int phone, String email , SupplierCountry supplierCountry) throws SQLException 
	{
		return sDB.createSupplier(companyName, cvr, phone, email, supplierCountry); 
	}
	
	public int updateSupplierByCvr(int cvrToUpdate, String companyName, int newCvr, int phone, String email,
			SupplierCountry supplierCountry) throws SQLException 
	{
		return sDB.updateSupplierByCvr( cvrToUpdate,  companyName, newCvr, phone,  email,  supplierCountry);
		
	}
	
	public int deleteSupplierByCvr(int cvr) throws SQLException 
	{
		
		return sDB.deleteSupplierByCvr(cvr);
	}
	
	public ArrayList<Supplier> getAll() throws SQLException 
	{
		return sDB.getAll();
	}
	
	public Supplier getSupplierByCvr(int cvr) throws SQLException 
	{
		 return sDB.getSupplierByCvr(cvr); 
		
	}






	
	
	
}
