package com.example.demojpa3.reposss;

import com.example.demojpa3.entities.Book;
import org.springframework.data.repository.CrudRepository;



//Created repo for book
public interface Bookrepo extends CrudRepository<Book,Integer> {
}








//Q-8Which method on the session object can be used to remove an object from the cache?
//Ans-Session.clear() method is used to remove all cached objects associated with the session.



//Q-9 What does @transactional annotation do?
// Ans- transaction management code needs to be explicitly written so as to commit when everything is successful and rolling back if anything goes wrong.
// The transaction management code is tightly bound to the business logic in this case.
// By using @Transactional, many important aspects such as transaction propagation are handled automatically.
