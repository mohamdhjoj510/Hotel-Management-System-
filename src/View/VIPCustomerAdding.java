package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Exception.DiscountPercentageException;
import Exception.EmptyFieldsException;
import Exception.InvalidNameException;
import Exception.InvalidPhoneNumberException;
import Exception.NegativeNumberException;
import Exception.PersonAlreadyExistException;
import model.Hotel;
import model.VIPCustomer;
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

public class VIPCustomerAdding extends JInternalFrame {

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
	private JTextField discountPercentageText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIPCustomerAdding window = new VIPCustomerAdding();
					window.frmCustomerdetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VIPCustomerAdding() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmCustomerdetails = new JFrame();
		frmCustomerdetails.setTitle("Customer_Details");
		frmCustomerdetails.setBounds(100, 100, 645, 500);
		frmCustomerdetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomerdetails.getContentPane().setLayout(null);

		JLabel msg1 = new JLabel("                Please fill in the new VIP customer details");
		msg1.setForeground(new Color(0, 255, 255));
		msg1.setFont(new Font("Tahoma", Font.BOLD, 20));
		msg1.setBounds(10, 40, 598, 40);
		frmCustomerdetails.getContentPane().add(msg1);

		JLabel msg2 = new JLabel("customer id :");
		msg2.setForeground(new Color(0, 255, 255));
		msg2.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg2.setBounds(22, 124, 114, 23);
		frmCustomerdetails.getContentPane().add(msg2);

		customerIdText = new JTextField();
		customerIdText.setBounds(22, 145, 114, 31);
		frmCustomerdetails.getContentPane().add(customerIdText);
		customerIdText.setColumns(10);

		JLabel msg3 = new JLabel("first name :");
		msg3.setForeground(new Color(0, 255, 255));
		msg3.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg3.setBounds(219, 127, 114, 16);
		frmCustomerdetails.getContentPane().add(msg3);

		firstNameText = new JTextField();
		firstNameText.setBounds(219, 145, 114, 31);
		frmCustomerdetails.getContentPane().add(firstNameText);
		firstNameText.setColumns(10);

		JLabel msg4 = new JLabel("last name :");
		msg4.setForeground(new Color(0, 255, 255));
		msg4.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg4.setBounds(426, 127, 114, 16);
		frmCustomerdetails.getContentPane().add(msg4);

		lastNameText = new JTextField();
		lastNameText.setBounds(426, 145, 114, 31);
		frmCustomerdetails.getContentPane().add(lastNameText);
		lastNameText.setColumns(10);

		JLabel msg5 = new JLabel("phone number :");
		msg5.setForeground(new Color(0, 255, 255));
		msg5.setFont(new Font("Tahoma", Font.BOLD, 14));
		msg5.setBounds(22, 211, 129, 23);
		frmCustomerdetails.getContentPane().add(msg5);

		phoneNumberText = new JTextField();
		phoneNumberText.setBounds(22, 233, 114, 31);
		frmCustomerdetails.getContentPane().add(phoneNumberText);
		phoneNumberText.setColumns(10);

		Area[] customerAreas = { Area.Jerusalem, Area.Central, Area.Haifa, Area.JudeaAndSamaria, Area.Northern,
				Area.Southern, Area.TelAviv };
		JLabel msg6 = new JLabel("area :");
		msg6.setForeground(new Color(0, 255, 255));
		msg6.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg6.setBounds(219, 211, 114, 23);
		frmCustomerdetails.getContentPane().add(msg6);

		JComboBox areaBox = new JComboBox(customerAreas);
		areaBox.setBounds(219, 233, 114, 31);
		frmCustomerdetails.getContentPane().add(areaBox);

		String[] genders = { "MALE", "FEMALE" };
		JLabel msg7 = new JLabel("gender :");
		msg7.setForeground(new Color(0, 255, 255));
		msg7.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg7.setBounds(426, 211, 114, 23);
		frmCustomerdetails.getContentPane().add(msg7);

		JComboBox genderBox = new JComboBox(genders);
		genderBox.setBounds(426, 233, 114, 31);
		frmCustomerdetails.getContentPane().add(genderBox);

		JLabel msg8 = new JLabel("year of birth :");
		msg8.setForeground(new Color(0, 255, 255));
		msg8.setFont(new Font("Tahoma", Font.BOLD, 16));
		msg8.setBounds(22, 309, 114, 16);
		frmCustomerdetails.getContentPane().add(msg8);

		yearOfBirthText = new JTextField();
		yearOfBirthText.setBounds(22, 325, 114, 31);
		frmCustomerdetails.getContentPane().add(yearOfBirthText);
		yearOfBirthText.setColumns(10);

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

		JComboBox dayBox = new JComboBox(days);
		dayBox.setToolTipText("");
		dayBox.setBounds(209, 329, 44, 31);
		frmCustomerdetails.getContentPane().add(dayBox);

		JComboBox monthBox = new JComboBox(months);
		monthBox.setBounds(252, 329, 62, 31);
		frmCustomerdetails.getContentPane().add(monthBox);

		JComboBox yearBox = new JComboBox(years);
		yearBox.setBounds(314, 329, 62, 31);
		frmCustomerdetails.getContentPane().add(yearBox);

