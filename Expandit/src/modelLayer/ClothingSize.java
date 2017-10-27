package modelLayer;

public enum ClothingSize {

	XS(1), 
	S(2),
	M(3),
	L(4), 
	XL(5),
	XXL(6); 
	
	
	int value = 0;
	
	
	ClothingSize(int value){
	this.value = value; 	
	}
	
	
	public int getValue() {
		return this.value; 
	}
	
	public static ClothingSize fromInt(int value) throws IllegalArgumentException
	{
		for(ClothingSize cs : ClothingSize.values()) 
		{
			if(cs.getValue() == value) {
				return cs; 
			}
		}
		return null; 
		
	}
	
	
	
	
	
	
	
	
	
	
}
