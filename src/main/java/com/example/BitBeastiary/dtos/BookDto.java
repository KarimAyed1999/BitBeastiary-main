package com.example.BitBeastiary.dtos;

import com.example.BitBeastiary.models.Book;

import java.time.LocalDate;
import java.util.Date;

public class BookDto {
    private long id; // ID del libro
    private String name; // Nome del libro
    private String author; // Autore del libro
    private String categoryOrGenre; // Categoria o genere del libro
    private String nationality; // Nazionalità dell'autore
    private Date publicationDate; // Data di pubblicazione del libro
    private String comment; // Commento sul libro
    private int pages; // Numero di pagine del libro

    // Costruttore per inizializzare gli attributi
    public BookDto(long id, String name, String author, String categoryOrGenre, String nationality, Date publicationDate, String comment, int pages) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.categoryOrGenre = categoryOrGenre;
        this.nationality = nationality;
        this.publicationDate = publicationDate;
        this.comment = comment;
        this.pages = pages;
    }

    // Costruttore vuoto
    public BookDto() {
    }

    // Costruttore da un oggetto Book
    public BookDto(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.categoryOrGenre = book.getCategoryOrGenre();
        this.nationality = book.getNationality();
        this.publicationDate = book.getPublicationDate();
        this.comment = book.getComment();
        this.pages = book.getPages();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategoryOrGenre(String categoryOrGenre) {
        this.categoryOrGenre = categoryOrGenre;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategoryOrGenre() {
        return categoryOrGenre;
    }

    public String getNationality() {
        return nationality;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getComment() {
        return comment;
    }

    public int getPages() {
        return pages;
    }

    public Book toBook() {
        Book book = new Book(id, name, author, categoryOrGenre, nationality, publicationDate, pages, comment);
        return book;
    }
}
