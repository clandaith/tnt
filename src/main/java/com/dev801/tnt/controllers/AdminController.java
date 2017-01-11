package com.dev801.tnt.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev801.tnt.data.User;
import com.dev801.tnt.repositories.UsersRepository;

@Controller
public class AdminController extends ControllerHelper {
	private static final Logger LOGGER = Logger.getLogger(AdminController.class);

	@Autowired
	UsersRepository usersRepository;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		LOGGER.info("getAllUsers ::  User: " + SecurityContextHolder.getContext().getAuthentication().getName());

		model.addAttribute("users", usersRepository.findAll());

		return "admin";
	}

	@RequestMapping(value = "/admin/enable/{id}", method = RequestMethod.GET)
	public String enableUser(Model model, @PathVariable(value = "id") Integer userId) {
		LOGGER.info("enableUser ::  User: " + SecurityContextHolder.getContext().getAuthentication().getName());

		User user = usersRepository.findOne(userId);
		if (user == null) {
			model.addAttribute("message", "User id '" + userId + "' doesn't exist.");
		} else {
			user.setEnabled(!user.getEnabled());
			usersRepository.save(user);
			model.addAttribute("message", "'" + user.getUsername() + "' has been enabled.");
		}

		model.addAttribute("users", usersRepository.findAll());

		return "admin";
	}

	@RequestMapping(value = "/admin/showdetails/{id}", method = RequestMethod.GET)
	public String showDetails(Model model, @PathVariable(value = "id") Integer userId) {
		LOGGER.info("showDetails ::  User: " + SecurityContextHolder.getContext().getAuthentication().getName());

		User user = usersRepository.findOne(userId);
		if (user == null) {
			model.addAttribute("message", "User id '" + userId + "' doesn't exist.");
		} else {
			user.setShowDetails(!user.getShowDetails());
			usersRepository.save(user);
			model.addAttribute("message", "'" + user.getUsername() + "' has been set to show details.");
		}

		model.addAttribute("users", usersRepository.findAll());

		return "admin";
	}

	@RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(Model model, @PathVariable(value = "id") Integer userId) {
		LOGGER.info("deleteUser ::  User: " + SecurityContextHolder.getContext().getAuthentication().getName());

		User user = usersRepository.findOne(userId);
		if (user == null) {
			model.addAttribute("message", "User id '" + userId + "' doesn't exist.");
		} else {
			user.setEnabled(true);
			usersRepository.delete(user);
			model.addAttribute("message", "'" + user.getUsername() + "' has been deleted.");
		}
		model.addAttribute("users", usersRepository.findAll());

		return "admin";
	}
}
