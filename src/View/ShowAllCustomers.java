package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import model.Hotel;
import model.VIPCustomer;

public class ShowAllCustomers extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable bookingTable;
	private DefaultTableModel tableModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAllCustomers window = new ShowAllCustomers();
					window.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ShowAllCustomers() {
		setTitle("Customers");
		initialize();
	}

	private void initialize() {

		// Column names for the JTable
		String[] columnNames = { "Customer ID", "Customer Type", "First Name", "Last Name", "Phone Number", "Area",
				"Gender", "Year of Birth", "Date Of Joining", "Bookings" };

		// Create the DefaultTableModel with no data initially
		tableModel = new DefaultTableModel(columnNames, 0);

		if (SystemFunctions.isAllCustomersByPK() == false && SystemFunctions.isAllCustomersCMP() == false) {
			// Add data to the table model from the list of bookings
			for (Customer customer : Hotel.getInstance().getAllCustomers().values()) {
				Object[] rowData = { customer.getId(),
						customer instanceof VIPCustomer ? "VIP Customer" : "Regular Customer", customer.getFirstName(),
						customer.getLastName(), customer.getPhoneNumber(), customer.getArea(), customer.getGender(),
						customer.getYearOfBirth(), customer.getDateOfJoining(), customer.getAllBookings() };
				tableModel.addRow(rowData);
			}
		}
		if (SystemFunctions.isAllCustomersByPK() == true) {
			// Add data to the table model from the list of bookings
			for (Customer customer : Hotel.getInstance().allCustomersByPK()) {
				Object[] rowData = { customer.getId(),
						customer instanceof VIPCustomer ? "VIP Customer" : "Regular Customer", customer.getFirstName(),
						customer.getLastName(), customer.getPhoneNumber(), customer.getArea(), customer.getGender(),
						customer.getYearOfBirth(), customer.getDateOfJoining(), customer.getAllBookings() };
				tableModel.addRow(rowData);
			}
		}
		if (SystemFunctions.isAllCustomersCMP() == true) {
			// Add data to the table model from the list of bookings
			for (Customer customer : Hotel.getInstance().allCustomersCmp()) {
				Object[] rowData = { customer.getId(),
						customer instanceof VIPCustomer ? "VIP Customer" : "Regular Customer", customer.getFirstName(),
						customer.getLastName(), customer.getPhoneNumber(), customer.getArea(), customer.getGender(),
						customer.getYearOfBirth(), customer.getDateOfJoining(), customer.getAllBookings() };
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
				if (SystemFunctions.isAllCustomersByPK() == false && SystemFunctions.isAllCustomersCMP() == false) {
					SystemDetails mainMenu = new SystemDetails();
					mainMenu.showWindow();
				}
				if (SystemFunctions.isAllCustomersByPK() == true) {
					SystemFunctions mainMenu = new SystemFunctions();
					mainMenu.showWindow();
				}
				if (SystemFunctions.isAllCustomersCMP() == true) {
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
