package librarysystem;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.ControllerInterface;
import business.LoginException;
import business.SystemController;

public class AdminWindow extends JFrame implements LibWindow {
	public static final AdminWindow INSTANCE = new AdminWindow();
	private static final long serialVersionUID = 1L;
	private boolean isInitialized = false;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow frame = new AdminWindow();
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
	public AdminWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Admin Menu");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addNewMember = new JButton("Add New Member");
		addNewMember.setBounds(40, 52, 117, 23);
		contentPane.add(addNewMember);
		
		JButton addNewBook = new JButton("Add New Book");
		addNewBook.setBounds(167, 52, 110, 23);
		addBookButtonListener(addNewBook);
		contentPane.add(addNewBook);
		
		JButton lookUp = new JButton("Lookup");
		lookUp.setBounds(287, 52, 89, 23);
		contentPane.add(lookUp);
		
		JButton backButton = new JButton("<= Back to Main");
		backButton.setBounds(269, 197, 117, 23);
		addBackButtonListener(backButton);
		contentPane.add(backButton);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		JFrame adminFrame = new JFrame("Admin");
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.setSize(400, 200);

		JButton addMemberButton = new JButton("Add Member");
		JButton addBookButton = new JButton("Add Book");
		JButton addCopyButton = new JButton("Add Copy");
		
		adminFrame.getContentPane().add(addMemberButton);
		adminFrame.getContentPane().add(addBookButton);
		adminFrame.getContentPane().add(addCopyButton);
	}

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		// TODO Auto-generated method stub
		isInitialized = val;
	}
	
	private void addBookButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
				LibrarySystem.hideAllWindows();
				BookWindow.INSTANCE.init();
				Util.centerFrameOnDesktop(BookWindow.INSTANCE);
				BookWindow.INSTANCE.setVisible(true);

		});
	}
	private void addBackButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			LibrarySystem.hideAllWindows();
			LibrarySystem.INSTANCE.setVisible(true);
		});
	}
	
}
