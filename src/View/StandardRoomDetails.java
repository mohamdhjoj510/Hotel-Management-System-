package View;

import javax.swing.JFrame;
import model.StandardRoom;
import javax.swing.*;
import java.awt.*;

public class StandardRoomDetails extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StandardRoom standardRoom;

	public StandardRoomDetails(StandardRoom standardRoom) {
		this.standardRoom = standardRoom;

		setTitle("Standard Room Details");
		setSize(552, 214); // Increased the frame size
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null); // Center the frame on the screen

		initComponents();
	}

	private void initComponents() {
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		String[] columnNames = { "Property", "Value" };
		Object[][] data = { { "Room Number:", standardRoom.getRoomNumber() },
				{ "Daily Price:", String.valueOf(standardRoom.getDailyPrice()) },
				{ "Floor:", String.valueOf(standardRoom.getFloor()) },
				{ "Average Daily Cost:", String.valueOf(standardRoom.getAvgDailyCost()) },
				{ "Room Grade:", String.valueOf(standardRoom.getRoomGrade()) },
				{ "Max Population Capacity:", String.valueOf(standardRoom.getMaxPopulationCapacity()) },
				{ "Size:", String.valueOf(standardRoom.getSize()) },
				{ "Has View:", String.valueOf(standardRoom.isHasView()) }, };

		JTable table = new JTable(data, columnNames);
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setEnabled(false); // Make the table read-only
		JScrollPane scrollPane = new JScrollPane(table);

		// Set preferred size for the scroll pane
		scrollPane.setPreferredSize(new Dimension(480, 320)); // Increased the size of the table

		contentPanel.add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(contentPanel);
	}

	public void showWindow() {
		setVisible(true);

	}
}
