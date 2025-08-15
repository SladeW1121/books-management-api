package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.Book;
import org.example.repository.RepositoryBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBook {
    private final RepositoryBook repositoryBook;

    public ServiceBook(RepositoryBook repositoryBook){
        this.repositoryBook = repositoryBook;
    }

    @Transactional
    public List<Book> showAllBooksService(){ return repositoryBook.findAll();}

    @Transactional
    public void addNewBookService(Book newBook){ repositoryBook.save(newBook);}

    @Transactional
    public boolean deleteBookService(String bookName, String authorName) {
        long rows = repositoryBook
                .deleteByNameIgnoreCaseAndAuthorIgnoreCase(bookName, authorName);
        return rows > 0; // true dacă a șters cel puțin un rând
    }

    @Transactional
    public Book showSpecificBookService(String bookName, String authorName){
        return repositoryBook.findByNameIgnoreCaseAndAuthorIgnoreCase(bookName, authorName).orElse(null);
    }

}
