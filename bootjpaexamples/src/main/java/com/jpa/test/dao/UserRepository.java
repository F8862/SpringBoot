package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.User;
//CrudRepository will provide basic functionaliy
public interface UserRepository extends CrudRepository<User, Integer>{
	public List<User> findByName(String name);
	
	public List<User> findByNameAndCity(String name,String city);
	
	@Query("select u FROM User u")//JPQL
	public List<User> getAllUser();
	
	@Query("select u FROM User u WHERE u.name=:n")
	public List<User> getUserByName(@Param("n") String name);//@Param will bind the name to n and pass it in query

	@Query("select u FROM User u WHERE u.name=:n and u.city=:c")
	public List<User> getUserByNameAndCity(@Param("n") String name,@Param("c") String city);
	
	@Query(value="select * from user",nativeQuery = true)//SQL (Native query)
	public List<User> getUsers();
}
