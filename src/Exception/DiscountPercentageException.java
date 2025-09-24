package Exception;

public class DiscountPercentageException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DiscountPercentageException() {

		super("Discount percentage must be between (0-1) ");
	}

}
