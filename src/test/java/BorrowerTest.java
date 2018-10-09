import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    Borrower borrower;
    Book book;
    Library library;

    @Before
    public void before() {
        borrower = new Borrower();
        book = new Book("title", "author", "genre");
        library = new Library(5);
    }

    @Test
    public void countBooks() {
        assertEquals(0, borrower.countBooks());
    }

    @Test
    public void addBook() {
        assertEquals(0, borrower.countBooks());
        borrower.addBook(book);
        assertEquals(1, borrower.countBooks());
    }

    @Test
    public void borrowBook() {
        assertEquals(0, library.countBooks());
        library.addBook(book);
        assertEquals(1, library.countBooks());
        borrower.borrowBook(book, library);
        assertEquals(0, library.countBooks());
        assertEquals(1, borrower.countBooks());
    }

}
