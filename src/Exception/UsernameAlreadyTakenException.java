package Exception;

public class UsernameAlreadyTakenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsernameAlreadyTakenException() {
		super("This username is already taken\ntry another one please");
	}

}
