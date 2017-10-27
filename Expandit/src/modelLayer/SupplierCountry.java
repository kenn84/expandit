package modelLayer;

public enum SupplierCountry {
	Denmark(1),
	Sweden(2), 
	Norway(3), 
	Germany(4);
	
	int value = 0;
	
	
	SupplierCountry(int value) {
		this.value = value; 
	}
	
	
	public int getValue(){
		return this.value; 
	}
	
	
	public static SupplierCountry fromInt(int value)throws IllegalArgumentException {
		
		for(SupplierCountry sc : SupplierCountry.values()){
			if(sc.getValue() == value){
				return sc; 
			}
		}
		return null;
	}
	
	


	
	

}
