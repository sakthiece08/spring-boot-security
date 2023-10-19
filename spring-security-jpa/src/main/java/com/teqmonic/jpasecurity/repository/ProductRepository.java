package com.teqmonic.jpasecurity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.teqmonic.jpasecurity.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
