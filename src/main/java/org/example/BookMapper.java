package org.example;

import org.example.dto.RequestBook;
import org.example.dto.ResponseBook;
import org.example.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book reqToEntity(RequestBook requestBook){
        return new Book(requestBook.getNameReqBook(),requestBook.getAuthorReqBook(),requestBook.getPriceReqBook(),requestBook.getCodeReqBook());
    }

    public ResponseBook entityToResponse(Book book){
        return new ResponseBook( book.getName(),book.getAuthor(),book.getPrice());
    }

}
