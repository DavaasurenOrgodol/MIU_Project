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
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		DataAccess da = new DataAccessFacade();
		da.saveNewBook(book);
	}

	@Override
	public Book getInfo(String memId, String isbn) {
		// TODO Auto-generated method stub
		DataAccess da = new DataAccessFacade();
		if (da.checkLibraryMemberById(memId)) {
			Book book = da.checkBookByISBN(isbn);
			if (book != null) {
				return book;
			}
		}
		return null;
	}

	@Override
	public void saveRecord(CheckoutRecord record) {
		// TODO Auto-generated method stub
		DataAccess da = new DataAccessFacade();
		da.saveCheckoutRecord(record);
	}

}
