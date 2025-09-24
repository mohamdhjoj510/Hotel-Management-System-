package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class AdminRemovePage extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmRemovepageadmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// This is the entry point of the application.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRemovePage window = new AdminRemovePage();
					// When the application is launched, create an instance of AdminRemovePage
					// and make the frame visible.
					window.frmRemovepageadmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminRemovePage() {
		// Constructor to initialize the class.
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Initialize the JFrame and its components.
		frmRemovepageadmin = new JFrame();
		frmRemovepageadmin.setTitle("Remove_Page(Admin)");
		frmRemovepageadmin.setBounds(100, 100, 645, 500);
		frmRemovepageadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRemovepageadmin.getContentPane().setLayout(null);

		// Create a button to go back to the AdminFirstView.
		JButton backToAdminMenu = new JButton("Back To Menu");
		backToAdminMenu.setBackground(new Color(0, 255, 255));
		backToAdminMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When clicked, hide the current frame and show the AdminFirstView.
				frmRemovepageadmin.setVisible(false);
				AdminFirstView p2 = new AdminFirstView();
				p2.showWindow();

			}
		});
		backToAdminMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		backToAdminMenu.setBounds(10, 32, 120, 39);
		frmRemovepageadmin.getContentPane().add(backToAdminMenu);

		// Create buttons for different remove actions.

		// Button for removing a room.
		JButton roomRemoving = new JButton("Room removing");
		roomRemoving.setBackground(new Color(0, 255, 255));
		roomRemoving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When clicked, hide the current frame and show the RoomRemoving view.
				frmRemovepageadmin.setVisible(false);
				RoomRemoving p2 = new RoomRemoving();
				p2.showWindow();

			}
		});
		roomRemoving.setFont(new Font("Tahoma", Font.BOLD, 18));
		roomRemoving.setBounds(208, 45, 194, 63);
		frmRemovepageadmin.getContentPane().add(roomRemoving);

		// Button for removing a customer.
		JButton customerRemoving = new JButton("Customer removing");
		customerRemoving.setBackground(new Color(0, 255, 255));
		customerRemoving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When clicked, hide the current frame and show the CustomerRemoving view.
				frmRemovepageadmin.setVisible(false);
				CustomerRemoving p2 = new CustomerRemoving();
				p2.showWindow();

			}
		});
		customerRemoving.setFont(new Font("Tahoma", Font.BOLD, 16));
		customerRemoving.setBounds(208, 132, 194, 63);
		frmRemovepageadmin.getContentPane().add(customerRemoving);

		// Button for removing an employee.
		JButton employeeRemoving = new JButton("Employee removing");
		employeeRemoving.setBackground(new Color(0, 255, 255));
		employeeRemoving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When clicked, hide the current frame and show the EmployeeRemoving view.
				frmRemovepageadmin.setVisible(false);
				EmployeeRemoving p2 = new EmployeeRemoving();
				p2.showWindow();

			}
		});
		employeeRemoving.setFont(new Font("Tahoma", Font.BOLD, 16));
		employeeRemoving.setBounds(208, 215, 194, 63);
		frmRemovepageadmin.getContentPane().add(employeeRemoving);

		// Button for removing a booking.
		JButton bookingRemoving = new JButton("Booking removing");
		bookingRemoving.setBackground(new Color(0, 255, 255));
		bookingRemoving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When clicked, hide the current frame and show the BookingRemoving view.
				frmRemovepageadmin.setVisible(false);
				BookingRemoving p2 = new BookingRemoving();
				p2.showWindow();

			}
		});
		bookingRemoving.setFont(new Font("Tahoma", Font.BOLD, 16));
		bookingRemoving.setBounds(208, 300, 194, 63);
		frmRemovepageadmin.getContentPane().add(bookingRemoving);

		// Button for removing a department.
		JButton departmentRemovingBtn = new JButton("Department removing");
		departmentRemovingBtn.setBackground(new Color(0, 255, 255));
		departmentRemovingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When clicked, hide the current frame and show the DepartmentRemoving view.
				frmRemovepageadmin.setVisible(false);
				DepartmentRemoving p2 = new DepartmentRemoving();
				p2.showWindow();

			}
		});
		departmentRemovingBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		departmentRemovingBtn.setBounds(208, 381, 194, 63);
		frmRemovepageadmin.getContentPane().add(departmentRemovingBtn);

		// Set background image using JLabel.
		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 631, 471);
		frmRemovepageadmin.getContentPane().add(backgroundLabel);
	}

	// Method to show the frame.
	public void showWindow() {
		frmRemovepageadmin.setVisible(true);
	}
}
