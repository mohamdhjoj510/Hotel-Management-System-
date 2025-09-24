package View;


import javax.swing.JFrame;
import model.Employee;
import javax.swing.*;
import java.awt.*;

public class EmployeeDetails extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee employee;

	public EmployeeDetails(Employee employee) {
		this.employee = employee;

		setTitle("Employee Details");
		setSize(500, 273);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		initComponents();
	}

	private void initComponents() {
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		String[] columnNames = { "Property", "Value" };
		Object[][] data = { { "ID:", employee.getId() }, { "First Name:", employee.getFirstName() },
				{ "Last Name:", employee.getLastName() }, { "Phone Number:", employee.getPhoneNumber() },
				{ "Area:", employee.getArea().toString() }, { "Gender:", employee.getGender().toString() },
				{ "Year of Birth:", String.valueOf(employee.getYearOfBirth()) },
				{ "Salary:", String.valueOf(employee.getSalary()) },
				{ "Department:", employee.getDepartment().toString() },
				{ "Start of Work:", String.valueOf(employee.getStartOfWork()) },
				{ "System Username:", employee.getSystemUsername() },
				{ "System Password:", employee.getSystemPassword() },
				// Add more properties as needed
		};

		JTable table = new JTable(data, columnNames);
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
		table.setEnabled(false); // Make the table read-only
		JScrollPane scrollPane = new JScrollPane(table);

		// Set preferred size for the scroll pane
		scrollPane.setPreferredSize(new Dimension(480, 320));

		contentPanel.add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(contentPanel);
	}

	public void showWindow() {
		setVisible(true);

	}
}
