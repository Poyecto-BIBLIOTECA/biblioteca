package org.biblioteca.controller;

import org.biblioteca.model.Book;
import org.biblioteca.repository.BookRepository;
import org.biblioteca.repository.BookRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class BookController {
    BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    public List<Book> showBooks() throws SQLException {
        List<Book> books = bookRepository.getLibrary();
        return books;
    }

    public Book showBook(String isbn) throws SQLException {
        Book book = bookRepository.getBook(isbn);
        return book;
    }
    public void createBook(Book book) {
        bookRepository.createBook(book);
    }

    public String deleteBook(String isbn) throws SQLException {
        int deleted = bookRepository.deleteBook(isbn);
        if (deleted > 0) {
            return "Libro excluido exitosamente! ";
        } else {
            return "El libro no existe.";
        }
    }
        public void updateBook (Book book){
            bookRepository.updateBook(book);
        }
}


