package org.example.repository;

import org.example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface RepositoryBook extends JpaRepository<Book, Long> {
    Optional<Book> findByNameIgnoreCaseAndAuthorIgnoreCase(String name, String author);

    long deleteByNameIgnoreCaseAndAuthorIgnoreCase(String name, String author);
}
