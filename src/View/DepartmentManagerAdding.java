package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
import model.DepartmentManager;
import model.Employee;
import model.Hotel;
import utils.Area;
import utils.Gender;
import javax.swing.JPasswordField;

public class DepartmentManagerAdding extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmDepmanagerdetails;
	private JTextField salaryText;
	private JTextField startOfWorkText;
	private JTextField bonusText;
	private JTextField employeeUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentManagerAdding window = new DepartmentManagerAdding();
					window.frmDepmanagerdetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DepartmentManagerAdding() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private void initialize() {
		frmDepmanagerdetails = new JFrame();
		frmDepmanagerdetails.setTitle("DepManager_Details");
		frmDepmanagerdetails.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 25));
		frmDepmanagerdetails.setBounds(100, 100, 645, 500);
		frmDepmanagerdetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDepmanagerdetails.getContentPane().setLayout(null);

		// Label for instructions to fill the details
		JLabel msg1 = new JLabel("    Please, fill in the new department manager details");
		msg1.setForeground(new Color(0, 255, 255));
		msg1.setFont(new Font("Tahoma", Font.BOLD, 20));
		msg1.setBounds(22, 10, 550, 25);
		frmDepmanagerdetails.getContentPane().add(msg1);

		// Label and text field for employee ID
		JLabel msg2 = new JLabel("employee id :");
		msg2.setForeground(new Color(0, 255, 255));
		msg2.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg2.setBounds(32, 45, 114, 23);
		frmDepmanagerdetails.getContentPane().add(msg2);
		JTextField employeeIdText = new JTextField();
		employeeIdText.setBounds(32, 64, 114, 31);
		frmDepmanagerdetails.getContentPane().add(employeeIdText);
		employeeIdText.setColumns(10);

		// Label and text fields for first name and last name
		JLabel msg3 = new JLabel("first name :");
		msg3.setForeground(new Color(0, 255, 255));
		msg3.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg3.setBounds(219, 48, 114, 16);
		frmDepmanagerdetails.getContentPane().add(msg3);
		JTextField firstNameText = new JTextField();
		firstNameText.setBounds(219, 64, 114, 31);
		frmDepmanagerdetails.getContentPane().add(firstNameText);
		firstNameText.setColumns(10);

		JLabel msg4 = new JLabel("last name :");
		msg4.setForeground(new Color(0, 255, 255));
		msg4.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg4.setBounds(414, 48, 114, 16);
		frmDepmanagerdetails.getContentPane().add(msg4);
		JTextField lastNameText = new JTextField();
		lastNameText.setBounds(414, 64, 114, 31);
		frmDepmanagerdetails.getContentPane().add(lastNameText);
		lastNameText.setColumns(10);

		// Label and text field for phone number
		JLabel msg5 = new JLabel("phone number :");
		msg5.setForeground(new Color(0, 255, 255));
		msg5.setFont(new Font("Tahoma", Font.BOLD, 14));
		msg5.setBounds(32, 125, 129, 23);
		frmDepmanagerdetails.getContentPane().add(msg5);
		JTextField phoneNumberText = new JTextField();
		phoneNumberText.setBounds(32, 147, 114, 31);
		frmDepmanagerdetails.getContentPane().add(phoneNumberText);
		phoneNumberText.setColumns(10);

		// ComboBox for selecting the area
		Area[] customerAreas = { Area.Jerusalem, Area.Central, Area.Haifa, Area.JudeaAndSamaria, Area.Northern,
				Area.Southern, Area.TelAviv };
		JLabel msg6 = new JLabel("area :");
		msg6.setForeground(new Color(0, 255, 255));
		msg6.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg6.setBounds(219, 125, 114, 23);
		frmDepmanagerdetails.getContentPane().add(msg6);
		JComboBox areaBox = new JComboBox(customerAreas);
		areaBox.setBounds(219, 144, 114, 37);
		frmDepmanagerdetails.getContentPane().add(areaBox);

		// ComboBox for selecting gender
		String[] genders = { "MALE", "FEMALE" };
		JLabel msg7 = new JLabel("gender :");
		msg7.setForeground(new Color(0, 255, 255));
		msg7.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg7.setBounds(414, 125, 114, 23);
		frmDepmanagerdetails.getContentPane().add(msg7);
		JComboBox genderBox = new JComboBox(genders);
		genderBox.setBounds(414, 145, 114, 34);
		frmDepmanagerdetails.getContentPane().add(genderBox);

		// Label and text field for year of birth
		JLabel msg8 = new JLabel("year of birth :");
		msg8.setForeground(new Color(0, 255, 255));
		msg8.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg8.setBounds(32, 203, 114, 16);
		frmDepmanagerdetails.getContentPane().add(msg8);
		JTextField yearOfBirthText = new JTextField();
		yearOfBirthText.setBounds(32, 221, 114, 31);
		frmDepmanagerdetails.getContentPane().add(yearOfBirthText);
		yearOfBirthText.setColumns(10);

		Integer[] days = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
				26, 27, 28, 29, 30, 31 };
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		Integer[] years = { 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004,
				2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021,
				2022, 2023 };

		// Label, text field, and icon for salary
		JLabel msg9 = new JLabel("salary :");
		msg9.setForeground(new Color(0, 255, 255));
		msg9.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg9.setBounds(219, 203, 108, 16);
		frmDepmanagerdetails.getContentPane().add(msg9);
		salaryText = new JTextField();
		salaryText.setBounds(219, 221, 114, 31);
		frmDepmanagerdetails.getContentPane().add(salaryText);
		salaryText.setColumns(10);
		JLabel usdIcon = new JLabel("$");
		usdIcon.setFont(new Font("Tahoma", Font.BOLD, 15));
		usdIcon.setBounds(334, 300, 26, 27);
		frmDepmanagerdetails.getContentPane().add(usdIcon);

		// ComboBox for selecting department ID
		JLabel msg10 = new JLabel("department id :");
		msg10.setFont(new Font("Tahoma", Font.BOLD, 15));
		msg10.setForeground(new Color(0, 255, 255));
		msg10.setBounds(414, 203, 129, 16);
		frmDepmanagerdetails.getContentPane().add(msg10);
		ArrayList<String> departments = new ArrayList<String>();
		for (Department d : Hotel.getInstance().getAllDepartments().values()) {
			departments.add(d.getDepartmentId());
		}
		JComboBox departmentsBox = new JComboBox();
		departmentsBox.setBounds(414, 221, 114, 31);
		frmDepmanagerdetails.getContentPane().add(departmentsBox);
		for (String departmentID : departments) {
			departmentsBox.addItem(departmentID);
		}

		// Label and text field for start of work year
		JLabel msg11 = new JLabel("start of work year :");
		msg11.setForeground(new Color(0, 255, 255));
		msg11.setBackground(new Color(0, 0, 255));
		msg11.setFont(new Font("Tahoma", Font.BOLD, 12));
		msg11.setBounds(32, 278, 129, 25);
		frmDepmanagerdetails.getContentPane().add(msg11);
		startOfWorkText = new JTextField();
		startOfWorkText.setBounds(32, 296, 123, 31);
		frmDepmanagerdetails.getContentPane().add(startOfWorkText);
		startOfWorkText.setColumns(10);

		// Label and text field for bonus
		JLabel msg12 = new JLabel("bonus :");
		msg12.setForeground(new Color(0, 255, 255));
		msg12.setFont(new Font("Tahoma", Font.BOLD, 15));
		msg12.setBounds(219, 281, 111, 16);
		frmDepmanagerdetails.getContentPane().add(msg12);
		bonusText = new JTextField();
		bonusText.setBounds(219, 298, 114, 31);
		frmDepmanagerdetails.getContentPane().add(bonusText);
		bonusText.setColumns(10);

		// Label and text field for employee username
		JLabel lblNewLabel = new JLabel("employee username :");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(414, 284, 188, 19);
		frmDepmanagerdetails.getContentPane().add(lblNewLabel);
		employeeUsername = new JTextField();
		employeeUsername.setBounds(414, 302, 114, 31);
		frmDepmanagerdetails.getContentPane().add(employeeUsername);
		employeeUsername.setColumns(10);

		// Label and password field for employee password
		JLabel lblNewLabel_1 = new JLabel("employee password :");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(32, 357, 159, 25);
		frmDepmanagerdetails.getContentPane().add(lblNewLabel_1);
		passwordField = new JPasswordField();
		passwordField.setBounds(32, 379, 129, 31);
		frmDepmanagerdetails.getContentPane().add(passwordField);

		// Submit button to add department manager
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					// Check if there are empty fields in the details
					if (employeeIdText.getText().isEmpty() || firstNameText.getText().isEmpty()
							|| lastNameText.getText().isEmpty() || phoneNumberText.getText().isEmpty()
							|| yearOfBirthText.getText().isEmpty() || salaryText.getText().isEmpty()
							|| departmentsBox.getSelectedItem() == null || startOfWorkText.getText().isEmpty()
							|| employeeUsername.getText().isEmpty() || passwordField.getText().isEmpty()
							|| bonusText.getText().isEmpty()) {
						throw new EmptyFieldsException();
					}
					// Check if first name and last name contain only letters
					if (!firstNameText.getText().matches("[a-zA-Z]+") || !lastNameText.getText().matches("[a-zA-Z]+")) {
						throw new InvalidNameException();
					}
					// Check if phone number has exactly 10 digits
					if (phoneNumberText.getText().length() != 10) {
						throw new InvalidPhoneNumberException();
					}
					// Check if the employee ID or username already exists in the system
					if (Hotel.getInstance().getAllCustomers().containsKey(employeeIdText.getText())
							|| Hotel.getInstance().getAllEmployees().containsKey(employeeIdText.getText())) {
						throw new PersonAlreadyExistException(firstNameText.getText(), lastNameText.getText());
					}
					// Check if any numeric field is negative
					if (Double.parseDouble(employeeIdText.getText()) < 0
							|| Double.parseDouble(phoneNumberText.getText()) < 0
							|| Integer.parseInt(yearOfBirthText.getText()) < 0
							|| Double.parseDouble(salaryText.getText()) < 0
							|| Integer.parseInt(startOfWorkText.getText()) < 0
							|| Double.parseDouble(bonusText.getText()) < 0) {
						throw new NegativeNumberException();
					}

					Area dpEmployeeArea = (Area) areaBox.getSelectedItem();
					Gender g;
					if (genderBox.getSelectedItem().equals("MALE")) {
						g = Gender.M;
					} else {
						g = Gender.F;
					}
					for (Employee e1 : Hotel.getInstance().getAllEmployees().values()) {
						if (e1.getSystemUsername().equals(employeeUsername.getText())) {
							throw new UsernameAlreadyTakenException();
						}
					}
					// Ask the user if they want to add a profile image
					int option = JOptionPane.showOptionDialog(null, "Do you want to add a profile image?",
							"Profile Image", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

					String profileImagePath = null;

					if (option == JOptionPane.YES_OPTION) {
						// If the user chooses "Yes," ask for the profile image path or URL
						profileImagePath = JOptionPane.showInputDialog(null, "Enter the profile image path:");
					}

					Department employeeDepartment = Hotel.getInstance()
							.getRealDepartment((String) departmentsBox.getSelectedItem());

					DepartmentManager dp1 = new DepartmentManager(employeeIdText.getText(), firstNameText.getText(),
							lastNameText.getText(), phoneNumberText.getText(), dpEmployeeArea, g,
							Integer.parseInt(yearOfBirthText.getText()), Double.parseDouble(salaryText.getText()),
							employeeDepartment, Integer.parseInt(startOfWorkText.getText()), employeeUsername.getText(),
							passwordField.getText(), Double.parseDouble(bonusText.getText()));
					if (option == JOptionPane.NO_OPTION) {
						dp1.setProfileImage(null);
					} else {
						dp1.setProfileImage(profileImagePath);
					}
					dp1.setLoginsCounter(0);
					Hotel.getInstance().addDepartmentManager(dp1);
					Main.save();
					JOptionPane.showMessageDialog(null, "Department manager added successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					frmDepmanagerdetails.setVisible(false);
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
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		submit.setBackground(new Color(0, 255, 255));
		submit.setBounds(482, 379, 108, 40);
		frmDepmanagerdetails.getContentPane().add(submit);

		// Button to go back to the employee type selection page
		JButton backToAddPage = new JButton("CANCEL");
		backToAddPage.setBackground(new Color(0, 255, 255));
		backToAddPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDepmanagerdetails.setVisible(false);
				EmployeeType page2 = new EmployeeType();
				page2.showWindow();
			}
		});
		backToAddPage.setBounds(339, 379, 108, 40);
		frmDepmanagerdetails.getContentPane().add(backToAddPage);

		// Background image for the frame
		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 645, 463);
		frmDepmanagerdetails.getContentPane().add(backgroundLabel);
	}

	// Method to show the frame
	public void showWindow() {
		frmDepmanagerdetails.setVisible(true);
	}
}
