package org.biblioteca.repository;

import org.biblioteca.config.DBManager;
import org.biblioteca.model.Book;
import java.sql.PreparedStatement;
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
            Book book = new Book(rs.getInt("idbook"), rs.getString("title"), rs.getString("author"),
                    rs.getString("description"), rs.getString("isbn"), rs.getString("genre"));
            books.add(book);
        }
        return books;
    }

    @Override
    public Book getBook(String isbn) throws SQLException {
        String query = "SELECT * FROM library.book WHERE isbn = '" + isbn + "'";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Book book = new Book(0, null, null, null, null, null);
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
        String query = "UPDATE library.book SET title=?, author=?, description=?, isbn=?, genre=? WHERE idbook=?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getDescription());
            pstmt.setString(4, book.getIsbn());
            pstmt.setString(5, book.getGenre());
            pstmt.setInt(6, book.getIdbook());
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated == 0) {
                System.out.println("No se encontró el libro con ID: " + book.getIdbook());
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el libro: " + e.getMessage());
        }
    }
    @Override
    public void createBook(Book book) {
        String query = "INSERT INTO library.book (title, author, description, isbn, genre) VALUES (?,?,?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getDescription());
            pstmt.setString(4, book.getIsbn());
            pstmt.setString(5, book.getGenre());
            pstmt.executeUpdate();
            System.out.println("Libro creado en la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al crear el libro: " + e.getMessage());
        }
    }


    @Override
    public int deleteBook(String isbn) throws SQLException {
        String sql = "DELETE FROM book WHERE isbn = '" + isbn + "'";
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            int affectedRows = stmt.executeUpdate(sql);
            return affectedRows;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
