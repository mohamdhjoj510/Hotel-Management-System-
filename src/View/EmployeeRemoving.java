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
import Exception.NoEmployeesFound;
import model.Employee;
import model.Hotel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;


public class EmployeeRemoving extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmEmployeeremove;

	// Main method to launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeRemoving window = new EmployeeRemoving();
					window.frmEmployeeremove.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor to create a new EmployeeRemoving object.
	public EmployeeRemoving() {
		initialize();
	}

	// Initialize the contents of the frame and set up the GUI components.
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmEmployeeremove = new JFrame();
		frmEmployeeremove.setTitle("Employee_Remove");
		frmEmployeeremove.setBounds(100, 100, 646, 501);
		frmEmployeeremove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeeremove.getContentPane().setLayout(null);

		// Label to prompt the admin to add the ID of the employee to remove.
		JLabel msg1 = new JLabel("      Please add the id for the employee you would like to remove");
		msg1.setForeground(new Color(0, 255, 255));
		msg1.setBackground(new Color(0, 255, 255));
		msg1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		msg1.setBounds(10, 76, 612, 35);
		frmEmployeeremove.getContentPane().add(msg1);

		// Label to display "employee id :"
		JLabel msg2 = new JLabel("employee id :");
		msg2.setForeground(new Color(0, 255, 255));
		msg2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		msg2.setBounds(148, 179, 130, 22);
		frmEmployeeremove.getContentPane().add(msg2);

		// Creating a list to hold all the employee IDs to be used in the JComboBox.
		ArrayList<String> employeesID = new ArrayList<String>();
		for (Employee e : Hotel.getInstance().getAllEmployees().values()) {
			employeesID.add(e.getId());
		}
		JComboBox employessBox = new JComboBox();
		employessBox.setBounds(148, 200, 286, 35);
		frmEmployeeremove.getContentPane().add(employessBox);
		for (String employeeID : employeesID) {
			employessBox.addItem(employeeID);
		}

		// Button to remove the selected employee when clicked.
		JButton employeeRemoveBtn = new JButton("SUBMIT");
		employeeRemoveBtn.setBackground(new Color(0, 255, 255));
		employeeRemoveBtn.setForeground(new Color(0, 0, 0));
		employeeRemoveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (employeesID.size() == 0) {
						throw new NoEmployeesFound();
					}
					if (Hotel.getInstance().getRealEmployee((String) employessBox.getSelectedItem()) != null) {
						Hotel.getInstance().getRemovedEmployees()
								.add(Hotel.getInstance().getRealEmployee((String) employessBox.getSelectedItem()));
						Hotel.getInstance().removeEmployee(
								Hotel.getInstance().getRealEmployee((String) employessBox.getSelectedItem()));
					}
					if (Hotel.getInstance().getRealDepartmentManager((String) employessBox.getSelectedItem()) != null) {
						Hotel.getInstance().getRemovedEmployees().add(
								Hotel.getInstance().getRealDepartmentManager((String) employessBox.getSelectedItem()));
						Hotel.getInstance().removeDepartmentManager(
								Hotel.getInstance().getRealDepartmentManager((String) employessBox.getSelectedItem()));

					}
					Main.save();
					JOptionPane.showMessageDialog(null, "Employee removed successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					frmEmployeeremove.setVisible(false);
					AdminFirstView page = new AdminFirstView();
					page.showWindow();

				} catch (NoEmployeesFound ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		employeeRemoveBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		employeeRemoveBtn.setBounds(253, 294, 100, 35);
		frmEmployeeremove.getContentPane().add(employeeRemoveBtn);

		// Button to cancel the employee removal process and go back to the admin remove
		// page.
		JButton cancel = new JButton("CANCEL");
		cancel.setBackground(new Color(0, 255, 255));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeeremove.setVisible(false);
				AdminRemovePage p2 = new AdminRemovePage();
				p2.showWindow();

			}
		});
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cancel.setBounds(253, 357, 100, 35);
		frmEmployeeremove.getContentPane().add(cancel);

		// Set background image.
		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 631, 480);
		frmEmployeeremove.getContentPane().add(backgroundLabel);
	}

	// Method to display the window and make it visible.
	public void showWindow() {
		frmEmployeeremove.setVisible(true);
	}
}
