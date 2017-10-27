package databaseLayer;

public class VeryBadException extends Exception{

	public VeryBadException(Exception e, String message) 
	{
		super(message, e);
		
	}
}
