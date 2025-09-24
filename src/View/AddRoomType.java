package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class AddRoomType extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame roomType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoomType window = new AddRoomType();
					window.roomType.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddRoomType() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Create the main JFrame for room type selection.
		roomType = new JFrame();
		roomType.getContentPane().setBackground(new Color(255, 255, 255));
		roomType.setTitle("Room_Type");
		roomType.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		roomType.setBounds(100, 100, 645, 500);
		roomType.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		roomType.getContentPane().setLayout(null);

		// Label to instruct the user to choose the room type.
		JLabel chooseMsg = new JLabel("            Choose the type of room you would like to add");
		chooseMsg.setForeground(new Color(0, 0, 0));
		chooseMsg.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chooseMsg.setBounds(29, 123, 581, 45);
		roomType.getContentPane().add(chooseMsg);

		// Dropdown box to select the room type from the available options.
		String[] roomTypes = { "Standard Room", "Superior Room", "Suite" };
		JComboBox<String> roomTypeBox = new JComboBox<>(new DefaultComboBoxModel<>(roomTypes));
		roomTypeBox.setBackground(new Color(0, 255, 255));
		roomTypeBox.setBounds(184, 178, 229, 38);
		roomType.getContentPane().add(roomTypeBox);

		// Button to proceed to the next step (depending on the selected room type).
		JButton next = new JButton("NEXT");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Hide the current frame and show the relevant room adding view based on the
				// selection.
				roomType.setVisible(false);
				String roomSelected = (String) roomTypeBox.getSelectedItem();
				if (roomSelected.equals("Standard Room")) {
					StandardRoomAdding p6 = new StandardRoomAdding(roomSelected);
					p6.showWindow();
				} else if (roomSelected.equals("Superior Room")) {
					SuperiorRoomAdding p6 = new SuperiorRoomAdding(roomSelected);
					p6.showWindow();
				} else if (roomSelected.equals("Suite")) {
					SuiteRoomAdding p6 = new SuiteRoomAdding(roomSelected);
					p6.showWindow();
				}
			}
		});
		next.setForeground(new Color(0, 0, 0));
		next.setFont(new Font("Tahoma", Font.PLAIN, 14));
		next.setBackground(new Color(0, 255, 255));
		next.setBounds(243, 252, 121, 30);
		roomType.getContentPane().add(next);

		// Button to go back to the previous page (AdminAddPage or EmployeeAddPage).
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Show the respective previous page based on the user type.
				if (LoginPage.getUserType().equals("admin")) {
					roomType.setVisible(false);
					AdminAddPage p5 = new AdminAddPage();
					p5.showWindow();
				} else {
					roomType.setVisible(false);
					EmployeeAddPage p5 = new EmployeeAddPage();
					p5.showWindow();
				}
			}

		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 18));
		back.setBackground(new Color(0, 255, 255));
		back.setBounds(10, 31, 104, 30);
		roomType.getContentPane().add(back);

		// Set background image using JLabel.
		String imageUrl = "/hotel-del-coronado-views-suite-K1TOS1-K1TOJ1-1600x1000-1.jpg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 645, 500);
		roomType.getContentPane().add(backgroundLabel);
	}

	/**
	 * Method to show the room type selection frame.
	 */
	public void showWindow() {
		roomType.setVisible(true);
	}
}
