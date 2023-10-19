package com.teqmonic.jpasecurity.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Product name is required")
	@Column(name = "name")
	private final String name;

	@NotBlank(message = "Product type is required")
	@Column(name = "type")
	private final String type;

	@NotBlank(message = "Product description is required")
	@Column(name = "description")
	private final String description;

	@Column(name = "created_on", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdOn;
	
}
