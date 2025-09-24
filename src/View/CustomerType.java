package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class CustomerType extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame customersType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerType window = new CustomerType();
					window.customersType.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerType() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		customersType = new JFrame();
		customersType.setTitle("Customer_Type");
		customersType.setBounds(100, 100, 646, 500);
		customersType.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		customersType.getContentPane().setLayout(null);

		JLabel msg1 = new JLabel("       Please choose the customer type you would like to add");
		msg1.setBackground(new Color(0, 255, 255));
		msg1.setForeground(new Color(0, 255, 255));
		msg1.setFont(new Font("Tahoma", Font.BOLD, 17));
		msg1.setBounds(21, 132, 580, 59);
		customersType.getContentPane().add(msg1);

		// Create an array of customer types (Regular Customer and VIP Customer)
		String[] customersTypes = { "Regular Customer", "VIP Customer" };
		// Create a JComboBox to select a customer type
		JComboBox customersTypeBox = new JComboBox(customersTypes);
		customersTypeBox.setBounds(182, 215, 195, 34);
		customersType.getContentPane().add(customersTypeBox);

		JButton nextBtn = new JButton("NEXT");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Hide the current frame
				customersType.setVisible(false);
				// Get the selected customer type from the combo box
				String customerSelected = (String) customersTypeBox.getSelectedItem();
				// Depending on the selected customer type, show the appropriate adding page
				if (customerSelected.equals("Regular Customer")) {
					RegCustomerAdding page1 = new RegCustomerAdding();
					page1.showWindow();
				}
				if (customerSelected.equals("VIP Customer")) {
					VIPCustomerAdding page1 = new VIPCustomerAdding();
					page1.showWindow();
				}
			}
		});
		nextBtn.setBackground(new Color(0, 255, 255));
		nextBtn.setForeground(new Color(0, 0, 0));
		nextBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nextBtn.setBounds(220, 285, 124, 34);
		customersType.getContentPane().add(nextBtn);

		JButton backbtn = new JButton("BACK");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check the user type to decide which add page to go back to
				if (LoginPage.getUserType().equals("admin")) {
					customersType.setVisible(false);
					AdminAddPage p5 = new AdminAddPage();
					p5.showWindow();
				} else {
					customersType.setVisible(false);
					EmployeeAddPage p5 = new EmployeeAddPage();
					p5.showWindow();
				}
			}
		});
		backbtn.setBackground(new Color(0, 255, 255));
		backbtn.setBounds(10, 24, 111, 34);
		customersType.getContentPane().add(backbtn);

		// Set a background image for the frame
		String imageUrl = "/Your favorite iPhone wallpapers of 2022.png";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(-39, -28, 711, 505);
		customersType.getContentPane().add(backgroundLabel);
	}

	// Method to display the CustomerType frame
	public void showWindow() {
		customersType.setVisible(true);
	}
}
