package com.dev801.tnt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dev801.tnt.data.User;

public interface UsersRepository extends CrudRepository<User, Integer> {

}
