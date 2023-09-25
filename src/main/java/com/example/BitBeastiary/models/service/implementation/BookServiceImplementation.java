package com.example.BitBeastiary.models.service.implementation;

import com.example.BitBeastiary.models.Book;
import com.example.BitBeastiary.models.repository.abstruction.BookRepository;
import com.example.BitBeastiary.models.service.abstraction.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService {

    private final BookRepository repository;

    @Autowired
    public BookServiceImplementation(BookRepository repository) {
        this.repository = repository;
        System.out.println("Il repository è: " + this.repository.getClass().getName());
    }

    // Implementazione del metodo per ottenere tutti i libri
    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> getBookById(long id) {
        return Optional.empty();
    }

    // Implementazione del metodo per trovare un libro per ID
    @Override
    public Optional<Book> getBookById(Long id) {
        return repository.findById(id);
    }

    // Implementazione del metodo per creare un libro
    @Override
    public Book createBook(Book book) {
        return repository.save(book);
    }

    @Override
    public void updateBook(Book book) {

    }

    // Implementazione del metodo per eliminare un libro per ID
    @Override
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    // Implementazione del metodo per verificare se un libro esiste
    @Override
    public boolean bookExists(Long id) {
        return repository.existsById(id);
    }

    // Implementazione del metodo per aggiornare un libro
    /*@Override
    public Book updateBook(Book book) {
        return repository.save(book);
    }*/
}