		JLabel msg10 = new JLabel("discount percentage :");
		msg10.setForeground(new Color(0, 255, 255));
		msg10.setFont(new Font("Tahoma", Font.BOLD, 14));
		msg10.setBounds(426, 306, 182, 23);
		frmCustomerdetails.getContentPane().add(msg10);

		discountPercentageText = new JTextField();
		discountPercentageText.setBounds(426, 329, 114, 31);
		frmCustomerdetails.getContentPane().add(discountPercentageText);
		discountPercentageText.setColumns(10);

		// Create a JButton for submitting VIP customer details
		JButton submitVIPCustomer = new JButton("SUBMIT");

		// Attach an ActionListener to the submit button
		submitVIPCustomer.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					// Check for empty fields in the customer details
					if (customerIdText.getText().isEmpty() || firstNameText.getText().isEmpty()
							|| lastNameText.getText().isEmpty() || phoneNumberText.getText().isEmpty()
							|| yearOfBirthText.getText().isEmpty() || discountPercentageText.getText().isEmpty()) {
						throw new EmptyFieldsException(); // Throw an EmptyFieldsException
					}

					// Validate first name and last name format
					if (!firstNameText.getText().matches("[a-zA-Z]+") || !lastNameText.getText().matches("[a-zA-Z]+")) {
						throw new InvalidNameException(); // Throw an InvalidNameException
					}

					// Check for negative numbers in specific fields
					if (Double.parseDouble(customerIdText.getText()) < 0.0
							|| Double.parseDouble(phoneNumberText.getText()) < 0
							|| Integer.parseInt(yearOfBirthText.getText()) < 0) {
						throw new NegativeNumberException(); // Throw a NegativeNumberException
					}

					// Validate phone number length
					if (phoneNumberText.getText().length() != 10) {
						throw new InvalidPhoneNumberException(); // Throw an InvalidPhoneNumberException
					}

					// Check for existing customer or employee with the same ID
					if (Hotel.getInstance().getAllCustomers().containsKey(customerIdText.getText())
							|| Hotel.getInstance().getAllEmployees().containsKey(customerIdText.getText())) {
						throw new PersonAlreadyExistException(firstNameText.getText(), lastNameText.getText()); // Throw
																												// a
																												// PersonAlreadyExistException
					}

					// Validate discount percentage range
					if (Double.parseDouble(discountPercentageText.getText()) > 1
							|| Double.parseDouble(discountPercentageText.getText()) < 0) {
						throw new DiscountPercentageException(); // Throw a DiscountPercentageException
					}

					// Get selected area and gender
					Area customerArea = (Area) areaBox.getSelectedItem();
					Gender g = (genderBox.getSelectedItem().equals("MALE")) ? Gender.M : Gender.F;

					// Get selected date values and create a java.util.Date object
					int day = (Integer) dayBox.getSelectedItem();
					int monthIndex = monthBox.getSelectedIndex();
					int year = (Integer) yearBox.getSelectedItem();
					java.util.Date selectedDate = new java.util.Date(year - 1900, monthIndex, day);

					// Create a VIPCustomer object
					VIPCustomer c = new VIPCustomer(customerIdText.getText(), firstNameText.getText(),
							lastNameText.getText(), phoneNumberText.getText(), customerArea, g,
							Integer.parseInt(yearOfBirthText.getText()), selectedDate,
							Double.parseDouble(discountPercentageText.getText()));

					// Add the VIPCustomer to the Hotel's instance
					Hotel.getInstance().addVIPCustomer(c);

					// Save changes
					Main.save();

					// Show success message
					JOptionPane.showMessageDialog(null, "VIP customer added successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);

					// Navigate to appropriate views based on user type
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
					// Handle empty fields exception
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (InvalidPhoneNumberException ex1) {
					// Handle invalid phone number exception
					JOptionPane.showMessageDialog(null, ex1.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (PersonAlreadyExistException ex2) {
					// Handle person already exists exception
					JOptionPane.showMessageDialog(null, ex2.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (DiscountPercentageException ex3) {
					// Handle discount percentage exception
					JOptionPane.showMessageDialog(null, ex3.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (InvalidNameException ex4) {
					// Handle invalid name exception
					JOptionPane.showMessageDialog(null, ex4.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (NegativeNumberException ex5) {
					// Handle negative number exception
					JOptionPane.showMessageDialog(null, ex5.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					// Handle IO exception
					e1.printStackTrace();
				}
			}
		});
		submitVIPCustomer.setBackground(new Color(0, 255, 255));
		submitVIPCustomer.setBounds(500, 389, 108, 40);
		frmCustomerdetails.getContentPane().add(submitVIPCustomer);

		JButton cancel = new JButton("CANCEL");
		cancel.setBackground(new Color(0, 255, 255));
		cancel.addActionListener(new ActionListener() {
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
		cancel.setBounds(382, 389, 108, 40);
		frmCustomerdetails.getContentPane().add(cancel);

		String imageUrl = "/Your favorite iPhone wallpapers of 2022.png";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 651, 480);
		frmCustomerdetails.getContentPane().add(backgroundLabel);
	}

	public void showWindow() {
		frmCustomerdetails.setVisible(true);

	}
}
