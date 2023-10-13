package librarysystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import business.Book;
import business.BookCopy;
import business.BookException;
import business.SystemController;
import business.UtilityClass;
import dataaccess.Auth;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;

public class LookUpBookWindow extends JFrame implements LibWindow {

	private static final long serialVersionUID = 1L;
	public static final LookUpBookWindow INSTANCE = new LookUpBookWindow();
	private JPanel contentPane;
	private JTextField iSBNNumberField;
	private JTextArea detailsTextArea;
	 private JSpinner spinner;
	SystemController c=new SystemController();
	private Book b;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LookUpBookWindow frame = new LookUpBookWindow();
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
	public LookUpBookWindow() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(660,500);
		UtilityClass.centerFrameOnDesktop(this);
		
		contentPane = new JPanel();

		contentPane.setBackground(new Color(226, 226, 226));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lookupLabel = new JLabel("LookUp Book");
		lookupLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lookupLabel.setBounds(259, 12, 160, 36);
		contentPane.add(lookupLabel);
		
		JLabel enterISBNLabel = new JLabel("EnterISBN:");
		enterISBNLabel.setBounds(291, 59, 67, 14);
		contentPane.add(enterISBNLabel);
		
		iSBNNumberField = new JTextField();
		iSBNNumberField.setBounds(368, 59, 128, 20);
		contentPane.add(iSBNNumberField);
		iSBNNumberField.setColumns(10);
		
		JButton submitButton = new JButton("Search");
		submitButton.setHorizontalAlignment(SwingConstants.LEFT);
		submitButton.setBackground(new Color(255, 255, 255));
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		submitButton.setIcon(new ImageIcon(LookUpBookWindow.class.getResource("/librarysystem/search1.gif")));
		submitButton.setForeground(new Color(102, 153, 0));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 b=c.getLookUpDetails(iSBNNumberField.getText());
				
				String details = "\tBook Details\n\n Title: "+b.getTitle() +"\n"+" Number of Copies:"+b.getNumCopies();
                detailsTextArea.setText(details);
			}
		});
		submitButton.setBounds(377, 101, 119, 45);
		
		contentPane.add(submitButton);
        detailsTextArea = new JTextArea();

        detailsTextArea.setBackground(new Color(230, 230, 230));
        
        detailsTextArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
        detailsTextArea.setBounds(312, 185, 347, 89);
        detailsTextArea.setEditable(false); 

        contentPane.add(detailsTextArea);

		
		JButton backButton = new JButton("<---");
		backButton.setBounds(10, 11, 60, 23);
		backButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			LookUpBookWindow.this.setVisible(false);
			if(SystemController.currentAuth.equals(Auth.ADMIN))
				AdminWindow.INSTANCE.setVisible(true);
				else
					BothUserWindow.INSTANCE.setVisible(true);
		}});
		contentPane.add(backButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LookUpBookWindow.class.getResource("/librarysystem/libraryAgain.jpg")));
		lblNewLabel.setBounds(-20, 45, 269, 415);
		contentPane.add(lblNewLabel);
		
		JButton addCopyButton = new JButton("Add Copy");
		addCopyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.addCopy((int) spinner.getValue());
				try {
					c.editBook(b);;
					b=c.getLookUpDetails(iSBNNumberField.getText());
					String details = "\tBook Details\n\n Title: "+b.getTitle() +"\n"+" Number of Copies:"+b.getNumCopies();
	                detailsTextArea.setText(details);
				} catch (BookException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		addCopyButton.setBounds(417, 300, 98, 21);
		contentPane.add(addCopyButton);
		
		 spinner = new JSpinner();
		spinner.setBounds(377, 300, 30, 20);
		contentPane.add(spinner);
		
		
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
