import static org.junit.Assert.*;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.BookException;

public class BookTest {
	@Test
	public void Equals1(){
		Book bk = new Book("bk097", "Me", "Thish", "Goodness", 100.00, new Date(1, 2, 3, 4, 5), "Pure Goodness");
		Book mcDonalds = new Book("bk097", "Me", "Thish", "Goodness", 100.00, new Date(1, 2, 3, 4, 5), "Pure Goodness");
		assertTrue(bk.equals(mcDonalds));
	}
	
	@Test
	public void Equals2(){
		Book bk = new Book("bk097", "Me", "Thish", "Goodness", 100.00, new Date(1, 2, 3, 4, 5), "Pure Goodness");
		Book wendys = new Book("bk098", "Me", "Thish", "Goodness", 100.00, new Date(1, 2, 3, 4, 5), "Pure Goodness");
		assertFalse(bk.equals(wendys));
	}

	@Test
	public void GetBook1() {
		Book bk = new Book("bk101");
		assertTrue(bk.GetBook("bk101").equals(bk));
	}
	
	@Test
	public void GetBook2() {
		Book bk = new Book("bk110");
		assertNotEquals(bk.GetBook("id110"), bk);
	}
	
	@Test
	public void AddBook1() {
		Book bk = new Book("bk099", "Me", "Thish", "Goodness", 100.00, new Date(1, 2, 3, 4, 5), "Pure Goodness");
		bk.AddBook("bk099", bk);
		//Book was successfully added to the list.
		assertTrue((bk.GetBook("bk099") != null) && (bk.GetBook("bk099").equals(bk)));
	}
	
	@Test
	public void AddBook2() {
		Book imposter = new Book("bk101", "Gambardella, Matthew", "XML Developer's Guide", "Computer", 49.45,
			new Date(2000, 10, 1, 4, 0), "Pure Goodness. 99% Authentic");
		imposter.AddBook("bk101", imposter);
		//There's a book "bk101".
		assertTrue(imposter.GetBook("bk101") != null);
		//But it's not the imposter!
		assertFalse(imposter.GetBook("bk101").equals(imposter));
	}

}
