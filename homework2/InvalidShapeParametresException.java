package javaproject1;

public class InvalidShapeParametresException extends Exception {
	String message;
	InvalidShapeParametresException(String m){
		message=m;
	}
	
	
	public String getMessage() {
		return message;
	}
}
