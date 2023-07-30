package com.foobar42.springwebapp.repositories;

import com.foobar42.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{
    
}
