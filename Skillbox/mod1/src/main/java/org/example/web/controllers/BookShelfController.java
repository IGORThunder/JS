package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.app.services.BookService;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "books")
public class BookShelfController {

    private final Logger logger = Logger.getLogger(BookShelfController.class);
    private final BookService bookService;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/shelf")
    public String books(Model model) {
        logger.info("got book shelf");
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        if (isBook(book)) {
            book.setAuthor(book.getAuthor().trim());
            book.setTitle(book.getTitle().trim());
            book.setSize(book.getSize().trim());
            bookService.saveBook(book);
            logger.info("current repository size: " + bookService.getAllBooks().size());
        }
        return "redirect:/books/shelf";
    }

    @PostMapping("/remove")
    public String removeBookById(@RequestParam(value = "bookIdToRemove") Integer bookIdToRemove) {
        if (bookService.removeBookById(bookIdToRemove)) {
            logger.info("current repository size: " + bookService.getAllBooks().size());
        }
        return "redirect:/books/shelf";
    }

    @PostMapping("/removeByRegex")
    public String removeBookByRegex(@RequestParam(value = "regex") String regex) {
        if (bookService.removeBookByRegex(regex.trim())) {
            logger.info("current repository size: " + bookService.getAllBooks().size());
        }
        return "redirect:/books/shelf";
    }

    private static boolean isBook(Book book) {
        return (book.getAuthor() != null
                || book.getTitle() != null
                || book.getSize() != null)
                && (!book.getAuthor().trim().isEmpty()
                || !book.getTitle().trim().isEmpty()
                || !book.getSize().trim().isEmpty());
    }
}
