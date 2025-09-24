package View;

import javax.swing.JFrame;
import model.SuperiorRoom;
import javax.swing.*;
import java.awt.*;

public class SuperiorRoomDetails extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SuperiorRoom superiorRoom;

	public SuperiorRoomDetails(SuperiorRoom superiorRoom) {
		this.superiorRoom = superiorRoom;

		setTitle("Superior Room Details");
		setSize(500, 234); // Adjust the frame size as needed
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null); // Center the frame on the screen

		initComponents();
	}

	private void initComponents() {
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		String[] columnNames = { "Property", "Value" };
		Object[][] data = { { "Room Number:", superiorRoom.getRoomNumber() },
				{ "Daily Price:", String.valueOf(superiorRoom.getDailyPrice()) },
				{ "Floor:", String.valueOf(superiorRoom.getFloor()) },
				{ "Average Daily Cost:", String.valueOf(superiorRoom.getAvgDailyCost()) },
				{ "Room Grade:", String.valueOf(superiorRoom.getRoomGrade()) },
				{ "Max Population Capacity:", String.valueOf(superiorRoom.getMaxPopulationCapacity()) },
				{ "Size:", String.valueOf(superiorRoom.getSize()) },
				{ "Has View:", String.valueOf(superiorRoom.isHasView()) },
				{ "Has Jaccozi:", String.valueOf(superiorRoom.isHasJaccozi()) },
				// Add more properties as needed
		};

		JTable table = new JTable(data, columnNames);
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
		table.setEnabled(false); // Make the table read-only
		JScrollPane scrollPane = new JScrollPane(table);

		// Set preferred size for the scroll pane
		scrollPane.setPreferredSize(new Dimension(480, 320));

		contentPanel.add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(contentPanel);
	}

	public void showWindow() {
		setVisible(true);

	}
}
