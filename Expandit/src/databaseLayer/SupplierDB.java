package databaseLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




import modelLayer.Supplier;
import modelLayer.SupplierCountry;

public class SupplierDB implements SupplierDBIF{
	private final static String createSupplierQ = "insert into Supplier (companyName , cvr, phone, email, country) values(?, ? ,?, ?,? )"; 
	private final static String getAllSuppliersQ = "select * from Supplier";
	private final static String findSupplierByCvrQ = "select * from Supplier where cvr= ?";
	private final static String updateSupplierQ = "update Supplier set companyName = ? , cvr = ? , phone = ? , email = ? , country = ?  where cvr= ?";
	private final static String deleteSupplierQ = "delete from Supplier where cvr= ?";
	
	PreparedStatement createSupplier , findSupplierByCvr, updateSupplier, deleteSupplier , getAllSuppliers; 
	public SupplierDB () throws SQLException 
	{
	
		
			createSupplier = DBConnection.getInstance().getConnection().prepareStatement(createSupplierQ); 
			findSupplierByCvr = DBConnection.getInstance().getConnection().prepareStatement(findSupplierByCvrQ);
			 updateSupplier = DBConnection.getInstance().getConnection().prepareStatement(updateSupplierQ); 
			 deleteSupplier = DBConnection.getInstance().getConnection().prepareStatement(deleteSupplierQ); 
			 getAllSuppliers = DBConnection.getInstance().getConnection().prepareStatement(getAllSuppliersQ);
			 
	
		
		 
		
	}
	@Override
	public int createSupplier(String companyName, int cvr, int phone, String email , SupplierCountry supplierCountry) throws SQLException 
	{
		int created = 0;
		  
		try {
			DBConnection.getInstance().startTransaction();
			createSupplier.setString(1, companyName);
			createSupplier.setInt(2, cvr);
			createSupplier.setInt(3, phone);
			createSupplier.setString(4, email);
			createSupplier.setInt(5, supplierCountry.getValue());
			created = createSupplier.executeUpdate();
			DBConnection.getInstance().commitTransaction();
		} catch (SQLException e) {
			DBConnection.getInstance().rollbackTransaction();
			e.printStackTrace();
		}
		
		return created;
		
		
	}
	@Override
	public int updateSupplierByCvr(int cvrToUpdate, String companyName, int newCvr, int phone, String email,
			SupplierCountry supplierCountry) throws SQLException {
			
		int generatedKey = 0;
		try {
			DBConnection.getInstance().startTransaction();
			updateSupplier.setString(1, companyName);
			updateSupplier.setInt(2, newCvr);
			updateSupplier.setInt(3, phone);
			updateSupplier.setString(4, email);
			updateSupplier.setInt(5, supplierCountry.getValue());
			updateSupplier.setInt(6, cvrToUpdate);
			generatedKey = updateSupplier.executeUpdate();
			DBConnection.getInstance().commitTransaction();
		} catch (SQLException e) {
			DBConnection.getInstance().rollbackTransaction();
			e.printStackTrace();
		}
		
		return generatedKey;
		
	}

	@Override
	public ArrayList<Supplier> getAll() throws SQLException {
		
		ResultSet rs;
	
			rs =  getAllSuppliers.executeQuery();
			ArrayList<Supplier> sup = buildObjects(rs);
			return sup;
			}
	


	@Override
	public Supplier getSupplierByCvr(int cvr) throws SQLException {
		
		
			findSupplierByCvr.setInt(1, cvr);
			ResultSet rs = findSupplierByCvr.executeQuery();
			Supplier s = null;
			if(rs.next()) {
				s = buildObject(rs);
			}
			return s;
	}
	


	@Override
	public int deleteSupplierByCvr(int cvr) throws SQLException {
	
		deleteSupplier.setInt(1, cvr);
		return deleteSupplier.executeUpdate();
		
		
	}
	
	public Supplier buildObject(ResultSet rs) throws SQLException  
	{
		
	
		Supplier s = new Supplier(
		rs.getString("companyName"),
		rs.getInt("cvr"),
		rs.getInt("phone"), 
		rs.getString("email"), 
		SupplierCountry.fromInt(rs.getInt("country")));
		
		return s;
		

		
	} 
	public ArrayList<Supplier> buildObjects(ResultSet rs) throws SQLException  
	{
		ArrayList<Supplier> suppliers = new ArrayList<>();
		while(rs.next()) {
		Supplier s = new Supplier(
		rs.getString("companyName"),
		rs.getInt("cvr"),
		rs.getInt("phone"), 
		rs.getString("email"), 
		SupplierCountry.fromInt(rs.getInt("country")));
		suppliers.add(s);
		
		}
		
		return suppliers;
		

		
	} 
	
	
	
	
}
