package com.example.BitBeastiary.models.service.abstraction;

import com.example.BitBeastiary.models.Book;

import java.util.List;
import java.util.Optional;



public interface BookService {


    // Metodo per ottenere tutti i libri
    Iterable<Book> getAllBooks() ;



    // Metodo per ottenere un libro per ID
     Optional<Book> getBookById(long id)
        ;


    // Implementazione del metodo per trovare un libro per ID
    Optional<Book> getBookById(Long id);

    // Metodo per creare un nuovo libro
     Book createBook(Book book) ;


    // Metodo per aggiornare un libro
     void updateBook(Book book) ;



    // Metodo per eliminare un libro per ID
    void deleteBook(Long id) ;



    // Metodo per verificare se un libro esiste
    boolean bookExists(Long id) ;


}
