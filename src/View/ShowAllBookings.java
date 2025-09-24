package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Booking;
import model.Hotel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ShowAllBookings extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable bookingTable;
	private DefaultTableModel tableModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAllBookings window = new ShowAllBookings();
					window.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ShowAllBookings() {
		setTitle("Bookings");
		initialize();
	}

	private void initialize() {

		// Column names for the JTable
		if (SystemFunctions.isAllBookingsOfCustomer() == true) {
			String[] columnNames = { "Booking Number", "Room Number", "Check-In Date", "Number of Days",
					"Total Revenue", "Total Cost" };
			tableModel = new DefaultTableModel(columnNames, 0);
		} else {
			String[] columnNames = { "Booking Number", "Room Number", "CustomerID", "Check-In Date", "Number of Days",
					"Total Revenue", "Total Cost" };
			// Create the DefaultTableModel with no data initially
			tableModel = new DefaultTableModel(columnNames, 0);
		}

		if (SystemFunctions.isAllBookingsByRevenue() == false && SystemFunctions.isAllBookingsOfCustomer() == false) {
			// Add data to the table model from the list of bookings
			for (Booking booking : Hotel.getInstance().getAllBookings().values()) {
				Object[] rowData = { booking.getBookingNumber(), booking.getRoomNumber(),
						"ID: " + booking.getCustomer().getId(), booking.getCheckInDate(), booking.getNumberOfDays(),
						booking.getTotalRevenue(), booking.getTotalCost() };
				tableModel.addRow(rowData);
			}
		}
		if (SystemFunctions.isAllBookingsByRevenue() == true) {
			// Add data to the table model from the list of bookings
			for (Booking booking : Hotel.getInstance().allBookingByRevenue()) {
				Object[] rowData = { booking.getBookingNumber(), booking.getRoomNumber(),
						"ID: " + booking.getCustomer().getId(), booking.getCheckInDate(), booking.getNumberOfDays(),
						booking.getTotalRevenue(), booking.getTotalCost() };
				tableModel.addRow(rowData);
			}
		}
		if (SystemFunctions.isAllBookingsOfCustomer() == true) {
			for (Booking booking : Hotel.getInstance()
					.allBookingsOfSpecCustomer(SystemFunctions.getAllBookingsOfCustomerID())) {
				Object[] rowData = { booking.getBookingNumber(), booking.getRoomNumber(), booking.getCheckInDate(),
						booking.getNumberOfDays(), booking.getTotalRevenue(), booking.getTotalCost() };
				tableModel.addRow(rowData);
			}
		}

		// Create the JTable using the table model
		bookingTable = new JTable(tableModel);

		// Set font size for the table cells
		bookingTable.setFont(new Font("Arial", Font.PLAIN, 12));

		// Adjust row height for a more compact appearance
		bookingTable.setRowHeight(20);

		// Add the JTable to a JScrollPane to enable scrolling
		JScrollPane scrollPane = new JScrollPane(bookingTable);

		// Create the "Back to Menu" button
		JButton backButton = new JButton("Back To Menu");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				if (SystemFunctions.isAllBookingsByRevenue() == false
						&& SystemFunctions.isAllBookingsOfCustomer() == false) {
					SystemDetails mainMenu = new SystemDetails();
					mainMenu.showWindow();
				}
				if (SystemFunctions.isAllBookingsByRevenue() == true) {
					SystemFunctions mainMenu = new SystemFunctions();
					mainMenu.showWindow();
				}
				if (SystemFunctions.isAllBookingsOfCustomer() == true) {
					SystemFunctions mainMenu = new SystemFunctions();
					mainMenu.showWindow();
				}
			}
		});

		// Create a panel to hold the table and the "Back to Menu" button
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(backButton, BorderLayout.SOUTH);

		// Add the panel to the JFrame
		setContentPane(panel);

		// Set the size of the JFrame (adjust the values according to your preference)
		setSize(1500, 600);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void showWindow() {
		// Make the frame visible
		setVisible(true);
	}
}