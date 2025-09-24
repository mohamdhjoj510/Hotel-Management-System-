package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import Exception.NoDepartmentsFound;
import model.Department;
import model.Hotel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class DepartmentRemoving extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame departments_removing;

	// Main method to launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentRemoving window = new DepartmentRemoving();
					window.departments_removing.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor to create a new DepartmentRemoving object.
	public DepartmentRemoving() {
		initialize();
	}

	// Initialize the contents of the frame and set up the GUI components.
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		departments_removing = new JFrame();
		departments_removing.setTitle("Department_Removing");
		departments_removing.setBounds(100, 100, 646, 500);
		departments_removing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		departments_removing.getContentPane().setLayout(null);

		// Label to display instructions for the user.
		JLabel msg1 = new JLabel("   Please add the id for the department you would like to remove");
		msg1.setForeground(new Color(0, 255, 255));
		msg1.setFont(new Font("Tahoma", Font.BOLD, 18));
		msg1.setBounds(10, 77, 612, 25);
		departments_removing.getContentPane().add(msg1);

		// Label for department ID selection.
		JLabel msg2 = new JLabel("department id :");
		msg2.setForeground(new Color(0, 255, 255));
		msg2.setFont(new Font("Tahoma", Font.BOLD, 14));
		msg2.setBounds(169, 171, 126, 25);
		departments_removing.getContentPane().add(msg2);

		// Combobox to display the available department IDs for selection.
		ArrayList<String> departments = new ArrayList<String>();
		for (Department d : Hotel.getInstance().getAllDepartments().values()) {
			departments.add(d.getDepartmentId());
		}
		JComboBox departmentsRemovBOX = new JComboBox();
		departmentsRemovBOX.setBounds(169, 194, 238, 33);
		departments_removing.getContentPane().add(departmentsRemovBOX);
		for (String departmentID : departments) {
			departmentsRemovBOX.addItem(departmentID);
		}

		// Button to submit the selected department for removal.
		JButton submit = new JButton("SUBMIT");
		submit.setBackground(new Color(0, 255, 255));
		submit.setForeground(new Color(0, 0, 0));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Check if a department ID is selected
					if (departmentsRemovBOX.getSelectedItem() == null) {
						throw new NoDepartmentsFound();
					}

					// Remove the selected department from the system
					Hotel.getInstance().removeDepartment(
							Hotel.getInstance().getRealDepartment((String) departmentsRemovBOX.getSelectedItem()));
					Main.save();

					// Show a success message to the user
					JOptionPane.showMessageDialog(null, "Department removed successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);

					// Redirect the user to the appropriate page based on their user type
					// (admin/employee)
					if (LoginPage.getUserType().equals("admin")) {
						departments_removing.setVisible(false);
						AdminRemovePage p2 = new AdminRemovePage();
						p2.showWindow();
					} else {
						departments_removing.setVisible(false);
						EmployeeRemovePage p2 = new EmployeeRemovePage();
						p2.showWindow();
					}

				} catch (NoDepartmentsFound ex1) {
					// Handle the exception when no departments are found for removal
					JOptionPane.showMessageDialog(null, ex1.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submit.setFont(new Font("Tahoma", Font.BOLD, 14));
		submit.setBounds(233, 287, 114, 38);
		departments_removing.getContentPane().add(submit);

		// Button to cancel and return to the previous page based on user type.
		JButton cancel = new JButton("CANCEL");
		cancel.setBackground(new Color(0, 255, 255));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginPage.getUserType().equals("admin")) {
					departments_removing.setVisible(false);
					AdminRemovePage p2 = new AdminRemovePage();
					p2.showWindow();
				} else {
					departments_removing.setVisible(false);
					EmployeeRemovePage p2 = new EmployeeRemovePage();
					p2.showWindow();
				}

			}
		});
		cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancel.setBounds(233, 350, 114, 38);
		departments_removing.getContentPane().add(cancel);

		// Set a background image for the frame.
		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 645, 463);
		departments_removing.getContentPane().add(backgroundLabel);
	}

	// Method to display the window and make it visible.
	public void showWindow() {
		departments_removing.setVisible(true);
	}
}
