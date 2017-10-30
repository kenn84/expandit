package controllerLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import databaseLayer.ProductDB;
import databaseLayer.ProductDBIF;
import modelLayer.ClothingSize;
import modelLayer.Colors;
import modelLayer.Product;
import modelLayer.ShoesSizeCountry;

public class ProductController implements ProductDBIF{

	private ProductDB productDB;
	
	public ProductController() throws SQLException 
	{
		productDB = new ProductDB(); 
	}

	@Override
	public int createClothing(String name, Colors color, String brand, double purchasePrice, double regularPrice,
			double salesPrice, int supplierCvr, ClothingSize clothingSize) throws SQLException {
		return  productDB.createClothing(name, color, brand, purchasePrice, regularPrice, salesPrice, supplierCvr, clothingSize);
		
		
		
	}

	@Override
	public int createShoes(String name, Colors color, String brand, double purchasePrice, double regularPrice,
			double salesPrice, int supplierCvr, int shoesSize, ShoesSizeCountry shoesSizeCountry) throws SQLException {
		return productDB.createShoes(name, color, brand, purchasePrice, regularPrice, salesPrice, supplierCvr, shoesSize, shoesSizeCountry);
	}

	@Override
	public int updateClothing(int productId, String name, Colors color, String brand, double purchasePrice,
			double regularPrice, double salesPrice, int supplierCvr, String proType, ClothingSize clothingSize)
			throws SQLException {
		return productDB.updateClothing(productId, name, color, brand, purchasePrice, regularPrice, salesPrice, supplierCvr, proType, clothingSize);
	}

	@Override
	public int updateShoes(int productId, String name, Colors color, String brand, double purchasePrice,
			double regularPrice, double salesPrice, int supplierCvr, String proType, double shoesSize,
			ShoesSizeCountry shoesSizeCountry) throws SQLException {
		return productDB.updateShoes(productId, name, color, brand, purchasePrice, regularPrice, salesPrice, supplierCvr, proType, shoesSize, shoesSizeCountry);
	}

	@Override
	public Product getProductById(int productId) throws SQLException {
		
		return productDB.getProductById(productId);
		
	}

	@Override
	public int deleteProductById(int productId) throws SQLException {
		return productDB.deleteProductById(productId);
	}

	@Override
	public <T extends Product> ArrayList<Product> getAllProducts() throws SQLException {
		
		return productDB.getAllProducts();
	}

}
