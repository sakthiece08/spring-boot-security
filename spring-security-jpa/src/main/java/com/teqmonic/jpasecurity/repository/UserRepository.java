package com.teqmonic.jpasecurity.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.teqmonic.jpasecurity.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUserName(String userName);

}
