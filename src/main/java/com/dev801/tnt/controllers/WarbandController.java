package com.dev801.tnt.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev801.tnt.data.TntCharacter;
import com.dev801.tnt.data.Warband;
import com.dev801.tnt.helpers.ProjectHelpers;
import com.dev801.tnt.repositories.ArmorsRepository;
import com.dev801.tnt.repositories.DetrimentsRepository;
import com.dev801.tnt.repositories.EquipmentRepository;
import com.dev801.tnt.repositories.GeneralAbilitiesRepository;
import com.dev801.tnt.repositories.GrenadesRepository;
import com.dev801.tnt.repositories.MeleeWeaponsRepository;
import com.dev801.tnt.repositories.MutationsRepository;
import com.dev801.tnt.repositories.RangedWeaponsRepository;
import com.dev801.tnt.repositories.SkillsRepository;
import com.dev801.tnt.repositories.SpecialRulesRepository;
import com.dev801.tnt.repositories.TntCharactersRepository;
import com.dev801.tnt.repositories.UnitTypesRepository;
import com.dev801.tnt.repositories.WarbandsRepository;
import com.google.common.collect.Lists;

@Controller
public class WarbandController {
	private static final Logger LOGGER = Logger.getLogger(WarbandController.class);

	private static final String WARBAND_PAGE = "warband";
	private static final String WARBAND_ATTRIBUTE = "warband";

	@Autowired
	ArmorsRepository armorsRepository;
	@Autowired
	DetrimentsRepository detrimentsRepository;
	@Autowired
	EquipmentRepository equipmentRepository;
	@Autowired
	GeneralAbilitiesRepository generalAbilitiesRepository;
	@Autowired
	GrenadesRepository grenadeRepository;
	@Autowired
	MeleeWeaponsRepository meleeWeaponsRepository;
	@Autowired
	MutationsRepository mutationsRepository;
	@Autowired
	RangedWeaponsRepository rangedWeaponsRepository;
	@Autowired
	SkillsRepository skillsRepository;
	@Autowired
	SpecialRulesRepository specialRulesRepository;
	@Autowired
	TntCharactersRepository tntCharactersRepository;
	@Autowired
	WarbandsRepository warbandsRepository;
	@Autowired
	UnitTypesRepository unitTypesRepository;

	@RequestMapping(value = "/warband", method = RequestMethod.GET)
	public String newWarband(Model model, HttpSession session) {
		LOGGER.info("main get method");

		Warband warband = new Warband();

		model.addAttribute(WARBAND_ATTRIBUTE, warband);
		session.setAttribute(WARBAND_ATTRIBUTE, warband);

		loadModelVariables(model);
		return WARBAND_PAGE;
	}

	@RequestMapping(value = "/warband", method = RequestMethod.POST)
	public String addNewCharacter(@Valid Warband warband, BindingResult bindingResult, Model model, HttpServletRequest request,
					HttpSession session) {
		LOGGER.info("add a character");

		warband.addTntCharacter(new TntCharacter(ProjectHelpers.getIdHolder(), "New Character"));

		session.setAttribute(WARBAND_ATTRIBUTE, warband);
		model.addAttribute(WARBAND_ATTRIBUTE, warband);

		loadModelVariables(model);
		return WARBAND_PAGE;
	}

	@RequestMapping(value = "/warband/save", method = RequestMethod.POST)
	private String save(@Valid Warband warband, BindingResult bindingResult, Model model, HttpServletRequest request,
					HttpSession session) {
		LOGGER.info("persist warband");

		if (bindingResult.hasErrors()) {
			LOGGER.info("Warband has errors");
			return WARBAND_PAGE;
		}

		LOGGER.info("Pre:  " + warband.toString());

		List<TntCharacter> chars = warband.getTntCharacters();
		warband = warbandsRepository.save(warband);

		for (TntCharacter tntCharacter : chars) {
			LOGGER.info("Pre:  " + tntCharacter);

			if (tntCharacter.getId() != null && tntCharacter.getId() < 0) {
				tntCharacter.setId(null);
			}

			tntCharacter.setWarband(warband);
			tntCharacter.setId(tntCharactersRepository.save(tntCharacter).getId());

			LOGGER.info("Post: " + tntCharacter);
		}

		// chars.add(new TntCharacter(ProjectHelpers.getIdHolder(), "New Character"));

		warband.setTntCharacters(chars);

		LOGGER.info("Post: " + warband.toString());

		session.setAttribute(WARBAND_ATTRIBUTE, warband);
		model.addAttribute(WARBAND_ATTRIBUTE, warband);

		loadModelVariables(model);
		return WARBAND_PAGE;

	}

	@RequestMapping(value = "/warband", params = { "removeCharacter" }, method = RequestMethod.POST)
	public String removeCharacter(@Valid Warband warband, BindingResult bindingResult, Model model, HttpSession session,
					final HttpServletRequest req) {

		LOGGER.info("remove warband character");

		// Integer characterId = Integer.valueOf(req.getParameter("removeCharacter"));
		// for (RogueStarCharacter rogueStarCharacter : warband.getCharacters()) {
		// if (rogueStarCharacter.getId().equals(characterId)) {
		// warband.getCharacters().remove(rogueStarCharacter);
		// break;
		// }
		// }
		//
		// session.setAttribute(WARBAND_ATTRIBUTE, warband);
		// model.addAttribute(WARBAND_ATTRIBUTE, warband);
		// model.addAttribute("characterIds", getCharacterIds(warband));
		//
		// updateModel(warband, model);

		return null;
	}

	@RequestMapping(value = "/warband", params = { "printWarband" }, method = RequestMethod.POST)
	public String printWarband(@Valid Warband warband, BindingResult bindingResult, Model model, HttpSession session,
					final HttpServletRequest req) {

		LOGGER.info("remove warband character");

		// Integer characterId = Integer.valueOf(req.getParameter("removeCharacter"));
		// for (RogueStarCharacter rogueStarCharacter : warband.getCharacters()) {
		// if (rogueStarCharacter.getId().equals(characterId)) {
		// warband.getCharacters().remove(rogueStarCharacter);
		// break;
		// }
		// }
		//
		// session.setAttribute(WARBAND_ATTRIBUTE, warband);
		// model.addAttribute(WARBAND_ATTRIBUTE, warband);
		// model.addAttribute("characterIds", getCharacterIds(warband));
		//
		// updateModel(warband, model);

		return "redirect:/print";
	}

	private void loadModelVariables(Model model) {
		model.addAttribute("armorList", Lists.newArrayList(armorsRepository.findAll()));
		model.addAttribute("detrimentsList", Lists.newArrayList(detrimentsRepository.findAll()));
		model.addAttribute("equipmentList", Lists.newArrayList(equipmentRepository.findAll()));
		model.addAttribute("generalAbilitiesList", Lists.newArrayList(generalAbilitiesRepository.findAll()));
		model.addAttribute("grenadesList", Lists.newArrayList(grenadeRepository.findAll()));
		model.addAttribute("meleeWeaponsList", Lists.newArrayList(meleeWeaponsRepository.findAll()));
		model.addAttribute("mutationsList", Lists.newArrayList(mutationsRepository.findAll()));
		model.addAttribute("rangedWeaponsList", Lists.newArrayList(rangedWeaponsRepository.findAll()));
		model.addAttribute("skillsList", Lists.newArrayList(skillsRepository.findAll()));
		model.addAttribute("specialRulesList", Lists.newArrayList(specialRulesRepository.findAll()));
		model.addAttribute("unitTypesList", Lists.newArrayList(unitTypesRepository.findAll()));
	}
}
