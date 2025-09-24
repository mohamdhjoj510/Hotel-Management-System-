package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

//This class is used to show text information of how to use the system .
public class SystemGuide extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmGuide;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemGuide window = new SystemGuide();
					window.frmGuide.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SystemGuide() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuide = new JFrame();
		frmGuide.setTitle("GUIDE");
		frmGuide.setBounds(100, 100, 750, 543);
		frmGuide.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuide.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("               WELCOME TO HRS HOTEL MANAGMENT SYSTEM GUIDE ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 716, 43);
		frmGuide.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(
				"In the main page you will have four options to choose , by clicking on each one you will have the ability to make changes in the system");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 63, 726, 51);
		frmGuide.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Please make sure you are choosing the right option !");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 97, 403, 29);
		frmGuide.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(
				" by clicking on this button you will have the ability to add different types of objects to the system .");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(145, 136, 591, 35);
		frmGuide.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("ADD TO THE HOTEL .");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setBounds(10, 134, 146, 37);
		frmGuide.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel(
				"Note that your account may be limited in this option based in your account type!");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 156, 534, 29);
		frmGuide.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("REMOVE FROM THE HOTEL.");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setBounds(10, 181, 167, 29);
		frmGuide.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel(
				"by clicking on this button you will have the ability to remove different types of objects from the system . ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(177, 185, 549, 21);
		frmGuide.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel(
				"Note that your account may be limited in this option based in your account type!");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(10, 205, 509, 21);
		frmGuide.getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("SYSTEM DETAILS. ");
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(10, 236, 167, 21);
		frmGuide.getContentPane().add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel(
				"by choosing this option you can see the system data (Rooms,Customers,Employees,Departments,Bookings) .");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(125, 236, 611, 21);
		frmGuide.getContentPane().add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Please don't share this data with others!");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(10, 251, 484, 21);
		frmGuide.getContentPane().add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("SYSTEM FUNCTIONS.");
		lblNewLabel_12.setForeground(new Color(255, 0, 0));
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12.setBounds(10, 282, 146, 21);
		frmGuide.getContentPane().add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel(
				"by choosing this option you can access special functions in the system .  ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(144, 287, 396, 13);
		frmGuide.getContentPane().add(lblNewLabel_13);

		JButton btnNewButton = new JButton("functions explanation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGuide.setVisible(false);
				FunctionsExplanation page = new FunctionsExplanation();
				page.showWindow();
			}
		});
		btnNewButton.setBounds(10, 301, 167, 29);
		frmGuide.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_14 = new JLabel("       if you need any help please contact us ,");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_14.setBounds(144, 373, 416, 29);
		frmGuide.getContentPane().add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("mohamdhjoj.5@gmail.com");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(241, 412, 219, 21);
		frmGuide.getContentPane().add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("+972-549425653");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(241, 429, 167, 29);
		frmGuide.getContentPane().add(lblNewLabel_16);

		JButton btnNewButton_1 = new JButton("BACK ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginPage.getUserType().equals("admin")) {
					frmGuide.setVisible(false);
					AdminFirstView page = new AdminFirstView();
					page.showWindow();
				} else {
					frmGuide.setVisible(false);
					EmployeeFirstView p5 = new EmployeeFirstView();
					p5.showWindow();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(10, 467, 119, 29);
		frmGuide.getContentPane().add(btnNewButton_1);
	}

	public void showWindow() {
		frmGuide.setVisible(true);

	}
}
