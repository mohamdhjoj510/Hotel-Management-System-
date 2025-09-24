package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Hotel;
import model.Room;
import model.StandardRoom;
import model.Suite;
import model.SuperiorRoom;

import java.awt.*;

public class ShowAllRooms extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable roomTable;
	private DefaultTableModel tableModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAllRooms window = new ShowAllRooms();
					window.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ShowAllRooms() {
		setTitle("Rooms");
		initialize();
	}

	private void initialize() {
		// Column names for the JTable
		String[] columnNames = { "Room Number", "Room Type", "Daily Price", "Floor", "Avg Daily Cost", "Room Grade",
				"Max Population", "Size", "Has View", "Has Jacuzzi", "Balcony Size" };

		// Create the DefaultTableModel with no data initially
		tableModel = new DefaultTableModel(columnNames, 0);

		// Add data to the table model from the list of rooms in the hotel
		for (Room room : Hotel.getInstance().getAllRooms().values()) {
			Object[] rowData = { room.getRoomNumber(),
					room instanceof Suite ? "Suite" : room instanceof SuperiorRoom ? "SuperiorRoom" : "StandardRoom",
					room.getDailyPrice(), room.getFloor(), room.getAvgDailyCost(), room.getRoomGrade(),
					room.getMaxPopulationCapacity(), room.getSize(),
					room instanceof StandardRoom ? ((StandardRoom) room).isHasView() : "-",
					room instanceof SuperiorRoom ? ((SuperiorRoom) room).isHasJaccozi() : "-",
					room instanceof Suite ? ((Suite) room).getBalconySize() : "-" };
			tableModel.addRow(rowData);
		}

		// Create the JTable using the table model
		roomTable = new JTable(tableModel);

		// Set font size for the table cells
		roomTable.setFont(new Font("Arial", Font.PLAIN, 12));

		// Adjust row height for a more compact appearance
		roomTable.setRowHeight(20);

		// Add the JTable to a JScrollPane to enable scrolling
		JScrollPane scrollPane = new JScrollPane(roomTable);

		// Create the cancel button
		JButton backBtn = new JButton("Back To Menu");
		backBtn.addActionListener(e -> {
			setVisible(false);
			SystemDetails page = new SystemDetails();
			page.showWindow();
		});

		// Create a panel to hold the table and the buttons
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(backBtn, BorderLayout.SOUTH);

		// Add the panel to the JFrame
		setContentPane(panel);

		// Set the size of the JFrame (adjust the values according to your preference)
		setSize(1500, 600);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void showWindow() {
		// Make the frame visible
		setVisible(true);
	}
}
