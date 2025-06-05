package org.biblioteca.repository;

import org.biblioteca.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
    List<Book> getLibrary() throws SQLException;
    Book getBook(String isbn) throws SQLException;
    void updateBook(Book book);
    void createBook(Book book);
    public int deleteBook(String isbn) throws SQLException;
}
