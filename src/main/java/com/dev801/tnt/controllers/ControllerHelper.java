package com.dev801.tnt.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import com.dev801.tnt.data.Mutation;
import com.dev801.tnt.data.RangedWeapon;
import com.dev801.tnt.data.Skill;
import com.dev801.tnt.data.User;
import com.dev801.tnt.data.WarbandUnit;
import com.dev801.tnt.data.WarbandUnitJSON;
import com.dev801.tnt.repositories.ArmorsRepository;
import com.dev801.tnt.repositories.DetrimentsRepository;
import com.dev801.tnt.repositories.EquipmentRepository;
import com.dev801.tnt.repositories.GeneralAbilitiesRepository;
import com.dev801.tnt.repositories.GrenadesRepository;
import com.dev801.tnt.repositories.InjuriesRepository;
import com.dev801.tnt.repositories.MeleeWeaponsRepository;
import com.dev801.tnt.repositories.MutationsRepository;
import com.dev801.tnt.repositories.RangedWeaponsRepository;
import com.dev801.tnt.repositories.SkillsRepository;
import com.dev801.tnt.repositories.SpecialRulesRepository;
import com.dev801.tnt.repositories.TntCharactersRepository;
import com.dev801.tnt.repositories.UnitTypesRepository;
import com.dev801.tnt.repositories.UsersRepository;
import com.dev801.tnt.repositories.WarbandTypesRepository;
import com.dev801.tnt.repositories.WarbandUnitsRepository;
import com.dev801.tnt.repositories.WarbandsRepository;
import com.dev801.tnt.service.ForgotPasswordService;
import com.dev801.tnt.service.WarbandService;
import com.google.common.collect.Lists;

public class ControllerHelper {
	private static final Logger LOGGER = Logger.getLogger(ControllerHelper.class);

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
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	WarbandService warbandService;
	@Autowired
	InjuriesRepository injuriesRepository;
	@Autowired
	WarbandTypesRepository warbandTypesRepository;
	@Autowired
	WarbandUnitsRepository warbandUnitsRepository;
	@Autowired
	ForgotPasswordService forgotPasswordService;

	protected User getUser(HttpSession session) {
		User user = usersRepository.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

		LOGGER.info("User from session: " + user.getUsername());
		return user;
	}

	protected void loadModelVariables(Model model) {
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
		model.addAttribute("injuriesList", Lists.newArrayList(injuriesRepository.findAll()));
		model.addAttribute("warbandTypes", Lists.newArrayList(warbandTypesRepository.findAll()));
		model.addAttribute("warbandUnits", Lists.newArrayList(warbandUnitsRepository.findAll()));

		Map<Integer, WarbandUnitJSON> jsonWarbandUnits = new HashMap<>();
		for (WarbandUnit warbandUnit : Lists.newArrayList(warbandUnitsRepository.findAll())) {
			jsonWarbandUnits.put(warbandUnit.getId(), new WarbandUnitJSON(warbandUnit));
		}
		model.addAttribute("warbandUnitsJson", jsonWarbandUnits);

		// +++++++++++++++++++++++++++++++++++++++++++++++

		Map<String, List<Skill>> skillOptgroupList = new HashMap<>();
		for (Skill skill : skillsRepository.findAll()) {
			if (!skillOptgroupList.containsKey(skill.getSkillTypeName())) {
				skillOptgroupList.put(skill.getSkillTypeName(), new ArrayList<Skill>());
			}

			skillOptgroupList.get(skill.getSkillTypeName()).add(skill);
		}
		model.addAttribute("skillOptgroupList", skillOptgroupList);

		// +++++++++++++++++++++++++++++++++++++++++++++++

		Map<String, List<Mutation>> mutationOptgroupList = new HashMap<>();
		for (Mutation mutation : mutationsRepository.findAll()) {
			if (!mutationOptgroupList.containsKey(mutation.getMutationTypeName())) {
				mutationOptgroupList.put(mutation.getMutationTypeName(), new ArrayList<Mutation>());
			}

			mutationOptgroupList.get(mutation.getMutationTypeName()).add(mutation);
		}
		model.addAttribute("mutationOptgroupList", mutationOptgroupList);

		// +++++++++++++++++++++++++++++++++++++++++++++++

		Map<String, List<RangedWeapon>> rangedOptgroupList = new HashMap<>();
		for (RangedWeapon rangedWeapon : rangedWeaponsRepository.findAll()) {
			if (!rangedOptgroupList.containsKey(rangedWeapon.getCatagoryName())) {
				rangedOptgroupList.put(rangedWeapon.getCatagoryName(), new ArrayList<RangedWeapon>());
			}

			rangedOptgroupList.get(rangedWeapon.getCatagoryName()).add(rangedWeapon);
		}
		model.addAttribute("rangedOptgroupList", rangedOptgroupList);

	}
}
