package com.dev801.tnt.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev801.tnt.data.User;
import com.dev801.tnt.data.UserRole;
import com.dev801.tnt.data.UserRole.ROLE;
import com.dev801.tnt.repositories.UserRolesRepository;
import com.dev801.tnt.repositories.UsersRepository;

@Controller
public class RegisterController {
	private static final Logger LOGGER = Logger.getLogger(RegisterController.class);

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	UserRolesRepository userRolesRepository;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result) {
		LOGGER.info("Creating a new user: " + user.getUsername());

		BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
		LOGGER.info("Password: " + user.getPassword() + " :: " + bcryptEncoder.encode(user.getPassword()));
		user.setPassword(bcryptEncoder.encode(user.getPassword()));

		user.setEnabled(false);
		user.setShowDetails(false);
		user.setDateAdded(new Date());
		usersRepository.save(user);

		UserRole userRole = new UserRole();
		userRole.setUsername(user.getUsername());
		userRole.setRole(ROLE.ROLE_USER);
		userRolesRepository.save(userRole);

		LOGGER.info("User and role created: " + user.getId() + " :: " + userRole.getId());

		return "redirect:/?requestmembership";
	}
}
