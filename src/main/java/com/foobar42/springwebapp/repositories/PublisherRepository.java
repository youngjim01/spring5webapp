package com.foobar42.springwebapp.repositories;

import com.foobar42.springwebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
    
}
