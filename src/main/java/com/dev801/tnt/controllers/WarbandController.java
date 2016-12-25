package com.dev801.tnt.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev801.tnt.data.TntCharacter;
import com.dev801.tnt.data.Warband;
import com.dev801.tnt.helpers.ProjectHelpers;

@Controller
public class WarbandController extends ControllerHelper {
	private static final Logger LOGGER = Logger.getLogger(WarbandController.class);

	@RequestMapping(value = "/warband", method = RequestMethod.GET)
	public String newWarband(Model model, @RequestParam(value = "warbandId", defaultValue = "-1") Integer warbandId,
					HttpSession session) {
		LOGGER.info("Loading a warband.  User: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

		Warband warband = new Warband();

		if (warbandId > -1) {
			LOGGER.info("Getting the requested warband id: " + warbandId);

			warband = warbandsRepository.findOne(warbandId);

			if (warband == null || !warband.getUserId().equals(getUser(session).getId())) {
				LOGGER.error("User tried to get a warband that doesn't belong to them or is null.");
				model.addAttribute("returnMessage", "There was a problem getting that warband.  Please try again.");
				return ProjectHelpers.WARBANDS_PAGE;
			}
		}

		model.addAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);
		session.setAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);

		loadModelVariables(model);
		return ProjectHelpers.WARBAND_PAGE;
	}

	@RequestMapping(value = "/warband", method = RequestMethod.POST)
	public String addNewCharacter(@Valid Warband warband, BindingResult bindingResult, Model model, HttpServletRequest request,
					HttpSession session) {
		LOGGER.info("Add a character.  User: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

		warband.addTntCharacter(new TntCharacter(ProjectHelpers.getIdHolder(), "New Character"));

		session.setAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);
		model.addAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);

		loadModelVariables(model);
		return ProjectHelpers.WARBAND_PAGE;
	}

	@RequestMapping(value = "/warband", params = { "saveWarband" }, method = RequestMethod.POST)
	private String save(@Valid Warband warband, BindingResult bindingResult, Model model, HttpServletRequest request,
					HttpSession session) {
		LOGGER.info("Persist warband.  User: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

		warband.setUserId(getUser(session).getId());
		warband.setDateCreated(new Date());

		// if (bindingResult.hasErrors()) {
		// LOGGER.info("Warband has errors");
		//
		// session.setAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);
		// model.addAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);
		// model.addAttribute("returnMessage", "There was a problem saving the warband.  Please try again.");
		//
		// loadModelVariables(model);
		// return ProjectHelpers.WARBAND_PAGE;
		// }

		boolean saveSuccessful = warbandService.saveWarband(warband);

		LOGGER.info("Warband save success: " + saveSuccessful);

		return "redirect:/" + ProjectHelpers.WARBANDS_PAGE + "?saved=" + saveSuccessful;
	}

	@RequestMapping(value = "/warband", params = { "removeCharacter" }, method = RequestMethod.POST)
	public String removeCharacter(@Valid Warband warband, BindingResult bindingResult, Model model, HttpSession session,
					final HttpServletRequest req) {
		LOGGER.info("remove warband character id: " + Integer.valueOf(req.getParameter("removeCharacter")));

		for (TntCharacter rogueStarCharacter : warband.getTntCharacters()) {
			if (rogueStarCharacter.getId().equals(Integer.valueOf(req.getParameter("removeCharacter")))) {
				warband.getTntCharacters().remove(rogueStarCharacter);
				break;
			}
		}

		session.setAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);
		model.addAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);
		loadModelVariables(model);

		return ProjectHelpers.WARBAND_PAGE;
	}

	@RequestMapping(value = "/warband", params = { "printWarband" }, method = RequestMethod.POST)
	public String printWarband(@Valid Warband warband, BindingResult bindingResult, Model model, HttpSession session,
					final HttpServletRequest req) {

		LOGGER.info("print warband.  User: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

		session.setAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);

		return "redirect:/print";
	}
}
