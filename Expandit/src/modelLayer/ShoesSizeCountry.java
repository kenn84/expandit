package modelLayer;

public enum ShoesSizeCountry {
	US(1), 
	Inch(2), 
	EU(3);
	
	
	int value = 0;
	
	
	ShoesSizeCountry(int value) {
		this.value = value; 
	}
	
	
	public int getValue(){
		return this.value; 
	}
	
	
	public static ShoesSizeCountry fromInt(int value)throws IllegalArgumentException {
		
		for(ShoesSizeCountry ss : ShoesSizeCountry.values()){
			if(ss.getValue() == value){
				return ss; 
			}
		}
		return null;
	}
	
	

}
