package com.dev801.tnt.controllers;

import java.util.Optional;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev801.tnt.data.Warband;
import com.dev801.tnt.helpers.ProjectHelpers;

import jakarta.servlet.http.HttpSession;

@Controller
public class WarbandsController extends ControllerHelper {
	private static final Logger LOGGER = LogManager.getLogger(WarbandsController.class);

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
		Optional<Warband> warband = warbandsRepository.findById(warbandId);

		if (warband.isPresent() && warband.get().getUserId().equals(userId)) {
			warbandsRepository.delete(warband.get());
		}

		return "redirect:/" + ProjectHelpers.WARBANDS_PAGE;
	}
}
