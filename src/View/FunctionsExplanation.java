package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FunctionsExplanation extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmFunctionsguide;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FunctionsExplanation window = new FunctionsExplanation();
					window.frmFunctionsguide.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FunctionsExplanation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFunctionsguide = new JFrame();
		frmFunctionsguide.setTitle("Functions_Guide");
		frmFunctionsguide.setBounds(100, 100, 747, 540);
		frmFunctionsguide.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFunctionsguide.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"*KEmployees - This function takes an integer 'k' as input and returns a list of 'k' top employees (sorted)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 10, 713, 55);
		frmFunctionsguide.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(
				"*allCustomersByPK - This function returns a List of all customers sorted by their primary key in ascending order.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 72, 713, 30);
		frmFunctionsguide.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(
				"*allBookingsByRevenue - This function returns a TreeSet of bookings, sorted by their total revenue in descending order.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 112, 719, 30);
		frmFunctionsguide.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(
				" If two bookings have the same total revenue, it further sorts them by their booking numbers in ascending order.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 131, 740, 20);
		frmFunctionsguide.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(
				"*allCustomersCmp - This function returns a TreeSet of customers, sorted by the number of bookings they have in ascending order");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 173, 713, 30);
		frmFunctionsguide.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel(
				"If two customers have the same number of bookings, it further sorts them by their first names in descending lexicographic order.");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 195, 713, 20);
		frmFunctionsguide.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(
				"*totalProfit - This function calculates the total profit from all bookings by subtracting the total cost from the total revenue of each booking .");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 236, 713, 30);
		frmFunctionsguide.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel(
				"*allBookingsOfSpecCustomer - This function takes a customer ID as input, searches for the customer with the specified ID,");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(10, 291, 775, 20);
		frmFunctionsguide.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("and returns a list of all bookings associated with that customer");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(10, 310, 713, 13);
		frmFunctionsguide.getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel(
				"*customerBookedTheMostRooms - This function finds and returns the customer who has booked the most number of rooms ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(10, 355, 713, 20);
		frmFunctionsguide.getContentPane().add(lblNewLabel_9);

		JButton btnNewButton = new JButton("Return to Guide");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFunctionsguide.setVisible(false);
				SystemGuide page = new SystemGuide();
				page.showWindow();
			}
		});
		btnNewButton.setBounds(273, 418, 139, 30);
		frmFunctionsguide.getContentPane().add(btnNewButton);
	}

	public void showWindow() {
		frmFunctionsguide.setVisible(true);

	}
}
