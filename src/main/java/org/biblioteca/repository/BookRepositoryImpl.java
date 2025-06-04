package org.biblioteca.repository;

import org.biblioteca.config.DBManager;
import org.biblioteca.model.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    Connection connection = DBManager.initConnection();

    @Override
    public List<Book> getLibrary() throws SQLException {
        String query = "SELECT * FROM library.book";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<Book> books = new ArrayList<>();
        while (rs.next()) {
            Book book = new Book(rs.getInt("idbook"), rs.getString("title"),rs.getString("author"),
                    rs.getString("description"),rs.getString("isbn"), rs.getString("genre"));
            books.add(book);
        }
        return books;
    }

    @Override
    public Book getBook(String isbn) throws SQLException {
        String query = "SELECT * FROM library.book WHERE isbn = '"+isbn+"'";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Book book = new Book(0,null,null,null,null,null);
        while (rs.next()) {
            book.setIdbook(rs.getInt("idbook"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setDescription(rs.getString("description"));
            book.setIsbn(rs.getString("isbn"));
            book.setGenre(rs.getString("genre"));
        }
        return book;
    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void createBook(Book book) {

    }

    @Override
    public void deleteBook(int idbook) {

    }

    public void addBook(Book book) {
    }
}
