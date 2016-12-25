package com.dev801.tnt.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dev801.tnt.data.User;

public interface UsersRepository extends CrudRepository<User, Integer> {
	@Query("select u from User u where u.username = :username")
	public User findUserByUsername(@Param("username") String username);
}
