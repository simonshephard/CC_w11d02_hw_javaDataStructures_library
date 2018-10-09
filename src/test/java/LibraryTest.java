import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Library library;
    Book book;

    @Before
    public void before() {
        library = new Library(5);
        book = new Book("title", "author", "genre");
    }

    @Test
    public void countBooks() {
        assertEquals(0, library.countBooks());
    }

    @Test
    public void countBooksOfGenre() {
        assertEquals(0, library.countBooksOfGenre("genre"));
        library.addBook(book);
        assertEquals(1, library.countBooksOfGenre("genre"));
    }


    @Test
    public void addBook() {
        assertEquals(0, library.countBooks());
        library.addBook(book);
        assertEquals(1, library.countBooks());
        assertEquals(1, library.countBooksOfGenre("genre"));
    }

    @Test
    public void removeBook() {
        library.addBook(book);
        assertEquals(1, library.countBooks());
        library.removeBook(book);
        assertEquals(0, library.countBooks());
    }

    @Test
    public void atCapacity() {
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        assertEquals(5, library.countBooks());
        assertEquals(false, library.spareCapacity());
    }

    @Test
    public void addBookAtCapacity() {
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        assertEquals(5, library.countBooks());
        assertEquals(false, library.spareCapacity());
    }
}
