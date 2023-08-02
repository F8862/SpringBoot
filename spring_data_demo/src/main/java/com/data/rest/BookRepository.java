package com.data.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//In postman when we hot url it takes 'books' as url (localhost:8585/books) which is plural of entity class
//if we want to give our custom url then we can use following annotation
@RepositoryRestResource(path = "mybooks",collectionResourceRel = "boo")//collectionResourceRel is the collection variable name
public interface BookRepository extends JpaRepository<Book,Integer> {
}
