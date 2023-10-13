package librarysystem;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Book;
import business.BookException;
import business.Checkout;
import business.ControllerInterface;
import business.SystemController;
import dataaccess.Auth;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class LibrarionWindow extends JFrame implements LibWindow {
	public static final LibrarionWindow INSTANCE = new LibrarionWindow();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean isInitialized = false;
	private JTextField memId;
	private JTextField isbn;
	private JLabel title;
	private JLabel chkLen;
	List<Checkout> records = new ArrayList<Checkout>();
	List<String> rList = new ArrayList<String>();
	private JTable table;
	static int row = 0;

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
		setSize(660, 500);
		setTitle("Librarian Window");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel memIdLabel = new JLabel("Member ID:");
		memIdLabel.setBounds(35, 27, 65, 14);
		contentPane.add(memIdLabel);

		memId = new JTextField();
		memId.setBounds(124, 27, 151, 20);
		contentPane.add(memId);
		memId.setColumns(10);

		JLabel isbnLabel = new JLabel("ISBN:");
		isbnLabel.setBounds(35, 61, 46, 14);
		contentPane.add(isbnLabel);

		isbn = new JTextField();
		isbn.setBounds(124, 58, 151, 20);
		contentPane.add(isbn);
		isbn.setColumns(10);

		JButton searchButton = new JButton("Search...");
		searchButton.setBounds(440, 86, 89, 23);
		searchButtonListener(searchButton);
		contentPane.add(searchButton);

		JButton chkoutButton = new JButton("Checkout...");
		chkoutButton.setBounds(417, 427, 99, 23);
		chkButtonListener(chkoutButton);
		contentPane.add(chkoutButton);

		JButton clrButton = new JButton("Clear");
		clrButton.setBounds(532, 86, 71, 23);
		clearButtonListener(clrButton);
		contentPane.add(clrButton);

		JButton backButton = new JButton("<=Back");
		backButton.setBounds(324, 427, 89, 23);
		backButtonListener(backButton);
		contentPane.add(backButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(517, 427, 89, 23);
		contentPane.add(cancelButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 120, 571, 296);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "Member ID", "ISBN", "Book Title", "Maximuim Checkout Length", "Checkout Date",
						"DueDate" }));
		scrollPane.setViewportView(table);

		JLabel titleLabel = new JLabel("Title:");
		titleLabel.setBounds(289, 27, 46, 14);
		contentPane.add(titleLabel);

		JLabel chkLenLabel = new JLabel("Max. checkout length:");
		chkLenLabel.setBounds(288, 61, 125, 14);
		contentPane.add(chkLenLabel);

		title = new JLabel("");
		title.setVerticalAlignment(SwingConstants.TOP);
		title.setBounds(333, 27, 273, 20);
		contentPane.add(title);

		chkLen = new JLabel("");
		chkLen.setBounds(430, 61, 46, 14);
		contentPane.add(chkLen);
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
			try {
				ControllerInterface c = new SystemController();
				Book book = c.getInfo(memId.getText(), isbn.getText());
				book.getNextAvailableCopy().changeAvailability();
				title.setText(book.getTitle());
				chkLen.setText(String.valueOf(book.getMaxCheckoutLength()));
				Checkout recd = new Checkout(memId.getText(), book, LocalDate.now(),
						LocalDate.now().plusDays(book.getMaxCheckoutLength()));
				records.add(recd);
				rList.add(book.getIsbn() + " " + book.getTitle() + " " + LocalDate.now().toString() + " "
						+ LocalDate.now().plusDays(book.getMaxCheckoutLength()).toString());
			} catch (BookException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
				memId.setText("");
				isbn.setText("");
				title.setText("");
				chkLen.setText("");
			}

		});
	}

	private void chkButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			ControllerInterface c = new SystemController();
			for (int i = 0; i < records.size(); i++) {
				try {
					c.updateBook(records.get(i).getBook());
					c.saveRecord(records.get(i));
					table.getModel().setValueAt(records.get(i).getMemId(), row, 0);
					table.getModel().setValueAt(records.get(i).getBook().getIsbn(), row, 1);
					table.getModel().setValueAt(records.get(i).getBook().getTitle(), row, 2);
					table.getModel().setValueAt(records.get(i).getBook().getMaxCheckoutLength(), row, 3);
					table.getModel().setValueAt(records.get(i).getCheckoutDate(), row, 4);
					table.getModel().setValueAt(records.get(i).getDueDate(), row, 5);
				} catch (BookException ex) {
					ex.printStackTrace();
				}

			}
			row++;
			JOptionPane.showMessageDialog(this, "Successful.");
			memId.setText("");
			isbn.setText("");
			rList.clear();
			title.setText("");
			chkLen.setText("");
		});
	}

	private void clearButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			memId.setText("");
			isbn.setText("");
			rList.clear();
			title.setText("");
			chkLen.setText("");
		});
	}

	private void backButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			LibrarySystem.hideAllWindows();
			if (SystemController.currentAuth.equals(Auth.BOTH))
				BothUserWindow.INSTANCE.setVisible(true);
			else
				LibrarySystem.INSTANCE.setVisible(true);

		});
	}
}
