package View;

import javax.swing.JFrame;
import model.Suite;
import javax.swing.*;
import java.awt.*;

public class SuiteDetails extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Suite suite;

	public SuiteDetails(Suite suite) {
		this.suite = suite;

		setTitle("Suite Details");
		setSize(500, 243); // Adjust the frame size as needed
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null); // Center the frame on the screen

		initComponents();
	}

	private void initComponents() {
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		String[] columnNames = { "Property", "Value" };
		Object[][] data = { { "Room Number:", suite.getRoomNumber() },
				{ "Daily Price:", String.valueOf(suite.getDailyPrice()) },
				{ "Floor:", String.valueOf(suite.getFloor()) },
				{ "Average Daily Cost:", String.valueOf(suite.getAvgDailyCost()) },
				{ "Room Grade:", String.valueOf(suite.getRoomGrade()) },
				{ "Max Population Capacity:", String.valueOf(suite.getMaxPopulationCapacity()) },
				{ "Size:", String.valueOf(suite.getSize()) }, { "Has View:", String.valueOf(suite.isHasView()) },
				{ "Has Jaccozi:", String.valueOf(suite.isHasJaccozi()) },
				{ "Balcony Size:", String.valueOf(suite.getBalconySize()) },
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
