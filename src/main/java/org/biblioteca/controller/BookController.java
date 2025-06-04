package org.biblioteca.controller;

import org.biblioteca.model.Book;
import org.biblioteca.repository.BookRepository;
import org.biblioteca.repository.BookRepositoryImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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
    public void createBook() {
        Scanner sc = new Scanner(System.in);

        System.out.println("📚 Añadir un nuevo libro");
        System.out.print("Título: ");
        String title = sc.nextLine();

        System.out.print("Autor: ");
        String author = sc.nextLine();

        System.out.print("isbn: ");
        int isbn = sc.nextInt();

        Book nuevoLibro = new Book(title, author, isbn);
        bookRepository.addBook(nuevoLibro);
    }
}


