package librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.UtilityClass;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BothUserWindow extends JFrame  implements LibWindow{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static final BothUserWindow INSTANCE = new BothUserWindow();
	private boolean isInitialized = false;

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
		setSize(660, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UtilityClass.centerFrameOnDesktop(this);
		
		contentPane = new JPanel();
		setTitle("SuperUser Window");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddMemberButton = new JButton("Add Member");
		btnAddMemberButton.setIcon(new ImageIcon(BothUserWindow.class.getResource("/librarysystem/addMember.png")));
		btnAddMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarySystem.hideAllWindows();
				AddLibraryMemberWindow.INSTANCE.init();
				Util.centerFrameOnDesktop(AddLibraryMemberWindow.INSTANCE);
				AddLibraryMemberWindow.INSTANCE.setVisible(true);
			}
		});
		btnAddMemberButton.setBounds(317, 38, 156, 41);
		contentPane.add(btnAddMemberButton);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setIcon(new ImageIcon(BothUserWindow.class.getResource("/librarysystem/addBook.png")));
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarySystem.hideAllWindows();
				BookWindow.INSTANCE.init();
				Util.centerFrameOnDesktop(BookWindow.INSTANCE);
				BookWindow.INSTANCE.setVisible(true);
			}
		});
		btnAddBook.setBounds(317, 100, 156, 41);
		contentPane.add(btnAddBook);
		
		JButton btnCheckOutButton_2 = new JButton("Check Out");
		btnCheckOutButton_2.setIcon(new ImageIcon(BothUserWindow.class.getResource("/librarysystem/addCheckout.png")));
		btnCheckOutButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarySystem.hideAllWindows();
				LibrarionWindow.INSTANCE.init();
				Util.centerFrameOnDesktop(LibrarionWindow.INSTANCE);
				LibrarionWindow.INSTANCE.setVisible(true);
			}
		});
		btnCheckOutButton_2.setBounds(317, 224, 156, 41);
		contentPane.add(btnCheckOutButton_2);
		
		JButton overdueButton = new JButton("Overdue");
		overdueButton.setIcon(new ImageIcon(BothUserWindow.class.getResource("/librarysystem/addCheckout.png")));
		overdueButtonListener(overdueButton);
		overdueButton.setBounds(317, 288, 156, 41);
		contentPane.add(overdueButton);
		
		JButton btnAddCopyButton_3 = new JButton("Add Copy");
		btnAddCopyButton_3.setIcon(new ImageIcon(BothUserWindow.class.getResource("/librarysystem/addCopy.png")));
		btnAddCopyButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarySystem.hideAllWindows();
				LookUpBookWindow.INSTANCE.init();
				Util.centerFrameOnDesktop(LookUpBookWindow.INSTANCE);
				LookUpBookWindow.INSTANCE.setVisible(true);

			}
		});
		btnAddCopyButton_3.setBounds(317, 162, 156, 41);
		contentPane.add(btnAddCopyButton_3);
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setBounds(134, 11, 164, 14);
		contentPane.add(titleLabel);
		
		JLabel jlabelLabel = new JLabel("");
		jlabelLabel.setIcon(new ImageIcon(BothUserWindow.class.getResource("/librarysystem/libraryAgain.jpg")));
		jlabelLabel.setBounds(0, 11, 265, 452);
		contentPane.add(jlabelLabel);
		JButton backButton = new JButton("<= Back");
		backButton.setBounds(507, 414, 95, 23);
		addBackButtonListener(backButton);
		contentPane.add(backButton);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
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
	private void addBackButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			LibrarySystem.hideAllWindows();
			LibrarySystem.INSTANCE.setVisible(true);
		});
	}
	
	private void overdueButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			LibrarySystem.hideAllWindows();
			OverdueWindow.INSTANCE.init();
			Util.centerFrameOnDesktop(OverdueWindow.INSTANCE);
			OverdueWindow.INSTANCE.setVisible(true);

		});
	}
}
