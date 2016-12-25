package com.dev801.tnt.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev801.tnt.data.Warband;
import com.dev801.tnt.helpers.ProjectHelpers;

@Controller
public class WarbandsController extends ControllerHelper {
	private static final Logger LOGGER = Logger.getLogger(WarbandsController.class);

	@RequestMapping(value = "/warbands", method = RequestMethod.GET)
	public String getWarbands(Model model, HttpSession session) {
		LOGGER.info("Getting warbands for user: " + getUser(session));

		model.addAttribute(ProjectHelpers.WARBANDS_ATTRIBUTE, warbandsRepository.findWarbandsByUserId(getUser(session).getId()));

		return ProjectHelpers.WARBANDS_PAGE;
	}

	@RequestMapping(value = "/warbands/{warbandId}", method = RequestMethod.POST)
	public String deleteWarband(Model model, HttpSession session, @PathVariable(value = "warbandId") Integer warbandId) {
		LOGGER.info("Deleting warband id: " + warbandId);

		Integer userId = getUser(session).getId();
		Warband warband = warbandsRepository.findOne(warbandId);

		if (warband != null && warband.getUserId().equals(userId)) {
			warbandsRepository.delete(warband);
		}

		return "redirect:/" + ProjectHelpers.WARBANDS_PAGE;
	}
}
