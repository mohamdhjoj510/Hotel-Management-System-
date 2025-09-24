package Exception;

public class DepartmentAlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DepartmentAlreadyExistException() {
		super("Department already exist , Can't be added");
	}

}
