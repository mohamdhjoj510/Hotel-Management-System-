package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Booking;
import model.Hotel;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class EmployeeFirstView {

	private JFrame EmployeeManagmentSystemFrm;
	private static String EmployeeUsername;
	private static String EmployeeName;
	private static String EmployeePhoto;

	// Getters and setters for EmployeeUsername and EmployeeName.
	public static String getEmployeeName() {
		return EmployeeName;
	}

	public static void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public static String getEmployeeUsername() {
		return EmployeeUsername;
	}

	public static void setEmployeeUsername(String employeeUsername) {
		EmployeeUsername = employeeUsername;
	}

	public static String getEmployeePhoto() {
		return EmployeePhoto;
	}

	public static void setEmployeePhoto(String employeePhoto) {
		EmployeePhoto = employeePhoto;
	}

	// Main method to launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFirstView window = new EmployeeFirstView();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Getter for the JFrame.
	public JFrame getFrame() {
		return EmployeeManagmentSystemFrm;
	}

	// Setter for the JFrame.
	public void setFrame(JFrame frame) {
		this.EmployeeManagmentSystemFrm = frame;
	}

	// Constructor to create a new EmployeeFirstView object.
	public EmployeeFirstView() {
		initialize();
	}

	// Initialize the contents of the frame and set up the GUI components.
	private void initialize() {
		EmployeeManagmentSystemFrm = new JFrame();
		EmployeeManagmentSystemFrm
				.setTitle("Employee_Management_System(" + EmployeeFirstView.getEmployeeUsername() + ")");
		EmployeeManagmentSystemFrm.getContentPane().setBackground(new Color(0, 0, 0));
		EmployeeManagmentSystemFrm.setBackground(new Color(0, 0, 0));
		EmployeeManagmentSystemFrm.setBounds(100, 100, 645, 500);
		EmployeeManagmentSystemFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EmployeeManagmentSystemFrm.getContentPane().setLayout(null);

		if (EmployeePhoto != null) {
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setBounds(500, -127, 424, 378);
			Image img3 = new ImageIcon(this.getClass().getResource(EmployeePhoto)).getImage();
			lblNewLabel_4.setIcon(new ImageIcon(img3));
			EmployeeManagmentSystemFrm.getContentPane().add(lblNewLabel_4);
		}

		// Label to display a message indicating the system and employee management.
		JLabel msg = new JLabel(" System Management / Employee Management ,");
		msg.setFont(new Font("Tahoma", Font.BOLD, 20));
		msg.setForeground(new Color(0, 255, 255));
		msg.setBackground(new Color(0, 0, 0));
		msg.setBounds(20, 22, 566, 41);
		EmployeeManagmentSystemFrm.getContentPane().add(msg);

		// Label to display a welcome message with the employee's name.
		JLabel welcomeMsg = new JLabel(" WELCOME BACK , " + EmployeeFirstView.getEmployeeName());
		welcomeMsg.setFont(new Font("Tahoma", Font.BOLD, 16));
		welcomeMsg.setForeground(new Color(0, 255, 255));
		welcomeMsg.setBackground(new Color(0, 0, 0));
		welcomeMsg.setBounds(20, 50, 366, 34);
		EmployeeManagmentSystemFrm.getContentPane().add(welcomeMsg);

		// Button to go to the employee add page.
		JButton addBtn = new JButton("Add To The Hotel");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeManagmentSystemFrm.setVisible(false);
				EmployeeAddPage page1 = new EmployeeAddPage();
				page1.showWindow();
			}
		});
		addBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		addBtn.setBackground(new Color(0, 255, 255));
		addBtn.setBounds(39, 162, 237, 41);
		EmployeeManagmentSystemFrm.getContentPane().add(addBtn);

		// Button to go to the employee remove page.
		JButton removeBtn = new JButton("Remove From The Hotel");
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeManagmentSystemFrm.setVisible(false);
				EmployeeRemovePage page1 = new EmployeeRemovePage();
				page1.showWindow();
			}
		});
		removeBtn.setBackground(new Color(0, 255, 255));
		removeBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		removeBtn.setBounds(360, 162, 226, 41);
		EmployeeManagmentSystemFrm.getContentPane().add(removeBtn);

		// Button to go to the system details page.
		JButton detailsBtn = new JButton("System Details");
		detailsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeManagmentSystemFrm.setVisible(false);
				SystemDetails page1 = new SystemDetails();
				page1.showWindow();
			}
		});
		detailsBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		detailsBtn.setBackground(new Color(0, 255, 255));
		detailsBtn.setBounds(360, 299, 226, 41);
		EmployeeManagmentSystemFrm.getContentPane().add(detailsBtn);

		// Button to go to the system functions page.
		JButton functionsBtn = new JButton("System Functions");
		functionsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeManagmentSystemFrm.setVisible(false);
				SystemFunctions page1 = new SystemFunctions();
				page1.showWindow();
			}
		});
		functionsBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		functionsBtn.setBackground(new Color(0, 255, 255));
		functionsBtn.setBounds(38, 299, 238, 41);
		EmployeeManagmentSystemFrm.getContentPane().add(functionsBtn);

		// Button to log out from the system and return to the login page.
		JButton backBtn = new JButton("Log Out");
		backBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out from the system?",
						"Logout Confirmation", JOptionPane.YES_NO_OPTION);

				if (choice == JOptionPane.YES_OPTION) {
					EmployeeManagmentSystemFrm.setVisible(false);
					LoginPage p1 = new LoginPage();
					p1.showWindow();
				}
			}
		});
		backBtn.setBackground(new Color(0, 255, 255));
		backBtn.setBounds(20, 412, 168, 41);
		EmployeeManagmentSystemFrm.getContentPane().add(backBtn);

		// Button to go to the system guide page for instructions on how to use the
		// system.
		JButton btnNewButton = new JButton("how to use?");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeManagmentSystemFrm.setVisible(false);
				SystemGuide page = new SystemGuide();
				page.showWindow();
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(439, 412, 168, 41);
		EmployeeManagmentSystemFrm.getContentPane().add(btnNewButton);

		LocalDate currentDate = LocalDate.now();
		JLabel currentDateLbl = new JLabel("Date - " + currentDate);
		currentDateLbl.setForeground(new Color(0, 255, 255));
		currentDateLbl.setBounds(10, 0, 134, 34);
		EmployeeManagmentSystemFrm.getContentPane().add(currentDateLbl);

		// a button to generate word file with all the bookings and revenue .
		JButton btnNewButton_1 = new JButton("bookings to word");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content = "Hello, this is hotel bookings and profit\n";

				for (Booking booking : Hotel.getInstance().getAllBookings().values()) {
					double bookingProfit = booking.getTotalRevenue() - booking.getTotalCost();
					content += "booking number : " + booking.getBookingNumber() + " -> " + "booking profit : "
							+ bookingProfit + "\n";
				}

				try {
					FileWriter fileWriter = new FileWriter("BookingsAndRevenueFile.doc");
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

					bufferedWriter.write(content);

					bufferedWriter.close();

					JOptionPane.showMessageDialog(EmployeeManagmentSystemFrm,
							"Bookings written successfully\nPlease check the word file (BookingsAndRevenueFile.doc)",
							"Word file generated", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(EmployeeManagmentSystemFrm, "Error writing to the file", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(439, 361, 168, 41);
		EmployeeManagmentSystemFrm.getContentPane().add(btnNewButton_1);

		// Background video setup
		String imageUrl = "/CalculatingThickBushsqueaker-size_restricted.gif";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 648, 489);
		EmployeeManagmentSystemFrm.getContentPane().add(backgroundLabel);

	}

	// Method to display the window and make it visible.
	public void showWindow() {
		EmployeeManagmentSystemFrm.setVisible(true);
	}
}
