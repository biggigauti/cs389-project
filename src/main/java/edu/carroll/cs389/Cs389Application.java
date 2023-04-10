package edu.carroll.cs389;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Runs the application.
 *
 * The @SpringBootApplication annotation acts as @Configuration, @EnableAutoConfiguration,
 * and @ComponentScan.
 */
@SpringBootApplication
public class Cs389Application {

	public static void main(String[] args) {
		SpringApplication.run(Cs389Application.class, args);
	}

}
