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
import Exception.NoRoomsFound;
import model.Hotel;
import model.Room;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class RoomRemoving extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmRoomremove;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomRemoving window = new RoomRemoving();
					window.frmRoomremove.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RoomRemoving() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmRoomremove = new JFrame();
		frmRoomremove.setTitle("Room_Remove");
		frmRoomremove.setBounds(100, 100, 644, 499);
		frmRoomremove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRoomremove.getContentPane().setLayout(null);

		JLabel msg1 = new JLabel("       Please add the room number you would like to remove");
		msg1.setForeground(new Color(0, 255, 255));
		msg1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		msg1.setBounds(25, 81, 595, 44);
		frmRoomremove.getContentPane().add(msg1);

		JLabel msg2 = new JLabel("room number : ");
		msg2.setForeground(new Color(0, 255, 255));
		msg2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		msg2.setBounds(150, 188, 101, 24);
		frmRoomremove.getContentPane().add(msg2);

		ArrayList<String> rooms = new ArrayList<String>();
		for (Room r : Hotel.getInstance().getAllRooms().values()) {
			rooms.add(r.getRoomNumber());
		}
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(150, 210, 285, 36);
		frmRoomremove.getContentPane().add(comboBox);
		for (String roomNumber : rooms) {
			comboBox.addItem(roomNumber);
		}

		// Create a JButton with the label "SUBMIT"
		JButton removeRoomBtn = new JButton("SUBMIT");

		// Set the background color of the button to cyan (RGB: 0, 255, 255)
		removeRoomBtn.setBackground(new Color(0, 255, 255));

		// Add an ActionListener to the button
		removeRoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Check if the list of rooms is empty
					if (rooms.size() == 0) {
						throw new NoRoomsFound();
					}

					// Get the selected room number from a combo box
					String roomNumber = (String) comboBox.getSelectedItem();

					// Check if a real Standard Room with the given room number exists
					if (Hotel.getInstance().getRealStandardRoom(roomNumber) != null) {
						// Remove the Standard Room from the Hotel's instance
						Hotel.getInstance().removeStandardRoom(Hotel.getInstance().getRealStandardRoom(roomNumber));

						// Save changes to the data (assuming Main.save() handles this)
						Main.save();

						// Show a success message
						JOptionPane.showMessageDialog(null, "Room removed successfully", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					}

					// Check if a real Superior Room with the given room number exists
					if (Hotel.getInstance().getRealSuperiorRoom(roomNumber) != null) {
						// Remove the Superior Room from the Hotel's instance
						Hotel.getInstance().removeSuperiorRoom(Hotel.getInstance().getRealSuperiorRoom(roomNumber));

						// Save changes to the data (assuming Main.save() handles this)
						Main.save();

						// Show a success message
						JOptionPane.showMessageDialog(null, "Room removed successfully", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					}

					// Check if a real Suite with the given room number exists
					if (Hotel.getInstance().getRealSuite(roomNumber) != null) {
						// Remove the Suite from the Hotel's instance
						Hotel.getInstance().removeSuite(Hotel.getInstance().getRealSuite(roomNumber));

						// Save changes to the data (assuming Main.save() handles this)
						Main.save();

						// Show a success message
						JOptionPane.showMessageDialog(null, "Room removed successfully", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					}

					// Check the user type to determine the next steps
					if (LoginPage.getUserType().equals("admin")) {
						// If the user is an admin, switch to AdminRemovePage
						frmRoomremove.setVisible(false);
						AdminRemovePage p2 = new AdminRemovePage();
						p2.showWindow();
					} else {
						// If the user is an employee, switch to EmployeeRemovePage
						frmRoomremove.setVisible(false);
						EmployeeRemovePage p2 = new EmployeeRemovePage();
						p2.showWindow();
					}
				} catch (NoRoomsFound ex) {
					// Handle the case where no rooms were found
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					// Handle IO exception (printing the stack trace for debugging)
					e1.printStackTrace();
				}
			}
		});
		removeRoomBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		removeRoomBtn.setBounds(253, 307, 101, 36);
		frmRoomremove.getContentPane().add(removeRoomBtn);

		JButton cancel = new JButton("CANCEL");
		cancel.setBackground(new Color(0, 255, 255));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If the user is an admin, switch to AdminRemovePage
				if (LoginPage.getUserType().equals("admin")) {
					frmRoomremove.setVisible(false);
					AdminRemovePage p2 = new AdminRemovePage();
					p2.showWindow();
				} else {
					frmRoomremove.setVisible(false);
					EmployeeRemovePage p2 = new EmployeeRemovePage();
					p2.showWindow();
				}

			}
		});
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cancel.setBounds(253, 362, 101, 36);
		frmRoomremove.getContentPane().add(cancel);

		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 645, 463);
		frmRoomremove.getContentPane().add(backgroundLabel);

	}

	public void showWindow() {
		frmRoomremove.setVisible(true);

	}
}
