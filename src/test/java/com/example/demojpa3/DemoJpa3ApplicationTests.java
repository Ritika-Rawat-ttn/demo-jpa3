package com.example.demojpa3;

import com.example.demojpa3.entities.Address;
import com.example.demojpa3.entities.Author;
import com.example.demojpa3.entities.Book;
import com.example.demojpa3.reposss.AuthorRepo;
import com.example.demojpa3.reposss.Bookrepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class DemoJpa3ApplicationTests {

	@Autowired
	Bookrepo bookrepo;

	@Autowired
	AuthorRepo authorRepo;



	@Test
	public void testcreate() {
		Author author=new Author();
		Book book=new Book();
		Address address=new Address();

		address.setStreetNumber(21);
		address.setLocation("Kotdwara");
		address.setState("Uttrakhand");

		author.setAuthName("Ritika");
		author.setAddress(address);


		//Q4 Persist 3 subjects for each author.
		//By this we have added to subjects
		List<String> subjects=new ArrayList<>();
		subjects.add("Maths");
		subjects.add("Science");
		subjects.add("GK");

		author.setSubjects(subjects);
		book.setBookName("Avengers");
		book.setAuthors((Set<Author>) author);


		bookrepo.save(book);
	}

	@Test
	public void testonetooneCreate() {
		Author author = new Author();
		Book book = new Book();

		List<String> subjects = new ArrayList<>();

		subjects.add("English");
		subjects.add("Hindi");
		subjects.add("DBMS");

		author.setSubjects(subjects);

		Address address = new Address();

		address.setStreetNumber(74);
		address.setLocation("Rohini");
		address.setState("Delhi");

		author.setAuthName("Riya");
		author.setAddress(address);
		book.setBookName("INTRO TO JPA");
		book.setAuthors((Set<Author>) author);

		bookrepo.save(book);
	}

	//one to many  Unidirectional


	@Test
	public void testonetomanycreate(){
		Author author=new Author();
		Address address=new Address();
		HashSet<Book> books = new HashSet<>();


		address.setStreetNumber(24);
		address.setLocation("ddun");
		address.setState("UK");

		List<String> subjects=new ArrayList<>();

		subjects.add("DBMS");
		subjects.add("TESTING");
		subjects.add("JAVA");

		author.setSubjects(subjects);

		author.setAuthName("Iqra");
		author.setAddress(address);

		Book book1=new Book();
		Book book2=new Book();
		Book book3=new Book();

		book1.setBookName("Operating system");
		books.add(book1);
		book2.setBookName("Spring Framework");
		books.add(book2);
		book3.setBookName("React");
		books.add(book3);

		author.setBook(books);

		authorRepo.save(author);

	}

	//One to Many BiDirectional

	@Test
	public void testonetomanyCreate(){

		Author author=new Author();
		Address address=new Address();

		address.setStreetNumber(24);
		address.setLocation("ddun");
		address.setState("UK");

		List<String> subjects=new ArrayList<>();

		subjects.add("DBMS");
		subjects.add("TESTING");
		subjects.add("JAVA");

		author.setSubjects(subjects);
		author.setAuthName("SAURABH");
		author.setAddress(address);

		Book book1=new Book();
		Book book2=new Book();

		book1.setBookName("INTRO TO DATABASES");
		book2.setBookName("CORE");

		author.addBooks(book1);
		author.addBooks(book2);

		authorRepo.save(author);
	}

	//Many to Many

	@Test
	@Rollback(value = true)
	public void testmanytomanyCreate(){

		Author author1=new Author();
		Address address1=new Address();

		Set<Author> authors=new HashSet<Author>();
		Set<Book> books=new HashSet<Book>();
		Set<Book> books2=new HashSet<Book>();

		address1.setStreetNumber(24);
		address1.setLocation("ddun");
		address1.setState("UK");

		List<String> subjects1=new ArrayList<>();

		subjects1.add("INTRO TO DATABASES");
		subjects1.add("JAVA");
		subjects1.add("CORE");

		author1.setSubjects(subjects1);
		author1.setAuthName("SAURABH");
		author1.setAddress(address1);

		Author author2=new Author();
		Address address2=new Address();

		address2.setStreetNumber(11);
		address2.setLocation("Delhi");
		address2.setState("Delhi");

		List<String> subjects2=new ArrayList<>();

		subjects2.add("Math");
		subjects2.add("flux");
		subjects2.add("version control");

		author2.setSubjects(subjects2);
		author2.setAuthName("Ritika");
		author2.setAddress(address2);

		authors.add(author1);
		authors.add(author2);

		Book book1=new Book();
		Book book2=new Book();

		book1.setBookName("Rest-webservice");
		book2.setBookName("Spring Security");

		Book book3=new Book();
		Book book4=new Book();

		book3.setBookName("2 states");
		book4.setBookName("NewersWorld");

		books.add(book1);
		books.add(book2);
		books.add(book3);
		books2.add(book4);
		books2.add(book3);

		author1.setBook(books);
		author2.setBook(books2);


		List<Author> authorList = new ArrayList<>();
		authorList.add(author1);
		authorList.add(author2);
		authorRepo.saveAll(authorList);

	}



}
