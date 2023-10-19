package com.teqmonic.jpasecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.teqmonic.jpasecurity.entity.Product;
import com.teqmonic.jpasecurity.entity.User;
import com.teqmonic.jpasecurity.repository.ProductRepository;
import com.teqmonic.jpasecurity.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJpaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		System.out.println("Adding default products to DB...");
		return arg -> {
			productRepository.save(new Product("Computer", "Desktop", "An electronic product"));
			productRepository.save(new Product("Laptop", "Desktop", "A portable electronic product"));
			userRepository.save(new User("sakthi", passwordEncoder.encode("password"), "ROLE_USER"));
			userRepository.save(new User("admin", passwordEncoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));
		};
	}

}
