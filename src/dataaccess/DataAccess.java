package dataaccess;

import java.util.HashMap;

import business.Book;
import business.CheckoutRecord;
import business.LibraryMember;
import dataaccess.DataAccessFacade.StorageType;

public interface DataAccess { 
	public HashMap<String,Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String,CheckoutRecord> readRecordsMap();
	public HashMap<String, LibraryMember> readMemberMap();
	public void saveNewMember(LibraryMember member);
	public boolean checkMemberPresentOrNot(LibraryMember member);
	public void saveNewBook(Book book); 
	public boolean checkLibraryMemberById(String memId);
	public Book checkBookByISBN(String isbn);
	public void saveCheckoutRecord(CheckoutRecord checkoutRecord);
}
