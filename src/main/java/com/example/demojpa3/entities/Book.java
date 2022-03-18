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
