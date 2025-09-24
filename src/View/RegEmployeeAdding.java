package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Exception.EmptyFieldsException;
import Exception.InvalidNameException;
import Exception.InvalidPhoneNumberException;
import Exception.NegativeNumberException;
import Exception.PersonAlreadyExistException;
import Exception.UsernameAlreadyTakenException;
import model.Department;
import model.Employee;
import model.Hotel;
import utils.Area;
import utils.Gender;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPasswordField;

public class RegEmployeeAdding extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmEmployeedetails;
	private JTextField salaryText;
	private JTextField startOfWorkYearText;
	private JTextField usernameText;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegEmployeeAdding window = new RegEmployeeAdding();
					window.frmEmployeedetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegEmployeeAdding() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private void initialize() {
		frmEmployeedetails = new JFrame();
		frmEmployeedetails.setTitle("Employee_Details");
		frmEmployeedetails.setBounds(100, 100, 645, 500);
		frmEmployeedetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeedetails.getContentPane().setLayout(null);

		JLabel msg1 = new JLabel("              Please , fill in the new employee details");
		msg1.setForeground(new Color(0, 255, 255));
		msg1.setFont(new Font("Tahoma", Font.BOLD, 20));
		msg1.setBounds(22, 10, 550, 25);
		frmEmployeedetails.getContentPane().add(msg1);
		JLabel msg2 = new JLabel("employee id :");
		msg2.setForeground(new Color(0, 255, 255));
		msg2.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg2.setBounds(22, 56, 114, 23);
		frmEmployeedetails.getContentPane().add(msg2);

		JTextField employeeIdText = new JTextField();
		employeeIdText.setBounds(22, 76, 114, 31);
		frmEmployeedetails.getContentPane().add(employeeIdText);
		employeeIdText.setColumns(10);

		JLabel msg3 = new JLabel("first name :");
		msg3.setForeground(new Color(0, 255, 255));
		msg3.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg3.setBounds(219, 59, 114, 16);
		frmEmployeedetails.getContentPane().add(msg3);

		JTextField firstNameText = new JTextField();
		firstNameText.setBounds(219, 76, 114, 31);
		frmEmployeedetails.getContentPane().add(firstNameText);
		firstNameText.setColumns(10);

		JLabel msg4 = new JLabel("last name :");
		msg4.setForeground(new Color(0, 255, 255));
		msg4.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg4.setBounds(410, 59, 114, 16);
		frmEmployeedetails.getContentPane().add(msg4);

		JTextField lastNameText = new JTextField();
		lastNameText.setBounds(410, 76, 114, 31);
		frmEmployeedetails.getContentPane().add(lastNameText);
		lastNameText.setColumns(10);

		JLabel msg5 = new JLabel("phone number :");
		msg5.setForeground(new Color(0, 255, 255));
		msg5.setFont(new Font("Tahoma", Font.BOLD, 14));
		msg5.setBounds(22, 146, 129, 23);
		frmEmployeedetails.getContentPane().add(msg5);

		JTextField phoneNumberText = new JTextField();
		phoneNumberText.setBounds(22, 168, 114, 31);
		frmEmployeedetails.getContentPane().add(phoneNumberText);
		phoneNumberText.setColumns(10);

		Area[] employeesAreas = { Area.Jerusalem, Area.Central, Area.Haifa, Area.JudeaAndSamaria, Area.Northern,
				Area.Southern, Area.TelAviv };
		JLabel msg6 = new JLabel("area :");
		msg6.setForeground(new Color(0, 255, 255));
		msg6.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg6.setBounds(219, 146, 114, 23);
		frmEmployeedetails.getContentPane().add(msg6);

		JComboBox areaBox = new JComboBox(employeesAreas);
		areaBox.setBounds(219, 165, 114, 37);
		frmEmployeedetails.getContentPane().add(areaBox);

		String[] genders = { "MALE", "FEMALE" };
		JLabel msg7 = new JLabel("gender :");
		msg7.setForeground(new Color(0, 255, 255));
		msg7.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg7.setBounds(410, 146, 114, 23);
		frmEmployeedetails.getContentPane().add(msg7);

		JComboBox genderBox = new JComboBox(genders);
		genderBox.setBounds(410, 166, 114, 34);
		frmEmployeedetails.getContentPane().add(genderBox);

		JLabel msg8 = new JLabel("year of birth :");
		msg8.setForeground(new Color(0, 255, 255));
		msg8.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg8.setBounds(22, 233, 114, 25);
		frmEmployeedetails.getContentPane().add(msg8);

		JTextField yearOfBirthText = new JTextField();
		yearOfBirthText.setBounds(22, 255, 114, 31);
		frmEmployeedetails.getContentPane().add(yearOfBirthText);
		yearOfBirthText.setColumns(10);

		Integer[] days = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
				26, 27, 28, 29, 30, 31 };
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		Integer[] years = { 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004,
				2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021,
				2022, 2023 };

		JLabel msg9 = new JLabel("salary :");
		msg9.setForeground(new Color(0, 255, 255));
		msg9.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg9.setBounds(219, 233, 114, 25);
		frmEmployeedetails.getContentPane().add(msg9);

		salaryText = new JTextField();
		salaryText.setBounds(219, 255, 114, 31);
		frmEmployeedetails.getContentPane().add(salaryText);
		salaryText.setColumns(10);

		JLabel msg10 = new JLabel("department id :");
		msg10.setFont(new Font("Tahoma", Font.BOLD, 15));
		msg10.setForeground(new Color(0, 255, 255));
		msg10.setBounds(410, 233, 162, 25);
		frmEmployeedetails.getContentPane().add(msg10);

		JLabel msg11 = new JLabel("start of work year :");
		msg11.setForeground(new Color(0, 255, 255));
		msg11.setBackground(new Color(0, 0, 255));
		msg11.setFont(new Font("Tahoma", Font.BOLD, 12));
		msg11.setBounds(22, 317, 129, 25);
		frmEmployeedetails.getContentPane().add(msg11);

		startOfWorkYearText = new JTextField();
		startOfWorkYearText.setBounds(22, 338, 123, 31);
		frmEmployeedetails.getContentPane().add(startOfWorkYearText);
		startOfWorkYearText.setColumns(10);

		JLabel lblNewLabel = new JLabel("employee username :");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(210, 317, 134, 21);
		frmEmployeedetails.getContentPane().add(lblNewLabel);

		usernameText = new JTextField();
		usernameText.setBounds(210, 338, 129, 31);
		frmEmployeedetails.getContentPane().add(usernameText);
		usernameText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("employee password :");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(410, 318, 129, 23);
		frmEmployeedetails.getContentPane().add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(410, 338, 129, 31);
		frmEmployeedetails.getContentPane().add(passwordField);

		ArrayList<String> departments = new ArrayList<String>();
		for (Department d : Hotel.getInstance().getAllDepartments().values()) {
			departments.add(d.getDepartmentId());
		}
		JComboBox departmentsBox = new JComboBox();
		departmentsBox.setBounds(410, 255, 114, 31);
		frmEmployeedetails.getContentPane().add(departmentsBox);
		for (String departmentID : departments) {
			departmentsBox.addItem(departmentID);
		}

		// Assuming the UI is created using Swing components
		JButton addPhotoButton = new JButton("Add Photo");
		// Add this button to the UI as needed.

		// Create a "SUBMIT" button
		JButton submit = new JButton("SUBMIT");
		// Add an ActionListener to handle the button click
		submit.addActionListener(new ActionListener() {
			// ActionListener's actionPerformed method is invoked when the button is clicked
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					// Check if any required fields are empty
					if (employeeIdText.getText().isEmpty() || firstNameText.getText().isEmpty()
							|| lastNameText.getText().isEmpty() || phoneNumberText.getText().isEmpty()
							|| yearOfBirthText.getText().isEmpty() || salaryText.getText().isEmpty()
							|| departmentsBox.getSelectedItem() == null || startOfWorkYearText.getText().isEmpty()
							|| usernameText.getText().isEmpty() || passwordField.getText().isEmpty()) {
						// Throw an exception if any field is empty
						throw new EmptyFieldsException();
					}

					// Check if first name and last name contain only letters
					if (!firstNameText.getText().matches("[a-zA-Z]+") || !lastNameText.getText().matches("[a-zA-Z]+")) {
						throw new InvalidNameException();
					}

					// Check for negative numeric values
					if (Double.parseDouble(employeeIdText.getText()) < 0
							|| Double.parseDouble(phoneNumberText.getText()) < 0
							|| Integer.parseInt(yearOfBirthText.getText()) < 0
							|| Double.parseDouble(salaryText.getText()) < 0
							|| Integer.parseInt(startOfWorkYearText.getText()) < 0) {
						throw new NegativeNumberException();
					}

					// Check if phone number has exactly 10 digits
					if (phoneNumberText.getText().length() != 10) {
						throw new InvalidPhoneNumberException();
					}

					// Check if employee ID or username already exist
					if (Hotel.getInstance().getAllCustomers().containsKey(employeeIdText.getText())
							|| Hotel.getInstance().getAllEmployees().containsKey(employeeIdText.getText())) {
						throw new PersonAlreadyExistException(firstNameText.getText(), lastNameText.getText());
					}

					// Check if the username is already taken
					for (Employee e1 : Hotel.getInstance().getAllEmployees().values()) {
						if (e1.getSystemUsername().equals(usernameText.getText())) {
							throw new UsernameAlreadyTakenException();
						}
					}

					// Get the selected area from the combo box
					Area employeeArea = (Area) areaBox.getSelectedItem();

					// Determine the selected gender
					Gender g;
					if (genderBox.getSelectedItem().equals("MALE")) {
						g = Gender.M;
					} else {
						g = Gender.F;
					}

					// Ask the user if they want to add a profile image
					int option = JOptionPane.showOptionDialog(null, "Do you want to add a profile image?",
							"Profile Image", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

					String profileImagePath = null;

					// If the user chooses "Yes," ask for the profile image path or URL
					if (option == JOptionPane.YES_OPTION) {
						profileImagePath = JOptionPane.showInputDialog(null, "Enter the profile image path:");
					}

					// Get the selected department using the department ID from the combo box
					Department employeeDepartment = Hotel.getInstance()
							.getRealDepartment((String) departmentsBox.getSelectedItem());

					// Create a new Employee object with provided details
					Employee e1 = new Employee(employeeIdText.getText(), firstNameText.getText(),
							lastNameText.getText(), phoneNumberText.getText(), employeeArea, g,
							Integer.parseInt(yearOfBirthText.getText()), Double.parseDouble(salaryText.getText()),
							employeeDepartment, Integer.parseInt(startOfWorkYearText.getText()), usernameText.getText(),
							passwordField.getText());

					// Set the profile image path if provided, otherwise set to null
					if (option == JOptionPane.NO_OPTION) {
						e1.setProfileImage(null);
					} else {
						e1.setProfileImage(profileImagePath);
					}

					// Set the logins counter and add the employee to the system
					e1.setLoginsCounter(0);
					Hotel.getInstance().addEmployee(e1);
					Main.save();

					// Display a success message
					JOptionPane.showMessageDialog(null, "employee added successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);

					// Hide the current window and show the AdminFirstView
					frmEmployeedetails.setVisible(false);
					AdminFirstView page = new AdminFirstView();
					page.showWindow();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter numeric values for appropriate fields",
							"Input Error", JOptionPane.ERROR_MESSAGE);
				} catch (EmptyFieldsException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (InvalidPhoneNumberException ex1) {
					JOptionPane.showMessageDialog(null, ex1.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (PersonAlreadyExistException ex2) {
					JOptionPane.showMessageDialog(null, ex2.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (InvalidNameException ex3) {
					JOptionPane.showMessageDialog(null, ex3.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (NegativeNumberException ex4) {
					JOptionPane.showMessageDialog(null, ex4.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (UsernameAlreadyTakenException ex5) {
					JOptionPane.showMessageDialog(null, ex5.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		submit.setBackground(new Color(0, 255, 255));
		submit.setBounds(339, 402, 108, 40);
		frmEmployeedetails.getContentPane().add(submit);

		JButton cancel = new JButton("CANCEL");
		cancel.setBackground(new Color(0, 255, 255));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeedetails.setVisible(false);
				EmployeeType page2 = new EmployeeType();
				page2.showWindow();
			}
		});
		cancel.setBounds(167, 402, 108, 40);
		frmEmployeedetails.getContentPane().add(cancel);

		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 648, 489);
		frmEmployeedetails.getContentPane().add(backgroundLabel);
	}

	public void showWindow() {
		frmEmployeedetails.setVisible(true);

	}
}
