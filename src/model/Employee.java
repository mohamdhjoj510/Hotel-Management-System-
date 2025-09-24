package model;

import java.util.Objects;

import utils.Area;
import utils.Gender;

public class Employee extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double salary;
	private Department department;
	private int startOfWork;
	private String systemUsername;
	private String systemPassword;
	private int loginsCounter;
    private String profileImage; // New field to hold the profile image information.

	
	public Employee(String id, String firstName, String lastName, String phoneNumber, Area area, Gender gender,
			int yearOfBirth, double salary, Department department, int startOfWork, String systemUsername,
			String systemPassword) {
		super(id, firstName, lastName, phoneNumber, area, gender, yearOfBirth);
		this.salary = salary;
		this.department = department;
		this.startOfWork = startOfWork;
		this.systemUsername = systemUsername;
		this.systemPassword = systemPassword;
	}
	
	

	public String getProfileImage() {
		return profileImage;
	}



	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	



	public int getLoginsCounter() {
		return loginsCounter;
	}



	public void setLoginsCounter(int loginsCounter) {
		this.loginsCounter = loginsCounter;
	}



	public String getSystemUsername() {
		return systemUsername;
	}

	public void setSystemUsername(String systemUsername) {
		this.systemUsername = systemUsername;
	}

	public String getSystemPassword() {
		return systemPassword;
	}

	public void setSystemPassword(String systemPassword) {
		this.systemPassword = systemPassword;
	}

	public int getStartOfWork() {
		return startOfWork;
	}

	public void setStartOfWork(int startOfWork) {
		this.startOfWork = startOfWork;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id " + getId() + " salary=" + salary + ", department=" + department + ", startOfWork="
				+ startOfWork + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(department, salary, startOfWork);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(department, other.department)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary)
				&& startOfWork == other.startOfWork;
	}

}
