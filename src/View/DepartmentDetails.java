package View;

import javax.swing.JFrame;
import model.Department;
import model.Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentDetails extends JFrame {
	private static final long serialVersionUID = 1L;
	private Department department;

	public DepartmentDetails(Department department) {
		this.department = department;

		setTitle("Department Details");
		setSize(512, 158);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		initComponents();
	}

	// Initialize the components of the frame
	private void initComponents() {
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Table data setup
		String[] columnNames = { "Property", "Value" };
		Object[][] data = { { "Department ID:", department.getDepartmentId() },
				{ "Specialization:", department.getSpecialization().toString() },
				{ "Department Manager:", department.getDepManager() != null
						? department.getDepManager().getFirstName() + " " + department.getDepManager().getLastName()
						: "None" },
				// Add more properties as needed
		};

		JTable table = new JTable(data, columnNames);
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
		table.setEnabled(false); // Make the table read-only
		JScrollPane scrollPane = new JScrollPane(table);

		// Set preferred size for the scroll pane
		scrollPane.setPreferredSize(new Dimension(480, 320));

		contentPanel.add(scrollPane, BorderLayout.CENTER);

		// Add a button to view all employees
		JButton viewEmployeesButton = new JButton("View All Employees");
		viewEmployeesButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		viewEmployeesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showAllEmployees();
			}
		});
		contentPanel.add(viewEmployeesButton, BorderLayout.SOUTH);

		getContentPane().add(contentPanel);
	}

	// Method to show all employees in the department
	private void showAllEmployees() {
		JFrame employeesFrame = new JFrame("All Employees in Department " + department.getDepartmentId());
		employeesFrame.setSize(600, 400);
		employeesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		employeesFrame.setLocationRelativeTo(null);

		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		String[] columnNames = { "Employee ID", "First Name", "Last Name", "Salary", "Department", "Start of Work" };
		Object[][] data = new Object[department.getAllEmployees().size()][6];
		int row = 0;
		for (Employee employee : department.getAllEmployees()) {
			data[row][0] = employee.getId();
			data[row][1] = employee.getFirstName();
			data[row][2] = employee.getLastName();
			data[row][3] = employee.getSalary();
			data[row][4] = employee.getDepartment().getDepartmentId(); // Add department ID
			data[row][5] = employee.getStartOfWork(); // Add start of work
			row++;
		}

		JTable table = new JTable(data, columnNames);
		table.setEnabled(false); // Make the table read-only
		JScrollPane scrollPane = new JScrollPane(table);

		// Set preferred size for the scroll pane
		scrollPane.setPreferredSize(new Dimension(580, 320));

		contentPanel.add(scrollPane, BorderLayout.CENTER);
		employeesFrame.getContentPane().add(contentPanel);
		employeesFrame.setVisible(true);
	}

	// Method to display the JFrame.
	public void showWindow() {
		setVisible(true);
	}
}
