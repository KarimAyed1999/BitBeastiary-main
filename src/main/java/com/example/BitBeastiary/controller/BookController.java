package com.example.BitBeastiary.controller;
import com.example.BitBeastiary.dtos.BookDto;
import com.example.BitBeastiary.models.Book;
import com.example.BitBeastiary.models.service.abstraction.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/books") // Modifica il percorso principale per i libri
public class BookController {

    private BookService bookService; // Assumiamo che tu abbia un servizio chiamato BookService per i libri

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Metodo per ottenere tutti i libri
    @GetMapping
    public ResponseEntity<Iterable<BookDto>> getAllBooks() {
        List<BookDto> bookDtoList = new ArrayList<>();

        // Ottieni la lista di tutti i libri dal servizio
        var books = bookService.getAllBooks();

        // Itera su ciascun libro e crea un DTO per ciascuno
        for (Book book : books) {
            BookDto bookDto = new BookDto(book.getId(), book.getName(), book.getAuthor(), book.getCategoryOrGenre(), book.getNationality(), book.getPublicationDate(), book.getComment(), book.getPages());
            bookDtoList.add(bookDto);
        }

        // Restituisci la lista di DTO dei libri con uno status HTTP OK
        return new ResponseEntity<>(bookDtoList, HttpStatus.OK);
    }

    // Metodo per trovare un libro per ID
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable long id) {
        // Trova un libro per ID utilizzando il servizio
        Optional<Book> bookOptional = bookService.getBookById(id);

        // Verifica se il libro è stato trovato o no
        if (bookOptional.isEmpty()) {
            // Se non è stato trovato, restituisci uno status HTTP NOT FOUND
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // Se il libro è stato trovato, crea un DTO per il libro e restituiscilo con uno status HTTP OK
        Book book = bookOptional.get();
        BookDto bookDto = new BookDto(book.getId(), book.getName(), book.getAuthor(), book.getCategoryOrGenre(), book.getNationality(), book.getPublicationDate(), book.getComment(), book.getPages());
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    // Metodo per creare un nuovo libro
    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        Book book = bookDto.toBook();
        bookService.createBook(book);
        BookDto createdBookDto = new BookDto(book.getId(), book.getName(), book.getAuthor(), book.getCategoryOrGenre(), book.getNationality(), book.getPublicationDate(), book.getComment(), book.getPages());
        return new ResponseEntity<>(createdBookDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        // Verifica se il libro esiste prima di eliminarlo
        if (!bookService.bookExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@RequestBody BookDto bookDto, @PathVariable long id) {
        // Verifica se il libro esiste prima di aggiornarlo
        if (!bookService.bookExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Book book = bookDto.toBook();
        book.setId(id); // Assumiamo che l'ID del libro non debba essere modificato
        bookService.updateBook(book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
