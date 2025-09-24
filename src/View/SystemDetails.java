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

public class SystemDetails extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmSystemdetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemDetails window = new SystemDetails();
					window.frmSystemdetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SystemDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSystemdetails = new JFrame();
		frmSystemdetails.setTitle("System_Details");
		frmSystemdetails.setBounds(100, 100, 645, 500);
		frmSystemdetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSystemdetails.getContentPane().setLayout(null);

		// Show all hotel employees
		JButton allEmployessBtn = new JButton("Hotel Employees");
		allEmployessBtn.setBackground(new Color(0, 255, 255));
		allEmployessBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSystemdetails.setVisible(false);
				ShowAllEmployees page1 = new ShowAllEmployees();
				page1.showWindow();
			}

		});
		allEmployessBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		allEmployessBtn.setBounds(199, 46, 185, 61);
		frmSystemdetails.getContentPane().add(allEmployessBtn);

		// show all hotel customers
		JButton allCustomersBtn = new JButton("Hotel Customers");
		allCustomersBtn.setBackground(new Color(0, 255, 255));
		allCustomersBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSystemdetails.setVisible(false);
				ShowAllCustomers page1 = new ShowAllCustomers();
				page1.showWindow();
			}

		});
		allCustomersBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		allCustomersBtn.setBounds(199, 123, 185, 61);
		frmSystemdetails.getContentPane().add(allCustomersBtn);

		// show all hotel rooms
		JButton allRoomsBtn = new JButton("Hotel Rooms");
		allRoomsBtn.setBackground(new Color(0, 255, 255));
		allRoomsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSystemdetails.setVisible(false);
				ShowAllRooms page1 = new ShowAllRooms();
				page1.showWindow();
			}

		});
		allRoomsBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		allRoomsBtn.setBounds(199, 200, 185, 61);
		frmSystemdetails.getContentPane().add(allRoomsBtn);

		// show all hotel bookings
		JButton allBookingsBtn = new JButton("Hotel Bookings");
		allBookingsBtn.setBackground(new Color(0, 255, 255));
		allBookingsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSystemdetails.setVisible(false);
				ShowAllBookings page1 = new ShowAllBookings();
				page1.showWindow();
			}

		});
		allBookingsBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		allBookingsBtn.setBounds(199, 277, 185, 61);
		frmSystemdetails.getContentPane().add(allBookingsBtn);

		// show all hotel departments
		JButton allDepartmentsBtn = new JButton("Hotel Departments");
		allDepartmentsBtn.setBackground(new Color(0, 255, 255));
		allDepartmentsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSystemdetails.setVisible(false);
				ShowAllDepartments page1 = new ShowAllDepartments();
				page1.showWindow();
			}

		});
		allDepartmentsBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		allDepartmentsBtn.setBounds(199, 359, 185, 61);
		frmSystemdetails.getContentPane().add(allDepartmentsBtn);

		// back to main menu page based in user type (admin/employee)
		JButton backBtn = new JButton("Back To Menu");
		backBtn.setBackground(new Color(0, 255, 255));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginPage.getUserType().equals("admin")) {
					frmSystemdetails.setVisible(false);
					AdminFirstView p2 = new AdminFirstView();
					p2.showWindow();
				} else {
					frmSystemdetails.setVisible(false);
					EmployeeFirstView p2 = new EmployeeFirstView();
					p2.showWindow();
				}
			}
		});
		backBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		backBtn.setBounds(10, 20, 125, 33);
		frmSystemdetails.getContentPane().add(backBtn);

		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 645, 463);
		frmSystemdetails.getContentPane().add(backgroundLabel);

	}

	public void showWindow() {
		frmSystemdetails.setVisible(true);

	}

}
