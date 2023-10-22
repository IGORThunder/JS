package aop;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class UniLibrary {

    private final Map<String, Book> books;

    public UniLibrary(List<Book> books) {
        this.books = new HashMap<>();
        for(Book book : books) {
            this.addBook(book);
        }
    }

    public Book getBook(String title) throws Exception {
        if (!books.containsKey(title)) {
            throw new Exception("Book not found");
        }
        return books.get(title);
    }

    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }

    @Override
    public String toString() {
        return "UniLibrary{" +
                "books=" + books +
                '}';
    }
}
