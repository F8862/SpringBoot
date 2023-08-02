package com.jdbc;

import com.jdbc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class BootjdbcexampleApplication implements CommandLineRunner {
	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(BootjdbcexampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.userDao.createtable());
		//craeting user
		this.createuser();
	}
	public void  createuser() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user ID:");
		Integer userId=Integer.parseInt(br.readLine());

		System.out.println("Enter user Name:");
		String name=br.readLine();

		System.out.println("Enter user age:");
		Integer age=Integer.parseInt(br.readLine());

		System.out.println("Enter user city:");
		String city=br.readLine();

		int i=this.userDao.insertUser(userId,name,age,city);
		System.out.println(i+ "User added");
	}


}
