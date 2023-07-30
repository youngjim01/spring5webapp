package com.foobar42.springwebapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.foobar42.springwebapp.domain.Author;
import com.foobar42.springwebapp.domain.Book;
import com.foobar42.springwebapp.domain.Publisher;
import com.foobar42.springwebapp.repositories.AuthorRepository;
import com.foobar42.springwebapp.repositories.BookRepository;
import com.foobar42.springwebapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        
        Publisher oreilly = new Publisher(  "O'Reilly Media", 
                                    "1005 Gravenstein Highway North", 
                                    "Sebastopol", "CA", "95472");

        publisherRepository.save(oreilly);

        Author eric = new Author ("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(oreilly);
        oreilly.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(oreilly);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(oreilly);
        oreilly.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(oreilly);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Books by " + oreilly.getName() + ": " + oreilly.getBooks().size());
    }
    
}
