package com.example.BitBeastiary.models.repository.abstruction;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BitBeastiary.models.Book;
@Repository
@Profile("spring")
public interface SpringJPABookRepository extends BookRepository, JpaRepository <Book,Long>{};



