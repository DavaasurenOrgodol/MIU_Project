package librarysystem;


import java.awt.Color;
import java.awt.EventQueue;

import java.awt.Font;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

import business.ControllerInterface;
import business.SystemController;



public class AllMemberIdsWindow extends JFrame implements LibWindow {
	public static final AllMemberIdsWindow INSTANCE = new AllMemberIdsWindow();
    ControllerInterface ci = new SystemController();
	private boolean isInitialized = false;
	
	
	private static final long serialVersionUID = 1L;

	private JTextField membertextField;
	private JTextField firstNametextField;
	private JTextField lastNametextField;
	private JTextField textField_2;
	private JTextField zip;
	private JTextField contactNo;
	private JTextField state;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllMemberIdsWindow frame = new AllMemberIdsWindow();
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
	public AllMemberIdsWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 800, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(156, 229, 89, 23);
		getContentPane().add(submitButton);
		
		JLabel title = new JLabel("Add New Library Member");
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setForeground(new Color(0, 64, 128));
		title.setBounds(73, 26, 266, 23);
		getContentPane().add(title);
		
		JLabel firstName = new JLabel("First Name");
		firstName.setBounds(107, 79, 54, 14);
		getContentPane().add(firstName);
		
		JLabel lastName = new JLabel("Last Name");
		lastName.setBounds(196, 79, 69, 14);
		getContentPane().add(lastName);
		
		JLabel memberID = new JLabel("Member ID");
		memberID.setBounds(10, 79, 64, 14);
		getContentPane().add(memberID);
		
		JLabel telephone = new JLabel("Contact Info");
		telephone.setBounds(112, 135, 64, 14);
		getContentPane().add(telephone);
		
		JLabel Zip = new JLabel("ZIP");
		Zip.setBounds(10, 135, 49, 14);
		getContentPane().add(Zip);
		
		JLabel State = new JLabel("State");
		State.setBounds(206, 135, 49, 14);
		getContentPane().add(State);
		
		JLabel city = new JLabel("City");
		city.setBounds(299, 79, 49, 14);
		getContentPane().add(city);
		
		JLabel street = new JLabel("Street Name");
		street.setBounds(299, 135, 49, 14);
		getContentPane().add(street);
		
		membertextField = new JTextField();
		membertextField.setBounds(10, 104, 64, 20);
		getContentPane().add(membertextField);
		membertextField.setColumns(10);
		
		firstNametextField = new JTextField();
		firstNametextField.setBounds(95, 104, 88, 20);
		getContentPane().add(firstNametextField);
		firstNametextField.setColumns(10);
		
		lastNametextField = new JTextField();
		lastNametextField.setBounds(195, 104, 83, 20);
		getContentPane().add(lastNametextField);
		lastNametextField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(299, 104, 96, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		zip = new JTextField();
		zip.setBounds(10, 160, 64, 20);
		getContentPane().add(zip);
		zip.setColumns(10);
		
		contactNo = new JTextField();
		contactNo.setBounds(95, 160, 89, 20);
		getContentPane().add(contactNo);
		contactNo.setColumns(10);
		
		state = new JTextField();
		state.setBounds(196, 160, 69, 20);
		getContentPane().add(state);
		state.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(299, 160, 69, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
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


