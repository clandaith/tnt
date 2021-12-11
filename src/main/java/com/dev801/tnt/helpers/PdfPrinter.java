package com.dev801.tnt.helpers;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.dev801.tnt.data.Armor;
import com.dev801.tnt.data.Detriment;
import com.dev801.tnt.data.Equipment;
import com.dev801.tnt.data.GeneralAbility;
import com.dev801.tnt.data.Grenade;
import com.dev801.tnt.data.Injury;
import com.dev801.tnt.data.MeleeWeapon;
import com.dev801.tnt.data.Mutation;
import com.dev801.tnt.data.RangedWeapon;
import com.dev801.tnt.data.Skill;
import com.dev801.tnt.data.SpecialRule;
import com.dev801.tnt.data.TntCharacter;
import com.dev801.tnt.data.Warband;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfPrinter {
	private static final Logger LOGGER = Logger.getLogger(PdfPrinter.class);
	private static final Font BOLD_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);

	private static final Font font = new Font(FontFamily.HELVETICA, 8);

	private static final PdfPCell leftCell = new PdfPCell();
	private static final PdfPCell centeredCell = new PdfPCell();

	private static Map<Integer, RangedWeapon> rangedWeapons = new TreeMap<>();
	private static Map<Integer, MeleeWeapon> meleeWeapons = new TreeMap<>();
	private static Map<Integer, Grenade> grenadeList = new TreeMap<>();

	private static Map<String, String> skillList = new TreeMap<>();
	private static Map<String, String> mutationList = new TreeMap<>();
	private static Map<String, String> detrimentList = new TreeMap<>();
	private static Map<String, String> generalAbilityList = new TreeMap<>();
	private static Map<String, String> injuryList = new TreeMap<>();
	private static Map<String, String> specialRules = new TreeMap<>();
	private static Map<String, String> equipmentList = new TreeMap<>();

	private static final String SPECIAL_RULES = "Special Rules";
	private static final String STRENGTH = "Strength";

	static {
		leftCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		centeredCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	}

	private PdfPrinter() {

	}

	public static byte[] printWarband(Warband warband, boolean showRules) {
		return printWarband(warband, showRules, false);
	}

	public static byte[] printWarband(Warband warband, boolean showRules, boolean useShortSheet) {
		try {
			Document document = new Document();

			OutputStream out = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, out);
			document.open();

			Chapter chapter = new Chapter(1);
			handleWarbandSection(warband, chapter, useShortSheet);

			chapter.setNumberDepth(0);

			if (useShortSheet) {
				printShortSheet(warband, chapter, showRules);
			} else {
				printLongSheet(warband, chapter, showRules);
				addNotes(warband, chapter);
			}

			document.add(chapter);
			document.close();

			return out.toString().getBytes();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return warband.toString().getBytes();
		}
	}

	private static PdfPCell addCenterCellText(String text) {
		centeredCell.setPhrase(new Phrase(text, font));
		return centeredCell;
	}

	private static PdfPCell addLeftCellText(String text) {
		leftCell.setPhrase(new Phrase(text, font));
		return leftCell;
	}

	private static BaseColor getBackgroundColor(Integer i) {
		return (++i % 2 == 0) ? BaseColor.LIGHT_GRAY : BaseColor.WHITE;
	}

	private static void printShortSheet(Warband warband, Chapter chapter, boolean showRules) {

		centeredCell.setBackgroundColor(BaseColor.CYAN);

		float[] columnWidths = { 4, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 4 };
		PdfPTable pTable = new PdfPTable(columnWidths);
		pTable.setWidthPercentage(100);

		// ++++++++++++++++++++++++++

		pTable.addCell(addCenterCellText("Name"));
		pTable.addCell(addCenterCellText("Mov"));
		pTable.addCell(addCenterCellText("Mel"));
		pTable.addCell(addCenterCellText("Rng"));
		pTable.addCell(addCenterCellText("Str"));
		pTable.addCell(addCenterCellText("Met"));
		pTable.addCell(addCenterCellText("Def"));
		pTable.addCell(addCenterCellText("W"));
		pTable.addCell(addCenterCellText("K"));
		pTable.addCell(addCenterCellText("Weapons"));
		pTable.addCell(addCenterCellText("Armor"));
		pTable.addCell(addCenterCellText("BS"));
		pTable.addCell(addCenterCellText("XP"));
		pTable.addCell(addCenterCellText("UXP"));
		pTable.addCell(addCenterCellText("Special"));

		// ++++++++++++++++++++++++++++++++

		printShortCharacterSection(warband, pTable);

		chapter.add(pTable);

		if (!rangedWeapons.isEmpty()) {
			chapter.add(new Paragraph(" "));
			chapter.add(addRangedList(rangedWeapons, showRules));
		}

		if (!meleeWeapons.isEmpty()) {
			chapter.add(new Paragraph(" "));
			chapter.add(addMeleeList(meleeWeapons, showRules));
		}

		if (!grenadeList.isEmpty()) {
			chapter.add(new Paragraph(" "));
			chapter.add(addGrenadeList(grenadeList, showRules));
		}

		if (!mutationList.isEmpty()) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList("Mutations", mutationList, showRules));
		}

		if (!detrimentList.isEmpty()) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList("Detriments", detrimentList, showRules));
		}

		if (!injuryList.isEmpty()) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList("Injuries", injuryList, showRules));
		}

		if (!specialRules.isEmpty()) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList(SPECIAL_RULES, specialRules, showRules));
		}

		if (!skillList.isEmpty()) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList("Skills", skillList, showRules));
		}

		if (!generalAbilityList.isEmpty()) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList("General Abilities", generalAbilityList, showRules));
		}

		if (!equipmentList.isEmpty()) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList("Equipment", equipmentList, showRules));
		}
	}

	private static void printShortCharacterSection(Warband warband, PdfPTable pTable) {
		int i = 0;

		Map<String, TntCharacter> sortedCharacterList = new TreeMap<>();

		for (TntCharacter tntCharacter : warband.getTntCharacters()) {
			sortedCharacterList.put(
					tntCharacter.getWarbandUnit().getId() + tntCharacter.getName() + tntCharacter.getId(),
					tntCharacter);
		}

		for (TntCharacter tntCharacter : sortedCharacterList.values()) {
			++i;
			centeredCell.setBackgroundColor(getBackgroundColor(i));
			leftCell.setBackgroundColor(getBackgroundColor(i));

			pTable.addCell(addLeftCellText(tntCharacter.getName()));
			pTable.addCell(addCenterCellText(tntCharacter.getMove().toString()));
			pTable.addCell(addCenterCellText(tntCharacter.getMelee().toString()));
			pTable.addCell(addCenterCellText(tntCharacter.getRanged().toString()));
			pTable.addCell(addCenterCellText(tntCharacter.getStrength().toString()));
			pTable.addCell(addCenterCellText(tntCharacter.getMettle().toString()));
			pTable.addCell(addCenterCellText(tntCharacter.getDefense().toString()));
			pTable.addCell(addCenterCellText(tntCharacter.getWounds().toString()));
			pTable.addCell(addCenterCellText(" ")); // Kills

			StringBuilder weapons = new StringBuilder("");
			for (RangedWeapon weapon : tntCharacter.getRangedWeapons()) {
				weapons.append(weapon.getType() + ", ");

				for (SpecialRule specialRule : weapon.getSpecialRules()) {
					specialRules.put(specialRule.getName(), specialRule.getDescription());
				}

				rangedWeapons.put(weapon.getId(), weapon);
			}

			for (MeleeWeapon weapon : tntCharacter.getMeleeWeapons()) {
				weapons.append(weapon.getType() + ", ");

				for (SpecialRule specialRule : weapon.getSpecialRules()) {
					specialRules.put(specialRule.getName(), specialRule.getDescription());
				}

				meleeWeapons.put(weapon.getId(), weapon);
			}

			for (Grenade grenade : tntCharacter.getGrenades()) {
				weapons.append(grenade.getType() + ", ");

				for (SpecialRule specialRule : grenade.getSpecialRules()) {
					specialRules.put(specialRule.getName(), specialRule.getDescription());
				}

				grenadeList.put(grenade.getId(), grenade);
			}

			pTable.addCell(addLeftCellText(weapons.toString()));

			StringBuilder armors = new StringBuilder("");
			for (Armor armor : tntCharacter.getArmors()) {
				armors.append(armor.getType() + ", ");
			}

			pTable.addCell(addLeftCellText(armors.toString()));
			pTable.addCell(addCenterCellText(tntCharacter.getBaseCost().toString()));
			pTable.addCell(addCenterCellText(tntCharacter.getXp().toString()));// XP
			pTable.addCell(addCenterCellText(tntCharacter.getUnusedXP().toString()));// Unused XP

			StringBuilder text = new StringBuilder(tntCharacter.getWarbandUnit().getTitle() + ", "
					+ tntCharacter.getWarbandUnit().getTypeName() + ", ");
			for (Skill skill : tntCharacter.getSkills()) {
				text.append(skill.getName() + ", ");
				skillList.put(skill.getName(), skill.getDescription());
			}

			for (Mutation mutation : tntCharacter.getMutations()) {
				text.append(mutation.getName() + ", ");
				mutationList.put(mutation.getName(), mutation.getDescription());
			}

			for (Detriment detriment : tntCharacter.getDetriments()) {
				text.append(detriment.getName() + ", ");
				detrimentList.put(detriment.getName(), detriment.getDescription());
			}

			for (GeneralAbility ability : tntCharacter.getGeneralAbilities()) {
				text.append(ability.getName() + ", ");
				generalAbilityList.put(ability.getName(), ability.getDescription());
			}

			for (Injury injury : tntCharacter.getInjuries()) {
				text.append(injury.getName() + ", ");
				injuryList.put(injury.getName(), injury.getDescription());
			}

			for (Equipment equipment : tntCharacter.getEquipment()) {
				text.append(equipment.getItem() + ", ");
				equipmentList.put(equipment.getItem(), equipment.getItem());
			}

			pTable.addCell(addLeftCellText(text.toString()));
		}
	}

	private static PdfPTable addSpecialRulesList(String name, Map<String, String> rules, boolean showRules) {
		float[] columnWidths = { 1, 10 };
		PdfPTable pTable = new PdfPTable(columnWidths);
		pTable.setWidthPercentage(100);

		centeredCell.setBackgroundColor(BaseColor.CYAN);
		pTable.addCell(addCenterCellText(name));
		pTable.addCell(addCenterCellText("Description"));

		int i = 0;
		for (Entry<String, String> key : rules.entrySet()) {
			++i;
			leftCell.setBackgroundColor(getBackgroundColor(i));
			leftCell.setBackgroundColor(getBackgroundColor(i));

			pTable.addCell(addLeftCellText(key.getKey()));
			pTable.addCell(addLeftCellText(showRules ? key.getValue() : ""));
		}

		return pTable;
	}

	private static PdfPTable addRangedList(Map<Integer, RangedWeapon> rangedWeapons, boolean showRules) {
		float[] columnWidths = { 2, 1, 1, 1, 1, 5 };
		PdfPTable pTable = new PdfPTable(columnWidths);
		pTable.setWidthPercentage(100);

		centeredCell.setBackgroundColor(BaseColor.CYAN);

		pTable.addCell(addCenterCellText("Ranged Weapon"));
		pTable.addCell(addCenterCellText("Range"));
		pTable.addCell(addCenterCellText(STRENGTH));
		pTable.addCell(addCenterCellText("Reliabiltiy"));
		pTable.addCell(addCenterCellText("1H / 2H"));
		pTable.addCell(addCenterCellText(SPECIAL_RULES));

		int i = 0;
		for (RangedWeapon weapon : rangedWeapons.values()) {
			++i;
			centeredCell.setBackgroundColor(getBackgroundColor(i));
			leftCell.setBackgroundColor(getBackgroundColor(i));

			pTable.addCell(addLeftCellText(weapon.getType()));
			pTable.addCell(addCenterCellText(showRules ? weapon.getMaxRange().toString() : ""));
			pTable.addCell(addCenterCellText(showRules ? weapon.getStrength().toString() : ""));
			pTable.addCell(addCenterCellText(showRules ? weapon.getReliability().toString() : ""));
			pTable.addCell(
					addCenterCellText(showRules ? (Boolean.TRUE.equals(weapon.getOneHanded()) ? "1H" : "2H") : ""));

			StringBuilder specialRules = new StringBuilder("");
			for (SpecialRule specialRule : weapon.getSpecialRules()) {
				specialRules.append(specialRule.getName() + ", ");
			}

			pTable.addCell(addLeftCellText(showRules ? specialRules.toString() : ""));

		}

		return pTable;
	}

	private static PdfPTable addGrenadeList(Map<Integer, Grenade> grenadeList, boolean showRules) {
		float[] columnWidths = { 2, 1, 5 };
		PdfPTable pTable = new PdfPTable(columnWidths);
		pTable.setWidthPercentage(100);

		centeredCell.setBackgroundColor(BaseColor.CYAN);

		pTable.addCell(addCenterCellText("Grenade"));
		pTable.addCell(addCenterCellText(STRENGTH));
		pTable.addCell(addCenterCellText(SPECIAL_RULES));

		int i = 0;
		for (Grenade grenade : grenadeList.values()) {
			++i;
			centeredCell.setBackgroundColor(getBackgroundColor(i));
			leftCell.setBackgroundColor(getBackgroundColor(i));

			pTable.addCell(addLeftCellText(grenade.getType()));
			pTable.addCell(addCenterCellText(showRules ? grenade.getStrength().toString() : ""));

			StringBuilder specialRules = new StringBuilder("");
			for (SpecialRule specialRule : grenade.getSpecialRules()) {
				specialRules.append(specialRule.getName() + ", ");
			}

			pTable.addCell(addLeftCellText(showRules ? specialRules.toString() : ""));

		}

		return pTable;
	}

	private static PdfPTable addMeleeList(Map<Integer, MeleeWeapon> meleeWeapons, boolean showRules) {
		float[] columnWidths = { 2, 1, 1, 1, 1, 1, 5 };
		PdfPTable pTable = new PdfPTable(columnWidths);
		pTable.setWidthPercentage(100);

		centeredCell.setBackgroundColor(BaseColor.CYAN);

		pTable.addCell(addCenterCellText("Melee Weapon"));
		pTable.addCell(addCenterCellText("Melee Range"));
		pTable.addCell(addCenterCellText("Thrown Range"));
		pTable.addCell(addCenterCellText(STRENGTH));
		pTable.addCell(addCenterCellText("Reliabiltiy"));
		pTable.addCell(addCenterCellText("1H / 2H"));
		pTable.addCell(addCenterCellText(SPECIAL_RULES));

		int i = 0;
		for (MeleeWeapon weapon : meleeWeapons.values()) {
			++i;
			centeredCell.setBackgroundColor(getBackgroundColor(i));
			leftCell.setBackgroundColor(getBackgroundColor(i));

			pTable.addCell(addLeftCellText(weapon.getType()));
			pTable.addCell(addCenterCellText(showRules ? weapon.getMeleeRange().toString() : ""));
			pTable.addCell(addCenterCellText(showRules ? weapon.getThrownRange().toString() : ""));
			pTable.addCell(addCenterCellText(showRules ? weapon.getStrength().toString() : ""));
			pTable.addCell(addCenterCellText(showRules ? weapon.getReliability().toString() : ""));
			pTable.addCell(
					addCenterCellText(showRules ? (Boolean.TRUE.equals(weapon.getOneHanded()) ? "1H" : "2H") : ""));

			StringBuilder specialRules = new StringBuilder("");
			for (SpecialRule specialRule : weapon.getSpecialRules()) {
				specialRules.append(specialRule.getName() + ", ");
			}

			pTable.addCell(addLeftCellText(showRules ? specialRules.toString() : ""));

		}

		return pTable;
	}

	// ++++++++++++++++++++++++++++++++++++++++++

	private static void addNotes(Warband warband, Chapter chapter) {
		Paragraph p = new Paragraph(warband.getNotes());
		chapter.add(p);
	}

	private static void handleWarbandSection(Warband warband, Chapter chapter, boolean useShortSheet) {
		Integer totalBs = 0;

		for (TntCharacter character : warband.getTntCharacters()) {
			totalBs += character.getBaseCost();
		}

		chapter.add(new Paragraph(warband.getWarbandName() + " (" + totalBs + " BS)", BOLD_FONT));
		chapter.add(new Paragraph(" "));

		if (!useShortSheet && warband.getBackground() != null) {
			chapter.add(new Paragraph(warband.getBackground()));
		}
	}

	private static void printLongSheet(Warband warband, Chapter chapter, boolean showRules) {
		for (TntCharacter tntCharacter : warband.getTntCharacters()) {
			try {
				handleCharacter(tntCharacter, chapter, showRules);
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	private static void handleCharacter(TntCharacter tntCharacter, Chapter chapter, boolean showRules) {
		Paragraph p = new Paragraph(tntCharacter.getName(), BOLD_FONT);
		chapter.add(p);

		if (tntCharacter.getBackground() != null) {
			p = new Paragraph(tntCharacter.getBackground());
			chapter.add(p);
		}

		chapter.add(setCharacterStats(tntCharacter, showRules));

	}

	private static PdfPTable setCharacterStats(TntCharacter tntCharacter, boolean showRules) {
		PdfPTable pTable = new PdfPTable(1);
		pTable.setWidthPercentage(100);

		buildBasicInfo(tntCharacter, pTable);
		buildStatLine(tntCharacter, pTable);

		if (!tntCharacter.getMutations().isEmpty()) {
			buildMutationsLine(tntCharacter, pTable, showRules);
		}

		if (!tntCharacter.getDetriments().isEmpty()) {
			buildDetrimentsLine(tntCharacter, pTable, showRules);
		}

		if (!tntCharacter.getGeneralAbilities().isEmpty()) {
			buildSpecialRulesLine(tntCharacter, pTable, showRules);
		}

		if (!tntCharacter.getSkills().isEmpty()) {
			buildSkillsLine(tntCharacter, pTable, showRules);
		}

		if (!tntCharacter.getEquipment().isEmpty()) {
			buildEquipmentLine(tntCharacter, pTable);
		}

		if (!tntCharacter.getInjuries().isEmpty()) {
			buildInjuriesLine(tntCharacter, pTable, showRules);
		}

		if (!tntCharacter.getArmors().isEmpty()) {
			buildArmorLine(tntCharacter, pTable, showRules);
		}

		if (!tntCharacter.getRangedWeapons().isEmpty()) {
			buildRangedWeaponLine(tntCharacter, pTable, showRules);
		}

		if (!tntCharacter.getMeleeWeapons().isEmpty()) {
			buildMeleeWeaponLine(tntCharacter, pTable, showRules);
		}

		if (!tntCharacter.getGrenades().isEmpty()) {
			buildGrenadeLine(tntCharacter, pTable);
		}

		return pTable;
	}

	private static void buildBasicInfo(TntCharacter tntCharacter, PdfPTable outerTable) {
		PdfPTable basicInfoTable = new PdfPTable(6);
		basicInfoTable.setWidthPercentage(100);

		basicInfoTable.addCell("Title");
		basicInfoTable.addCell("Type");
		basicInfoTable.addCell("Level");
		basicInfoTable.addCell("XP - Unused");
		basicInfoTable.addCell("XP - Total");
		basicInfoTable.addCell("Base Cost");

		basicInfoTable.addCell(tntCharacter.getWarbandUnit().getTitle());
		basicInfoTable.addCell(tntCharacter.getUnitType().getName());
		basicInfoTable.addCell("");
		basicInfoTable.addCell("");
		basicInfoTable.addCell("");
		basicInfoTable.addCell(tntCharacter.getBaseCost().toString());

		outerTable.addCell(basicInfoTable);
	}

	private static void buildStatLine(TntCharacter tntCharacter, PdfPTable outerTable) {
		PdfPTable statTable = new PdfPTable(7);
		statTable.setWidthPercentage(100);

		statTable.addCell("Move");
		statTable.addCell("Melee");
		statTable.addCell("Ranged");
		statTable.addCell(STRENGTH);
		statTable.addCell("Mettle");
		statTable.addCell("Defense");
		statTable.addCell("Wounds");

		statTable.addCell(tntCharacter.getMove().toString());
		statTable.addCell(tntCharacter.getMelee().toString());
		statTable.addCell(tntCharacter.getRanged().toString());
		statTable.addCell(tntCharacter.getStrength().toString());
		statTable.addCell(tntCharacter.getMettle().toString());
		statTable.addCell(tntCharacter.getDefense().toString());
		statTable.addCell(tntCharacter.getWounds().toString());

		outerTable.addCell(statTable);
	}

	private static void buildEquipmentLine(TntCharacter tntCharacter, PdfPTable outerTable) {
		PdfPTable equipmentTable = new PdfPTable(8);
		equipmentTable.setWidthPercentage(100);
		equipmentTable.addCell("Equipment");

		StringBuilder equipmentText = new StringBuilder("");
		for (Equipment equipment : tntCharacter.getEquipment()) {
			equipmentText.append(equipment.getItem() + ", ");
		}
		PdfPCell cell = new PdfPCell(new Phrase(equipmentText.toString()));
		cell.setColspan(7);
		equipmentTable.addCell(cell);

		outerTable.addCell(equipmentTable);
	}

	private static void buildMutationsLine(TntCharacter tntCharacter, PdfPTable outerTable, boolean showRules) {
		PdfPTable mutationTable = new PdfPTable(8);
		mutationTable.setWidthPercentage(100);
		mutationTable.addCell("Mutations");

		StringBuilder mutationText = new StringBuilder("");
		for (Mutation mutation : tntCharacter.getMutations()) {
			mutationText.append(mutation.getName()
					+ (showRules ? " [" + mutation.getMutationTypeName() + "]  : " + mutation.getDescription() : "")
					+ ", ");
		}

		PdfPCell cell = new PdfPCell(new Phrase(mutationText.toString()));
		cell.setColspan(7);
		mutationTable.addCell(cell);

		outerTable.addCell(mutationTable);
	}

	private static void buildDetrimentsLine(TntCharacter tntCharacter, PdfPTable outerTable, boolean showRules) {
		PdfPTable detrimentTable = new PdfPTable(8);
		detrimentTable.setWidthPercentage(100);
		detrimentTable.addCell("Detriments");

		StringBuilder detrimentsText = new StringBuilder("");
		for (Detriment detriment : tntCharacter.getDetriments()) {
			detrimentsText.append(detriment.getName()
					+ (showRules ? " [" + detriment.getDetrimentTypeId() + "] : " + detriment.getDescription() : "")
					+ ", ");
		}

		PdfPCell cell = new PdfPCell(new Phrase(detrimentsText.toString()));
		cell.setColspan(7);
		detrimentTable.addCell(cell);

		outerTable.addCell(detrimentTable);
	}

	private static void buildSkillsLine(TntCharacter tntCharacter, PdfPTable outerTable, boolean showRules) {
		PdfPTable skillsTable = new PdfPTable(8);
		skillsTable.setWidthPercentage(100);
		skillsTable.addCell("Skills");

		StringBuilder skillText = new StringBuilder("");
		for (Skill skill : tntCharacter.getSkills()) {
			skillText.append(skill.getName() + (showRules ? ": " + skill.getDescription() : "") + ", ");
		}
		PdfPCell cell = new PdfPCell(new Phrase(skillText.toString()));
		cell.setColspan(7);
		skillsTable.addCell(cell);

		outerTable.addCell(skillsTable);

	}

	private static void buildSpecialRulesLine(TntCharacter tntCharacter, PdfPTable outerTable, boolean showRules) {
		PdfPTable specialRulesTable = new PdfPTable(8);
		specialRulesTable.setWidthPercentage(100);
		specialRulesTable.addCell(SPECIAL_RULES);

		StringBuilder specialRulesText = new StringBuilder("");
		for (GeneralAbility generalAbility : tntCharacter.getGeneralAbilities()) {
			specialRulesText.append(
					generalAbility.getName() + (showRules ? ": " + generalAbility.getDescription() : "") + ", ");
		}
		PdfPCell cell = new PdfPCell(new Phrase(specialRulesText.toString()));
		cell.setColspan(7);
		specialRulesTable.addCell(cell);

		outerTable.addCell(specialRulesTable);

	}

	private static void buildInjuriesLine(TntCharacter tntCharacter, PdfPTable outerTable, boolean showRules) {
		PdfPTable injuryTable = new PdfPTable(8);
		injuryTable.addCell("Injuries");

		StringBuilder injuriesText = new StringBuilder("");
		for (Injury injury : tntCharacter.getInjuries()) {
			injuriesText.append(injury.getName() + (showRules ? ": " + injury.getDescription() : "") + ", ");
		}

		PdfPCell cell = new PdfPCell(new Phrase(injuriesText.toString()));
		cell.setColspan(7);
		injuryTable.addCell(cell);

		outerTable.addCell(injuryTable);
	}

	private static void buildArmorLine(TntCharacter tntCharacter, PdfPTable outerTable, boolean showRules) {

		PdfPTable rangedWeaponsTable = new PdfPTable(8);
		rangedWeaponsTable.setWidthPercentage(100);
		rangedWeaponsTable.addCell("Armor");

		PdfPCell cell;

		if (showRules) {
			cell = new PdfPCell(buildArmorBlah(tntCharacter));
		} else {
			StringBuilder armorText = new StringBuilder("");
			for (Armor armor : tntCharacter.getArmors()) {
				armorText.append(armor.getType() + ", ");
			}

			cell = new PdfPCell(new Phrase(armorText.toString()));
		}

		cell.setColspan(7);
		rangedWeaponsTable.addCell(cell);

		outerTable.addCell(rangedWeaponsTable);
	}

	private static PdfPTable buildArmorBlah(TntCharacter tntCharacter) {
		PdfPTable armorTable = new PdfPTable(5);
		armorTable.setWidthPercentage(100);

		armorTable.addCell("Type");
		armorTable.addCell("Melee Bonus");
		armorTable.addCell("Ranged Bonus");
		armorTable.addCell(SPECIAL_RULES);

		switch (tntCharacter.getWounds()) {
		case 1:
			armorTable.addCell("BS Cost 1W");
			break;
		case 2:
			armorTable.addCell("BS Cost 2W");
			break;

		default:
			armorTable.addCell("BS Cost 3+W");
			break;
		}

		for (Armor armor : tntCharacter.getArmors()) {
			armorTable.addCell(armor.getType());
			armorTable.addCell(armor.getMeleeBonus().toString());
			armorTable.addCell(armor.getRangedBonus().toString());

			StringBuilder specialRules = new StringBuilder("");
			for (SpecialRule specialRule : armor.getSpecialRules()) {
				specialRules.append(specialRule.getName() + ",");
			}

			armorTable.addCell(specialRules.toString());

			switch (tntCharacter.getWounds()) {
			case 1:
				armorTable.addCell(armor.getCostByWound1().toString());
				break;
			case 2:
				armorTable.addCell(armor.getCostByWound2().toString());
				break;

			default:
				armorTable.addCell(armor.getCostByWound3().toString());
				break;
			}
		}

		return armorTable;
	}

	private static void buildRangedWeaponLine(TntCharacter tntCharacter, PdfPTable outerTable, boolean showRules) {
		PdfPTable rangedWeaponsTable = new PdfPTable(8);
		rangedWeaponsTable.setWidthPercentage(100);
		rangedWeaponsTable.addCell("Ranged Weapons");

		PdfPCell cell;
		if (showRules) {
			cell = new PdfPCell(buildRangedWeaponTable(tntCharacter.getRangedWeapons()));
		} else {
			StringBuilder rangedWeaponsText = new StringBuilder("");
			for (RangedWeapon weapon : tntCharacter.getRangedWeapons()) {
				rangedWeaponsText.append(weapon.getType() + ", ");
			}

			cell = new PdfPCell(new Phrase(rangedWeaponsText.toString()));
		}

		cell.setColspan(7);
		rangedWeaponsTable.addCell(cell);

		outerTable.addCell(rangedWeaponsTable);
	}

	private static PdfPTable buildRangedWeaponTable(Set<RangedWeapon> weapons) {
		PdfPTable weaponTable = new PdfPTable(7);
		weaponTable.setWidthPercentage(100);

		weaponTable.addCell("Type");
		weaponTable.addCell("Range");
		weaponTable.addCell(STRENGTH);
		weaponTable.addCell("Reliability");
		weaponTable.addCell("1H/2H");
		weaponTable.addCell(SPECIAL_RULES);
		weaponTable.addCell("BS Cost");

		for (RangedWeapon rangedWeapon : weapons) {
			weaponTable.addCell(rangedWeapon.getType());
			weaponTable.addCell(rangedWeapon.getMaxRange().toString());
			weaponTable.addCell(rangedWeapon.getStrength().toString());
			weaponTable.addCell(rangedWeapon.getReliability().toString());
			weaponTable.addCell(Boolean.TRUE.equals(rangedWeapon.getOneHanded()) ? "1H" : "2H");

			StringBuilder specialRules = new StringBuilder("");
			for (SpecialRule specialRule : rangedWeapon.getSpecialRules()) {
				specialRules.append(specialRule.getName() + ",");
			}

			weaponTable.addCell(specialRules.toString());
			weaponTable.addCell(rangedWeapon.getCost().toString());
		}

		return weaponTable;
	}

	private static void buildMeleeWeaponLine(TntCharacter tntCharacter, PdfPTable outerTable, boolean showRules) {
		PdfPTable meleeWeaponsTable = new PdfPTable(8);
		meleeWeaponsTable.setWidthPercentage(100);
		meleeWeaponsTable.addCell("Melee Weapons");

		PdfPCell cell;

		if (showRules) {
			cell = new PdfPCell(buildMeleeWeaponTable(tntCharacter.getMeleeWeapons()));
		} else {
			StringBuilder meleeWeaponsText = new StringBuilder("");
			for (MeleeWeapon weapon : tntCharacter.getMeleeWeapons()) {
				meleeWeaponsText.append(weapon.getType() + ", ");
			}

			cell = new PdfPCell(new Phrase(meleeWeaponsText.toString()));
		}

		cell.setColspan(7);
		meleeWeaponsTable.addCell(cell);

		outerTable.addCell(meleeWeaponsTable);
	}

	private static PdfPTable buildMeleeWeaponTable(Set<MeleeWeapon> weapons) {
		PdfPTable weaponTable = new PdfPTable(8);
		weaponTable.setWidthPercentage(100);

		weaponTable.addCell("Type");
		weaponTable.addCell("Range - Melee");
		weaponTable.addCell("Range - Thrown");
		weaponTable.addCell(STRENGTH);
		weaponTable.addCell("Reliability");
		weaponTable.addCell("1H/2H");
		weaponTable.addCell(SPECIAL_RULES);
		weaponTable.addCell("BS Cost");

		for (MeleeWeapon meleeWeapon : weapons) {
			weaponTable.addCell(meleeWeapon.getType());
			weaponTable.addCell(meleeWeapon.getMeleeRange().toString());
			weaponTable.addCell(meleeWeapon.getThrownRange().toString());
			weaponTable.addCell(meleeWeapon.getStrength().toString());

			weaponTable.addCell(meleeWeapon.getReliability() > 0 ? meleeWeapon.getReliability().toString() : "");
			weaponTable.addCell(Boolean.TRUE.equals(meleeWeapon.getOneHanded()) ? "1H" : "2H");

			StringBuilder specialRules = new StringBuilder("");
			for (SpecialRule specialRule : meleeWeapon.getSpecialRules()) {
				specialRules.append(specialRule.getName() + ",");
			}

			weaponTable.addCell(specialRules.toString());
			weaponTable.addCell(meleeWeapon.getCost().toString());
		}

		return weaponTable;
	}

	private static void buildGrenadeLine(TntCharacter tntCharacter, PdfPTable outerTable) {

		PdfPTable rangedWeaponsTable = new PdfPTable(8);
		rangedWeaponsTable.setWidthPercentage(100);
		rangedWeaponsTable.addCell("Grenades");

		StringBuilder grenadeText = new StringBuilder("");
		for (Grenade grenade : tntCharacter.getGrenades()) {
			grenadeText.append(grenade.getType() + ", ");
		}

		PdfPCell cell = new PdfPCell(new Phrase(grenadeText.toString()));
		cell.setColspan(7);
		rangedWeaponsTable.addCell(cell);

		outerTable.addCell(rangedWeaponsTable);
	}
}
