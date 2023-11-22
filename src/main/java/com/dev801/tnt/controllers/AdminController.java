package com.dev801.tnt.controllers;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

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

		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			model.addAttribute(MESSAGE, USER_ID + userId + DOESNT_EXIST);
		} else {
			user.get().setEnabled(!user.get().getEnabled());
			userRepository.save(user.get());
			model.addAttribute(MESSAGE, "'" + user.get().getUsername() + "' has been enabled.");
		}

		model.addAttribute(USERS, userRepository.findAll());

		return ADMIN;
	}

	@GetMapping(value = "/admin/showdetails/{id}")
	public String showDetails(Model model, @PathVariable(value = "id") Integer userId) {
		LOGGER.info("showDetails ::  User: " + SecurityContextHolder.getContext().getAuthentication().getName());

		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			model.addAttribute(MESSAGE, USER_ID + userId + DOESNT_EXIST);
		} else {
			user.get().setShowDetails(!user.get().getShowDetails());
			userRepository.save(user.get());
			model.addAttribute(MESSAGE, "'" + user.get().getUsername() + "' has been set to show details.");
		}

		model.addAttribute(USERS, userRepository.findAll());

		return ADMIN;
	}

	@GetMapping(value = "/admin/delete/{id}")
	public String deleteUser(Model model, @PathVariable(value = "id") Integer userId) {
		LOGGER.info("deleteUser ::  User: " + SecurityContextHolder.getContext().getAuthentication().getName());

		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			model.addAttribute(MESSAGE, USER_ID + userId + DOESNT_EXIST);
		} else {
			user.get().setEnabled(true);
			userRepository.delete(user.get());
			model.addAttribute(MESSAGE, "'" + user.get().getUsername() + "' has been deleted.");
		}
		model.addAttribute(USERS, userRepository.findAll());

		return ADMIN;
	}
}
