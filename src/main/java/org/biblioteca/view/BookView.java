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
        System.out.println("El ID de tu libro es: " + book.getIdbook());
    }
    public void deleteBook() throws SQLException {
        while (true) {
            System.out.println("Introduce el ID del libro que quieres eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.println("¿Está seguro que desea borrar este libro? (s/n): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (confirm.equals("s")) {
                String result = bookController.deleteBook(id);
                System.out.println(result);
                break;
            } else if (confirm.equals("n")) {
                System.out.println("⚠ Operación cancelada. Por favor, introduce otro ID.");
            } else {
                System.out.println("⚠ Respuesta inválida. Por favor, responde con s o n.");
            }
        }
    }
    public void exitApp() {
        System.out.println("5. Lista de libros");

        scanner.close();
    }
}
