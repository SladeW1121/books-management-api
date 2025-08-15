package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="books")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank String name;
    @NotBlank String author;
    @NotNull double price;
    @NotNull private Integer code;

    public Book() {}

    public Book(String name, String author, double price, Integer code){
        this.name = name;
        this.author = author;
        this.price = price;
        this.code = code;
    }

    public Long getId(){return id;}
    public String getName(){return name;}
    public String getAuthor(){return author;}
    public double getPrice(){return price;}
    public Integer getCode(){return code;}
    public void setId(Long id){this.id = id;}
    public void setName(String name) { this.name = name; }
    public void setAuthor(String author) { this.author = author; }
    public void setPrice(Double price) { this.price = price; }
    public void setCode(Integer code) { this.code = code; }

}
