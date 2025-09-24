package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.Employee;
import model.Hotel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class PasswordRecover extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmPasswordrecover;
	private JTextField textField;
	private JTextField textField_1;

	// Main method to launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordRecover window = new PasswordRecover();
					window.frmPasswordrecover.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor to create a new PasswordRecover object.
	public PasswordRecover() {
		initialize();
	}

	// Initialize the contents of the frame and set up the GUI components.
	private void initialize() {
		frmPasswordrecover = new JFrame();
		frmPasswordrecover.setTitle("Password_Recover");
		frmPasswordrecover.setBounds(100, 100, 650, 499);
		frmPasswordrecover.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPasswordrecover.getContentPane().setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(276, -98, 424, 378);
		Image img3 = new ImageIcon(this.getClass().getResource("/password.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img3));
		frmPasswordrecover.getContentPane().add(lblNewLabel_4);

		// Label to prompt the user to enter their username.
		JLabel lblNewLabel = new JLabel("username :");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(189, 137, 264, 29);
		frmPasswordrecover.getContentPane().add(lblNewLabel);

		// Text field to input the username.
		textField = new JTextField();
		textField.setBounds(189, 165, 264, 29);
		frmPasswordrecover.getContentPane().add(textField);
		textField.setColumns(10);

		// Label to indicate password recovery.
		JLabel lblNewLabel_1 = new JLabel("                         Recover your password ");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(105, 29, 505, 35);
		frmPasswordrecover.getContentPane().add(lblNewLabel_1);

		// Label to prompt the user to enter their phone number.
		JLabel lblNewLabel_2 = new JLabel("phone number :");
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(189, 229, 264, 22);
		frmPasswordrecover.getContentPane().add(lblNewLabel_2);

		// Text field to input the phone number.
		textField_1 = new JTextField();
		textField_1.setBounds(189, 251, 264, 29);
		frmPasswordrecover.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		// Button to initiate the password recovery process.
		JButton btnNewButton = new JButton("recover password");
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean passwordFound = false;
				for (Employee e1 : Hotel.getInstance().getAllEmployees().values()) {
					// Check if the provided username and phone number match any employee's
					// credentials.
					if (e1.getSystemUsername().equals(textField.getText())
							&& e1.getPhoneNumber().equals(textField_1.getText())) {
						// Show the recovered password to the user.
						JOptionPane.showMessageDialog(frmPasswordrecover, "Your password is: " + e1.getSystemPassword(),
								"Password Recovery", JOptionPane.INFORMATION_MESSAGE);
						passwordFound = true;
						// Close the password recovery window and open the login page.
						frmPasswordrecover.setVisible(false);
						LoginPage page = new LoginPage();
						page.showWindow();
					}
				}
				// If no matching username and phone number found, show a warning message.
				if (!passwordFound) {
					JOptionPane.showMessageDialog(frmPasswordrecover,
							"Password not found for the given username and phone number", "Password Recovery",
							JOptionPane.WARNING_MESSAGE);
					frmPasswordrecover.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(241, 306, 158, 29);
		frmPasswordrecover.getContentPane().add(btnNewButton);

		// Button to go back to the login page.
		JButton btnNewButton_1 = new JButton("back to login");
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPasswordrecover.setVisible(false);
				LoginPage page = new LoginPage();
				page.showWindow();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(22, 394, 118, 35);
		frmPasswordrecover.getContentPane().add(btnNewButton_1);

		// Set background image.
		String imageUrl = "/Your favorite iPhone wallpapers of 2022.png";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 651, 480);
		frmPasswordrecover.getContentPane().add(backgroundLabel);
	}

	// Method to display the window and make it visible.
	public void showWindow() {
		frmPasswordrecover.setVisible(true);
	}
}
