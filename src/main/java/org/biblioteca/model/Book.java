package org.biblioteca.model;

public class Book {
    private int idbook;
    private String title;
    private String author;
    private String description;
    private String isbn;
    private String genre;

    public Book (int idbook, String title, String author, String description, String isbn, String genre) {
        this.idbook = idbook;
        this.title = title;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
        this.genre = genre;
    }

    public Book(String title, String author, int isbn) {
    }

    public int getIdbook() {
        return idbook;
    }

    public void setIdbook(int idbook) {
        this.idbook = idbook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
