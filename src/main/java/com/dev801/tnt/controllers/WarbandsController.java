package com.dev801.tnt.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WarbandsController extends ControllerHelper {
	private static final Logger LOGGER = Logger.getLogger(WarbandsController.class);

	@RequestMapping(value = "/warbands", method = RequestMethod.GET)
	public String getWarbands(Model model, HttpSession session) {
		LOGGER.info("Getting warbands for user: " + getUser(session));

		model.addAttribute("warbands", warbandsRepository.findWarbandsByUserId(getUser(session).getId()));

		return "warbands";
	}

	@RequestMapping(value = "/warbands", method = RequestMethod.POST)
	public String deleteWarband() {
		return "redirect/warbands?deleted";
	}
}
