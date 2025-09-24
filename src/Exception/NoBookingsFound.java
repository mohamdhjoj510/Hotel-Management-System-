package Exception;

public class NoBookingsFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoBookingsFound() {
		super("No bookings found");
	}

}
