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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev801.tnt.data.TntCharacter;
import com.dev801.tnt.data.Warband;
import com.dev801.tnt.helpers.ProjectHelpers;

@Controller
public class WarbandController extends ControllerHelper {
	private static final Logger LOGGER = Logger.getLogger(WarbandController.class);

	private static final String SHOW_RULES = "showRules";

	@GetMapping(value = "/warband")
	public String newWarband(Model model, @RequestParam(value = "warbandId", defaultValue = "-1") Integer warbandId,
			HttpSession session) {
		LOGGER.info("Loading a warband.  User: "
				+ SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

		Warband warband = new Warband();

		if (warbandId > -1) {
			LOGGER.info("Getting the requested warband id: " + warbandId);

			warband = warbandsRepository.findOne(warbandId);

			if (warband == null || !warband.getUserId().equals(getUser().getId())) {
				LOGGER.error("User tried to get a warband that doesn't belong to them or is null.");
				model.addAttribute("returnMessage", "There was a problem getting that warband.  Please try again.");
				return ProjectHelpers.WARBANDS_PAGE;
			}
		} else {
			warband.addTntCharacter(new TntCharacter(ProjectHelpers.getIdHolder(), "New Character"));
		}

		model.addAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);
		session.setAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);
		model.addAttribute(SHOW_RULES, getUser().getShowDetails());

		loadModelVariables(model);
		return ProjectHelpers.WARBAND_PAGE;
	}

	@PostMapping(value = "/warband")
	public String addNewCharacter(@Valid Warband warband, BindingResult bindingResult, Model model,
			HttpServletRequest request, HttpSession session) {
		LOGGER.info("Add a character.  User: "
				+ SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

		warband.addTntCharacter(new TntCharacter(ProjectHelpers.getIdHolder(), "New Character"));

		session.setAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);
		model.addAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);
		model.addAttribute(SHOW_RULES, getUser().getShowDetails());

		loadModelVariables(model);
		return ProjectHelpers.WARBAND_PAGE;
	}

	@PostMapping(value = "/warband", params = { "saveWarband" })
	public String save(@Valid Warband warband, BindingResult bindingResult, Model model, HttpServletRequest request,
			HttpSession session) {
		LOGGER.info("Persist warband.  User: "
				+ SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

		if (warband.getWarbandName() == null || warband.getWarbandTypeId() == null) {
			LOGGER.info("The warband name is null");
			model.addAttribute("warbandNameError",
					"The warband needs a name that it will be known throughout the wastelands!");

			session.setAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);
			model.addAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);
			loadModelVariables(model);
			return ProjectHelpers.WARBAND_PAGE;
		}

		warband.setUserId(getUser().getId());
		warband.setDateCreated(new Date());
		boolean saveSuccessful = warbandService.saveWarband(warband);

		LOGGER.info("Warband save success: " + saveSuccessful);

		return "redirect:/" + ProjectHelpers.WARBANDS_PAGE + "?saved=" + saveSuccessful;
	}

	@PostMapping(value = "/warband", params = { "removeCharacter" })
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
		model.addAttribute(SHOW_RULES, getUser().getShowDetails());
		loadModelVariables(model);

		return ProjectHelpers.WARBAND_PAGE;
	}

	@PostMapping(value = "/warband", params = { "printWarbandRules" })
	public String printWarbandRules(@Valid Warband warband, BindingResult bindingResult, Model model,
			HttpSession session, final HttpServletRequest req) {

		LOGGER.info("print warband w/ rules long.  User: "
				+ SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

		session.setAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);

		return "redirect:/printWithRules?length=long";
	}

	@PostMapping(value = "/warband", params = { "printWarbandRulesShort" })
	public String printWarbandRulesShort(@Valid Warband warband, BindingResult bindingResult, Model model,
			HttpSession session, final HttpServletRequest req) {

		LOGGER.info("print warband w/ rules short.  User: "
				+ SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

		session.setAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);

		return "redirect:/printWithRules";
	}

	@PostMapping(value = "/warband", params = { "printWarband" })
	public String printWarbandNoRules(@Valid Warband warband, BindingResult bindingResult, Model model,
			HttpSession session, final HttpServletRequest req) {

		LOGGER.info("print warband long.  User: "
				+ SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

		session.setAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);

		return "redirect:/print?length=long";
	}

	@PostMapping(value = "/warband", params = { "printWarbandShort" })
	public String printWarbandNoRulesShort(@Valid Warband warband, BindingResult bindingResult, Model model,
			HttpSession session, final HttpServletRequest req) {

		LOGGER.info("print warband short .  User: "
				+ SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

		session.setAttribute(ProjectHelpers.WARBAND_ATTRIBUTE, warband);

		return "redirect:/print";
	}

}
