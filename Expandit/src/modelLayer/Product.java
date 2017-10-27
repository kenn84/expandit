package modelLayer;

public abstract class Product {
	
	private String name; 
	private Colors color; 
	private String brand; 
	private double purchasePrice; 
	private double regularPrice; 
	private double salesPrice;
	public Product(String name, Colors color, String brand, double purchasePrice, double regularPrice,
			double salesPrice) {
		this.name = name;
		this.color = color;
		this.brand = brand;
		this.purchasePrice = purchasePrice;
		this.regularPrice = regularPrice;
		this.salesPrice = salesPrice;
	} 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Colors getColor() {
		return color;
	}
	public void setColor(Colors color) {
		this.color = color;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getRegularPrice() {
		return regularPrice;
	}
	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}
	public double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	

}
