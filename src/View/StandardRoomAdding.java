package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Exception.EmptyFieldsException;
import Exception.NegativeNumberException;
import model.Hotel;
import model.StandardRoom;

public class StandardRoomAdding extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame roomAdding;
	private String newRoomType;
	private JTextField dailyPriceText;
	private JTextField floorText;
	private JTextField dailyCostText;
	private JTextField roomGradeText;
	private JTextField roomSizeText;

	public String getNewRoomType() {
		return newRoomType;
	}

	public void setNewRoomType(String newRoomType) {
		this.newRoomType = newRoomType;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StandardRoomAdding window = new StandardRoomAdding("Standard Room");
					window.roomAdding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StandardRoomAdding(String newRoomType) {
		this.newRoomType = newRoomType;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		roomAdding = new JFrame();
		roomAdding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		roomAdding.setBounds(100, 100, 645, 500);
		roomAdding.setTitle("Room_Details");

		roomAdding.getContentPane().setLayout(null);

		JLabel msg1 = new JLabel("         Please fill in the new standard room details");
		msg1.setFont(new Font("Tahoma", Font.BOLD, 20));
		msg1.setForeground(new Color(0, 0, 0));
		msg1.setBounds(53, 42, 512, 34);
		roomAdding.getContentPane().add(msg1);

		JLabel msg2 = new JLabel("daily price :");
		msg2.setFont(new Font("Tahoma", Font.BOLD, 15));
		msg2.setForeground(new Color(0, 0, 0));
		msg2.setBounds(53, 112, 114, 24);
		roomAdding.getContentPane().add(msg2);

		dailyPriceText = new JTextField();
		dailyPriceText.setBounds(53, 137, 114, 31);
		roomAdding.getContentPane().add(dailyPriceText);
		dailyPriceText.setColumns(10);

		floorText = new JTextField();
		floorText.setBounds(239, 137, 114, 31);
		roomAdding.getContentPane().add(floorText);
		floorText.setColumns(10);

		JLabel msg3 = new JLabel("floor :");
		msg3.setFont(new Font("Tahoma", Font.BOLD, 15));
		msg3.setForeground(new Color(0, 0, 0));
		msg3.setBounds(239, 113, 78, 22);
		roomAdding.getContentPane().add(msg3);

		JLabel msg4 = new JLabel("avg daily cost :");
		msg4.setFont(new Font("Tahoma", Font.BOLD, 13));
		msg4.setForeground(new Color(0, 0, 0));
		msg4.setBounds(451, 114, 102, 20);
		roomAdding.getContentPane().add(msg4);

		dailyCostText = new JTextField();
		dailyCostText.setBounds(451, 137, 114, 31);
		roomAdding.getContentPane().add(dailyCostText);
		dailyCostText.setColumns(10);

		JLabel msg5 = new JLabel("room grade :");
		msg5.setForeground(new Color(0, 0, 0));
		msg5.setFont(new Font("Tahoma", Font.BOLD, 15));
		msg5.setBounds(53, 227, 102, 24);
		roomAdding.getContentPane().add(msg5);

		roomGradeText = new JTextField();
		roomGradeText.setBounds(53, 250, 114, 31);
		roomAdding.getContentPane().add(roomGradeText);
		roomGradeText.setColumns(10);

		JLabel msg6 = new JLabel("population capacity :");
		msg6.setFont(new Font("Tahoma", Font.BOLD, 15));
		msg6.setForeground(new Color(0, 0, 0));
		msg6.setBounds(237, 227, 173, 24);
		roomAdding.getContentPane().add(msg6);

		Integer[] pcOptions = { 1, 2 };
		JComboBox pcBox = new JComboBox(pcOptions);
		pcBox.setBounds(239, 255, 114, 26);
		roomAdding.getContentPane().add(pcBox);

		JLabel msg8 = new JLabel("room size :");
		msg8.setAlignmentX(0.5f);
		msg8.setFont(new Font("Tahoma", Font.BOLD, 13));
		msg8.setForeground(new Color(0, 0, 0));
		msg8.setBounds(445, 227, 78, 24);
		roomAdding.getContentPane().add(msg8);

		roomSizeText = new JTextField();
		roomSizeText.setBounds(445, 250, 114, 31);
		roomAdding.getContentPane().add(roomSizeText);
		roomSizeText.setColumns(10);

		String[] roomView = { "YES", "NO" };
		JComboBox roomViewBox = new JComboBox(roomView);
		roomViewBox.setBounds(53, 332, 114, 31);
		roomAdding.getContentPane().add(roomViewBox);

		JLabel msg7 = new JLabel("room view :");
		msg7.setFont(new Font("Tahoma", Font.BOLD, 15));
		msg7.setForeground(new Color(0, 0, 0));
		msg7.setBounds(53, 313, 91, 20);
		roomAdding.getContentPane().add(msg7);

		// Standard room adding
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int popCapacity = (int) pcBox.getSelectedItem();
					boolean hasView;
					if (roomViewBox.getSelectedItem().equals("YES")) {
						hasView = true;
					} else {
						hasView = false;
					}
					// Check if there is empty fields in the room details
					if (dailyPriceText.getText().isEmpty() || floorText.getText().isEmpty()
							|| dailyCostText.getText().isEmpty() || roomGradeText.getText().isEmpty()
							|| roomSizeText.getText().isEmpty()) {
						throw new EmptyFieldsException();
					}
					if (Double.parseDouble(dailyPriceText.getText()) < 0.0
							|| Double.parseDouble(dailyCostText.getText()) < 0
							|| Integer.parseInt(floorText.getText()) < 0
							|| Double.parseDouble(roomGradeText.getText()) < 0
							|| Integer.parseInt(roomSizeText.getText()) < 0) {
						throw new NegativeNumberException();

					}
					// Making a standardRoom with the given details .
					StandardRoom standardRoom = new StandardRoom(Double.parseDouble(dailyPriceText.getText()),
							Integer.parseInt(floorText.getText()), Double.parseDouble(dailyCostText.getText()),
							Double.parseDouble(roomGradeText.getText()), popCapacity,
							Integer.parseInt(roomSizeText.getText()), hasView);
					Hotel.getInstance().addStandardRoom(standardRoom);
					Main.save();
					JOptionPane.showMessageDialog(null, "standard room added successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					if (LoginPage.getUserType().equals("admin")) {
						roomAdding.setVisible(false);
						AdminFirstView page = new AdminFirstView();
						page.showWindow();
					} else {
						roomAdding.setVisible(false);
						EmployeeFirstView page = new EmployeeFirstView();
						page.showWindow();
					}
					// First exception for empty fields
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter numeric values for appropriate fields",
							"Input Error", JOptionPane.ERROR_MESSAGE);
				} catch (EmptyFieldsException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Adding error", JOptionPane.ERROR_MESSAGE);
				} catch (NegativeNumberException ex1) {
					JOptionPane.showMessageDialog(null, ex1.getMessage(), "Adding error", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submit.setFont(new Font("Tahoma", Font.BOLD, 13));
		submit.setBackground(new Color(128, 128, 0));
		submit.setBounds(303, 392, 107, 34);
		roomAdding.getContentPane().add(submit);

		JButton cancel = new JButton("CANCEL");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomAdding.setVisible(false);
				AddRoomType page = new AddRoomType();
				page.showWindow();

			}
		});
		cancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		cancel.setBackground(new Color(128, 128, 0));
		cancel.setBounds(446, 392, 107, 34);
		roomAdding.getContentPane().add(cancel);

		String imageUrl = "/hotel-del-coronado-views-suite-K1TOS1-K1TOJ1-1600x1000-1.jpg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 645, 500);
		roomAdding.getContentPane().add(backgroundLabel);
	}

	public void showWindow() {
		roomAdding.setVisible(true);
	}
}
