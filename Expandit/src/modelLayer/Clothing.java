package modelLayer;

public class Clothing extends Product{
	private ClothingSize clothingSize;
	
	public Clothing(String name, Colors color, String brand, double purchasePrice, double regularPrice,
			double salesPrice,ClothingSize clothingSize) {
		super(name , color , brand , purchasePrice , regularPrice, salesPrice );
		this.clothingSize = clothingSize;
	} 
	
	public ClothingSize getClothingSize() {
		return clothingSize;
	}

	public void setClothingSize(ClothingSize clothingSize) {
		this.clothingSize = clothingSize;
	}

	
	
}
