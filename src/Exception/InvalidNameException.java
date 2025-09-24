package Exception;

public class InvalidNameException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNameException() {
        super("Invalid Name! Only letters are allowed for names.");
    }
}
