package View;

import javax.swing.JFrame;
import model.Booking;
import model.Customer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDetails extends JFrame {
	private static final long serialVersionUID = 1L;
	private Customer customer;

	// Constructor that takes a Customer object as a parameter
	public CustomerDetails(Customer customer) {
		this.customer = customer;

		setTitle("Customer Details");
		setSize(551, 265);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		initComponents();
	}

	// Initialize the components of the frame
	private void initComponents() {
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Define the column names and data for the customer details table
		String[] columnNames = { "Property", "Value" };
		Object[][] data = { { "ID:", customer.getId() }, { "First Name:", customer.getFirstName() },
				{ "Last Name:", customer.getLastName() }, { "Phone Number:", customer.getPhoneNumber() },
				{ "Area:", customer.getArea().toString() }, { "Gender:", customer.getGender().toString() },
				{ "Year of Birth:", String.valueOf(customer.getYearOfBirth()) },
				{ "Date of Joining:", String.valueOf(customer.getDateOfJoining()) },
				// Add more properties as needed
		};

		// Create a JTable to display the customer details
		JTable table = new JTable(data, columnNames);
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
		table.setEnabled(false); // Make the table read-only
		JScrollPane scrollPane = new JScrollPane(table);

		// Set preferred size for the scroll pane
		scrollPane.setPreferredSize(new Dimension(480, 320));

		contentPanel.add(scrollPane, BorderLayout.CENTER);

		// Add a button to view all bookings
		JButton viewBookingsButton = new JButton("View All Bookings");
		viewBookingsButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		viewBookingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showAllBookings();
			}
		});
		contentPanel.add(viewBookingsButton, BorderLayout.SOUTH);

		getContentPane().add(contentPanel);
	}

	// Method to display all bookings for the customer in a new frame
	private void showAllBookings() {
		JFrame bookingsFrame = new JFrame("All Bookings for Customer " + customer.getId());
		bookingsFrame.setSize(500, 400);
		bookingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		bookingsFrame.setLocationRelativeTo(null);

		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Define the column names and data for the bookings table
		String[] columnNames = { "Booking Number", "Room Number", "Check-In Date", "Number of Days" };
		Object[][] data = new Object[customer.getAllBookings().size()][4];
		int row = 0;
		for (Booking booking : customer.getAllBookings()) {
			data[row][0] = booking.getBookingNumber();
			data[row][1] = booking.getRoomNumber();
			data[row][2] = booking.getCheckInDate();
			data[row][3] = booking.getNumberOfDays();
			row++;
		}

		// Create a JTable to display the bookings
		JTable table = new JTable(data, columnNames);
		table.setEnabled(false); // Make the table read-only
		JScrollPane scrollPane = new JScrollPane(table);

		// Set preferred size for the scroll pane
		scrollPane.setPreferredSize(new Dimension(480, 320));

		contentPanel.add(scrollPane, BorderLayout.CENTER);
		bookingsFrame.getContentPane().add(contentPanel);
		bookingsFrame.setVisible(true);
	}

	// Method to display the CustomerDetails frame
	public void showWindow() {
		setVisible(true);
	}
}
