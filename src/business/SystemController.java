package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;

	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if (!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if (!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();

	}

	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}

	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}

	@Override
	public void addMember(LibraryMember l) throws LibrarySystemException {
		DataAccess da = new DataAccessFacade();
		if (da.checkMemberPresentOrNot(l)) {
			throw new LibrarySystemException("Duplicate Member ID");
		}
		da.saveNewMember(l);
		return;
	}

	@Override
	public void saveBook(Book book) throws BookException {
		// TODO Auto-generated method stub
		DataAccess da = new DataAccessFacade();
		HashMap<String, Book> map = da.readBooksMap();
		if (book.getIsbn().equals("")) {
			throw new BookException("ISBN must be filled.");
		}
		if (book.getNumCopies() < 0) {
			throw new BookException("Number of sopies must be greater than 0.");
		}
		if (book.getMaxCheckoutLength() <= 0) {
			throw new BookException("Maximuim checkout length must be greater than 0.");
		}
		if (book.getTitle().equals("")) {
			throw new BookException("Book title must be filled.");
		}
		if (map.containsKey(book.getIsbn())) {
			throw new BookException("Duplicated ISBN.");
		}
		da.saveNewBook(book);
	}

	@Override
	public Book getInfo(String memId, String isbn) throws BookException {
		// TODO Auto-generated method stub
		DataAccess da = new DataAccessFacade();
		if (da.checkLibraryMemberById(memId)) {
			Book book = da.checkBookByISBN(isbn);
			if (book != null) {
				if (book.getNextAvailableCopy() == null) {
					throw new BookException("Did not found an available copy.");
				}
				return book;
			} else {
				throw new BookException("Book information did't found.");
			}
		} else {
			throw new BookException("Member Id didn't found.");
		}
	}

	@Override
	public int getAvailableCopyNum(BookCopy[] copies) {
		for (BookCopy copy : copies) {
			if (copy.isAvailable()) {
				return copy.getCopyNum();
			}
		}
		return -1;
	}
	

	@Override
	public void saveRecord(Checkout record) {
		// TODO Auto-generated method stub
		DataAccess da = new DataAccessFacade();
		da.saveCheckoutRecord(record);
	}

	@Override
	public Book getLookUpDetails(String ISBN) {
		DataAccess da = new DataAccessFacade();
		Book b = da.checkBookByISBN(ISBN);
		return b;
	}

	@Override
	public void editBook(Book book) throws BookException {
		// TODO Auto-generated method stub
		DataAccess da = new DataAccessFacade();
		da.editSelectedBook(book);
	}

	@Override
	public void updateBook(Book book) throws BookException {
		// TODO Auto-generated method stub
		DataAccess da = new DataAccessFacade();
		da.updateBook(book);		
	}
}
