package librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Address;
import business.LibraryMember;
import business.LibrarySystemException;
import business.RandomNumber;
import business.SystemController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AddLibraryMemberWindow extends JFrame implements LibWindow {

	private static final long serialVersionUID = 1L;
	private JPanel mainPane;
	public static final AddLibraryMemberWindow INSTANCE = new AddLibraryMemberWindow();

	private boolean isInitialized = false;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField memberID;
	private JTextField telephone;
	private JTextField city;
	private JTextField street;
	private JTextField state;
	private JTextField zip;
	private JLabel memberIDLabel;
	/**
	 * @wbp.nonvisual location=154,809
	 */

	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel telephoneLabel;
	private JLabel cityLabel;
	private JLabel streetLabel;
	private JLabel stateLabel;
	private JLabel zipLabel;
	private JLabel pictureLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLibraryMemberWindow frame = new AddLibraryMemberWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddLibraryMemberWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 550, 500);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add New Library Members");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(171, -4, 239, 25);
		mainPane.add(lblNewLabel);
		
		firstName = new JTextField();
		firstName.setBounds(215, 65, 96, 20);
		mainPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(391, 65, 96, 20);
		mainPane.add(lastName);
		lastName.setColumns(10);
		
		memberID = new JTextField();
		memberID.setBounds(43, 65, 96, 20);
		memberID.setText(Integer.toString(RandomNumber.generateRandomFourDigitNumber()));
		mainPane.add(memberID);
		memberID.setColumns(10);
		
		telephone = new JTextField();
		telephone.setBounds(43, 116, 96, 20);
		mainPane.add(telephone);
		telephone.setColumns(10);
		
		city = new JTextField();
		city.setBounds(215, 116, 96, 20);
		mainPane.add(city);
		city.setColumns(10);
		
		street = new JTextField();
		street.setBounds(391, 116, 96, 20);
		mainPane.add(street);
		street.setColumns(10);
		
		state = new JTextField();
		state.setBounds(43, 183, 96, 20);
		mainPane.add(state);
		state.setColumns(10);
		
		zip = new JTextField();
		zip.setBounds(215, 183, 96, 20);
		mainPane.add(zip);
		zip.setColumns(10);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBackground(new Color(255, 255, 255));
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		submitButton.setIcon(null);
		submitButton.setForeground(new Color(102, 153, 0));
		submitButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String memberId = memberID.getText();
		        String fName = firstName.getText();
		        String lName = lastName.getText();
		        String phone = telephone.getText();
		        String cityVal = city.getText();
		        String zipVal = zip.getText();
		        String stateVal = state.getText();
		        String streetVal = street.getText();
		        if (memberId.isEmpty() || fName.isEmpty() || lName.isEmpty() || phone.isEmpty() || cityVal.isEmpty()
		                || zipVal.isEmpty() || stateVal.isEmpty() || streetVal.isEmpty()) {
		                // Display an error message if any field is empty
		                JOptionPane.showMessageDialog(AddLibraryMemberWindow.this, "All fields are required.");
		        }
		                else
		                {
		                	
		              

		        Address a = new Address(streetVal, cityVal, stateVal, zipVal);
		        LibraryMember lb = new LibraryMember(memberId, fName, lName, phone, a);
		        SystemController controller = new SystemController();
		        try {
		            controller.addMember(lb);
		        } catch (LibrarySystemException ex) {
		            ex.printStackTrace();
		        }

		        JOptionPane.showMessageDialog(AddLibraryMemberWindow.this, "Member Information:\n" +
		                "Member ID: " + lb.getMemberId() + "\n" +
		                "Name: " + lb.getFirstName() + " " + lb.getLastName() + "\n" +
		                "Phone: " + lb.getTelephone() + "\n" +
		                "Address: " + lb.getAddress());
		    }
		        }
		});
		submitButton.setBounds(215, 214, 111, 38);
		mainPane.add(submitButton);
		
		memberIDLabel = new JLabel("Member ID");
		memberIDLabel.setBounds(66, 50, 62, 14);
		mainPane.add(memberIDLabel);
		
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(228, 50, 67, 14);
		mainPane.add(firstNameLabel);
		
		lastNameLabel = new JLabel("LastName");
		lastNameLabel.setBounds(418, 50, 49, 14);
		mainPane.add(lastNameLabel);
		
		telephoneLabel = new JLabel("Phone");
		telephoneLabel.setBounds(66, 96, 49, 14);
		mainPane.add(telephoneLabel);
		
		cityLabel = new JLabel("City");
		cityLabel.setBounds(243, 96, 49, 14);
		mainPane.add(cityLabel);
		
		streetLabel = new JLabel("Street");
		streetLabel.setBounds(418, 99, 49, 14);
		mainPane.add(streetLabel);
		
		stateLabel = new JLabel("State");
		stateLabel.setBounds(66, 158, 49, 14);
		mainPane.add(stateLabel);
		
		zipLabel = new JLabel("ZIP");
		zipLabel.setBounds(243, 158, 49, 14);
		mainPane.add(zipLabel);
		
		JButton backButton = new JButton("<---");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 8));
		backButton.setForeground(new Color(128, 64, 64));
		backButton.setBounds(0, 1, 49, 20);
		backButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			 AddLibraryMemberWindow.this.setVisible(false);
		}});
		mainPane.add(backButton);
		
		pictureLabel = new JLabel("");
		pictureLabel.setIcon(new ImageIcon(AddLibraryMemberWindow.class.getResource("/librarysystem/book.jpg")));
		pictureLabel.setBounds(10, 263, 516, 189);
		mainPane.add(pictureLabel);
	}

	@Override
	public boolean isInitialized() {

		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		isInitialized = val;

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}
}
