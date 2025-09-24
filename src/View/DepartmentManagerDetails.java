package View;

import javax.swing.JFrame;
import model.DepartmentManager;
import javax.swing.*;
import java.awt.*;

public class DepartmentManagerDetails extends JFrame {
	// The serial version UID for serialization and deserialization of objects.
	private static final long serialVersionUID = 1L;
	private DepartmentManager departmentManager;

	// Constructor to create a new DepartmentManagerDetails object.
	// departmentManager: The DepartmentManager object whose details will be
	// displayed.
	public DepartmentManagerDetails(DepartmentManager departmentManager) {
		this.departmentManager = departmentManager;

		setTitle("Department Manager Details");
		setSize(500, 292);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		initComponents();
	}

	// Initializes the components of the frame and sets up the table to display
	// department manager details.
	private void initComponents() {
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Define column names and data for the table
		String[] columnNames = { "Property", "Value" };
		Object[][] data = { { "ID:", departmentManager.getId() }, { "First Name:", departmentManager.getFirstName() },
				{ "Last Name:", departmentManager.getLastName() },
				{ "Phone Number:", departmentManager.getPhoneNumber() },
				{ "Area:", departmentManager.getArea().toString() },
				{ "Gender:", departmentManager.getGender().toString() },
				{ "Year of Birth:", String.valueOf(departmentManager.getYearOfBirth()) },
				{ "Salary:", String.valueOf(departmentManager.getSalary()) },
				{ "Department:", departmentManager.getDepartment().toString() },
				{ "Start of Work:", String.valueOf(departmentManager.getStartOfWork()) },
				{ "Bonus:", String.valueOf(departmentManager.getBonus()) },
				{ "System Username:", departmentManager.getSystemUsername() },
				{ "System Password:", departmentManager.getSystemPassword() },
				// Add more properties as needed
		};

		// Create the table and set its properties
		JTable table = new JTable(data, columnNames);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setEnabled(false); // Make the table read-only
		JScrollPane scrollPane = new JScrollPane(table);

		// Set preferred size for the scroll pane
		scrollPane.setPreferredSize(new Dimension(480, 320));

		// Add the scroll pane with the table to the content panel
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(contentPanel);
	}

	// Method to display the window and make it visible.
	public void showWindow() {
		setVisible(true);
	}
}
