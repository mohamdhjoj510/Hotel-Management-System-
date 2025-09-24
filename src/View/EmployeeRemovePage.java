package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Color;


public class EmployeeRemovePage extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	// Main method to launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeRemovePage window = new EmployeeRemovePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor to create a new EmployeeRemovePage object.
	public EmployeeRemovePage() {
		initialize();
	}

	// Initialize the contents of the frame and set up the GUI components.
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Remove_Page(Employee)");
		frame.setBounds(100, 100, 645, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Button to go back to the employee main menu.
		JButton backToAdminMenu = new JButton("Back To Menu");
		backToAdminMenu.setBackground(new Color(0, 255, 255));
		backToAdminMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeFirstView page = new EmployeeFirstView();
				frame.setVisible(false);
				page.showWindow();
			}
		});
		backToAdminMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		backToAdminMenu.setBounds(10, 32, 120, 39);
		frame.getContentPane().add(backToAdminMenu);

		// Button to go to the room removing page.
		JButton roomRemoving = new JButton("Room removing");
		roomRemoving.setBackground(new Color(0, 255, 255));
		roomRemoving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				RoomRemoving p2 = new RoomRemoving();
				p2.showWindow();
			}
		});
		roomRemoving.setFont(new Font("Tahoma", Font.BOLD, 18));
		roomRemoving.setBounds(208, 84, 194, 63);
		frame.getContentPane().add(roomRemoving);

		// Button to go to the customer removing page.
		JButton customerRemoving = new JButton("Customer removing");
		customerRemoving.setBackground(new Color(0, 255, 255));
		customerRemoving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				CustomerRemoving p2 = new CustomerRemoving();
				p2.showWindow();
			}
		});
		customerRemoving.setFont(new Font("Tahoma", Font.BOLD, 16));
		customerRemoving.setBounds(208, 172, 194, 63);
		frame.getContentPane().add(customerRemoving);

		// Button to go to the booking removing page.
		JButton bookingRemoving = new JButton("Booking removing");
		bookingRemoving.setBackground(new Color(0, 255, 255));
		bookingRemoving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				BookingRemoving p2 = new BookingRemoving();
				p2.showWindow();
			}
		});
		bookingRemoving.setFont(new Font("Tahoma", Font.BOLD, 16));
		bookingRemoving.setBounds(208, 268, 194, 63);
		frame.getContentPane().add(bookingRemoving);

		// Button to go to the department removing page.
		JButton departmentRemovingBtn = new JButton("Department removing");
		departmentRemovingBtn.setBackground(new Color(0, 255, 255));
		departmentRemovingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				DepartmentRemoving p2 = new DepartmentRemoving();
				p2.showWindow();
			}
		});
		departmentRemovingBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		departmentRemovingBtn.setBounds(208, 362, 194, 63);
		frame.getContentPane().add(departmentRemovingBtn);

		// Set background image.
		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 631, 480);
		frame.getContentPane().add(backgroundLabel);
	}

	// Method to display the window and make it visible.
	public void showWindow() {
		frame.setVisible(true);
	}
}
