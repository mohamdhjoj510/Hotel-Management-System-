package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Exception.InvalidNumberOfEmployees;
import Exception.NegativeNumberException;
import Exception.NoBookingsFound;
import Exception.NoCustomersFound;
import Exception.NoDepartmentsFound;
import Exception.NoEmployeesFound;
import Exception.NoRoomsFound;
import model.Booking;
import model.Customer;
import model.Department;
import model.DepartmentManager;
import model.Employee;
import model.Hotel;
import model.StandardRoom;
import model.Suite;
import model.SuperiorRoom;
import model.VIPCustomer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.awt.Color;

public class SystemFunctions extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frameSystemFunctions;
	private JTextField GetRealIdText;
	private static boolean allBookingsByRevenue;
	private static boolean Kemployees;
	private static boolean allCustomersByPK;
	private static boolean allCustomersCMP;
	private static boolean allBookingsOfCustomer;
	private static String allBookingsOfCustomerID;
	private static int k;

	public static String getAllBookingsOfCustomerID() {
		return allBookingsOfCustomerID;
	}

	public static void setAllBookingsOfCustomerID(String allBookingsOfCustomerID) {
		SystemFunctions.allBookingsOfCustomerID = allBookingsOfCustomerID;
	}

	public static int getK() {
		return k;
	}

	public static void setK(int k) {
		SystemFunctions.k = k;
	}

	public static boolean isAllBookingsOfCustomer() {
		return allBookingsOfCustomer;
	}

	public static void setAllBookingsOfCustomer(boolean allBookingsOfCustomer) {
		SystemFunctions.allBookingsOfCustomer = allBookingsOfCustomer;
	}

	public static boolean isAllCustomersCMP() {
		return allCustomersCMP;
	}

	public static void setAllCustomersCMP(boolean allCustomersCMP) {
		SystemFunctions.allCustomersCMP = allCustomersCMP;
	}

	public static boolean isAllCustomersByPK() {
		return allCustomersByPK;
	}

	public static void setAllCustomersByPK(boolean allCustomersByPK) {
		SystemFunctions.allCustomersByPK = allCustomersByPK;
	}

	public static boolean isKemployees() {
		return Kemployees;
	}

	public static void setKemployees(boolean kemployees) {
		Kemployees = kemployees;
	}

	public static boolean isAllBookingsByRevenue() {
		return allBookingsByRevenue;
	}

	public static void setAllBookingsByRevenue(boolean allBookingsByRevenue) {
		SystemFunctions.allBookingsByRevenue = allBookingsByRevenue;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemFunctions window = new SystemFunctions();
					window.frameSystemFunctions.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SystemFunctions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		SystemFunctions.setAllBookingsByRevenue(false);
		SystemFunctions.setAllCustomersByPK(false);
		SystemFunctions.setAllBookingsOfCustomer(false);
		SystemFunctions.setAllCustomersCMP(false);
		SystemFunctions.setKemployees(false);
		SystemFunctions.setAllBookingsOfCustomerID("");

		frameSystemFunctions = new JFrame();
		frameSystemFunctions.setTitle("System_Functions");
		frameSystemFunctions.setBounds(100, 100, 649, 501);
		frameSystemFunctions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSystemFunctions.getContentPane().setLayout(null);

		String[] getRealMethods = { "getRealStandardRoom", "getRealSuperiorRoom", "getRealSuite", "getRealBooking",
				"getRealCustomer", "getRealVIPCustomer", "getRealEmployee", "getRealDepartmentManager",
				"getRealDepartment" };
		JComboBox getRealBox = new JComboBox(getRealMethods);
		getRealBox.setBounds(247, 72, 171, 40);
		frameSystemFunctions.getContentPane().add(getRealBox);

		GetRealIdText = new JTextField();
		GetRealIdText.setBounds(428, 72, 96, 38);
		frameSystemFunctions.getContentPane().add(GetRealIdText);
		GetRealIdText.setColumns(10);

		JButton SendIdToGetRealBtn = new JButton("Send");
		SendIdToGetRealBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (getRealBox.getSelectedItem().equals("getRealStandardRoom")) {
						StandardRoom room = Hotel.getInstance().getRealStandardRoom(GetRealIdText.getText());
						if (room == null) {
							throw new NoRoomsFound();
						}
						StandardRoomDetails page = new StandardRoomDetails(room);
						page.showWindow();
					}
					if (getRealBox.getSelectedItem().equals("getRealSuperiorRoom")) {
						SuperiorRoom room = Hotel.getInstance().getRealSuperiorRoom(GetRealIdText.getText());
						if (room == null) {
							throw new NoRoomsFound();
						}
						SuperiorRoomDetails page = new SuperiorRoomDetails(room);
						page.showWindow();
					}
					if (getRealBox.getSelectedItem().equals("getRealSuite")) {
						Suite room = Hotel.getInstance().getRealSuite(GetRealIdText.getText());
						if (room == null) {
							throw new NoRoomsFound();
						}
						SuiteDetails page = new SuiteDetails(room);
						page.showWindow();
					}
					if (getRealBox.getSelectedItem().equals("getRealBooking")) {
						Booking booking = Hotel.getInstance().getRealBooking(GetRealIdText.getText());
						if (booking == null) {
							throw new NoBookingsFound();
						}
						BookingDetails page = new BookingDetails(booking);
						page.showWindow();
					}
					if (getRealBox.getSelectedItem().equals("getRealCustomer")) {
						Customer customer = Hotel.getInstance().getRealCustomer(GetRealIdText.getText());
						if (customer == null) {
							throw new NoCustomersFound();
						}
						CustomerDetails page = new CustomerDetails(customer);
						page.showWindow();
					}
					if (getRealBox.getSelectedItem().equals("getRealVIPCustomer")) {
						VIPCustomer customer = Hotel.getInstance().getRealVIPCustomer(GetRealIdText.getText());
						if (customer == null) {
							throw new NoCustomersFound();
						}
						VIPCustomerDetails page = new VIPCustomerDetails(customer);
						page.showWindow();
					}
					if (getRealBox.getSelectedItem().equals("getRealEmployee")) {
						Employee employee = Hotel.getInstance().getRealEmployee(GetRealIdText.getText());
						if (employee == null) {
							throw new NoEmployeesFound();
						}
						EmployeeDetails page = new EmployeeDetails(employee);
						page.showWindow();

					}
					if (getRealBox.getSelectedItem().equals("getRealDepartmentManager")) {
						DepartmentManager depMa = Hotel.getInstance().getRealDepartmentManager(GetRealIdText.getText());
						if (depMa == null) {
							throw new NoEmployeesFound();
						}
						DepartmentManagerDetails page = new DepartmentManagerDetails(depMa);
						page.showWindow();

					}
					if (getRealBox.getSelectedItem().equals("getRealDepartment")) {
						Department department = Hotel.getInstance().getRealDepartment(GetRealIdText.getText());
						if (department == null) {
							throw new NoDepartmentsFound();
						}
						DepartmentDetails page = new DepartmentDetails(department);
						page.showWindow();

					}
				} catch (NoRoomsFound ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (NoBookingsFound ex1) {
					JOptionPane.showMessageDialog(null, ex1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (NoCustomersFound ex2) {
					JOptionPane.showMessageDialog(null, ex2.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (NoEmployeesFound ex3) {
					JOptionPane.showMessageDialog(null, ex3.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (NoDepartmentsFound ex4) {
					JOptionPane.showMessageDialog(null, ex4.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		SendIdToGetRealBtn.setBackground(new Color(0, 255, 255));
		SendIdToGetRealBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		SendIdToGetRealBtn.setBounds(534, 72, 91, 39);
		frameSystemFunctions.getContentPane().add(SendIdToGetRealBtn);

		// Assuming you are using JTextField, you can add this line to the initialize()
		// method
		JTextField kText = new JTextField();
		kText.setBounds(286, 122, 132, 39);
		frameSystemFunctions.getContentPane().add(kText);
		kText.setVisible(false); // Initially set the TextField as invisible

		JButton sendButtonK = new JButton("Send");
		sendButtonK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int k = Integer.parseInt(kText.getText());

					if (k < 0) {
						throw new NegativeNumberException();
					}

					if (Hotel.getInstance().getAllEmployees().size() < k) {
						throw new InvalidNumberOfEmployees();
					}

					SystemFunctions.setKemployees(true);
					SystemFunctions.setK(k);
					ShowAllEmployees page = new ShowAllEmployees();
					frameSystemFunctions.setVisible(false);
					page.showWindow();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input: Not a numeric value", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} catch (NegativeNumberException ex1) {
					JOptionPane.showMessageDialog(null, ex1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (InvalidNumberOfEmployees ex2) {
					JOptionPane.showMessageDialog(null, ex2.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		sendButtonK.setBackground(new Color(0, 255, 255));
		sendButtonK.setFont(new Font("Tahoma", Font.BOLD, 15));
		sendButtonK.setBounds(428, 120, 93, 41);
		frameSystemFunctions.getContentPane().add(sendButtonK);
		sendButtonK.setVisible(false); // Initially set the "Send" button as invisible

		ArrayList<String> customers = new ArrayList<String>();
		for (Customer c : Hotel.getInstance().getAllCustomers().values()) {
			customers.add(c.getId());
		}
		JComboBox customerIDBox = new JComboBox();
		customerIDBox.setBounds(325, 366, 93, 40);
		frameSystemFunctions.getContentPane().add(customerIDBox);
		for (String customerID : customers) {
			customerIDBox.addItem(customerID);
		}

		JButton sendCustomerIDBtn = new JButton("Send");
		sendCustomerIDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemFunctions.setAllBookingsOfCustomer(true);
				frameSystemFunctions.setVisible(false);
				SystemFunctions.setAllBookingsOfCustomerID((String) customerIDBox.getSelectedItem());
				ShowAllBookings page = new ShowAllBookings();
				page.showWindow();
			}
		});
		sendCustomerIDBtn.setBackground(new Color(0, 255, 255));
		sendCustomerIDBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sendCustomerIDBtn.setBounds(436, 366, 85, 39);
		frameSystemFunctions.getContentPane().add(sendCustomerIDBtn);

		getRealBox.setVisible(false);
		GetRealIdText.setVisible(false);
		SendIdToGetRealBtn.setVisible(false);
		sendCustomerIDBtn.setVisible(false);
		kText.setVisible(false);
		sendButtonK.setVisible(false);
		customerIDBox.setVisible(false);

		JButton kEmployeesBtn = new JButton("KEmployees");
		kEmployeesBtn.setBackground(new Color(0, 255, 255));
		kEmployeesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kText.setVisible(true);
				sendButtonK.setVisible(true);
			}
		});
		kEmployeesBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		kEmployeesBtn.setBounds(105, 118, 171, 39);
		frameSystemFunctions.getContentPane().add(kEmployeesBtn);

		JButton allCustomersByPKBtn = new JButton("allCustomersByPK");
		allCustomersByPKBtn.setBackground(new Color(0, 255, 255));
		allCustomersByPKBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Hotel.getInstance().getAllCustomers().size() == 0) {
						throw new NoCustomersFound();
					}
					SystemFunctions.setAllCustomersByPK(true);
					ShowAllCustomers page = new ShowAllCustomers();
					frameSystemFunctions.setVisible(false);
					page.showWindow();
				} catch (NoCustomersFound ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		allCustomersByPKBtn.setBackground(new Color(0, 255, 255));
		allCustomersByPKBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		allCustomersByPKBtn.setBounds(105, 170, 171, 39);
		frameSystemFunctions.getContentPane().add(allCustomersByPKBtn);

		JButton allBookingByRevenueBtn = new JButton("allBookingByRevenue");
		allBookingByRevenueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Hotel.getInstance().getAllBookings().size() == 0) {
						throw new NoBookingsFound();
					}
					SystemFunctions.setAllBookingsByRevenue(true);
					frameSystemFunctions.setVisible(false);
					ShowAllBookings page = new ShowAllBookings();
					page.showWindow();
				} catch (NoBookingsFound ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		allBookingByRevenueBtn.setBackground(new Color(0, 255, 255));
		allBookingByRevenueBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		allBookingByRevenueBtn.setBounds(105, 219, 171, 39);
		frameSystemFunctions.getContentPane().add(allBookingByRevenueBtn);

		JButton allCustomersCmpBtn = new JButton("allCustomersCmp");
		allCustomersCmpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Hotel.getInstance().getAllCustomers().size() == 0) {
						throw new NoCustomersFound();
					}

					SystemFunctions.setAllCustomersCMP(true);
					frameSystemFunctions.setVisible(false);
					ShowAllCustomers page = new ShowAllCustomers();
					page.showWindow();
				} catch (NoCustomersFound ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		allCustomersCmpBtn.setBackground(new Color(0, 255, 255));
		allCustomersCmpBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		allCustomersCmpBtn.setBounds(105, 268, 171, 39);
		frameSystemFunctions.getContentPane().add(allCustomersCmpBtn);

		JButton totalProfitBtn = new JButton("Total Profit");
		totalProfitBtn.setBackground(new Color(0, 255, 255));
		totalProfitBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		totalProfitBtn.setBounds(105, 317, 171, 39);
		totalProfitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double totalProfit = Hotel.getInstance().totalProfit();
				JOptionPane.showMessageDialog(null, "Hotel Total Profit: " + totalProfit + " $", "HOTEL PROFIT",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		frameSystemFunctions.getContentPane().add(totalProfitBtn);

		JButton allBookingsOfSpecCustomerBtn = new JButton("allBookingsOfSpecCustomer");
		allBookingsOfSpecCustomerBtn.setBackground(new Color(0, 255, 255));
		allBookingsOfSpecCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Hotel.getInstance().getAllCustomers().size() == 0) {
						throw new NoCustomersFound();
					}
					customerIDBox.setVisible(true);
					sendCustomerIDBtn.setVisible(true);
				} catch (NoCustomersFound ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		allBookingsOfSpecCustomerBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		allBookingsOfSpecCustomerBtn.setBounds(105, 366, 210, 39);
		frameSystemFunctions.getContentPane().add(allBookingsOfSpecCustomerBtn);

		JButton customerBookedTheMostRoomsBtn = new JButton("customerBookedTheMostRooms");
		customerBookedTheMostRoomsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Hotel.getInstance().getAllCustomers().size() == 0) {
						throw new NoCustomersFound();
					}
					CustomerDetails page = new CustomerDetails(Hotel.getInstance().customerBookedTheMostRooms());
					page.showWindow();
				} catch (NoCustomersFound ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		customerBookedTheMostRoomsBtn.setBackground(new Color(0, 255, 255));
		customerBookedTheMostRoomsBtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		customerBookedTheMostRoomsBtn.setBounds(105, 415, 210, 39);
		frameSystemFunctions.getContentPane().add(customerBookedTheMostRoomsBtn);

		JButton cancel = new JButton("Back To Menu");
		cancel.setBackground(new Color(0, 255, 255));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginPage.getUserType().equals("admin")) {
					frameSystemFunctions.setVisible(false);
					AdminFirstView p2 = new AdminFirstView();
					p2.showWindow();
				} else {
					frameSystemFunctions.setVisible(false);
					EmployeeFirstView p2 = new EmployeeFirstView();
					p2.showWindow();
				}
			}
		});
		cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		cancel.setBounds(0, 0, 158, 39);
		frameSystemFunctions.getContentPane().add(cancel);

		JButton btnNewButton = new JButton("getReal Functions");
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getRealBox.setVisible(true);
				GetRealIdText.setVisible(true);
				SendIdToGetRealBtn.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(105, 71, 132, 38);
		frameSystemFunctions.getContentPane().add(btnNewButton);

		String imageUrl = "/photo-1507525428034-b723cf961d3e.jpeg";
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource(imageUrl));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 645, 463);
		frameSystemFunctions.getContentPane().add(backgroundLabel);

	}

	public void showWindow() {
		frameSystemFunctions.setVisible(true);

	}
}
