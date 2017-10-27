package databaseLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import modelLayer.Supplier;
import modelLayer.SupplierCountry;

public interface SupplierDBIF {
	public int createSupplier(String companyName, int cvr, int phone, String email , SupplierCountry supplierCountry)throws SQLException;
	public int updateSupplierByCvr(int cvrToUpdate, String companyName, int newCvr, int phone, String email,
			SupplierCountry supplierCountry)throws SQLException; 
	public ArrayList<Supplier> getAll() throws SQLException;
	public Supplier getSupplierByCvr(int cvr) throws SQLException;
	public int deleteSupplierByCvr(int cvr) throws SQLException; 
}
