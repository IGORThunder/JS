package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final ProjectRepository<Book> bookRepo;
    private final Logger logger = Logger.getLogger(BookService.class);

    @Autowired
    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        bookRepo.store(book);
    }

    public void removeBookById(Integer removeBookById) {
        bookRepo.removeItemById(removeBookById);
    }

    public void removeBookByRegex(String regex) {
        bookRepo.removeItemByRegex(regex);
    }

    public void defaultInit() {
        logger.info("default INIT in book service bean");
    }

    public void defaultDestroy() {
        logger.info("default DESTROY in book service bean");
    }
}
