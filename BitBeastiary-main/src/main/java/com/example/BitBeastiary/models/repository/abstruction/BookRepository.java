package com.example.BitBeastiary.models.repository.abstruction;
import com.example.BitBeastiary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

    @Repository
    public interface BookRepository extends JpaRepository<Book, Long> {
        List<Book> findByAuthor(String author);
        List<Book> findByCategoryOrGenre(String categoryOrGenre);
        // Altri metodi personalizzati se necessario.

        List<Book> findByName(String name);
        List<Book> findByNationality(String nationality);
        int countByAuthor(String author);
        List<Book> findByNameContainingOrAuthorContaining(String keyword1, String keyword2);

            List<Book> findAll();


            // Metodo per salvare un nuovo libro
            <S extends Book> S save(S entity);

            // Metodo per eliminare un libro per ID
            void deleteById(Long id);
        }








