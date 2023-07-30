package com.foobar42.springwebapp.repositories;

import com.foobar42.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
    
}
