package com.teqmonic.jpasecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teqmonic.jpasecurity.entity.Product;
import com.teqmonic.jpasecurity.repository.ProductRepository;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductRepository repository;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/products")
	public Iterable<Product> getAllProducts() {
		return repository.findAll();
	}
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/product/{id}")
	public Product getPostById(@PathVariable("id") Product product) {
		//return repository.findById(id).orElseThrow();
		
		// Leveraging Domain class converter, automatically does findById for us.
		return product;
	}

}
