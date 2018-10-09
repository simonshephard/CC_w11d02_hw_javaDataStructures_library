import java.util.ArrayList;

public class Borrower {

    private ArrayList<Book> books;

    public Borrower() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public int countBooks() {
        return this.books.size();
    }

    public void borrowBook(Book book, Library library) {
        library.removeBook(book);
        addBook(book);
    }

}

