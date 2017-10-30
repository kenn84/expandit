package databaseLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelLayer.Clothing;
import modelLayer.ClothingSize;
import modelLayer.Colors;
import modelLayer.Product;
import modelLayer.Shoes;
import modelLayer.ShoesSizeCountry;
import modelLayer.Supplier;
import modelLayer.SupplierCountry;


public class ProductDB implements ProductDBIF{
	
	private final static String createProductQ = "insert into Product(name, color, brand, purchasePrice, regularPrice,salesPrice ,supplierCvr, proType)"
			+ " values(?, ?, ?, ?, ?, ?, ?, ? )"; 
	private final static String createClothingQ= "insert into Clothing values(? ,? )"; 
	private final static String createShoesQ = "insert into Shoes(size , shoesSizeCountry, productId) values(? , ?, ? )"; 
	private final static String getAllProductQ = "select * from (( Product left join Shoes on Product.productId = Shoes.productId) left join Clothing on Product.productId = Clothing.productId)";
	private final static String getProductByIdQ = getAllProductQ + "where Product.productId = ?"; 
	private final static String updateProductQ = "update Product set name = ? , color = ? , brand = ? , purchasePrice = ? , regularPrice = ?,  salesPrice = ?, supplierCvr = ?, proType = ? ";
	private final static String updateClothingQ = updateProductQ + "size = ? , productId = ? where productId= ?";
	private final static String updateShoesQ = updateProductQ + "shoesSize = ? , productId = ? where productId= ?";
	private final static String deleteProductQ = "delete from Product where productId= ?";
	PreparedStatement createProduct, createClothing, getPorductById, createShoes , getAllProduct , findProductByProductId, updateProduct , deleteProduct , updateClothing , updateShoes,findClothingByProductId,findShoesByProductId;
	
	public ProductDB() throws SQLException {
		createClothing = DBConnection.getInstance().getConnection().prepareStatement(createClothingQ); 
		createShoes = DBConnection.getInstance().getConnection().prepareStatement(createShoesQ);
		createProduct = DBConnection.getInstance().getConnection().prepareStatement(createProductQ, Statement.RETURN_GENERATED_KEYS);
		getAllProduct = DBConnection.getInstance().getConnection().prepareStatement(getAllProductQ);
		getPorductById = DBConnection.getInstance().getConnection().prepareStatement(getProductByIdQ);
		updateProduct = DBConnection.getInstance().getConnection().prepareStatement(updateProductQ);
		updateClothing = DBConnection.getInstance().getConnection().prepareStatement(updateClothingQ);
		updateShoes = DBConnection.getInstance().getConnection().prepareStatement(updateShoesQ);
		deleteProduct = DBConnection.getInstance().getConnection().prepareStatement(deleteProductQ);

		
	
	}

	
	private int createProduct(String name, Colors color, String brand, double purchasePrice, double regularPrice,double salesPrice , int supplierCvr , String proType) throws SQLException {
		int generatedKey = 0; 
		try {
		DBConnection.getInstance().startTransaction();
		createProduct.setString(1, name);
		createProduct.setInt(2, color.getValue());
		createProduct.setString(3, brand);
		createProduct.setDouble(4, purchasePrice);
		createProduct.setDouble(5, regularPrice);
		createProduct.setDouble(6, salesPrice);
		createProduct.setInt(7, supplierCvr);
		createProduct.setString(8, proType);
		generatedKey = DBConnection.getInstance().executeInsertWithIdentity(createProduct);
		DBConnection.getInstance().commitTransaction();
		
	} catch (SQLException e) {
		DBConnection.getInstance().rollbackTransaction();
		e.printStackTrace();
	}
		return generatedKey;
		
	}
	
