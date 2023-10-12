package business;

import java.util.List;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	public void addMember(LibraryMember l)throws LibrarySystemException;
	public void saveBook(Book book);
	public Book getInfo(String memId, String isbn);
	public void saveRecord(Checkout record);
}
