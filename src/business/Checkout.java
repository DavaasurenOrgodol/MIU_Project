package business;

import java.io.Serializable;
import java.time.LocalDate;

final public class Checkout implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book book;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	public Checkout(Book book,LocalDate checkoutDate, LocalDate dueDate){
		this.book = book;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}
	public Book getBook() {
		return book;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	@Override
	public String toString() {
		return book.toString()+" Checkout Date:"+checkoutDate+" DueDate:"+dueDate;
	}
}
