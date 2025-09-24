package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import Exception.NoCustomersFound;
import model.Customer;
import model.Hotel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class CustomerRemoving extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmCustomerremove;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRemoving window = new CustomerRemoving();
					window.frmCustomerremove.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerRemoving() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmCustomerremove = new JFrame();
		frmCustomerremove.setTitle("Customer_Remove");
		frmCustomerremove.setBounds(100, 100, 645, 500);
		frmCustomerremove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomerremove.getContentPane().setLayout(null);

		JLabel msg1 = new JLabel("    Please add the id for the customer you would like to remove");
		msg1.setForeground(new Color(0, 255, 255));
		msg1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		msg1.setBounds(10, 70, 591, 41);
		frmCustomerremove.getContentPane().add(msg1);

		JLabel msg2 = new JLabel("customer id :");
		msg2.setForeground(new Color(0, 255, 255));
		msg2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		msg2.setBounds(151, 176, 108, 24);
		frmCustomerremove.getContentPane().add(msg2);

		// Create a list to store customer IDs
		ArrayList<String> customers = new ArrayList<String>();
		// Populate the list with all customer IDs from the Hotel's customer collection
		for (Customer c : Hotel.getInstance().getAllCustomers().values()) {
			customers.add(c.getId());
		}

		// Create a JComboBox to select a customer ID
		JComboBox customersBox = new JComboBox();
		customersBox.setBounds(151, 197, 274, 35);
		frmCustomerremove.getContentPane().add(customersBox);
		// Add all customer IDs to the combo box
		for (String customerID : customers) {
			customersBox.addItem(customerID);
		}

		JButton customerRemoveBtn = new JButton("SUBMIT");
		customerRemoveBtn.setBackground(new Color(0, 255, 255));
		customerRemoveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Check if there are no customers in the list
					if (customers.size() == 0) {
						throw new NoCustomersFound();
					}
					// Check if the selected customer ID corresponds to a real customer and remove
					// it
					if (Hotel.getInstance().getRealCustomer((String) customersBox.getSelectedItem()) != null) {
						Hotel.getInstance().removeCustomer(
								Hotel.getInstance().getRealCustomer((String) customersBox.getSelectedItem()));
					}
					// Check if the selected customer ID corresponds to a real VIP customer and
					// remove it
					if (Hotel.getInstance().getRealVIPCustomer((String) customersBox.getSelectedItem()) != null) {
						Hotel.getInstance().removeVIPCustomer(
								Hotel.getInstance().getRealVIPCustomer((String) customersBox.getSelectedItem()));
					}
					Main.save();
					JOptionPane.showMessageDialog(null, "Customer removed successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					if (LoginPage.getUserType().equals("admin")) {
						frmCustomerremove.setVisible(false);
						AdminRemovePage p2 = new AdminRemovePage();
						p2.showWindow();
					} else {
						frmCustomerremove.setVisible(false);
						EmployeeRemovePage p2 = new EmployeeRemovePage();
						p2.showWindow();
					}

				} catch (NoCustomersFound ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		customerRemoveBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customerRemoveBtn.setBounds(247, 299, 108, 35);
		frmCustomerremove.getContentPane().add(customerRemoveBtn);

		JButton cancel = new JButton("CANCEL");
		cancel.setBackground(new Color(0, 255, 255));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginPage.getUserType().equals("admin")) {
					frmCustomerremove.setVisible(false);
					AdminRemovePage p2 = new AdminRemovePage();
					p2.showWindow();
				} else {
					frmCustomerremove.setVisible(false);
					EmployeeRemovePage p2 = new EmployeeRemovePage();
					p2.showWindow();
				}
			}
		});
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cancel.setBounds(247, 360, 108, 35);
		frmCustomerremove.getContentPane().add(cancel);

		// Set a background image for the frame
		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(-39, -28, 711, 505);
		frmCustomerremove.getContentPane().add(backgroundLabel);
	}

	// Method to display the CustomerRemoving frame
	public void showWindow() {
		frmCustomerremove.setVisible(true);
	}

}
