package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Booking;
import model.Hotel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class AdminFirstView {

	private JFrame frmAdminsystemmanagement;

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFirstView window = new AdminFirstView();
					window.frmAdminsystemmanagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application.
	public AdminFirstView() {
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {
		frmAdminsystemmanagement = new JFrame();
		frmAdminsystemmanagement.setTitle("Admin_Management_System");
		frmAdminsystemmanagement.getContentPane().setBackground(new Color(0, 0, 0));
		frmAdminsystemmanagement.setBackground(new Color(0, 0, 0));
		frmAdminsystemmanagement.setBounds(100, 100, 645, 500);
		frmAdminsystemmanagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminsystemmanagement.getContentPane().setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(500, -127, 424, 378);
		Image img3 = new ImageIcon(this.getClass().getResource("/authorization.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img3));
		frmAdminsystemmanagement.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(30, -97, 436, 378);
		Image img4 = new ImageIcon(this.getClass().getResource("/banner (1).png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img4));
		frmAdminsystemmanagement.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(172, -152, 436, 489);
		Image img5 = new ImageIcon(this.getClass().getResource("/rating.png")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img5));
		frmAdminsystemmanagement.getContentPane().add(lblNewLabel_6);

		// Title label for the main view
		JLabel msg = new JLabel(" System Management  -  [Admin Management]");
		msg.setFont(new Font("Tahoma", Font.BOLD, 20));
		msg.setForeground(new Color(0, 255, 255));
		msg.setBackground(new Color(0, 0, 0));
		msg.setBounds(20, 22, 566, 41);
		frmAdminsystemmanagement.getContentPane().add(msg);

		// Button to add data to the hotel
		JButton addBtn = new JButton("Add To The Hotel");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminsystemmanagement.setVisible(false);
				AdminAddPage p3 = new AdminAddPage();
				p3.showWindow();
			}
		});
		addBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		addBtn.setBackground(new Color(0, 255, 255));
		addBtn.setBounds(20, 169, 237, 41);
		frmAdminsystemmanagement.getContentPane().add(addBtn);

		// Button to remove data from the hotel
		JButton removeBtn = new JButton("Remove From The Hotel");
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminsystemmanagement.setVisible(false);
				AdminRemovePage p3 = new AdminRemovePage();
				p3.showWindow();
			}
		});
		removeBtn.setBackground(new Color(0, 255, 255));
		removeBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		removeBtn.setBounds(360, 169, 226, 41);
		frmAdminsystemmanagement.getContentPane().add(removeBtn);

		// Button to view system details
		JButton detailsBtn = new JButton("System Details");
		detailsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminsystemmanagement.setVisible(false);
				SystemDetails p3 = new SystemDetails();
				p3.showWindow();
			}
		});
		detailsBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		detailsBtn.setBackground(new Color(0, 255, 255));
		detailsBtn.setBounds(360, 294, 226, 41);
		frmAdminsystemmanagement.getContentPane().add(detailsBtn);

		// Button to access system functions
		JButton functionsBtn = new JButton("System Functions");
		functionsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminsystemmanagement.setVisible(false);
				SystemFunctions p3 = new SystemFunctions();
				p3.showWindow();
			}
		});
		functionsBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		functionsBtn.setBackground(new Color(0, 255, 255));
		functionsBtn.setBounds(20, 294, 238, 41);
		frmAdminsystemmanagement.getContentPane().add(functionsBtn);

		// Button to log out from the system
		JButton backBtn = new JButton("Log Out");
		backBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Show a confirmation dialog before logging out
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out from the system?",
						"Logout Confirmation", JOptionPane.YES_NO_OPTION);

				if (choice == JOptionPane.YES_OPTION) {
					frmAdminsystemmanagement.setVisible(false);
					LoginPage p1 = new LoginPage();
					p1.showWindow();
				}
			}
		});
		backBtn.setBackground(new Color(0, 255, 255));
		backBtn.setBounds(10, 412, 168, 41);
		frmAdminsystemmanagement.getContentPane().add(backBtn);

		// Button to access the system guide or help
		JButton howToUseBtn = new JButton("how to use?");
		howToUseBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		howToUseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminsystemmanagement.setVisible(false);
				SystemGuide page = new SystemGuide();
				page.showWindow();
			}
		});
		howToUseBtn.setBackground(new Color(0, 255, 255));
		howToUseBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		howToUseBtn.setBounds(453, 419, 168, 34);
		frmAdminsystemmanagement.getContentPane().add(howToUseBtn);

		JLabel currentDateLbl = new JLabel("New label");
		currentDateLbl.setForeground(new Color(0, 255, 255));
		currentDateLbl.setBounds(10, 0, 134, 34);
		frmAdminsystemmanagement.getContentPane().add(currentDateLbl);
		LocalDate currentDate = LocalDate.now();
		currentDateLbl.setText("Date - " + currentDate);

		// a button to generate word file with all the bookings and revenue .admin
		JButton btnNewButton = new JButton("bookings to word file");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content = "Hello, this is hotel bookings profit\n";

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

					JOptionPane.showMessageDialog(frmAdminsystemmanagement,
							"Bookings written successfully\nPlease check the word file (BookingsAndRevenueFile.doc)",
							"Word file generated", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(frmAdminsystemmanagement, "Error writing to the file", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(453, 368, 168, 34);
		frmAdminsystemmanagement.getContentPane().add(btnNewButton);

		// Background video setup
		String imageUrl = "/CalculatingThickBushsqueaker-size_restricted.gif";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 648, 489);
		frmAdminsystemmanagement.getContentPane().add(backgroundLabel);

	}

	// Method to show the window
	public void showWindow() {
		frmAdminsystemmanagement.setVisible(true);
	}
}
