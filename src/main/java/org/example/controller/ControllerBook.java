package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.example.BookMapper;
import org.example.dto.ResponseBook;
import org.example.model.Book;
import org.example.dto.RequestBook;
import org.example.service.ServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.List;

@RestController
@Validated
@RequestMapping("/books")
public class ControllerBook {
    private final ServiceBook serviceBook;
    private final BookMapper mapper;

    @Autowired
    public ControllerBook(ServiceBook serviceBook, BookMapper mapper){this.serviceBook = serviceBook; this.mapper = mapper;}

    //show all books
    @GetMapping("/")
    public ResponseEntity<List<ResponseBook>> showAllBooksController(){
        List<ResponseBook> list = serviceBook.showAllBooksService().stream().map(mapper::entityToResponse).toList();
        return ResponseEntity.ok(list);
    }

    //add new book
    @PostMapping("/")
    public ResponseEntity<?> addNewBookController(@RequestBody @Valid RequestBook requestBook){
        Book book = mapper.reqToEntity(requestBook);
        serviceBook.addNewBookService(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book added.");
    }

    //select book
    @GetMapping("/{bookName}/{authorName}")
    public ResponseEntity<?> showSpecificBookController(@PathVariable @NotBlank String bookName, @PathVariable @NotBlank String authorName){
        Book book = serviceBook.showSpecificBookService(bookName,authorName);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
        ResponseBook resBook = mapper.entityToResponse(book);
        return ResponseEntity.ok(resBook);
    }

    //delete book
    @DeleteMapping("/{bookName}/{authorName}")
    public ResponseEntity<Void> deleteBookController(@PathVariable String bookName, @PathVariable String authorName) {
        boolean deleted = serviceBook.deleteBookService(bookName, authorName);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }



}
