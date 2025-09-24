package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminAddPage extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmAddpage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddPage window = new AdminAddPage();
					window.frmAddpage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminAddPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Create the main frame
		frmAddpage = new JFrame();
		frmAddpage.setTitle("Add_Page(Admin)");
		frmAddpage.getContentPane().setBackground(new Color(0, 0, 0));
		frmAddpage.setBackground(new Color(0, 0, 0));
		frmAddpage.setBounds(100, 100, 645, 498);
		frmAddpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddpage.getContentPane().setLayout(null);

		// Create and configure "Room Adding" button
		JButton roomAdding = new JButton("Room Adding");
		roomAdding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddpage.setVisible(false);
				AddRoomType p4 = new AddRoomType();
				p4.showWindow();
			}
		});
		roomAdding.setBackground(new Color(0, 255, 255));
		roomAdding.setFont(new Font("Tahoma", Font.BOLD, 16));
		roomAdding.setBounds(192, 43, 214, 58);
		frmAddpage.getContentPane().add(roomAdding);

		// Create and configure "Customer Adding" button
		JButton customerAdding = new JButton("Customer Adding");
		customerAdding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddpage.setVisible(false);
				CustomerType p8 = new CustomerType();
				p8.showWindow();
			}
		});
		customerAdding.setFont(new Font("Tahoma", Font.BOLD, 16));
		customerAdding.setBackground(new Color(0, 255, 255));
		customerAdding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		customerAdding.setBounds(192, 125, 214, 58);
		frmAddpage.getContentPane().add(customerAdding);

		// Create and configure "Employee Adding" button
		JButton EmployeeAdding = new JButton("Employee Adding");
		EmployeeAdding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddpage.setVisible(false);
				EmployeeType p8 = new EmployeeType();
				p8.showWindow();
			}
		});
		EmployeeAdding.setBackground(new Color(0, 255, 255));
		EmployeeAdding.setFont(new Font("Tahoma", Font.BOLD, 16));
		EmployeeAdding.setBounds(192, 212, 214, 58);
		frmAddpage.getContentPane().add(EmployeeAdding);

		// Create and configure "Booking Adding" button
		JButton bookingAdding = new JButton("Booking Adding");
		bookingAdding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddpage.setVisible(false);
				BookingAdding p8 = new BookingAdding();
				p8.showWindow();
			}
		});
		bookingAdding.setBackground(new Color(0, 255, 255));
		bookingAdding.setFont(new Font("Tahoma", Font.BOLD, 16));
		bookingAdding.setBounds(192, 295, 214, 58);
		frmAddpage.getContentPane().add(bookingAdding);

		// Create and configure "Back To Menu" button
		JButton backToMenu = new JButton("Back To Menu");
		backToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddpage.setVisible(false);
				AdminFirstView p2 = new AdminFirstView();
				p2.showWindow();
			}
		});
		backToMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
		backToMenu.setBackground(new Color(0, 255, 255));
		backToMenu.setBounds(21, 10, 127, 31);
		frmAddpage.getContentPane().add(backToMenu);

		// Create and configure "Department Adding" button
		JButton btnNewButton = new JButton("Department Adding");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddpage.setVisible(false);
				DepartmentAdding p8 = new DepartmentAdding();
				p8.showWindow();
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(192, 374, 214, 58);
		frmAddpage.getContentPane().add(btnNewButton);

		// Set the background image
		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 631, 471);
		frmAddpage.getContentPane().add(backgroundLabel);
	}

	// Method to show the window
	public void showWindow() {
		frmAddpage.setVisible(true);
	}

}
