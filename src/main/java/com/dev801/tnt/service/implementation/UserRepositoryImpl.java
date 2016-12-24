package com.dev801.tnt.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev801.tnt.data.User;
import com.dev801.tnt.repositories.UsersRepository;
import com.dev801.tnt.service.UsersService;

@Service
public class UserRepositoryImpl implements UsersService {
	@Autowired
	private UsersRepository userRepository;

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
}
