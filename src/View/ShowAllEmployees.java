package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DepartmentManager;
import model.Employee;
import model.Hotel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowAllEmployees extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable employeeTable;
	private DefaultTableModel tableModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAllEmployees window = new ShowAllEmployees();
					window.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ShowAllEmployees() {
		setTitle("Employees");
		initialize();
	}

	private void initialize() {
		// Column names for the JTable
		String[] columnNames = { "ID", "Employee Type", "First Name", "Last Name", "Phone Number", "Area", "Gender",
				"Year of Birth", "Salary", "DepartmentID", "Start of Work", "System Username", "System Password",
				"Bonus" };

		// Create the DefaultTableModel with no data initially
		tableModel = new DefaultTableModel(columnNames, 0);

		if (SystemFunctions.isKemployees() == false) {
			// Add data to the table model from the list of employees
			for (Employee employee : Hotel.getInstance().getAllEmployees().values()) {
				Object[] rowData = { employee.getId(), getEmployeeType(employee), employee.getFirstName(),
						employee.getLastName(), employee.getPhoneNumber(), employee.getArea(), employee.getGender(),
						employee.getYearOfBirth(), employee.getSalary(), "ID: "+employee.getDepartment().getDepartmentId(),
						employee.getStartOfWork(), employee.getSystemUsername(), employee.getSystemPassword(),
						employee instanceof DepartmentManager ? ((DepartmentManager) employee).getBonus() : "-" };
				tableModel.addRow(rowData);
			}
		}
		if (SystemFunctions.isKemployees() == true) {
			// Add data to the table model from the list of employees
			for (Employee employee : Hotel.getInstance().KEmployees(SystemFunctions.getK())) {
				Object[] rowData = { employee.getId(), getEmployeeType(employee), employee.getFirstName(),
						employee.getLastName(), employee.getPhoneNumber(), employee.getArea(), employee.getGender(),
						employee.getYearOfBirth(), employee.getSalary(), employee.getDepartment(),
						employee.getStartOfWork(), employee.getSystemUsername(), employee.getSystemPassword(),
						employee instanceof DepartmentManager ? ((DepartmentManager) employee).getBonus() : "-" };
				tableModel.addRow(rowData);
			}
		}

		// Create the JTable using the table model
		employeeTable = new JTable(tableModel);

		// Set font size for the table cells
		employeeTable.setFont(new Font("Arial", Font.PLAIN, 12));

		// Adjust row height for a more compact appearance
		employeeTable.setRowHeight(20);

		// Add the JTable to a JScrollPane to enable scrolling
		JScrollPane scrollPane = new JScrollPane(employeeTable);

		JButton backBtn = new JButton("Back To Menu");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Hide the current frame (ShowAllEmployees)
				setVisible(false);

				if (SystemFunctions.isKemployees() == false) {
					// Create and show the SystemDetails page (assuming it exists)
					SystemDetails page = new SystemDetails();
					page.showWindow();
				}

				if (SystemFunctions.isKemployees() == true) {
					// Create and show the SystemDetails page (assuming it exists)
					SystemFunctions page = new SystemFunctions();
					page.showWindow();
				}
			}
		});

		// Create a panel to hold the JTable and the "Back to Menu" button
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(backBtn, BorderLayout.SOUTH);

		// Set the JPanel as the content pane of the JFrame
		setContentPane(panel);

		// Set the size of the JFrame (adjust the values according to your preference)
		setSize(1500, 600);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private String getEmployeeType(Employee employee) {
		if (employee instanceof DepartmentManager) {
			return "DepManager";
		} else {
			return "RegEmployee";
		}
	}

	public void showWindow() {
		// Make the frame visible
		setVisible(true);
	}
}