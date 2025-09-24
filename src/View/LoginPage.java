package View;

// Importing necessary packages and classes
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import Exception.AccountNoLongerAvilableException;
import Exception.CheckBoxNotSelectedException;
import Exception.UsernamePasswordException;
import model.Employee;
import model.Hotel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class LoginPage {

	// Variables declaration
	private JFrame frmLoginpage;
	private JButton showPasswordBtn;
	private JButton hidePasswordBtn;
	private JTextField userNameText;
	private AdminFirstView adminFirstView;
	private JPasswordField passText;
	private static String userType; // Declaring systemMng as an instance variable
	private int failedAttempts = 0;
	private long blockStartTime = 0;
	private final int MAX_ATTEMPTS = 5;
	private final long BLOCK_PERIOD = 60 * 1000; // 1 minute in milliseconds

	// Getters and setters for userType
	public static String getUserType() {
		return userType;
	}

	public static void setUserType(String userType) {
		LoginPage.userType = userType;
	}

	// Getters and setters for adminFirstView
	public AdminFirstView getAdminFirstView() {
		return adminFirstView;
	}

	public void setAdminFirstView(AdminFirstView adminFirstView) {
		this.adminFirstView = adminFirstView;
	}

	// Main method for running the login page
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frmLoginpage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor for the LoginPage class
	public LoginPage() {
		initialize();
	}

	// Method to initialize the components of the login page
	private void initialize() {
		frmLoginpage = new JFrame();
		frmLoginpage.setTitle("LOGIN_PAGE");
		frmLoginpage.getContentPane().setBackground(new Color(0, 0, 0));
		frmLoginpage.setBackground(new Color(0, 0, 0));
		frmLoginpage.setBounds(100, 100, 645, 499);
		frmLoginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginpage.getContentPane().setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(422, -50, 424, 378);
		Image img3 = new ImageIcon(this.getClass().getResource("/profile (1).png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img3));
		frmLoginpage.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(124, 46, 436, 378);
		Image img4 = new ImageIcon(this.getClass().getResource("/profile (2).png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img4));
		frmLoginpage.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(120, 121, 70, 378);
		Image img5 = new ImageIcon(this.getClass().getResource("/lock.png")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img5));
		frmLoginpage.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(515, 184, 125, 221);
		Image img6 = new ImageIcon(this.getClass().getResource("/eye.png")).getImage();
		lblNewLabel_7.setIcon(new ImageIcon(img6));
		frmLoginpage.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(515, 203, 61, 259);
		Image img7 = new ImageIcon(this.getClass().getResource("/invisible.png")).getImage();
		lblNewLabel_8.setIcon(new ImageIcon(img7));
		frmLoginpage.getContentPane().add(lblNewLabel_8);

		// Welcome label
		JLabel welcome = new JLabel("      WELCOME TO HRS HOTEL MANAGEMENT SYSTEM ");
		welcome.setBackground(new Color(0, 0, 0));
		welcome.setForeground(new Color(0, 255, 255));
		welcome.setFont(new Font("Tahoma", Font.BOLD, 21));
		welcome.setBounds(10, 20, 608, 58);
		frmLoginpage.getContentPane().add(welcome);

		// Login label
		JLabel loginToAccount = new JLabel("       Login To Your Account");
		loginToAccount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		loginToAccount.setForeground(new Color(0, 255, 255));
		loginToAccount.setBounds(99, 119, 352, 35);
		frmLoginpage.getContentPane().add(loginToAccount);

		// Username label and text field
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Tahoma", Font.BOLD, 18));
		username.setForeground(new Color(0, 255, 255));
		username.setBounds(159, 197, 95, 25);
		frmLoginpage.getContentPane().add(username);
		userNameText = new JTextField();
		userNameText.setBounds(159, 219, 321, 35);
		frmLoginpage.getContentPane().add(userNameText);
		userNameText.setColumns(10);

		// Password label and password field
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Tahoma", Font.BOLD, 18));
		password.setForeground(new Color(0, 255, 255));
		password.setBounds(161, 269, 114, 25);
		frmLoginpage.getContentPane().add(password);
		passText = new JPasswordField();
		passText.setBounds(159, 294, 321, 35);
		frmLoginpage.getContentPane().add(passText);

		// Show password button
		showPasswordBtn = new JButton("");
		showPasswordBtn.setBackground(new Color(0, 255, 255));
		showPasswordBtn.setBounds(506, 282, 43, 25);
		showPasswordBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passText.setEchoChar((char) 0); // Show the password
				showPasswordBtn.setEnabled(false);
				hidePasswordBtn.setEnabled(true);
			}
		});
		frmLoginpage.getContentPane().add(showPasswordBtn);

		// Hide password button
		hidePasswordBtn = new JButton("");
		hidePasswordBtn.setBackground(new Color(0, 255, 255));
		hidePasswordBtn.setBounds(506, 317, 43, 25);
		hidePasswordBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passText.setEchoChar('\u25CF'); // Hide the password using the default echo char (bullet character)
				showPasswordBtn.setEnabled(true);
				hidePasswordBtn.setEnabled(false);
			}
		});
		frmLoginpage.getContentPane().add(hidePasswordBtn);

		// Checkbox for "I'm not a robot"
		JCheckBox chckbxNewCheckBox = new JCheckBox("I'm not a robot");
		chckbxNewCheckBox.setBackground(new Color(0, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 10));
		chckbxNewCheckBox.setBounds(159, 354, 116, 25);
		frmLoginpage.getContentPane().add(chckbxNewCheckBox);

		// Forgot password button
		JButton forgotPassBtn = new JButton("Forgot your password?");
		forgotPassBtn.setBackground(new Color(0, 255, 255));
		forgotPassBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordRecover page = new PasswordRecover();
				page.showWindow();
			}
		});
		forgotPassBtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		forgotPassBtn.setBounds(299, 354, 181, 25);
		frmLoginpage.getContentPane().add(forgotPassBtn);

		// Login button
		JButton login = new JButton("LOGIN");
		login.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unused", "deprecation" })
			public void actionPerformed(ActionEvent e) {
				try {
					// Check if the block period is still active
					if (blockStartTime != 0 && System.currentTimeMillis() < blockStartTime + BLOCK_PERIOD) {
						// Block period is still active, show a message to the user
						long remainingTime = (blockStartTime + BLOCK_PERIOD - System.currentTimeMillis()) / 1000;
						JOptionPane.showMessageDialog(null, "Login is blocked for " + remainingTime + " seconds.",
								"Login Error", JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Increment the failed attempts counter if there's a failed login
					failedAttempts++;

					// Check if the max attempts have been reached
					if (failedAttempts >= MAX_ATTEMPTS) {
						blockStartTime = System.currentTimeMillis();
						failedAttempts = 0; // Reset the counter for the next block period
						JOptionPane.showMessageDialog(null,
								"Too many failed login attempts. Login blocked, try again later.", "Login Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Rest of the login logic
					String username = userNameText.getText();
					String password = passText.getText();
					boolean isAdmin = false;
					boolean validUsername = false;
					boolean validPassword = false;

					// Check if the entered credentials match any of the employees
					for (Employee e1 : Hotel.getInstance().getRemovedEmployees()) {
						if (e1.getSystemUsername().equals(username) && e1.getSystemPassword().equals(password)) {
							throw new AccountNoLongerAvilableException();
						}
					}
					for (Employee employee : Hotel.getInstance().getAllEmployees().values()) {
						if (employee.getSystemUsername().equals(username)
								&& employee.getSystemPassword().equals(password) && chckbxNewCheckBox.isSelected()) {
							isAdmin = false;
							validUsername = true;
							validPassword = true;
							LoginPage.setUserType("employee");
							frmLoginpage.setVisible(false);
							EmployeeFirstView.setEmployeeUsername(employee.getSystemUsername());
							EmployeeFirstView.setEmployeeName(employee.getFirstName() + " " + employee.getLastName());
							EmployeeFirstView.setEmployeePhoto(employee.getProfileImage());
							EmployeeFirstView page1 = new EmployeeFirstView();
							page1.showWindow();
							if (employee.getLoginsCounter() == 0) {
								JOptionPane.showMessageDialog(null,
										"Welcome to HRS managment system\nWe're so glad you joined us!", "NEW LOGIN",
										JOptionPane.INFORMATION_MESSAGE);
								employee.setLoginsCounter(employee.getLoginsCounter() + 1);
							}
							break; // Exit the loop once we found a matching employee
						}
					}

					// Check if the entered credentials match the admin account
					if (username.equals("admin") && password.equals("admin") && chckbxNewCheckBox.isSelected()) {
						isAdmin = true;
						validUsername = true;
						validPassword = true;
						LoginPage.setUserType("admin");
						frmLoginpage.setVisible(false);
						AdminFirstView a1 = new AdminFirstView();
						a1.showWindow();
					}

					// Check if the "I'm not a robot" checkbox is selected
					if (!chckbxNewCheckBox.isSelected()) {
						throw new CheckBoxNotSelectedException();
					}

					// Check if the entered credentials are valid
					if (!validUsername || !validPassword) {
						throw new UsernamePasswordException();
					}

					// If login is successful, reset the failedAttempts counter
					failedAttempts = 0;
					blockStartTime = 0;
				} catch (UsernamePasswordException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Login Error", JOptionPane.ERROR_MESSAGE);
				} catch (CheckBoxNotSelectedException ex1) {
					JOptionPane.showMessageDialog(null, ex1.getMessage(), "Login Error", JOptionPane.ERROR_MESSAGE);
				} catch (AccountNoLongerAvilableException ex2) {
					JOptionPane.showMessageDialog(null, ex2.getMessage(), "Login Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		login.setBackground(new Color(0, 255, 255));
		login.setFont(new Font("Tahoma", Font.BOLD, 20));
		login.setForeground(new Color(0, 0, 0));
		login.setBounds(230, 402, 153, 35);
		frmLoginpage.getContentPane().add(login);

		// Background image setup
		String imageUrl = "/flowing-water-background-3or1h2fe6iuieki4.gif";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 648, 489);
		frmLoginpage.getContentPane().add(backgroundLabel);
	}

	// Method to show the login window
	public void showWindow() {
		frmLoginpage.setVisible(true);
	}
}
