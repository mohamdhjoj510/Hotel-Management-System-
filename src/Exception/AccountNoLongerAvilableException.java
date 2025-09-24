package Exception;

public class AccountNoLongerAvilableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNoLongerAvilableException() {
		super("Your account is no longer available!");
	}
}
