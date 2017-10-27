package modelLayer;

public enum Colors {
	
	Blue(1), 
	Green(2),
	Yellow(3),
	Red(4), 
	Purple(5),
	White(6),
	Black(7);
	
	
	int value = 0;
	
	
	Colors(int value){
		this.value = value; 
	}
	
	
	public int getValue() {
	return this.value;
	}
	
	
	public static Colors fromInt(int value) throws IllegalArgumentException 
	{ 
		for(Colors col : Colors.values()) {
			
			if(col.getValue() == value){
				return col; 
			}
		}
		return null;
	}
	
	
	
	
	

}
