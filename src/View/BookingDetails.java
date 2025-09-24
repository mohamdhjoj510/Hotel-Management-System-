package View;

import javax.swing.JFrame;
import model.Booking;
import javax.swing.*;
import java.awt.*;


public class BookingDetails extends JFrame {
	/**
	 * The serial version UID is used for object serialization and deserialization
	 * to ensure version compatibility.
	 */
	private static final long serialVersionUID = 1L;
	private Booking booking;

	/**
	 * Constructor to create a new BookingDetails frame.
	 * 
	 * @param booking The Booking object to display details for.
	 */
	public BookingDetails(Booking booking) {
		this.booking = booking;

		setTitle("Booking Details");
		setSize(500, 193);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		initComponents();
	}

	/**
	 * Method to initialize and set up the components for the frame.
	 */
	private void initComponents() {
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Table column names and data for the Booking details.
		String[] columnNames = { "Property", "Value" };
		Object[][] data = { { "Booking Number:", booking.getBookingNumber() },
				{ "Room Number:", booking.getRoomNumber() },
				{ "Customer ID:", String.valueOf(booking.getCustomer().getId()) },
				{ "Check-In Date:", String.valueOf(booking.getCheckInDate()) },
				{ "Number of Days:", String.valueOf(booking.getNumberOfDays()) },
				{ "Total Revenue:", String.valueOf(booking.getTotalRevenue()) },
				{ "Total Cost:", String.valueOf(booking.getTotalCost()) }, };

		// Create a JTable with the data and column names.
		JTable table = new JTable(data, columnNames);
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
		table.setEnabled(false); // Make the table read-only
		JScrollPane scrollPane = new JScrollPane(table);

		// Set preferred size for the scroll pane
		scrollPane.setPreferredSize(new Dimension(480, 320));

		contentPanel.add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(contentPanel);
	}

	/**
	 * Method to display the BookingDetails frame.
	 */
	public void showWindow() {
		setVisible(true);
	}
}
