package librarysystem;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import business.Address;
import business.Author;
import business.Book;
import business.BookException;
import business.ControllerInterface;
import business.SystemController;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;

public class BookWindow extends JFrame implements LibWindow {
	public static final BookWindow INSTANCE = new BookWindow();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField isbn;
	private JTextField title;
	static JTable table;
	private JLabel isbnLabel;
	private JSpinner checkoutLen;
	private JSpinner numOfCopies;
	static List<Author> authors = new ArrayList<>();
	private boolean isInitialized = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookWindow frame = new BookWindow();
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
	public BookWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setTitle("Add Book");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel isbnLabel = new JLabel("ISBN:");
		isbnLabel.setBounds(31, 25, 46, 14);
		contentPane.add(isbnLabel);

		JLabel titleLabel = new JLabel("Title:");
		titleLabel.setBounds(31, 109, 46, 14);
		contentPane.add(titleLabel);

		JLabel numOfCopiesLabel = new JLabel("Number of copies:");
		numOfCopiesLabel.setBounds(31, 53, 108, 14);
		contentPane.add(numOfCopiesLabel);

		JLabel checkoutLenLabel = new JLabel("Maximuim checkout length:");
		checkoutLenLabel.setBounds(31, 84, 171, 14);
		contentPane.add(checkoutLenLabel);

		JLabel authorsLabel = new JLabel("Authors:");
		authorsLabel.setBounds(31, 182, 81, 14);
		contentPane.add(authorsLabel);

		isbn = new JTextField();
		isbn.setBounds(188, 25, 195, 20);
		contentPane.add(isbn);
		isbn.setColumns(10);

		title = new JTextField();
		title.setBounds(188, 119, 195, 50);
		contentPane.add(title);
		title.setColumns(10);

		JButton addButton = new JButton("Add...");
		addButton.setBounds(276, 327, 89, 23);
		addButtonListener(addButton);
		contentPane.add(addButton);

		JButton backButton = new JButton("<=Back");
		backButton.setBounds(362, 327, 89, 23);
		addBackButtonListener(backButton);
		contentPane.add(backButton);

		String[] columnNames = { "Name", "Roll Number", "Department" };
		String[][] data = { { "Kundan Kumar Jha", "4031", "CSE" }, { "Anand Jha", "6014", "IT" } };

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 207, 420, 109);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, },
				new String[] { "First Name", "Last Name", "Bio", "Telephone", "City", "Street", "State", "Zip Code" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, Object.class, Object.class, String.class,
					String.class, String.class, Long.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setColumnSelectionAllowed(true);
		table.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				/*
				 * AuthorWindow.row = table.getSelectedRow();
				 * System.out.println(table.getSelectedRow()); AuthorWindow.INSTANCE.init();
				 * Util.centerFrameOnDesktop(AuthorWindow.INSTANCE);
				 * AuthorWindow.INSTANCE.setVisible(true);
				 */
			}

		});
		scrollPane.setViewportView(table);

		numOfCopies = new JSpinner();
		numOfCopies.setBounds(188, 53, 30, 20);
		contentPane.add(numOfCopies);

		checkoutLen = new JSpinner();
		checkoutLen.setBounds(188, 81, 30, 20);
		contentPane.add(checkoutLen);

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
			BookWindow.INSTANCE.setVisible(false);
			AdminWindow.INSTANCE.setVisible(true);
		});
	}

	private void addButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			try {
				ControllerInterface c = new SystemController();
				addAuthors(table);
				Book book = new Book(isbn.getText(), title.getText(),
						Integer.valueOf(checkoutLen.getModel().getValue().toString()), authors);
				c.saveBook(book);
				JOptionPane.showMessageDialog(this, "Successfully added.");
				LibrarySystem.hideAllWindows();
				BookWindow.INSTANCE.setVisible(false);
				AdminWindow.INSTANCE.setVisible(true);
			} catch (BookException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}

		});
	}

	public void addAuthors(JTable table) {
		for (int i = 0; i < table.getRowCount(); i++) {
			String fname = "";
			String lname = "";
			String telephone = "";
			String bio = "";
			String street = "";
			String city = "";
			String state = "";
			String zip = "";
			for (int j = 0; j < table.getColumnCount(); j++) {
				if (table.getModel().getValueAt(i, j) != null) {
					if (j == 0) {
						fname = table.getModel().getValueAt(i, j).toString();
					}
					if (j == 1) {
						lname = table.getModel().getValueAt(i, j).toString();
					}
					if (j == 2) {
						bio = table.getModel().getValueAt(i, j).toString();
					}
					if (j == 3) {
						telephone = table.getModel().getValueAt(i, j).toString();
					}
					if (j == 4) {
						city = table.getModel().getValueAt(i, j).toString();
					}
					if (j == 5) {
						street = table.getModel().getValueAt(i, j).toString();
					}
					if (j == 6) {
						state = table.getModel().getValueAt(i, j).toString();
					}
					if (j == 7) {
						zip = table.getModel().getValueAt(i, j).toString();
					}
					Address address = new Address(street, city, state, zip);
					Author author = new Author(fname, lname, telephone, address, bio);
					authors.add(author);
				}
			}

		}
	}
}
