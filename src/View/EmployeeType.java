package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import java.awt.Color;

public class EmployeeType extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmEmployeetype;

	// Main method to launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeType window = new EmployeeType();
					window.frmEmployeetype.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor to create a new EmployeeType object.
	public EmployeeType() {
		initialize();
	}

	// Initialize the contents of the frame and set up the GUI components.
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmEmployeetype = new JFrame();
		frmEmployeetype.setTitle("Employee_Type");
		frmEmployeetype.setBounds(100, 100, 645, 500);
		frmEmployeetype.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeetype.getContentPane().setLayout(null);

		// Button to go back to the admin add page.
		JButton backToAddPage = new JButton("BACK");
		backToAddPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeetype.setVisible(false);
				AdminAddPage p5 = new AdminAddPage();
				p5.showWindow();
			}
		});
		backToAddPage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backToAddPage.setBounds(10, 40, 122, 40);
		frmEmployeetype.getContentPane().add(backToAddPage);

		// Label to prompt the admin to choose the type of employee to add.
		JLabel msg1 = new JLabel("        Please choose the type of the employee you would like to add");
		msg1.setForeground(new Color(0, 0, 0));
		msg1.setFont(new Font("Tahoma", Font.BOLD, 14));
		msg1.setBounds(130, 21, 491, 40);
		frmEmployeetype.getContentPane().add(msg1);

		// Combo box to select the employee type.
		String[] employeeTypes = { "Regular Employee", "Department Manager" };
		JComboBox employeeTypeBox = new JComboBox(employeeTypes);
		employeeTypeBox.setBounds(213, 207, 182, 32);
		frmEmployeetype.getContentPane().add(employeeTypeBox);

		// Button to proceed to the next page based on the selected employee type.
		JButton next = new JButton("NEXT");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeetype.setVisible(false);
				String employeeSelected = (String) employeeTypeBox.getSelectedItem();
				if (employeeSelected.equals("Regular Employee")) {
					RegEmployeeAdding page1 = new RegEmployeeAdding();
					page1.showWindow();
				}
				if (employeeSelected.equals("Department Manager")) {
					DepartmentManagerAdding page1 = new DepartmentManagerAdding();
					page1.showWindow();
				}
			}
		});
		next.setFont(new Font("Tahoma", Font.PLAIN, 15));
		next.setBounds(261, 283, 97, 40);
		frmEmployeetype.getContentPane().add(next);

		// Set background image.
		String imageUrl = "/hotelEmployees.jpg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 645, 453);
		frmEmployeetype.getContentPane().add(backgroundLabel);
	}

	// Method to display the window and make it visible.
	public void showWindow() {
		frmEmployeetype.setVisible(true);
	}
}
