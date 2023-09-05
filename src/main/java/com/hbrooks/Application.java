package com.hbrooks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Value("${REAL_TIME_TRAIN_USERNAME}")
	private String name;
	@Value("${REAL_TIME_TRAIN_PASSWORD}")
	private String password;

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner runner(){
		return args -> {

			System.out.println(name);
			System.out.println(password);
		};
	}


}
