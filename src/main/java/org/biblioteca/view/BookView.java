package org.biblioteca.view;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import org.biblioteca.controller.BookController;
import org.biblioteca.model.Book;

public class BookView {
    Scanner scanner = new Scanner(System.in);
    private final BookController bookController = new BookController();

    public void viewMenu() throws SQLException {
        System.out.println("¿Cuál de las siguientes acciones quieres realizar?");
        System.out.println("1. Ver listado de libros");
        System.out.println("2. Añadir libro");
        System.out.println("3. Editar libro");
        System.out.println("4. Eliminar libro");
        System.out.println("5. Salir");
        System.out.println("Elige el numero de la acción que quieras realizar: ");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                showBooks();
                break;
            case 2:
                addBook();
                break;
            case 3:
                editBook();
                break;
            case 4:
                deleteBook();
                break;
            case 5:
                exitApp();
                break;
            default:
                System.out.println("La opción no existe");
        }

    }
    public void showBooks() throws SQLException {
        List<Book> books = bookController.showBooks();
        for (int i=0; i<=books.toArray().length-1; i++){
            Book book = books.get(i);
            System.out.println("ID BOOK: " + book.getIdbook());
            System.out.println("TÍTULO: " + book.getTitle());
            System.out.println("AUTOR: " + book.getAuthor());
            System.out.println("DESCRIPCIÓN: " + book.getDescription());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("GÉNERO: " + book.getGenre());
            System.out.println("---------------------------");
        }
    }
    public void addBook() {
        System.out.println("2. Añadir libros");
    }
    public void editBook() throws SQLException {
        System.out.println("Introduce el ISBN del libro que quieres editar: ");
        String isbn = scanner.nextLine();
        Book book = bookController.showBook(isbn);

        if (book.getIdbook() == 0) {
            System.out.println("Libro no encontrado.");
            return;
        }
        System.out.println("Libro encontrado:");
        System.out.println("Título: " + book.getTitle());
        System.out.println("Autor: " + book.getAuthor());
        System.out.println("Descripción: " + book.getDescription());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Género: " + book.getGenre());

        System.out.println("¿Es este el libro que deseas editar? (s/n): ");
        String confirmacion = scanner.nextLine().trim().toLowerCase();

        if (!(confirmacion.equals("s") || confirmacion.equals("si") || confirmacion.equals("sí"))) {
            System.out.println("Edición cancelada.");
            return;
        }

        System.out.println("Deja en blanco los campos que no quieras modificar.");

        System.out.println("Nuevo título (actual: " + book.getTitle() + "): ");
        String title = scanner.nextLine();
        if (!title.isEmpty()) book.setTitle(title);

        System.out.println("Nuevo autor (actual: " + book.getAuthor() + "): ");
        String author = scanner.nextLine();
        if (!author.isEmpty()) book.setAuthor(author);

        System.out.println("Nueva descripción (actual: " + book.getDescription() + "): ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) book.setDescription(description);

        System.out.println("Nuevo ISBN (actual: " + book.getIsbn() + "): ");
        String newIsbn = scanner.nextLine();
        if (!newIsbn.isEmpty()) book.setIsbn(newIsbn);

        System.out.println("Nuevo género (actual: " + book.getGenre() + "): ");
        String genre = scanner.nextLine();
        if (!genre.isEmpty()) book.setGenre(genre);

        bookController.updateBook(book);
        System.out.println("Libro actualizado exitosamente!");
    }
    public void deleteBook() {
        System.out.println("4. Lista de libros");
    }
    public void exitApp() {
        System.out.println("5. Lista de libros");

        scanner.close();
    }
}
