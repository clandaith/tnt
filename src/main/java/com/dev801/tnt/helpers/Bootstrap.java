package com.dev801.tnt.helpers;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOGGER = Logger.getLogger(Bootstrap.class);

	// @Autowired
	// ArmourRepository armourRepository;
	//
	// @Autowired
	// WeaponMeleeRepository weaponMeleeRepository;
	//
	// @Autowired
	// WeaponRangedRepository weaponRangedRepository;
	//
	// @Autowired
	// SpecialRuleRepository specialRuleRepository;
	//
	// @Autowired
	// TraitRepository traitRepository;
	//
	// @Autowired
	// ClassTypeRepository classTypeRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		LOGGER.info("Starting up...");

		// loadArmours();
		// loadWeaponsMelee();
		// loadWeaponsRanged();
		// loadTraits();
	}

	// private void loadTraits() {
	// List<Trait> traits = Lists.newArrayList(traitRepository.findAll());
	//
	// LOGGER.info("Traits size: " + traits.size());
	// for (Trait trait : traits) {
	// LOGGER.info(trait);
	// }
	// }
	//
	// private void loadWeaponsMelee() {
	// List<WeaponMelee> weaponsMelee = Lists.newArrayList(weaponMeleeRepository.findAll());
	//
	// LOGGER.info("WeaponsMelee size: " + weaponsMelee.size());
	// for (WeaponMelee weaponMelee : weaponsMelee) {
	// LOGGER.info(weaponMelee);
	// }
	// }
	//
	// private void loadWeaponsRanged() {
	// List<WeaponRanged> weaponsRanged = Lists.newArrayList(weaponRangedRepository.findAll());
	//
	// LOGGER.info("WeaponsRanged size: " + weaponsRanged.size());
	// for (WeaponRanged weaponRanged : weaponsRanged) {
	// LOGGER.info(weaponRanged);
	// }
	// }
	//
	// private void loadArmours() {
	// List<Armour> armours = Lists.newArrayList(armourRepository.findAll());
	//
	// LOGGER.info("Armours size: " + armours.size());
	// for (Armour armour : armours) {
	// LOGGER.info(armour);
	// }
	// }
}