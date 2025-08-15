package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RequestBook {
    @NotBlank String nameReqBook;
    @NotBlank String authorReqBook;
    @NotNull double priceReqBook;
    @NotNull private Integer codeReqBook;

    public RequestBook(String nameReqBook, String authorReqBook, double priceReqBook, Integer codeReqBook){
        this.nameReqBook = nameReqBook;
        this.authorReqBook = authorReqBook;
        this.priceReqBook = priceReqBook;
        this.codeReqBook = codeReqBook;
    }

    public String getNameReqBook(){return nameReqBook;}
    public String getAuthorReqBook(){return authorReqBook;}
    public double getPriceReqBook(){return priceReqBook;}
    public Integer getCodeReqBook(){return codeReqBook;}
}
