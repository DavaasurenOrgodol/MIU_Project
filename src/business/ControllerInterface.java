package business;

import java.util.List;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	public void saveBook(Book book);
	public Book getInfo(String memId, String isbn);
	public void saveRecord(CheckoutRecord record);
	
}
