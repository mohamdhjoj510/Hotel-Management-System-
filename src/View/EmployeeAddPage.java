package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class EmployeeAddPage extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmEmployeeaddpage;

	// Main method to launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeAddPage window = new EmployeeAddPage();
					window.frmEmployeeaddpage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor to create a new EmployeeAddPage object.
	public EmployeeAddPage() {
		initialize();
	}

	// Initialize the contents of the frame and set up the GUI components.
	private void initialize() {
		frmEmployeeaddpage = new JFrame();
		frmEmployeeaddpage.setTitle("Add_Page(Employee)");
		frmEmployeeaddpage.setBounds(100, 100, 645, 517);
		frmEmployeeaddpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeeaddpage.getContentPane().setLayout(null);

		// Button to add a new room.
		JButton roomAdding = new JButton("Room Adding");
		roomAdding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeeaddpage.setVisible(false);
				AddRoomType page1 = new AddRoomType();
				page1.showWindow();
			}
		});
		roomAdding.setBackground(new Color(0, 255, 255));
		roomAdding.setFont(new Font("Tahoma", Font.BOLD, 16));
		roomAdding.setBounds(191, 73, 214, 58);
		frmEmployeeaddpage.getContentPane().add(roomAdding);

		// Button to add a new customer.
		JButton customerAdding = new JButton("Customer Adding");
		customerAdding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeeaddpage.setVisible(false);
				CustomerType page1 = new CustomerType();
				page1.showWindow();
			}
		});
		customerAdding.setFont(new Font("Tahoma", Font.BOLD, 16));
		customerAdding.setBackground(new Color(0, 255, 255));
		customerAdding.setBounds(191, 165, 214, 58);
		frmEmployeeaddpage.getContentPane().add(customerAdding);

		// Button to add a new booking.
		JButton bookingAdding = new JButton("Booking Adding");
		bookingAdding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeeaddpage.setVisible(false);
				BookingAdding page1 = new BookingAdding();
				page1.showWindow();
			}
		});
		bookingAdding.setBackground(new Color(0, 255, 255));
		bookingAdding.setFont(new Font("Tahoma", Font.BOLD, 16));
		bookingAdding.setBounds(191, 262, 214, 58);
		frmEmployeeaddpage.getContentPane().add(bookingAdding);

		// Button to add a new department.
		JButton btnNewButton = new JButton("Department Adding");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeeaddpage.setVisible(false);
				DepartmentAdding page1 = new DepartmentAdding();
				page1.showWindow();
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(191, 360, 214, 58);
		frmEmployeeaddpage.getContentPane().add(btnNewButton);

		// Button to go back to the employee main menu.
		JButton backToMenu = new JButton("Back To Menu");
		backToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeeaddpage.setVisible(false);
				EmployeeFirstView p2 = new EmployeeFirstView();
				p2.showWindow();
			}
		});
		backToMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
		backToMenu.setBackground(new Color(0, 255, 255));
		backToMenu.setBounds(21, 10, 127, 31);
		frmEmployeeaddpage.getContentPane().add(backToMenu);

		// Set a background image for the frame.
		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 631, 480);
		frmEmployeeaddpage.getContentPane().add(backgroundLabel);
	}

	// Method to display the window and make it visible.
	public void showWindow() {
		frmEmployeeaddpage.setVisible(true);
	}
}
