package librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LookUpBookWindow extends JFrame implements LibWindow {

	private static final long serialVersionUID = 1L;
	public static final LookUpBookWindow INSTANCE = new LookUpBookWindow();
	private JPanel contentPane;
	private JTextField iSBNNumberField;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lookupLabel = new JLabel("Search book");
		lookupLabel.setBounds(169, 11, 116, 36);
		contentPane.add(lookupLabel);
		
		JLabel enterISBNLabel = new JLabel("EnterISBN");
		enterISBNLabel.setBounds(32, 63, 55, 14);
		contentPane.add(enterISBNLabel);
		
		iSBNNumberField = new JTextField();
		iSBNNumberField.setBounds(20, 98, 96, 20);
		contentPane.add(iSBNNumberField);
		iSBNNumberField.setColumns(10);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		submitButton.setBounds(169, 157, 89, 23);
		contentPane.add(submitButton);
		
		JButton backButton = new JButton("<---");
		backButton.setBounds(10, 11, 60, 23);
		backButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			LookUpBookWindow.this.setVisible(false);
		}});
		contentPane.add(backButton);
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
