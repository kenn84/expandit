package databaseLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import modelLayer.ClothingSize;
import modelLayer.Colors;
import modelLayer.Product;
import modelLayer.ShoesSizeCountry;

public interface ProductDBIF {
	
	public int createClothing( String name, Colors color, String brand, double purchasePrice, double regularPrice,double salesPrice , int supplierCvr ,  ClothingSize clothingSize) throws SQLException;
	public int createShoes(String name, Colors color, String brand, double purchasePrice, double regularPrice,double salesPrice , int supplierCvr, int size, ShoesSizeCountry shoesSizeCountry) throws SQLException;
	public int updateClothing(int productId,  String name, Colors color, String brand, double purchasePrice, double regularPrice,double salesPrice , int supplierCvr ,String proType, ClothingSize clothingSize) throws SQLException;
	public int updateShoes(int productId ,  String name, Colors color, String brand, double purchasePrice, double regularPrice,double salesPrice , int supplierCvr ,String proType, double size , ShoesSizeCountry shoesSizeCountry) throws SQLException;
	public Product getProductById(int id) throws SQLException;
	public int deleteProductById(int productId) throws SQLException;
	public <T extends Product> ArrayList<Product> getAllProducts() throws SQLException;
	
	
}
