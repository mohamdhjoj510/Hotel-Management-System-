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
import model.Suite;

public class SuiteRoomAdding extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame roomAdding;
	private String newRoomType;
	private JTextField balconySizeText;

	public JFrame getStandardRoom() {
		return roomAdding;
	}

	public void setStandardRoom(JFrame standardRoom) {
		this.roomAdding = standardRoom;
	}

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
					SuiteRoomAdding window = new SuiteRoomAdding("Suite");
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
	public SuiteRoomAdding(String newRoomType) {
		this.newRoomType = newRoomType;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		roomAdding = new JFrame();
		roomAdding.setTitle("Room_Details");
		roomAdding.setBounds(100, 100, 645, 500);
		roomAdding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		roomAdding.getContentPane().setLayout(null);

		JLabel msg1 = new JLabel("              Please fill in the new suite details");
		msg1.setFont(new Font("Tahoma", Font.BOLD, 20));
		msg1.setForeground(new Color(0, 0, 0));
		msg1.setBounds(53, 42, 512, 34);
		roomAdding.getContentPane().add(msg1);

		JLabel msg2 = new JLabel("daily price :");
		msg2.setFont(new Font("Tahoma", Font.BOLD, 15));
		msg2.setForeground(new Color(0, 0, 0));
		msg2.setBounds(53, 112, 114, 24);
		roomAdding.getContentPane().add(msg2);

		JTextField dailyPrice = new JTextField();
		dailyPrice.setBounds(53, 137, 114, 31);
		roomAdding.getContentPane().add(dailyPrice);
		dailyPrice.setColumns(10);

		JTextField floor = new JTextField();
		floor.setBounds(239, 137, 114, 31);
		roomAdding.getContentPane().add(floor);
		((JTextField) floor).setColumns(10);

		JLabel floorMsg = new JLabel("floor :");
		floorMsg.setFont(new Font("Tahoma", Font.BOLD, 15));
		floorMsg.setForeground(new Color(0, 0, 0));
		floorMsg.setBounds(239, 113, 78, 22);
		roomAdding.getContentPane().add(floorMsg);

		JLabel dailyCostMsg = new JLabel("avg daily cost :");
		dailyCostMsg.setFont(new Font("Tahoma", Font.BOLD, 13));
		dailyCostMsg.setForeground(new Color(0, 0, 0));
		dailyCostMsg.setBounds(451, 114, 102, 20);
		roomAdding.getContentPane().add(dailyCostMsg);

		JTextField dailyCost = new JTextField();
		dailyCost.setBounds(451, 137, 114, 31);
		roomAdding.getContentPane().add(dailyCost);
		((JTextField) dailyCost).setColumns(10);

		JLabel roomGradeMsg = new JLabel("room grade :");
		roomGradeMsg.setForeground(new Color(0, 0, 0));
		roomGradeMsg.setFont(new Font("Tahoma", Font.BOLD, 15));
		roomGradeMsg.setBounds(53, 227, 102, 24);
		roomAdding.getContentPane().add(roomGradeMsg);

		JTextField roomGrade = new JTextField();
		roomGrade.setBounds(53, 250, 114, 31);
		roomAdding.getContentPane().add(roomGrade);
		((JTextField) roomGrade).setColumns(10);

		JLabel pcMsg = new JLabel("population capacity :");
		pcMsg.setFont(new Font("Tahoma", Font.BOLD, 15));
		pcMsg.setForeground(new Color(0, 0, 0));
		pcMsg.setBounds(237, 227, 173, 24);
		roomAdding.getContentPane().add(pcMsg);

		JLabel roomSizeMsg = new JLabel("room size :");
		roomSizeMsg.setFont(new Font("Tahoma", Font.BOLD, 13));
		roomSizeMsg.setForeground(new Color(0, 0, 0));
		roomSizeMsg.setBounds(445, 227, 78, 24);
		roomAdding.getContentPane().add(roomSizeMsg);

		JTextField roomSize = new JTextField();
		roomSize.setBounds(445, 250, 120, 31);
		roomAdding.getContentPane().add(roomSize);
		roomSize.setColumns(10);

		String[] roomView = { "YES", "NO" };
		JComboBox viewBox = new JComboBox(roomView);
		viewBox.setBounds(53, 332, 114, 31);
		roomAdding.getContentPane().add(viewBox);

		JLabel supRoomView = new JLabel("room view :");
		supRoomView.setFont(new Font("Tahoma", Font.BOLD, 15));
		supRoomView.setForeground(new Color(0, 0, 0));
		supRoomView.setBounds(53, 313, 91, 20);
		roomAdding.getContentPane().add(supRoomView);

		JLabel jaccoziMsg = new JLabel("room jaccozi :");
		jaccoziMsg.setBackground(new Color(0, 0, 0));
		jaccoziMsg.setFont(new Font("Tahoma", Font.BOLD, 14));
		jaccoziMsg.setForeground(new Color(0, 0, 0));
		jaccoziMsg.setBounds(239, 313, 125, 17);
		roomAdding.getContentPane().add(jaccoziMsg);

		String[] roomJaccozi = { "YES", "NO" };
		JComboBox jaccoziBox = new JComboBox(roomJaccozi);
		jaccoziBox.setBounds(239, 332, 114, 31);
		roomAdding.getContentPane().add(jaccoziBox);

		JLabel balconySizeMsg = new JLabel("room balcony size :");
		balconySizeMsg.setFont(new Font("Tahoma", Font.BOLD, 12));
		balconySizeMsg.setBounds(440, 313, 125, 24);
		roomAdding.getContentPane().add(balconySizeMsg);

		balconySizeText = new JTextField();
		balconySizeText.setBounds(440, 332, 125, 31);
		roomAdding.getContentPane().add(balconySizeText);
		balconySizeText.setColumns(10);

		Integer[] pcOptions = { 1, 2, 3, 4, 5, 6, 7 };
		JComboBox pcBox = new JComboBox(pcOptions);
		pcBox.setBounds(239, 250, 114, 31);
		roomAdding.getContentPane().add(pcBox);

		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Get values from UI components
					int popcapicity = (int) pcBox.getSelectedItem();
					boolean hasView;
					if (viewBox.getSelectedItem().equals("YES")) {
						hasView = true;
					} else {
						hasView = false;
					}
					boolean hasJaccozi;
					if (jaccoziBox.getSelectedItem().equals("YES")) {
						hasJaccozi = true;
					} else {
						hasJaccozi = false;
					}

					// Check for empty fields
					if (dailyPrice.getText().isEmpty() || floor.getText().isEmpty() || dailyCost.getText().isEmpty()
							|| roomGrade.getText().isEmpty() || roomSize.getText().isEmpty()
							|| balconySizeText.getText().isEmpty()) {
						throw new EmptyFieldsException();
					}

					// Check for negative numbers
					if (Double.parseDouble(dailyPrice.getText()) < 0.0 || Double.parseDouble(dailyCost.getText()) < 0
							|| Integer.parseInt(floor.getText()) < 0 || Double.parseDouble(roomGrade.getText()) < 0
							|| Integer.parseInt(roomSize.getText()) < 0) {
						throw new NegativeNumberException();
					}

					// Create a Suite object with the provided data
					Suite suite = new Suite(Double.parseDouble(dailyPrice.getText()), Integer.parseInt(floor.getText()),
							Double.parseDouble(dailyCost.getText()), Double.parseDouble(roomGrade.getText()),
							popcapicity, Integer.parseInt(roomSize.getText()), hasView, hasJaccozi,
							Double.parseDouble(balconySizeText.getText()));

					// Add the Suite to the Hotel's instance
					Hotel.getInstance().addSuite(suite);

					// Save the changes
					Main.save();

					// Show success message
					JOptionPane.showMessageDialog(null, "suite added successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);

					// Navigate to appropriate views based on user type
					if (LoginPage.getUserType().equals("admin")) {
						roomAdding.setVisible(false);
						AdminFirstView page = new AdminFirstView();
						page.showWindow();
					} else {
						roomAdding.setVisible(false);
						EmployeeFirstView page = new EmployeeFirstView();
						page.showWindow();
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter numeric values for appropriate fields",
							"Input Error", JOptionPane.ERROR_MESSAGE);
				} catch (EmptyFieldsException ex) {
					// Handle empty fields exception
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Adding error", JOptionPane.ERROR_MESSAGE);
				} catch (NegativeNumberException ex1) {
					// Handle negative number exception
					JOptionPane.showMessageDialog(null, ex1.getMessage(), "Adding error", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					// Handle IO exception
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
