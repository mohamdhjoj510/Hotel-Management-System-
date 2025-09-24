package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Department;
import model.Hotel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowAllDepartments extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable employeeTable;
	private DefaultTableModel tableModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAllDepartments window = new ShowAllDepartments();
					window.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ShowAllDepartments() {
		setTitle("Departments");
		initialize();
	}

	private void initialize() {

		// Column names for the JTable
		String[] columnNames = { "Department ID", "Specialization", "Department Manager", "Department Employees" };

		// Create the DefaultTableModel with no data initially
		tableModel = new DefaultTableModel(columnNames, 0);

		// Add data to the table model from the list of employees
		for (Department department : Hotel.getInstance().getAllDepartments().values()) {
			Object[] rowData = { department.getDepartmentId(), department.getSpecialization(),
					department.getDepManager(), department.getAllEmployees() };
			tableModel.addRow(rowData);
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

				// Create and show the SystemDetails page (assuming it exists)
				SystemDetails page = new SystemDetails();
				page.showWindow();
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

	public void showWindow() {
		// Make the frame visible
		setVisible(true);
	}
}