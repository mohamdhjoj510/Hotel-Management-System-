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

import javax.swing.JTextField;
import Exception.DepartmentAlreadyExistException;
import Exception.EmptyFieldsException;
import Exception.NegativeNumberException;
import model.Department;
import model.Hotel;
import utils.Specialization;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class DepartmentAdding extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmDepartmentdetails;
	private JTextField departmentIDText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentAdding window = new DepartmentAdding();
					window.frmDepartmentdetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DepartmentAdding() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmDepartmentdetails = new JFrame();
		frmDepartmentdetails.setTitle("Department_Details");
		frmDepartmentdetails.setBounds(100, 100, 645, 500);
		frmDepartmentdetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDepartmentdetails.getContentPane().setLayout(null);

		// Labels and Text Fields
		JLabel msg1 = new JLabel("                   Please fill in the new department details");
		msg1.setBackground(new Color(128, 255, 255));
		msg1.setForeground(new Color(128, 255, 255));
		msg1.setFont(new Font("Tahoma", Font.BOLD, 20));
		msg1.setBounds(-16, 55, 647, 38);
		frmDepartmentdetails.getContentPane().add(msg1);

		JLabel msg2 = new JLabel("department id :");
		msg2.setBackground(new Color(128, 255, 255));
		msg2.setForeground(new Color(128, 255, 255));
		msg2.setFont(new Font("Tahoma", Font.BOLD, 12));
		msg2.setBounds(201, 133, 106, 20);
		frmDepartmentdetails.getContentPane().add(msg2);

		// Text field for entering the department ID
		departmentIDText = new JTextField();
		departmentIDText.setBackground(new Color(255, 255, 255));
		departmentIDText.setBounds(200, 153, 182, 29);
		frmDepartmentdetails.getContentPane().add(departmentIDText);
		departmentIDText.setColumns(10);

		JLabel msg3 = new JLabel("depaertment specialization :");
		msg3.setForeground(new Color(128, 255, 255));
		msg3.setFont(new Font("Tahoma", Font.BOLD, 12));
		msg3.setBounds(201, 227, 181, 20);
		frmDepartmentdetails.getContentPane().add(msg3);

		// Combo box for selecting department specialization
		Specialization[] sBox = { Specialization.Administration, Specialization.Advertisement,
				Specialization.customerService, Specialization.Finance, Specialization.Logistics };
		JComboBox specializationBox = new JComboBox(sBox);
		specializationBox.setForeground(new Color(0, 0, 0));
		specializationBox.setBackground(new Color(255, 255, 255));
		specializationBox.setBounds(201, 249, 181, 29);
		frmDepartmentdetails.getContentPane().add(specializationBox);

		// Buttons
		// Submit button for adding the department to the Hotel
		JButton addDepartmentBtn = new JButton("SUBMIT");
		addDepartmentBtn.setBackground(new Color(0, 255, 255));
		addDepartmentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Validate input fields before adding the department
					if (departmentIDText.getText().isEmpty()) {
						throw new EmptyFieldsException();
					}
					if (Hotel.getInstance().getAllDepartments().containsKey(departmentIDText.getText())) {
						throw new DepartmentAlreadyExistException();
					}
					if (Integer.parseInt(departmentIDText.getText()) < 0) {
						throw new NegativeNumberException();

					}
					// Create new Department object and add it to the Hotel
					Specialization departmentSpecialization = (Specialization) specializationBox.getSelectedItem();
					Department d1 = new Department(departmentIDText.getText(), departmentSpecialization);
					Hotel.getInstance().addDepartment(d1);
					Main.save();
					// Show success message and redirect to appropriate view based on user type
					JOptionPane.showMessageDialog(null, "department added successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					if (LoginPage.getUserType().equals("admin")) {
						frmDepartmentdetails.setVisible(false);
						AdminFirstView p7 = new AdminFirstView();
						p7.showWindow();
					} else {
						frmDepartmentdetails.setVisible(false);
						EmployeeFirstView p7 = new EmployeeFirstView();
						p7.showWindow();
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter numeric values for appropriate fields",
							"Input Error", JOptionPane.ERROR_MESSAGE);
				} catch (EmptyFieldsException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (DepartmentAlreadyExistException ex1) {
					JOptionPane.showMessageDialog(null, ex1.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (NegativeNumberException ex2) {
					JOptionPane.showMessageDialog(null, ex2.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		addDepartmentBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		addDepartmentBtn.setBounds(237, 322, 114, 38);
		frmDepartmentdetails.getContentPane().add(addDepartmentBtn);

		// Cancel button to go back to the previous view
		JButton cancel = new JButton("CANCEL");
		cancel.setBackground(new Color(0, 255, 255));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginPage.getUserType().equals("admin")) {
					frmDepartmentdetails.setVisible(false);
					AdminAddPage page = new AdminAddPage();
					page.showWindow();
				} else {
					frmDepartmentdetails.setVisible(false);
					EmployeeAddPage page = new EmployeeAddPage();
					page.showWindow();
				}
			}
		});
		cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		cancel.setBounds(237, 383, 114, 38);
		frmDepartmentdetails.getContentPane().add(cancel);

		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(-39, -28, 711, 505);
		frmDepartmentdetails.getContentPane().add(backgroundLabel);
	}

	/**
	 * Method to display the JFrame.
	 */
	public void showWindow() {
		frmDepartmentdetails.setVisible(true);

	}

}
