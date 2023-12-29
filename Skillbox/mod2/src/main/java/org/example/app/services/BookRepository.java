package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements ProjectRepository<Book>,
        ApplicationContextAware {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private ApplicationContext context;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> retreiveAll() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            book.setSize(rs.getInt("size"));
            return book;
        });
        return new ArrayList<>(books);
    }

    @Override
    public void store(Book book) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("author", book.getAuthor());
        source.addValue("title", book.getTitle());
        source.addValue("size", book.getSize());
        jdbcTemplate.update("INSERT INTO books(author, title, size) " +
                "VALUES(:author, :title, :size)",
                source);
        logger.info("store new book: " + book);
    }

    @Override
    public void removeItemById(Integer removeBookById) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id", removeBookById);
        jdbcTemplate.update("DELETE FROM books WHERE id = :id", source);
        logger.info("remove book completed");
    }

    @Override
    public void removeItemByRegex(String regex) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("regex", regex);
        jdbcTemplate.update("DELETE FROM books " +
                "WHERE title LIKE :regex " +
                "OR author LIKE :regex " +
                "OR CAST(size AS CHAR) LIKE :regex;", source);
        logger.info("remove book by regular expression completed");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void defaultInit() {
        logger.info("default INIT in book repository bean");
    }

    public void defaultDestroy() {
        logger.info("default DESTROY in book repository bean");
    }
}
