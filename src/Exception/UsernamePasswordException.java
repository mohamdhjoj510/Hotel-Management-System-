package Exception;

public class UsernamePasswordException extends Exception   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsernamePasswordException() {
		super("Inavlid username/password!");
	}

}
