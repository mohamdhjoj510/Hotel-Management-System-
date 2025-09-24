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
import Exception.NoBookingsFound;
import model.Booking;
import model.Hotel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class BookingRemoving extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmBookingremove;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingRemoving window = new BookingRemoving();
					window.frmBookingremove.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookingRemoving() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmBookingremove = new JFrame();
		frmBookingremove.setTitle("Booking_Remove");
		frmBookingremove.setBounds(100, 100, 645, 500);
		frmBookingremove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBookingremove.getContentPane().setLayout(null);

		// Label to instruct the user to add the booking number to be removed.
		JLabel msg1 = new JLabel("        Please add the booking number you would like to remove");
		msg1.setForeground(new Color(0, 255, 255));
		msg1.setBackground(new Color(0, 255, 255));
		msg1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		msg1.setBounds(10, 68, 611, 35);
		frmBookingremove.getContentPane().add(msg1);

		// Label and ComboBox for selecting the booking number to be removed.
		JLabel msg2 = new JLabel("booking number :");
		msg2.setForeground(new Color(0, 255, 255));
		msg2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		msg2.setBounds(159, 165, 166, 24);
		frmBookingremove.getContentPane().add(msg2);

		// Retrieve all booking numbers and add them to the ComboBox.
		ArrayList<String> bookingsNumbers = new ArrayList<String>();
		for (Booking b : Hotel.getInstance().getAllBookings().values()) {
			bookingsNumbers.add(b.getBookingNumber());
		}
		JComboBox bookingsBox = new JComboBox();
		bookingsBox.setBounds(159, 188, 265, 35);
		frmBookingremove.getContentPane().add(bookingsBox);
		for (String bookingNumber : bookingsNumbers) {
			bookingsBox.addItem(bookingNumber);
		}

		// Button to submit the removal of the selected booking.
		JButton bookingRemoveBtn = new JButton("SUBMIT");
		bookingRemoveBtn.setBackground(new Color(0, 255, 255));
		bookingRemoveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Check if no bookings found
					if (bookingsBox.getSelectedItem() == null) {
						throw new NoBookingsFound();
					}

					// Remove the booking from the hotel's list of bookings.
					Hotel.getInstance()
							.removeBooking(Hotel.getInstance().getRealBooking((String) bookingsBox.getSelectedItem()));
					Main.save();
					JOptionPane.showMessageDialog(null, "Booking removed successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);

					// Navigate to the respective views based on user type after successful removal.
					if (LoginPage.getUserType().equals("admin")) {
						frmBookingremove.setVisible(false);
						AdminRemovePage p2 = new AdminRemovePage();
						p2.showWindow();
					} else {
						frmBookingremove.setVisible(false);
						EmployeeRemovePage p2 = new EmployeeRemovePage();
						p2.showWindow();
					}

				} catch (NoBookingsFound ex) {
					// Display an error message if no booking number is selected before removal.
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bookingRemoveBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bookingRemoveBtn.setBounds(228, 285, 115, 35);
		frmBookingremove.getContentPane().add(bookingRemoveBtn);

		// Button to cancel and return to the previous page (AdminRemovePage or
		// EmployeeRemovePage).
		JButton cancel = new JButton("CANCEL");
		cancel.setBackground(new Color(0, 255, 255));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginPage.getUserType().equals("admin")) {
					frmBookingremove.setVisible(false);
					AdminRemovePage p2 = new AdminRemovePage();
					p2.showWindow();
				} else {
					frmBookingremove.setVisible(false);
					EmployeeRemovePage p2 = new EmployeeRemovePage();
					p2.showWindow();
				}
			}
		});
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cancel.setBounds(228, 355, 115, 35);
		frmBookingremove.getContentPane().add(cancel);

		// Set background image using JLabel.
		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(-39, -28, 711, 505);
		frmBookingremove.getContentPane().add(backgroundLabel);
	}

	/**
	 * Method to display the BookingRemoving frame.
	 */
	public void showWindow() {
		frmBookingremove.setVisible(true);
	}
}
