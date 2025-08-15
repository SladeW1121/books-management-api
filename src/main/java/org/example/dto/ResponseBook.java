package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ResponseBook {
    @NotBlank String nameResBook;
    @NotBlank String authorResBook;
    @NotNull double priceResBook;

    public ResponseBook(String nameResBook, String authorResBook, double priceResBook){
        this.nameResBook = nameResBook;
        this.authorResBook = authorResBook;
        this.priceResBook = priceResBook;
    }

    public String getNameResBook(){return nameResBook;}
    public String getAuthorResBook(){return authorResBook;}
    public double getPriceResBook(){return priceResBook;}
}
