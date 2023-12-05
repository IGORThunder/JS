package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements ProjectRepository<Book> {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList<>();

    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(book.hashCode());
        logger.info("store new book: " + book);
        repo.add(book);
    }

    @Override
    public boolean removeItemById(Integer removeBookById) {
        for (Book book : repo) {
            if (book.getId().equals(removeBookById)) {
                logger.info("remove book by id completed: " + book);
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeItemByRegex(String regex) {
        boolean result = false;
        for (int i = 0; i < repo.size(); i++) {
            if (repo.get(i).getTitle().contains(regex)
                    || repo.get(i).getAuthor().contains(regex)
                    || repo.get(i).getSize().contains(regex)) {
                logger.info("remove book by regular expression completed: " + repo.get(i));
                repo.remove(repo.get(i));
                i--;
                result = true;
            }
        }
        return result;
    }
}
