package com.example.Labo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LaboApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(LaboApplication.class, args);
		System.out.println("c'est parti :)");
	}

}
