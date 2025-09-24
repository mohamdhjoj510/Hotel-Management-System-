package Exception;

import model.Hotel;

public class InvalidNumberOfEmployees extends Exception  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidNumberOfEmployees() {
		super("The Employees Number is "+Hotel.getInstance().getAllEmployees().size()+"\nPlease add valed value!");
	}

}
