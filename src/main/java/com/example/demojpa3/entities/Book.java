package com.example.demojpa3.entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


//Q5 . Create an Entity book with an instance variable bookName
//Created entity book with instance variable bookName
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String bookName;
//Q6 Implement One to One mapping between Author and Book.
    //One to one mapping will be done  between author and book which means an can can only wirte one book and vice versa.
    //for this we will use @onetoone mapping between author and book
    @ManyToOne
    @JoinColumn(name = "auth_id")
    private Author author;


    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;

    public Author getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void addAuthors(Author author) {
        if (author != null) {
            if (authors == null) {
                authors = new HashSet<>();
            }
            author.setBook(Collections.singleton(this));
            authors.add(author);

        }
    }
}
