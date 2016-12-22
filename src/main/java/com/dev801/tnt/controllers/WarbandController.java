package com.dev801.tnt.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev801.tnt.data.TntCharacter;
import com.dev801.tnt.data.Warband;
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
import com.dev801.tnt.repositories.WarbandsRepository;
import com.google.common.collect.Lists;

@Controller
public class WarbandController {
	private static final Logger LOGGER = Logger.getLogger(WarbandController.class);

	private static final String WARBAND_PAGE = "pages/warband";
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

	@RequestMapping(value = "/warband", method = RequestMethod.GET)
	public String newWarband(Model model, HttpSession session) {
		LOGGER.info("main get method");

		Warband warband = new Warband();
		warband.addTntCharacter(new TntCharacter(1));

		loadModelVariables(model);

		model.addAttribute(WARBAND_ATTRIBUTE, warband);
		session.setAttribute(WARBAND_ATTRIBUTE, warband);

		return WARBAND_PAGE;
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
	}
}
