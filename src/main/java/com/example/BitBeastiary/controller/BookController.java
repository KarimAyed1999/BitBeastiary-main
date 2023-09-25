package com.example.BitBeastiary.controller;

import com.example.BitBeastiary.models.Book;
import com.example.BitBeastiary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //Get a book by ID
    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Libro non trovato con ID: " + id));
    }

    //Add new book
    @PostMapping(path="/create" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    //Update exsisting book
    @PutMapping("/update")
    public Book updateBook(@RequestBody Book updatedBook) {
        Book book = bookRepository.findById(updatedBook.getId())
                .orElseThrow(() -> new IllegalArgumentException("Libro non trovato con ID: " + updatedBook.getId()));

        book.setName(updatedBook.getName());
        book.setAuthor(updatedBook.getAuthor());
        // Aggiorna gli altri campi di interesse

        return bookRepository.save(book);
    }

    //Delete exsisting book
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

}
