package com.example.BitBeastiary.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity @Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String author;
    private String categoryOrGenre;
    private String nationality;
    private Date pubblicationDate;
    private String comment;
    private int pages;

    public Book() {
    }

    public Book(long id , String name , String author , String categoryOrGenre , String nationality , Date pubblicationDate , int pages , String comment) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.categoryOrGenre = categoryOrGenre;
        this.nationality = nationality ;
        this.pubblicationDate = pubblicationDate;
        this.pages  = pages ;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID='" + id + '\'' +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", categoryOrGenre='" + categoryOrGenre + '\'' +
                ", nationality='" + nationality + '\'' +
                ", pubblicationDate=" + pubblicationDate +
                ", pages=" + pages +
                ", comment='" + comment + '\'' +
                '}';
    }
}
