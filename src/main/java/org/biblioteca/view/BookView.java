package org.biblioteca.view;

import java.util.Scanner;
import org.biblioteca.controller.BookController;

public class BookView {
    Scanner scanner =new Scanner(System.in);
    private final BookController controller = new BookController();

    public void viewMenu() {
        System.out.println("¿Cual de las siguientes acciones quieres realizar?\n");
        System.out.println("1. Ver listado de libros");
        System.out.println("2. Añadir libro");
        System.out.println("3. Editar libro");
        System.out.println("4. Eliminar libro");
        System.out.println("5. Salir");
        System.out.println("Elige el numero de la accion que quieras realizar: ");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                showBook();
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
                System.out.println("La opcion no existe");
        }

    }
    public void showBook() {
        System.out.println("1. Lista de libros");
    }
    public void addBook() {
        System.out.println("2. Añadir libros");
    }
    public void editBook() {
        System.out.println("3. Lista de libros");
    }
    public void deleteBook() {
        System.out.println("4. Lista de libros");
    }
    public void exitApp() {
        System.out.println("5. Lista de libros");

        scanner.close();
    }
}
