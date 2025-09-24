package Exception;

public class EmptyFieldsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyFieldsException() {
		super("Make sure there are no empty fields");
	}

}
