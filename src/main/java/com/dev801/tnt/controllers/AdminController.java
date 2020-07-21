package com.dev801.tnt.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dev801.tnt.data.User;
import com.dev801.tnt.repositories.UsersRepository;

@Controller
public class AdminController extends ControllerHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	private static final String ADMIN = "admin";
	private static final String MESSAGE = "message";
	private static final String USERS = "users";
	private static final String USER_ID = "User id '";
	private static final String DOESNT_EXIST = "' doesn't exist.";

	@Autowired
	UsersRepository userRepository;

	@GetMapping(value = "/admin")
	public String getAllUsers(Model model) {
		LOGGER.info("getAllUsers ::  User: " + SecurityContextHolder.getContext().getAuthentication().getName());

		model.addAttribute(USERS, userRepository.findAll());

		return ADMIN;
	}

	@GetMapping(value = "/admin/enable/{id}")
	public String enableUser(Model model, @PathVariable(value = "id") Integer userId) {
		LOGGER.info("enableUser ::  User: " + SecurityContextHolder.getContext().getAuthentication().getName());

		User user = userRepository.findById(userId).orElse(null);
		if (user == null) {
			model.addAttribute(MESSAGE, USER_ID + userId + DOESNT_EXIST);
		} else {
			user.setEnabled(!user.getEnabled());
			userRepository.save(user);
			model.addAttribute(MESSAGE, "'" + user.getUsername() + "' has been enabled.");
		}

		model.addAttribute(USERS, userRepository.findAll());

		return ADMIN;
	}

	@GetMapping(value = "/admin/showdetails/{id}")
	public String showDetails(Model model, @PathVariable(value = "id") Integer userId) {
		LOGGER.info("showDetails ::  User: " + SecurityContextHolder.getContext().getAuthentication().getName());

		User user = userRepository.findById(userId).orElse(null);
		if (user == null) {
			model.addAttribute(MESSAGE, USER_ID + userId + DOESNT_EXIST);
		} else {
			user.setShowDetails(!user.getShowDetails());
			userRepository.save(user);
			model.addAttribute(MESSAGE, "'" + user.getUsername() + "' has been set to show details.");
		}

		model.addAttribute(USERS, userRepository.findAll());

		return ADMIN;
	}

	@GetMapping(value = "/admin/delete/{id}")
	public String deleteUser(Model model, @PathVariable(value = "id") Integer userId) {
		LOGGER.info("deleteUser ::  User: " + SecurityContextHolder.getContext().getAuthentication().getName());

		User user = userRepository.findById(userId).orElse(null);
		if (user == null) {
			model.addAttribute(MESSAGE, USER_ID + userId + DOESNT_EXIST);
		} else {
			user.setEnabled(true);
			userRepository.delete(user);
			model.addAttribute(MESSAGE, "'" + user.getUsername() + "' has been deleted.");
		}
		model.addAttribute(USERS, userRepository.findAll());

		return ADMIN;
	}
}
