package com.jpa.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;


@SpringBootApplication
public class BootjpaexamplesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexamplesApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		/*
		 * User user=new User(); user.setName("Furquan Ansaeri"); user.setCity("Akola");
		 * user.setStatus("Java Developer"); User user1 = userRepository.save(user);
		 * System.out.println(user1);
		 */
		
		//Create object for user
		/*
		 * User user1=new User(); user1.setName("Uttam"); user1.setCity("City1");
		 * user1.setStatus("Python programmer");
		 * 
		 * User user2=new User(); user2.setName("Ankiy"); user2.setCity("City2");
		 * user2.setStatus("Java programmer");
		 */
		//#####saving single user#####
		//User resultUser = userRepository.save(user2);
		//System.out.println("Saved user" +resultUser);
		/*
		 * List<User> users=new ArrayList<User>(); users.add(user1); users.add(user2);
		 */
		//####saving Multiple user####
		/*
		 * Iterable<User> result = userRepository.saveAll(users); result.forEach(user->{
		 * System.out.println(user); }); System.out.println("done");
		 */
		
		//#### update user having id=5#####
		/*
		 * Optional<User> optional = userRepository.findById(5); User user =
		 * optional.get(); user.setName("Ankit Tiwari"); User result =
		 * userRepository.save(user); System.out.println(result);
		 */
		
		//#### How to get Data####
		//findById(id)- return optional containing your data
		//Iterable<User> itr = userRepository.findAll();
		/*
		 * Iterator<User> iterator = itr.iterator(); while(iterator.hasNext()) { User
		 * user=iterator.next(); System.out.println(user); }
		 */
		
		/*
		 * itr.forEach(new Consumer<User>() {
		 * 
		 * @Override public void accept(User t) { // TODO Auto-generated method stub
		 * System.out.println(t); }
		 * 
		 * });
		 */
		//itr.forEach(user->{System.out.println(user);});
		
		//####Deleting single user element####
		/*
		 * userRepository.deleteById(5); System.out.println("Deleted");
		 */
		
		//####Deleting Multiple users element####
		/*
		 * Iterable<User> allUsers = userRepository.findAll();
		 * allUsers.forEach(users->System.out.println(users));
		 * userRepository.deleteAll(allUsers);
		 */
		
		//####get user based on name####
		/*
		 * List<User> users = userRepository.findByName("Uttam");
		 * users.forEach(e->System.out.println(e));
		 */
		
		//####get user based on name and city####
		/*
		 * List<User> users = userRepository.findByNameAndCity("Uttam", "City1");
		 * users.forEach(e->System.out.println(e));
		 */
		
		/*
		 * List<User> allUser = userRepository.getAllUser();
		 * allUser.forEach(e->System.out.println(e));
		 */
		
		/*
		 * List<User> userByName = userRepository.getUserByName("Uttam");
		 * userByName.forEach(e->System.out.println(e));
		 */
		
		/*
		 * List<User> userByNameAndCity =
		 * userRepository.getUserByNameAndCity("Uttam","City1");
		 * userByNameAndCity.forEach(e->System.out.println(e));
		 */
		
		List<User> allUser = userRepository.getUsers();
		allUser.forEach(e->System.out.println(e));
		}

}
