package business;

import java.util.List;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	public void addMember(LibraryMember l)throws LibrarySystemException;
	public void saveBook(Book book);
	public Book getInfo(String memId, String isbn);
//<<<<<<< HEAD
	//public void saveRecord(CheckoutRecord record);
	
////=======
	//public void saveRecord(CheckoutRecord record);	
//>>>>>>> c7b43eba65c324fa8ee0ff4e71c1f0649780ade1
}
