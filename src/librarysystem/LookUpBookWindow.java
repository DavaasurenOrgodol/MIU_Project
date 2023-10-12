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
import business.SystemController;

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
	SystemController c=new SystemController();
	private Book b;
	private JTextField valuetextField;
	

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
		setBounds(400, 400, 550, 500);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(226, 226, 226));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lookupLabel = new JLabel("LookUp Book");
		lookupLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lookupLabel.setBounds(167, 12, 160, 36);
		contentPane.add(lookupLabel);
		
		JLabel enterISBNLabel = new JLabel("EnterISBN:");
		enterISBNLabel.setBounds(167, 59, 67, 14);
		contentPane.add(enterISBNLabel);
		
		iSBNNumberField = new JTextField();
		iSBNNumberField.setBounds(233, 56, 128, 20);
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
		submitButton.setBounds(233, 84, 119, 45);
		
		contentPane.add(submitButton);
        detailsTextArea = new JTextArea();

        detailsTextArea.setBackground(new Color(230, 230, 230));
        
        detailsTextArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
        detailsTextArea.setBounds(156, 176, 347, 89);
        detailsTextArea.setEditable(false); 

        contentPane.add(detailsTextArea);

		
		JButton backButton = new JButton("<---");
		backButton.setBounds(10, 11, 60, 23);
		backButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			LookUpBookWindow.this.setVisible(false);
		}});
		contentPane.add(backButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LookUpBookWindow.class.getResource("/librarysystem/library4.jpg")));
		lblNewLabel.setBounds(-11, 48, 157, 415);
		contentPane.add(lblNewLabel);
		
		JButton addCopyButton = new JButton("Add Copy");
		addCopyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.addCopy(Integer.parseInt(valuetextField.getText()));
				c.saveBook(b);
				b=c.getLookUpDetails(iSBNNumberField.getText());
				String details = "\tBook Details\n\n Title: "+b.getTitle() +"\n"+" Number of Copies:"+b.getNumCopies();
                detailsTextArea.setText(details);
				
			}
		});
		addCopyButton.setBounds(299, 297, 89, 23);
		contentPane.add(addCopyButton);
		
		valuetextField = new JTextField();
		valuetextField.setBounds(256, 297, 33, 22);
		contentPane.add(valuetextField);
		valuetextField.setColumns(10);
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
