package com.jpa.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entities.User;
//CrudRepository will provide basic functionaliy
public interface UserRepository extends CrudRepository<User, Integer>{

}
