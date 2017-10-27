package databaseLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelLayer.ClothingSize;
import modelLayer.Colors;
import modelLayer.Product;
import modelLayer.ShoesSizeCountry;

public class ProductDB {
	
	private final static String createProductQ = "insert into Product values(?, ?, ?, ?, ?, ?, ?)"; 
	private final static String createClothingQ= "insert into Clothing values(? ,?  )"; 
	private final static String createShoesQ = "insert into Shoes values (? , ? )"; 
	
	PreparedStatement createProduct, createClothing, createShoes;
	
	public ProductDB() throws SQLException {
		createClothing = DBConnection.getInstance().getConnection().prepareStatement(createClothingQ); 
		createShoes = DBConnection.getInstance().getConnection().prepareStatement(createShoesQ);
		createProduct = DBConnection.getInstance().getConnection().prepareStatement("f");
	
	}

	
	private int createProduct(String name, Colors color, String brand, double purchasePrice, double regularPrice,double salesPrice , int supplierCvr) throws SQLException {
		int generatedKey = 0; 
		try {
		DBConnection.getInstance().startTransaction();
		createProduct.setString(1, name);
		createProduct.setInt(2, color.getValue());
		createProduct.setString(3, brand);
		createProduct.setDouble(4, purchasePrice);
		createProduct.setDouble(5, regularPrice);
		createProduct.setDouble(6, salesPrice);
		createProduct.setInt(6, supplierCvr);
		generatedKey = DBConnection.getInstance().executeInsertWithIdentity(createProduct);
		DBConnection.getInstance().commitTransaction();
		
	} catch (SQLException e) {
		DBConnection.getInstance().rollbackTransaction();
		e.printStackTrace();
	}
		return generatedKey;
		
		
	}
	
	
	public int createClothing( String name, Colors color, String brand, double purchasePrice, double regularPrice,double salesPrice , int supplierCvr , ClothingSize clothingSize) throws SQLException {
		
		 int productId = createProduct( name,  color,  brand,  purchasePrice,  regularPrice, salesPrice , supplierCvr);
		 // catch exception if productId = 0
		int generatedKey = 0; 
		try {
		DBConnection.getInstance().startTransaction();
		createClothing.setInt(1,clothingSize.getValue());
		createClothing.setInt(2, productId);
		generatedKey = DBConnection.getInstance().executeInsertWithIdentity(createClothing);
		DBConnection.getInstance().commitTransaction();
		} catch (SQLException e) {
			DBConnection.getInstance().rollbackTransaction();
			e.printStackTrace();
		}
		return generatedKey;
		
	}
	
	public int createShoes(String name, Colors color, String brand, double purchasePrice, double regularPrice,double salesPrice , int supplierCvr, int size, ShoesSizeCountry shoesSizeCountry) throws SQLException {
		 int productId = createProduct( name,  color,  brand,  purchasePrice,  regularPrice, salesPrice , supplierCvr);
		 // catch exception if productId = 0
		int generatedKey = 0; 
		try {
		DBConnection.getInstance().startTransaction();
		createShoes.setInt(1,size );
		createShoes.setInt(2, shoesSizeCountry.getValue());
		createShoes.setInt(3, productId);
		generatedKey = DBConnection.getInstance().executeInsertWithIdentity(createShoes);
		DBConnection.getInstance().commitTransaction();
		} catch (SQLException e) {
			DBConnection.getInstance().rollbackTransaction();
			e.printStackTrace();
		}
		
		return generatedKey;
	}
	
	
	
	

	
	
	

}
