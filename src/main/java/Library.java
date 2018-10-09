import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> books;
    private int capacity;
    private HashMap<String, Integer> genreCount;

    public Library(int capacity) {
        this.books = new ArrayList<>();
        this.capacity = capacity;
        this.genreCount = new HashMap<>();
    }

    public void addBook(Book book) {
        if (spareCapacity()) {
            this.books.add(book);
            if (this.genreCount.containsKey(book.getGenre())) {
                this.genreCount.put(book.getGenre(), this.genreCount.get(book.getGenre())+1);
            } else {
                this.genreCount.put(book.getGenre(), 1);
            }
        }
    }

    public Book removeBook(Book book) {
        int index = this.books.indexOf(book);
        this.genreCount.put(book.getGenre(), this.genreCount.get(book.getGenre())-1);
        return this.books.remove(index);
    }

    public int countBooks() {
        return this.books.size();
    }

    public int countBooksOfGenre(String genre) {
        if (this.genreCount.containsKey(genre)) {
            return this.genreCount.get(genre);
        } else {
            return 0;
        }
    }

    public boolean spareCapacity() {
        boolean result = true;
        if (countBooks() >= this.capacity) {
            result = false;
        }
        return result;
    }

}
