package com.postgres;

import com.postgres.dao.Studentdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootwithpostgresApplication implements CommandLineRunner {
	@Autowired
	private Studentdao studentdao;

	public static void main(String[] args) {
		SpringApplication.run(BootwithpostgresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//this.studentdao.createtable();
		this.studentdao.inserData("Furquan","Balapur");
	}
}
