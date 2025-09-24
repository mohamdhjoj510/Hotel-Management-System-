package View;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextField;
import Exception.EmptyFieldsException;
import Exception.NegativeNumberException;
import model.Booking;
import model.Customer;
import model.Hotel;
import model.Room;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class BookingAdding extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmBookingdetails;
	private JTextField numberOfDaysText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingAdding window = new BookingAdding();
					window.frmBookingdetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookingAdding() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Create the main JFrame for booking details.
		frmBookingdetails = new JFrame();
		frmBookingdetails.setTitle("Booking_Details");
		frmBookingdetails.setBounds(100, 100, 645, 514);
		frmBookingdetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBookingdetails.getContentPane().setLayout(null);

		// Label to instruct the user to fill in the booking details.
		JLabel msg1 = new JLabel("                       Please fill in the booking details");
		msg1.setForeground(new Color(0, 255, 255));
		msg1.setFont(new Font("Tahoma", Font.BOLD, 20));
		msg1.setBounds(10, 52, 611, 37);
		frmBookingdetails.getContentPane().add(msg1);

		// Labels for input fields and instructions.
		JLabel msg3 = new JLabel("room number :");
		msg3.setForeground(new Color(0, 255, 255));
		msg3.setFont(new Font("Tahoma", Font.BOLD, 13));
		msg3.setBounds(219, 116, 100, 19);
		frmBookingdetails.getContentPane().add(msg3);

		JLabel msg4 = new JLabel("customer id :");
		msg4.setForeground(new Color(0, 255, 255));
		msg4.setFont(new Font("Tahoma", Font.BOLD, 13));
		msg4.setBounds(219, 175, 100, 19);
		frmBookingdetails.getContentPane().add(msg4);

		// Arrays for days, months, and years.
		Integer[] days = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
				26, 27, 28, 29, 30, 31 };
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		Integer[] years = { 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004,
				2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021,
				2022, 2023 };

		// Label and ComboBoxes for check-in date.
		JLabel msg5 = new JLabel("checkIn date :");
		msg5.setForeground(new Color(0, 255, 255));
		msg5.setFont(new Font("Tahoma", Font.BOLD, 13));
		msg5.setBounds(219, 232, 118, 16);
		frmBookingdetails.getContentPane().add(msg5);

		JComboBox<Integer> dayBox = new JComboBox<>(days);
		dayBox.setToolTipText("");
		dayBox.setBounds(219, 251, 44, 23);
		frmBookingdetails.getContentPane().add(dayBox);

		JComboBox<String> monthBox = new JComboBox<>(months);
		monthBox.setBounds(261, 251, 72, 23);
		frmBookingdetails.getContentPane().add(monthBox);

		JComboBox<Integer> yearBox = new JComboBox<>(years);
		yearBox.setBounds(332, 251, 72, 23);
		frmBookingdetails.getContentPane().add(yearBox);

		// Label and text field for the number of days.
		JLabel msg6 = new JLabel("number of days :");
		msg6.setForeground(new Color(0, 255, 255));
		msg6.setFont(new Font("Tahoma", Font.BOLD, 13));
		msg6.setBounds(219, 292, 115, 13);
		frmBookingdetails.getContentPane().add(msg6);

		numberOfDaysText = new JTextField();
		numberOfDaysText.setBounds(219, 307, 142, 31);
		frmBookingdetails.getContentPane().add(numberOfDaysText);
		numberOfDaysText.setColumns(10);

		// Get room numbers and customers from the hotel instance and populate the
		// respective ComboBoxes.
		ArrayList<String> rooms = new ArrayList<>();
		for (Room r : Hotel.getInstance().getAllRooms().values()) {
			rooms.add(r.getRoomNumber());
		}
		JComboBox<String> roomNumberBox = new JComboBox<>();
		roomNumberBox.setBounds(219, 134, 142, 31);
		frmBookingdetails.getContentPane().add(roomNumberBox);
		for (String roomNumber : rooms) {
			roomNumberBox.addItem(roomNumber);
		}

		ArrayList<String> customers = new ArrayList<>();
		for (Customer c : Hotel.getInstance().getAllCustomers().values()) {
			customers.add(c.getId());
		}
		JComboBox<String> customerIDBox = new JComboBox<>();
		customerIDBox.setBounds(219, 191, 142, 31);
		frmBookingdetails.getContentPane().add(customerIDBox);
		for (String customerID : customers) {
			customerIDBox.addItem(customerID);
		}

		// Button to submit the booking details.
		JButton submitBooking = new JButton("SUBMIT");
		submitBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Validate if all fields are filled.
					if (numberOfDaysText.getText().isEmpty() || roomNumberBox.getSelectedItem() == null
							|| customerIDBox.getSelectedItem() == null) {
						throw new EmptyFieldsException();
					}

					// Get the selected check-in date.
					int day = (Integer) dayBox.getSelectedItem();
					int monthIndex = monthBox.getSelectedIndex(); // Since JComboBox is 0-based, the selected index
																	// represents the month
					int year = (Integer) yearBox.getSelectedItem();
					// Convert the selected values to a java.util.Date object
					@SuppressWarnings("deprecation")
					java.util.Date selectedDate = new java.util.Date(year - 1900, monthIndex, day);

					// Validate if the number of days is a non-negative integer.
					if (Integer.parseInt(numberOfDaysText.getText()) < 0) {
						throw new NegativeNumberException();
					}

					// Get the customer object for the booking.
					Customer customerForBooking = Hotel.getInstance()
							.getRealCustomer((String) customerIDBox.getSelectedItem());

					// Create a new booking object.
					Booking booking = new Booking((String) roomNumberBox.getSelectedItem(), customerForBooking,
							selectedDate, Integer.parseInt(numberOfDaysText.getText()));

					// Add the booking to the hotel's booking list.
					Hotel.getInstance().addBooking(booking);
					Main.save();
					// Show success message and navigate to the respective views based on user type.
					JOptionPane.showMessageDialog(null, "booking added successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);

					if (LoginPage.getUserType().equals("admin")) {
						frmBookingdetails.setVisible(false);
						AdminFirstView page = new AdminFirstView();
						page.showWindow();
					} else {
						frmBookingdetails.setVisible(false);
						EmployeeFirstView page = new EmployeeFirstView();
						page.showWindow();
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter numeric values for appropriate fields",
							"Input Error", JOptionPane.ERROR_MESSAGE);
				} catch (EmptyFieldsException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (NegativeNumberException ex1) {
					JOptionPane.showMessageDialog(null, ex1.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submitBooking.setBackground(new Color(0, 255, 255));
		submitBooking.setForeground(new Color(0, 0, 0));
		submitBooking.setFont(new Font("Tahoma", Font.BOLD, 16));
		submitBooking.setBounds(150, 414, 115, 37);
		frmBookingdetails.getContentPane().add(submitBooking);

		// Button to cancel and return to the previous page (AdminAddPage or
		// EmployeeAddPage).
		JButton backToAddPage = new JButton("CANCEL");
		backToAddPage.setBackground(new Color(0, 255, 255));
		backToAddPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginPage.getUserType().equals("admin")) {
					frmBookingdetails.setVisible(false);
					AdminAddPage page2 = new AdminAddPage();
					page2.showWindow();
				} else {
					frmBookingdetails.setVisible(false);
					EmployeeAddPage page2 = new EmployeeAddPage();
					page2.showWindow();
				}
			}
		});
		backToAddPage.setForeground(new Color(0, 0, 0));
		backToAddPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		backToAddPage.setBounds(359, 414, 115, 37);
		frmBookingdetails.getContentPane().add(backToAddPage);

		// Set background image using JLabel.
		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(-39, -28, 711, 505);
		frmBookingdetails.getContentPane().add(backgroundLabel);
	}

	/**
	 * Method to show the booking details frame.
	 */
	public void showWindow() {
		frmBookingdetails.setVisible(true);
	}

}
