package modelLayer;

public class Shoes extends Product{
	
	private double size; 
	private ShoesSizeCountry shoesSizeCountry;
	public Shoes(String name, Colors color, String brand, double purchasePrice, double regularPrice,
			double salesPrice, double size, ShoesSizeCountry shoesSizeCountry ) {
		super(name , color , brand , purchasePrice , regularPrice, salesPrice );
		this.size = size;
		this.shoesSizeCountry = shoesSizeCountry;
	}

	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public ShoesSizeCountry getCountry() {
		return shoesSizeCountry;
	}
	public void setCountry(ShoesSizeCountry shoesSizeCountry) {
		this.shoesSizeCountry = shoesSizeCountry;
	} 

}
