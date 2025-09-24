package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Exception.EmptyFieldsException;
import Exception.InvalidNameException;
import Exception.InvalidPhoneNumberException;
import Exception.NegativeNumberException;
import Exception.PersonAlreadyExistException;
import model.Customer;
import model.Hotel;
import utils.Area;
import utils.Gender;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class RegCustomerAdding extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmCustomerdetails;
	private JTextField customerIdText;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField phoneNumberText;
	private JTextField yearOfBirthText;

	// Main method to launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegCustomerAdding window = new RegCustomerAdding();
					window.frmCustomerdetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor to create a new RegCustomerAdding object.
	public RegCustomerAdding() {
		initialize();
	}

	// Initialize the contents of the frame and set up the GUI components.
	private void initialize() {
		frmCustomerdetails = new JFrame();
		frmCustomerdetails.setTitle("Customer_Details");
		frmCustomerdetails.setBounds(100, 100, 645, 500);
		frmCustomerdetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomerdetails.getContentPane().setLayout(null);

		// Label to prompt the user to fill in the customer details.
		JLabel msg1 = new JLabel("                  Please fill in the new customer details");
		msg1.setForeground(new Color(0, 255, 255));
		msg1.setFont(new Font("Tahoma", Font.BOLD, 20));
		msg1.setBounds(10, 40, 598, 40);
		frmCustomerdetails.getContentPane().add(msg1);

		// Label and text field for customer ID input.
		JLabel msg2 = new JLabel("customer id :");
		msg2.setForeground(new Color(0, 255, 255));
		msg2.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg2.setBounds(22, 124, 114, 23);
		frmCustomerdetails.getContentPane().add(msg2);

		customerIdText = new JTextField();
		customerIdText.setBounds(22, 145, 114, 31);
		frmCustomerdetails.getContentPane().add(customerIdText);
		customerIdText.setColumns(10);

		// Label and text field for first name input.
		JLabel msg3 = new JLabel("first name :");
		msg3.setForeground(new Color(0, 255, 255));
		msg3.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg3.setBounds(219, 127, 114, 16);
		frmCustomerdetails.getContentPane().add(msg3);

		firstNameText = new JTextField();
		firstNameText.setBounds(219, 145, 114, 31);
		frmCustomerdetails.getContentPane().add(firstNameText);
		firstNameText.setColumns(10);

		// Label and text field for last name input.
		JLabel msg4 = new JLabel("last name :");
		msg4.setForeground(new Color(0, 255, 255));
		msg4.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg4.setBounds(426, 127, 114, 16);
		frmCustomerdetails.getContentPane().add(msg4);

		lastNameText = new JTextField();
		lastNameText.setBounds(426, 145, 114, 31);
		frmCustomerdetails.getContentPane().add(lastNameText);
		lastNameText.setColumns(10);

		// Label and text field for phone number input.
		JLabel msg5 = new JLabel("phone number :");
		msg5.setForeground(new Color(0, 255, 255));
		msg5.setFont(new Font("Tahoma", Font.BOLD, 14));
		msg5.setBounds(22, 211, 129, 23);
		frmCustomerdetails.getContentPane().add(msg5);

		phoneNumberText = new JTextField();
		phoneNumberText.setBounds(22, 233, 114, 31);
		frmCustomerdetails.getContentPane().add(phoneNumberText);
		phoneNumberText.setColumns(10);

		// ComboBox for selecting the customer area.
		Area[] customerAreas = { Area.Jerusalem, Area.Central, Area.Haifa, Area.JudeaAndSamaria, Area.Northern,
				Area.Southern, Area.TelAviv };
		JLabel msg6 = new JLabel("area :");
		msg6.setForeground(new Color(0, 255, 255));
		msg6.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg6.setBounds(219, 211, 114, 23);
		frmCustomerdetails.getContentPane().add(msg6);

		JComboBox<Area> areaBox = new JComboBox<>(customerAreas);
		areaBox.setBounds(219, 233, 114, 31);
		frmCustomerdetails.getContentPane().add(areaBox);

		// ComboBox for selecting the customer gender.
		String[] genders = { "MALE", "FEMALE" };
		JLabel msg7 = new JLabel("gender :");
		msg7.setForeground(new Color(0, 255, 255));
		msg7.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg7.setBounds(426, 211, 114, 23);
		frmCustomerdetails.getContentPane().add(msg7);

		JComboBox<String> genderBox = new JComboBox<>(genders);
		genderBox.setBounds(426, 233, 114, 31);
		frmCustomerdetails.getContentPane().add(genderBox);

		// Label and text field for year of birth input.
		JLabel msg8 = new JLabel("year of birth :");
		msg8.setForeground(new Color(0, 255, 255));
		msg8.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg8.setBounds(22, 309, 114, 16);
		frmCustomerdetails.getContentPane().add(msg8);

		yearOfBirthText = new JTextField();
		yearOfBirthText.setBounds(22, 325, 114, 31);
		frmCustomerdetails.getContentPane().add(yearOfBirthText);
		yearOfBirthText.setColumns(10);

		// ComboBoxes for selecting the date of joining.
		Integer[] days = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
				26, 27, 28, 29, 30, 31 };
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		Integer[] years = { 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004,
				2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021,
				2022, 2023 };
		JLabel msg9 = new JLabel("date of joining :");
		msg9.setForeground(new Color(0, 255, 255));
		msg9.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg9.setBounds(209, 309, 167, 16);
		frmCustomerdetails.getContentPane().add(msg9);

		JComboBox<Integer> dayBox = new JComboBox<>(days);
		dayBox.setToolTipText("");
		dayBox.setBounds(209, 329, 44, 23);
		frmCustomerdetails.getContentPane().add(dayBox);

		JComboBox<String> monthBox = new JComboBox<>(months);
		monthBox.setBounds(252, 329, 62, 23);
		frmCustomerdetails.getContentPane().add(monthBox);

		JComboBox<Integer> yearBox = new JComboBox<>(years);
		yearBox.setBounds(314, 329, 62, 23);
		frmCustomerdetails.getContentPane().add(yearBox);

		// Button to submit the customer details.
		JButton submitCustomer = new JButton("SUBMIT");
		submitCustomer.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					// Check if there are any empty fields in the customer details.
					if (customerIdText.getText().isEmpty() || firstNameText.getText().isEmpty()
							|| lastNameText.getText().isEmpty() || phoneNumberText.getText().isEmpty()
							|| yearOfBirthText.getText().isEmpty()) {
						throw new EmptyFieldsException();
					}
					// Check if the first name and last name contain only letters.
					if (!firstNameText.getText().matches("[a-zA-Z]+") || !lastNameText.getText().matches("[a-zA-Z]+")) {
						throw new InvalidNameException();
					}
					// Check if customer ID, phone number, and year of birth are positive numbers.
					if (Double.parseDouble(customerIdText.getText()) < 0.0
							|| Double.parseDouble(phoneNumberText.getText()) < 0
							|| Integer.parseInt(yearOfBirthText.getText()) < 0) {
						throw new NegativeNumberException();

					}
					// Check if the phone number has the correct length.
					if (phoneNumberText.getText().length() != 10) {
						throw new InvalidPhoneNumberException();
					}
					// Check if the customer ID is already used by an existing customer or employee.
					if (Hotel.getInstance().getAllCustomers().containsKey(customerIdText.getText())
							|| Hotel.getInstance().getAllEmployees().containsKey(customerIdText.getText())) {
						throw new PersonAlreadyExistException(firstNameText.getText(), lastNameText.getText());
					}
					// Get the selected customer area.
					Area customerArea = (Area) areaBox.getSelectedItem();
					// Get the selected customer gender.
					Gender g = genderBox.getSelectedItem().equals("MALE") ? Gender.M : Gender.F;
					int day = (Integer) dayBox.getSelectedItem();
					int monthIndex = monthBox.getSelectedIndex(); // Since JComboBox is 0-based, the selected index
																	// represents the month
					int year = (Integer) yearBox.getSelectedItem();

					// Convert the selected values to a java.util.Date object
					java.util.Date selectedDate = new java.util.Date(year - 1900, monthIndex, day);
					// Create a new customer object with the provided details.
					Customer c = new Customer(customerIdText.getText(), firstNameText.getText(), lastNameText.getText(),
							phoneNumberText.getText(), customerArea, g, Integer.parseInt(yearOfBirthText.getText()),
							selectedDate);
					// Add the new customer to the system.
					Hotel.getInstance().addCustomer(c);
					// Show a success message.
					Main.save();
					JOptionPane.showMessageDialog(null, "customer added successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);

					// Decide which page to show next based on the user type (admin or employee).
					if (LoginPage.getUserType().equals("admin")) {
						frmCustomerdetails.setVisible(false);
						AdminAddPage p7 = new AdminAddPage();
						p7.showWindow();
					} else {
						frmCustomerdetails.setVisible(false);
						EmployeeAddPage p7 = new EmployeeAddPage();
						p7.showWindow();
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter numeric values for appropriate fields",
							"Input Error", JOptionPane.ERROR_MESSAGE);
				} catch (EmptyFieldsException ex) {
					// Handle the exception for empty fields.
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (InvalidPhoneNumberException ex1) {
					// Handle the exception for invalid phone number.
					JOptionPane.showMessageDialog(null, ex1.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (PersonAlreadyExistException ex2) {
					// Handle the exception for existing customer or employee.
					JOptionPane.showMessageDialog(null, ex2.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (InvalidNameException ex3) {
					// Handle the exception for invalid name (contains non-letter characters).
					JOptionPane.showMessageDialog(null, ex3.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (NegativeNumberException ex4) {
					// Handle the exception for negative numbers.
					JOptionPane.showMessageDialog(null, ex4.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submitCustomer.setBackground(new Color(0, 255, 255));
		submitCustomer.setBounds(455, 330, 108, 40);
		frmCustomerdetails.getContentPane().add(submitCustomer);

		// Button to cancel and go back to the previous page.
		JButton backToAddPage = new JButton("CANCEL");
		backToAddPage.setBackground(new Color(0, 255, 255));
		backToAddPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginPage.getUserType().equals("admin")) {
					frmCustomerdetails.setVisible(false);
					AdminAddPage p7 = new AdminAddPage();
					p7.showWindow();
				} else {
					frmCustomerdetails.setVisible(false);
					EmployeeAddPage p7 = new EmployeeAddPage();
					p7.showWindow();
				}
			}
		});
		backToAddPage.setBounds(455, 389, 108, 40);
		frmCustomerdetails.getContentPane().add(backToAddPage);

		// Background image for the frame.
		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 651, 480);
		frmCustomerdetails.getContentPane().add(backgroundLabel);
	}

	// Method to show the window for adding a new regular customer.
	public void showWindow() {
		frmCustomerdetails.setVisible(true);
	}
}
