package com.dev801.tnt.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev801.tnt.data.User;

@Controller
@RequestMapping(value = "/userinfo")
public class UserController extends ControllerHelper {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String getUser(Model model, HttpSession session) {

		User user = getUser(session);
		user.setPassword("");
		user.setPassword2("");
		user.setCurrentPassword("");

		model.addAttribute("user", user);

		return "userinfo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String updateUser(Model model, User user, HttpSession session) {

		User repoUser = getUser(session);
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
