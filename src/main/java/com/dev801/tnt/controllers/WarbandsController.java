package com.dev801.tnt.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev801.tnt.data.Warband;
import com.dev801.tnt.helpers.ProjectHelpers;

@Controller
public class WarbandsController extends ControllerHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(WarbandsController.class);

	@GetMapping(value = "/warbands")
	public String getWarbands(Model model, HttpSession session) {
		LOGGER.info("Getting warbands for user: " + getUser());

		model.addAttribute(ProjectHelpers.WARBANDS_ATTRIBUTE,
				warbandsRepository.findWarbandsByUserId(getUser().getId()));

		return ProjectHelpers.WARBANDS_PAGE;
	}

	@PostMapping(value = "/warbands/{warbandId}")
	public String deleteWarband(Model model, HttpSession session,
			@PathVariable(value = "warbandId") Integer warbandId) {
		LOGGER.info("Deleting warband id: " + warbandId);

		Integer userId = getUser().getId();
		Warband warband = warbandsRepository.findById(warbandId).orElse(null);

		if (warband != null && warband.getUserId().equals(userId)) {
			warbandsRepository.delete(warband);
		}

		return "redirect:/" + ProjectHelpers.WARBANDS_PAGE;
	}
}
