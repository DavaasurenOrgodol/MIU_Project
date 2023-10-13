package librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class BothUserWindow extends JFrame  implements LibWindow{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static final BothUserWindow INSTANCE = new BothUserWindow();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BothUserWindow frame = new BothUserWindow();
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
	public BothUserWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setTitle("SuperUser Window");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(213, 10, 10, 10);
		contentPane.add(panel);
		
		JButton btnAddMemberButton = new JButton("Add Member");
		btnAddMemberButton.setBounds(134, 32, 89, 23);
		contentPane.add(btnAddMemberButton);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(134, 71, 89, 23);
		contentPane.add(btnAddBook);
		
		JButton btnCheckOutButton_2 = new JButton("Check Out");
		btnCheckOutButton_2.setBounds(134, 171, 89, 23);
		contentPane.add(btnCheckOutButton_2);
		
		JButton btnAddCopyButton_3 = new JButton("Add Copy");
		btnAddCopyButton_3.setBounds(134, 123, 89, 23);
		contentPane.add(btnAddCopyButton_3);
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setBounds(134, 11, 164, 14);
		contentPane.add(titleLabel);
		
		JLabel jlabelLabel = new JLabel("");
		jlabelLabel.setBounds(10, 11, 89, 214);
		contentPane.add(jlabelLabel);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void isInitialized(boolean val) {
		// TODO Auto-generated method stub
		
	}
}
