package librarysystem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import librarysystem.LibrarySystem.AddLibraryMemberWindowListener;

public class MainMenu extends JFrame implements LibWindow {
	public static final MainMenu INSTANCE = new MainMenu();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.init(); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	  class AddLibraryMemberWindowListener implements ActionListener {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			LibrarySystem.hideAllWindows();
	  			AddLibraryMemberWindow.INSTANCE.init();
	  			Util.centerFrameOnDesktop(AddLibraryMemberWindow.INSTANCE);
	  			AddLibraryMemberWindow.INSTANCE.setVisible(true);
	  			
	  		}
	      	
	      }

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addNewMember = new JButton("Add New Member");
		addNewMember.setBounds(40, 52, 117, 23);
		addNewMember.addActionListener(new AddLibraryMemberWindowListener());
		contentPane.add(addNewMember);
		
		JButton addNewBook = new JButton("Add New Book");
		addNewBook.setBounds(167, 52, 110, 23);
		contentPane.add(addNewBook);
		
		JButton lookUp = new JButton("Lookup");
		lookUp.setBounds(287, 52, 89, 23);
		contentPane.add(lookUp);
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
		return false;
	}

	@Override
	public void isInitialized(boolean val) {
		// TODO Auto-generated method stub

	}
}
