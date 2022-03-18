package com.example.demojpa3.reposss;

import com.example.demojpa3.entities.Author;
import org.springframework.data.repository.CrudRepository;


//Created repo of class author
public interface AuthorRepo extends CrudRepository <Author,Integer>{

}