	@Override
	public int createClothing( String name, Colors color, String brand, double purchasePrice, double regularPrice,double salesPrice , int supplierCvr ,  ClothingSize clothingSize) throws SQLException {
		
		 int productId = createProduct( name,  color,  brand,  purchasePrice,  regularPrice, salesPrice , supplierCvr ,"Clothing");
		 // catch exception if productId = 0
	
		try {
		DBConnection.getInstance().startTransaction();
		createClothing.setInt(1,clothingSize.getValue());
		createClothing.setInt(2, productId);
	
		DBConnection.getInstance().commitTransaction();
		
		} catch (SQLException e) {
			DBConnection.getInstance().rollbackTransaction();
			e.printStackTrace();
		}
		return productId;
		
	}
	@Override
	public int createShoes(String name, Colors color, String brand, double purchasePrice, double regularPrice,double salesPrice , int supplierCvr,  int shoesSize, ShoesSizeCountry shoesSizeCountry) throws SQLException {
		 int productId = createProduct( name,  color,  brand,  purchasePrice,  regularPrice, salesPrice , supplierCvr ,"Shoes");
		 // catch exception if productId = 0
		
		try {
		DBConnection.getInstance().startTransaction();
		createShoes.setInt(1,shoesSize );
		createShoes.setInt(2, shoesSizeCountry.getValue());
		createShoes.setInt(3, productId);
		
		DBConnection.getInstance().commitTransaction();
		} catch (SQLException e) {
			DBConnection.getInstance().rollbackTransaction();
			e.printStackTrace();
		}
		
		return productId;
	}
	@Override
	public int updateClothing(int productId,  String name, Colors color, String brand, double purchasePrice, double regularPrice,double salesPrice , int supplierCvr ,String proType,  ClothingSize clothingSize) throws SQLException {
			
		int generatedKey = 0;
		try {
			DBConnection.getInstance().startTransaction();
			updateClothing.setString(1, name);
			updateClothing.setInt(2, color.getValue());
			updateClothing.setDouble(3,purchasePrice );
			updateClothing.setDouble(4, regularPrice);
			updateClothing.setDouble(5,salesPrice);
			updateClothing.setInt(6, supplierCvr);
			updateClothing.setString(7, proType);
			updateClothing.setInt(8, clothingSize.getValue());
			updateClothing.setInt(9, productId);
			
			generatedKey = DBConnection.getInstance().executeInsertWithIdentity(updateClothing);
			DBConnection.getInstance().commitTransaction();
		} catch (SQLException e) {
			DBConnection.getInstance().rollbackTransaction();
			e.printStackTrace();
		}
		
		return generatedKey;
		
	}
	@Override
	public int updateShoes(int productId ,  String name, Colors color, String brand, double purchasePrice, double regularPrice,double salesPrice , int supplierCvr, String proType , double shoesSize , ShoesSizeCountry shoesSizeCountry) throws SQLException {
		
		int generatedKey = 0;
		try {
			DBConnection.getInstance().startTransaction();
			updateClothing.setString(1, name);
			updateClothing.setInt(2, color.getValue());
			updateClothing.setDouble(3,purchasePrice );
			updateClothing.setDouble(4, regularPrice);
			updateClothing.setDouble(5,salesPrice);
			updateClothing.setInt(6, supplierCvr);
			updateClothing.setString(7, proType);
			updateClothing.setDouble(8, shoesSize);
			updateClothing.setInt(9, shoesSizeCountry.getValue());
			updateClothing.setInt(10, productId);
			
			generatedKey = DBConnection.getInstance().executeInsertWithIdentity(updateShoes);
			DBConnection.getInstance().commitTransaction();
		} catch (SQLException e) {
			DBConnection.getInstance().rollbackTransaction();
			e.printStackTrace();
		}
		
		return generatedKey;
		
	}


	@Override
	public <T extends Product> ArrayList<Product> getAllProducts() throws SQLException {
		ResultSet rs = getAllProduct.executeQuery(); 
		ArrayList<Product> products = new ArrayList<>();
		
		
		while(rs.next()) 
		{
			String type = rs.getString("proType");
			
			if(type.equals("Shoes")) 
			{
				Shoes shoes = new Shoes(rs.getString("name"), Colors.fromInt(rs.getInt("color")) , rs.getString("brand"), rs.getDouble("purchasePrice"), rs.getDouble("regularPrice"), rs.getDouble("salesPrice"), rs.getInt("shoesSize"), ShoesSizeCountry.fromInt(rs.getInt("shoesSizeCountry")));
				 shoes.setProType(rs.getString("proType"));
				 products.add(shoes);
			}
			else 
			{
				 Clothing clothing = new Clothing(rs.getString("name"), Colors.fromInt(rs.getInt("color")) , rs.getString("brand"), rs.getDouble("purchasePrice"), rs.getDouble("regularPrice"), rs.getDouble("salesPrice"),ClothingSize.fromInt(rs.getInt("size"))); 
				 clothing.setProType(rs.getString("proType"));
				
				 products.add(clothing); 
				 }
		}
		return products;
	}

	
	@Override
	public int deleteProductById(int productId) throws SQLException {
	// har casade på min produkt foreign key , så når et produkt slettes 
	//	, slettes det tilhørende sub produkt også 
		deleteProduct.setInt(1, productId);
		return deleteProduct.executeUpdate(); 
	}
	
	
	 
 
	@Override
	public  Product getProductById(int productId) throws SQLException 
	{
	
		
		getPorductById.setInt(1, productId);
		ResultSet rs = getPorductById.executeQuery();
		if(rs.next()) {
			String type = rs.getString("proType");
			if(type.equals("Shoes")) 
			{
				 
				Shoes shoes = new Shoes(rs.getString("name"), Colors.fromInt(rs.getInt("color")) , rs.getString("brand"), rs.getDouble("purchasePrice"), rs.getDouble("regularPrice"), rs.getDouble("salesPrice"), rs.getInt("shoesSize"), ShoesSizeCountry.fromInt(rs.getInt("shoesSizeCountry")));
				 shoes.setProType(rs.getString("proType"));
				 return shoes;
			}
			else 
			{
				Clothing clothing = new Clothing(rs.getString("name"), Colors.fromInt(rs.getInt("color")) , rs.getString("brand"), rs.getDouble("purchasePrice"), rs.getDouble("regularPrice"), rs.getDouble("salesPrice"),ClothingSize.fromInt(rs.getInt("size"))); 
				 clothing.setProType(rs.getString("proType"));
				 return clothing; 
			}
		}
		
		return null;
	}
	
	
	
	

	
	
	

}
