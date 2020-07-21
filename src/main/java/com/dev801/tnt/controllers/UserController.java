package com.dev801.tnt.controllers;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev801.tnt.data.User;

@Controller
@RequestMapping(value = "/userinfo")
public class UserController extends ControllerHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@GetMapping
	public String getUser(Model model, HttpSession session) {

		User user = getUser();
		user.setPassword("");
		user.setPassword2("");
		user.setCurrentPassword("");

		model.addAttribute("user", user);

		return "userinfo";
	}

	@PostMapping
	public String updateUser(Model model, User user, HttpSession session) {

		User repoUser = getUser();
		LOGGER.info("Repo user: " + repoUser.getUsername() + " :: " + repoUser.getEmailAddress());
		LOGGER.info("Form User: " + " :: " + user.getEmailAddress());

		if (BCrypt.checkpw(user.getCurrentPassword(), repoUser.getPassword())) {
			LOGGER.info("Passwords match");
			repoUser.setEmailAddress(user.getEmailAddress());
			repoUser.setReceiveEmail(user.getReceiveEmail());

			if (user.getPassword() != null && user.getPassword().length() > 0) {
				repoUser.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			}

			repoUser.setFirstName(user.getFirstName());
			repoUser.setLastName(user.getLastName());
			usersRepository.save(repoUser);
			model.addAttribute("message", "Your information has been updated!");
		} else {
			LOGGER.info("Passwords DO NOT match!");
			model.addAttribute("message", "Your current password is incorrect.  Please try again.");
		}

		repoUser.setCurrentPassword("");
		repoUser.setPassword("");
		repoUser.setPassword2("");
		model.addAttribute("user", repoUser);

		return "userinfo";
	}
}
