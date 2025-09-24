package View;

import javax.swing.JFrame;
import model.Booking;
import model.VIPCustomer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VIPCustomerDetails extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VIPCustomer vipCustomer;

	public VIPCustomerDetails(VIPCustomer vipCustomer) {
		this.vipCustomer = vipCustomer;

		setTitle("VIP Customer Details");
		setSize(566, 268);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		initComponents();
	}

	private void initComponents() {
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		String[] columnNames = { "Property", "Value" };
		Object[][] data = { { "ID:", vipCustomer.getId() }, { "First Name:", vipCustomer.getFirstName() },
				{ "Last Name:", vipCustomer.getLastName() }, { "Phone Number:", vipCustomer.getPhoneNumber() },
				{ "Area:", vipCustomer.getArea().toString() }, { "Gender:", vipCustomer.getGender().toString() },
				{ "Year of Birth:", String.valueOf(vipCustomer.getYearOfBirth()) },
				{ "Date of Joining:", String.valueOf(vipCustomer.getDateOfJoining()) },
				{ "Discount Percentage:", String.valueOf(vipCustomer.getDiscountPercentage()) },
				// Add more properties as needed
		};

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

	private void showAllBookings() {
		JFrame bookingsFrame = new JFrame("All Bookings for VIP Customer " + vipCustomer.getId());
		bookingsFrame.setSize(500, 400);
		bookingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		bookingsFrame.setLocationRelativeTo(null);

		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		String[] columnNames = { "Booking Number", "Room Number", "Check-In Date", "Number of Days" };
		Object[][] data = new Object[vipCustomer.getAllBookings().size()][4];
		int row = 0;
		for (Booking booking : vipCustomer.getAllBookings()) {
			data[row][0] = booking.getBookingNumber();
			data[row][1] = booking.getRoomNumber();
			data[row][2] = booking.getCheckInDate();
			data[row][3] = booking.getNumberOfDays();
			row++;
		}

		JTable table = new JTable(data, columnNames);
		table.setEnabled(false); // Make the table read-only
		JScrollPane scrollPane = new JScrollPane(table);

		// Set preferred size for the scroll pane
		scrollPane.setPreferredSize(new Dimension(480, 320));

		contentPanel.add(scrollPane, BorderLayout.CENTER);
		bookingsFrame.getContentPane().add(contentPanel);
		bookingsFrame.setVisible(true);
	}

	public void showWindow() {
		setVisible(true);

	}
}
