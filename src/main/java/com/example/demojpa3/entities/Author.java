package com.example.demojpa3.entities;

import javax.persistence.*;
import java.util.*;


//Q-2Create instance variable of Address class inside Author class and save it as
//embedded object.
//Author is created instance variable cof address class and declare as embedded object
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authID;

    private String authName;


    @Embedded
     private Address address;


    @OneToOne(mappedBy = "author")
    private Book book;


//Q-8 . Implement Many to Many Mapping between Author and Book.
    //AS ManytoMany realtionships indicates that an author can write many books abd also a book can by written by many author .For this we use manytomany relationship
    //We have @ManytoMany() annotation for this relationship
    //as for this manyrelation we make new table i.e book to store respective primary key init.

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "authors_book",
            joinColumns = @JoinColumn(name="author_id",referencedColumnName = "authId"),
            inverseJoinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"))

    //Q7Implement One to Many Mapping between Author and Book(Unidirectional,
    //BiDirectional and without additional table ) and implement cascade save.
    //ANS-onetomany mapping without additional tables wi;; done as on author is able to write many book but vice versa
    //many book is written by one author.So, for this we will be implementing one to many between author to book and also its called UNIDIRECTIONAL
    //as we cannot see from book to author but an author can see many book.



    //Bi-directional bi-directional one to many mapping is that we can go from authorto book and vice versa.


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_id")
    private Set<Book> books;






    //Q3 Introduce a List of subjects for author.
    //By using @element collection collection we have list subject for author.
     @ElementCollection
     List<String> subjects = new ArrayList <String> ();

    public int getAuthID() {
        return authID;
    }

    public void setAuthID(int authID) {
        this.authID = authID;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }
     public Address getAddress(){
        return address;
     }
     public void setAddress(Address address){
        this.address=address;

     }
    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
    public Set<Book> getBooks(){
        return books;
    }
    public void setBook(Set<Book>books){
        this.books=books;
    }

    //By HashSet method we can add many book as we want in it
    public void addBooks(Book book) {
        if (book != null) {
            if (books == null) {
                books = new HashSet<>();
            }
            book.setAuthors((Set<Author>) this);
            books.add(book);
        }
    }



}
