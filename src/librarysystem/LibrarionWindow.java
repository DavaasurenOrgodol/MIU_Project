package librarysystem;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Book;
import business.ControllerInterface;
import business.SystemController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class LibrarionWindow extends JFrame implements LibWindow {
	public static final LibrarionWindow INSTANCE = new LibrarionWindow();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean isInitialized = false;
	private JTextField memId;
	private JTextField isbn;
	private JList list;
	//List<CheckoutRecord> records = new ArrayList<CheckoutRecord>();
	List<String> rList = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarionWindow frame = new LibrarionWindow();
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
	public LibrarionWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel memIdLabel = new JLabel("Member ID:");
		memIdLabel.setBounds(23, 11, 65, 14);
		contentPane.add(memIdLabel);

		memId = new JTextField();
		memId.setBounds(98, 8, 151, 20);
		contentPane.add(memId);
		memId.setColumns(10);

		JLabel isbnLabel = new JLabel("ISBN:");
		isbnLabel.setBounds(23, 39, 46, 14);
		contentPane.add(isbnLabel);

		isbn = new JTextField();
		isbn.setBounds(98, 36, 151, 20);
		contentPane.add(isbn);
		isbn.setColumns(10);

		JButton searchButton = new JButton("Search...");
		searchButton.setBounds(318, 35, 89, 23);
		searchButtonListener(searchButton);
		contentPane.add(searchButton);
		list = new JList();
		list.setBounds(23, 90, 384, 118);
		contentPane.add(list);

		JButton chkoutButton = new JButton("Checkout");
		chkoutButton.setBounds(318, 219, 89, 23);
		chkButtonListener(chkoutButton);
		contentPane.add(chkoutButton);
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

	private void searchButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			/*ControllerInterface c = new SystemController();
			Book book = c.getInfo(memId.getText(), isbn.getText());
			CheckoutRecord recd = new CheckoutRecord(book, LocalDate.now(),
					LocalDate.now().plusDays(book.getMaxCheckoutLength()));
			records.add(recd);
			rList.add(book.getIsbn() + " " + book.getTitle() + " " + LocalDate.now().toString() + " "
					+ LocalDate.now().plusDays(book.getMaxCheckoutLength()).toString());
			list.setListData(rList.toArray());*/

		});
	}

	private void chkButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			ControllerInterface c = new SystemController();
			//records.forEach(e -> c.saveRecord(e));
		});
	}

}
