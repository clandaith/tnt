package com.dev801.tnt.helpers;

import java.io.ByteArrayOutputStream;
import java.util.Map;
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
import com.dev801.tnt.data.User;
import com.dev801.tnt.data.Warband;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
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

	static {
		leftCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		centeredCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	}

	public static byte[] printWarband(Warband warband, User user, boolean showRules) {
		return printWarband(warband, user, showRules, false);
	}

	public static byte[] printWarband(Warband warband, User user, boolean showRules, boolean useShortSheet) {
		try {
			Document document = new Document();

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, out);
			document.open();

			Chapter chapter = new Chapter(1);
			handleWarbandSection(warband, chapter, useShortSheet);

			chapter.setNumberDepth(0);

			if (useShortSheet) {
				printShortSheet(warband, chapter, user, showRules);
			} else {
				printLongSheet(warband, chapter, user, showRules);
				addNotes(warband, chapter);
			}

			document.add(chapter);
			document.close();

			return out.toByteArray();
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
		return (++i % 2 == 0) ? GrayColor.LIGHT_GRAY : GrayColor.WHITE;
	}

	private static void printShortSheet(Warband warband, Chapter chapter, User user, boolean showRules) {

		centeredCell.setBackgroundColor(GrayColor.CYAN);

		float[] columnWidths = { 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 3, 1, 1, 4 };
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
		pTable.addCell(addCenterCellText("Special"));

		// ++++++++++++++++++++++++++++++++

		printShortCharacterSection(warband, pTable);

		chapter.add(pTable);

		if (!rangedWeapons.isEmpty() && showRules) {
			chapter.add(new Paragraph(" "));
			chapter.add(addRangedList(rangedWeapons));
		}

		if (!meleeWeapons.isEmpty() && showRules) {
			chapter.add(new Paragraph(" "));
			chapter.add(addMeleeList(meleeWeapons));
		}

		if (!grenadeList.isEmpty() && showRules) {
			chapter.add(new Paragraph(" "));
			chapter.add(addGrenadeList(grenadeList));
		}

		if (!mutationList.isEmpty() && showRules) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList("Mutations", mutationList));
		}

		if (!detrimentList.isEmpty() && showRules) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList("Detriments", detrimentList));
		}

		if (!injuryList.isEmpty() && showRules) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList("Injuries", injuryList));
		}

		if (!specialRules.isEmpty() && showRules) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList("Special Rules", specialRules));
		}

		if (!skillList.isEmpty() && showRules) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList("Skills", skillList));
		}

		if (!generalAbilityList.isEmpty() && showRules) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList("General Abilities", generalAbilityList));
		}

		if (!equipmentList.isEmpty() && showRules) {
			chapter.add(new Paragraph(" "));
			chapter.add(addSpecialRulesList("Equipment", equipmentList));
		}
	}

	private static void printShortCharacterSection(Warband warband, PdfPTable pTable) {
		int i = 0;

		Map<String, TntCharacter> sortedCharacterList = new TreeMap<String, TntCharacter>();

		for (TntCharacter tntCharacter : warband.getTntCharacters()) {
			sortedCharacterList
							.put(tntCharacter.getWarbandUnit().getId() + tntCharacter.getName() + tntCharacter.getId(), tntCharacter);
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

			String weapons = "";
			for (RangedWeapon weapon : tntCharacter.getRangedWeapons()) {
				weapons += weapon.getType() + ", ";

				for (SpecialRule specialRule : weapon.getSpecialRules()) {
					specialRules.put(specialRule.getName(), specialRule.getDescription());
				}

				rangedWeapons.put(weapon.getId(), weapon);
			}

			for (MeleeWeapon weapon : tntCharacter.getMeleeWeapons()) {
				weapons += weapon.getType() + ", ";

				for (SpecialRule specialRule : weapon.getSpecialRules()) {
					specialRules.put(specialRule.getName(), specialRule.getDescription());
				}

				meleeWeapons.put(weapon.getId(), weapon);
			}

			for (Grenade grenade : tntCharacter.getGrenades()) {
				weapons += grenade.getType() + ", ";

				for (SpecialRule specialRule : grenade.getSpecialRules()) {
					specialRules.put(specialRule.getName(), specialRule.getDescription());
				}

				grenadeList.put(grenade.getId(), grenade);
			}

			pTable.addCell(addLeftCellText(weapons));

			String armors = "";
			for (Armor armor : tntCharacter.getArmors()) {
				armors += armor.getType() + ", ";
			}

			pTable.addCell(addLeftCellText(armors));
			pTable.addCell(addCenterCellText(tntCharacter.getBaseCost().toString()));
			pTable.addCell(addCenterCellText(" "));// XP

			String text = "";
			for (Skill skill : tntCharacter.getSkills()) {
				text += skill.getName() + ", ";
				skillList.put(skill.getName(), skill.getDescription());
			}

			for (Mutation mutation : tntCharacter.getMutations()) {
				text += mutation.getName() + ", ";
				mutationList.put(mutation.getName(), mutation.getDescription());
			}

			for (Detriment detriment : tntCharacter.getDetriments()) {
				text += detriment.getName() + ", ";
				detrimentList.put(detriment.getName(), detriment.getDescription());
			}

			for (GeneralAbility ability : tntCharacter.getGeneralAbilities()) {
				text += ability.getName() + ", ";
				generalAbilityList.put(ability.getName(), ability.getDescription());
			}

			for (Injury injury : tntCharacter.getInjuries()) {
				text += injury.getName() + ", ";
				injuryList.put(injury.getName(), injury.getDescription());
			}

			for (Equipment equipment : tntCharacter.getEquipment()) {
				text += equipment.getItem() + ", ";
				equipmentList.put(equipment.getItem(), equipment.getItem());
			}

			pTable.addCell(addLeftCellText(text));
		}
	}

	private static PdfPTable addSpecialRulesList(String name, Map<String, String> rules) {
		float[] columnWidths = { 1, 10 };
		PdfPTable pTable = new PdfPTable(columnWidths);
		pTable.setWidthPercentage(100);

		centeredCell.setBackgroundColor(GrayColor.CYAN);
		pTable.addCell(addCenterCellText(name));
		pTable.addCell(addCenterCellText("Description"));

		int i = 0;
		for (String key : rules.keySet()) {
			++i;
			leftCell.setBackgroundColor(getBackgroundColor(i));
			leftCell.setBackgroundColor(getBackgroundColor(i));

			pTable.addCell(addLeftCellText(key));
			pTable.addCell(addLeftCellText(rules.get(key)));
		}

		return pTable;
	}

	private static PdfPTable addRangedList(Map<Integer, RangedWeapon> rangedWeapons) {
		float[] columnWidths = { 2, 1, 1, 1, 1, 5 };
		PdfPTable pTable = new PdfPTable(columnWidths);
		pTable.setWidthPercentage(100);

		centeredCell.setBackgroundColor(GrayColor.CYAN);

		pTable.addCell(addCenterCellText("Ranged Weapon"));
		pTable.addCell(addCenterCellText("Range"));
		pTable.addCell(addCenterCellText("Strength"));
		pTable.addCell(addCenterCellText("Reliabiltiy"));
		pTable.addCell(addCenterCellText("1H / 2H"));
		pTable.addCell(addCenterCellText("Special Rules"));

		int i = 0;
		for (RangedWeapon weapon : rangedWeapons.values()) {
			++i;
			centeredCell.setBackgroundColor(getBackgroundColor(i));
			leftCell.setBackgroundColor(getBackgroundColor(i));

			pTable.addCell(addLeftCellText(weapon.getType()));
			pTable.addCell(addCenterCellText(weapon.getMaxRange().toString()));
			pTable.addCell(addCenterCellText(weapon.getStrength().toString()));
			pTable.addCell(addCenterCellText(weapon.getReliability().toString()));
			pTable.addCell(addCenterCellText(weapon.getOneHanded() ? "1H" : "2H"));

			String specialRules = "";
			for (SpecialRule specialRule : weapon.getSpecialRules()) {
				specialRules += specialRule.getName() + ", ";
			}

			pTable.addCell(addLeftCellText(specialRules));

		}

		return pTable;
	}

	private static PdfPTable addGrenadeList(Map<Integer, Grenade> grenadeList) {
		float[] columnWidths = { 2, 1, 5 };
		PdfPTable pTable = new PdfPTable(columnWidths);
		pTable.setWidthPercentage(100);

		centeredCell.setBackgroundColor(GrayColor.CYAN);

		pTable.addCell(addCenterCellText("Grenade"));
		pTable.addCell(addCenterCellText("Strength"));
		pTable.addCell(addCenterCellText("Special Rules"));

		int i = 0;
		for (Grenade grenade : grenadeList.values()) {
			++i;
			centeredCell.setBackgroundColor(getBackgroundColor(i));
			leftCell.setBackgroundColor(getBackgroundColor(i));

			pTable.addCell(addLeftCellText(grenade.getType()));
			pTable.addCell(addCenterCellText(grenade.getStrength().toString()));

			String specialRules = "";
			for (SpecialRule specialRule : grenade.getSpecialRules()) {
				specialRules += specialRule.getName() + ", ";
			}

			pTable.addCell(addLeftCellText(specialRules));

		}

		return pTable;
	}

	private static PdfPTable addMeleeList(Map<Integer, MeleeWeapon> meleeWeapons) {
		float[] columnWidths = { 2, 1, 1, 1, 1, 1, 5 };
		PdfPTable pTable = new PdfPTable(columnWidths);
		pTable.setWidthPercentage(100);

		centeredCell.setBackgroundColor(GrayColor.CYAN);

		pTable.addCell(addCenterCellText("Melee Weapon"));
		pTable.addCell(addCenterCellText("Melee Range"));
		pTable.addCell(addCenterCellText("Thrown Range"));
		pTable.addCell(addCenterCellText("Strength"));
		pTable.addCell(addCenterCellText("Reliabiltiy"));
		pTable.addCell(addCenterCellText("1H / 2H"));
		pTable.addCell(addCenterCellText("Special Rules"));

		int i = 0;
		for (MeleeWeapon weapon : meleeWeapons.values()) {
			++i;
			centeredCell.setBackgroundColor(getBackgroundColor(i));
			leftCell.setBackgroundColor(getBackgroundColor(i));

			pTable.addCell(addLeftCellText(weapon.getType()));
			pTable.addCell(addCenterCellText(weapon.getMeleeRange().toString()));
			pTable.addCell(addCenterCellText(weapon.getThrownRange().toString()));
			pTable.addCell(addCenterCellText(weapon.getStrength().toString()));
			pTable.addCell(addCenterCellText(weapon.getReliability().toString()));
			pTable.addCell(addCenterCellText(weapon.getOneHanded() ? "1H" : "2H"));

			String specialRules = "";
			for (SpecialRule specialRule : weapon.getSpecialRules()) {
				specialRules += specialRule.getName() + ", ";
			}

			pTable.addCell(addLeftCellText(specialRules));

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

	private static void printLongSheet(Warband warband, Chapter chapter, User user, boolean showRules) {
		for (TntCharacter tntCharacter : warband.getTntCharacters()) {
			try {
				handleCharacter(tntCharacter, chapter, user, showRules);
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	private static void handleCharacter(TntCharacter tntCharacter, Chapter chapter, User user, boolean showRules) {
		Paragraph p = new Paragraph(tntCharacter.getName(), BOLD_FONT);
		chapter.add(p);

		if (tntCharacter.getBackground() != null) {
			p = new Paragraph(tntCharacter.getBackground());
			chapter.add(p);
		}

		chapter.add(setCharacterStats(tntCharacter, user, showRules));

	}

	private static PdfPTable setCharacterStats(TntCharacter tntCharacter, User user, boolean showRules) {
		PdfPTable pTable = new PdfPTable(1);
		pTable.setWidthPercentage(100);

		buildBasicInfo(tntCharacter, pTable);
		buildStatLine(tntCharacter, pTable);

		if (!tntCharacter.getMutations().isEmpty()) {
			buildMutationsLine(tntCharacter, pTable, user, showRules);
		}

		if (!tntCharacter.getDetriments().isEmpty()) {
			buildDetrimentsLine(tntCharacter, pTable, user, showRules);
		}

		if (!tntCharacter.getGeneralAbilities().isEmpty()) {
			buildSpecialRulesLine(tntCharacter, pTable, user, showRules);
		}

		if (!tntCharacter.getSkills().isEmpty()) {
			buildSkillsLine(tntCharacter, pTable, user, showRules);
		}

		if (!tntCharacter.getEquipment().isEmpty()) {
			buildEquipmentLine(tntCharacter, pTable);
		}

		if (!tntCharacter.getInjuries().isEmpty()) {
			buildInjuriesLine(tntCharacter, pTable, user, showRules);
		}

		if (!tntCharacter.getArmors().isEmpty()) {
			buildArmorLine(tntCharacter, pTable, user, showRules);
		}

		if (!tntCharacter.getRangedWeapons().isEmpty()) {
			buildRangedWeaponLine(tntCharacter, pTable, user, showRules);
		}

		if (!tntCharacter.getMeleeWeapons().isEmpty()) {
			buildMeleeWeaponLine(tntCharacter, pTable, user, showRules);
		}

		if (!tntCharacter.getGrenades().isEmpty()) {
			buildGrenadeLine(tntCharacter, pTable, user);
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
		statTable.addCell("Strength");
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

		String equipmentText = "";
		for (Equipment equipment : tntCharacter.getEquipment()) {
			equipmentText += equipment.getItem() + ", ";
		}
		PdfPCell cell = new PdfPCell(new Phrase(equipmentText));
		cell.setColspan(7);
		equipmentTable.addCell(cell);

		outerTable.addCell(equipmentTable);
	}

	private static void buildMutationsLine(TntCharacter tntCharacter, PdfPTable outerTable, User user, boolean showRules) {
		PdfPTable mutationTable = new PdfPTable(8);
		mutationTable.setWidthPercentage(100);
		mutationTable.addCell("Mutations");

		String mutationText = "";
		for (Mutation mutation : tntCharacter.getMutations()) {
			mutationText += mutation.getName()
							+ (showRules ? " [" + mutation.getMutationTypeName() + "]  : " + mutation.getDescription() : "") + ", ";
		}

		PdfPCell cell = new PdfPCell(new Phrase(mutationText));
		cell.setColspan(7);
		mutationTable.addCell(cell);

		outerTable.addCell(mutationTable);
	}

	private static void buildDetrimentsLine(TntCharacter tntCharacter, PdfPTable outerTable, User user, boolean showRules) {
		PdfPTable detrimentTable = new PdfPTable(8);
		detrimentTable.setWidthPercentage(100);
		detrimentTable.addCell("Detriments");

		String detrimentsText = "";
		for (Detriment detriment : tntCharacter.getDetriments()) {
			detrimentsText += detriment.getName()
							+ (showRules ? " [" + detriment.getDetrimentTypeId() + "] : " + detriment.getDescription() : "") + ", ";
		}

		PdfPCell cell = new PdfPCell(new Phrase(detrimentsText));
		cell.setColspan(7);
		detrimentTable.addCell(cell);

		outerTable.addCell(detrimentTable);
	}

	private static void buildSkillsLine(TntCharacter tntCharacter, PdfPTable outerTable, User user, boolean showRules) {
		PdfPTable skillsTable = new PdfPTable(8);
		skillsTable.setWidthPercentage(100);
		skillsTable.addCell("Skills");

		String skillText = "";
		for (Skill skill : tntCharacter.getSkills()) {
			skillText += skill.getName() + (showRules ? ": " + skill.getDescription() : "") + ", ";
		}
		PdfPCell cell = new PdfPCell(new Phrase(skillText));
		cell.setColspan(7);
		skillsTable.addCell(cell);

		outerTable.addCell(skillsTable);

	}

	private static void buildSpecialRulesLine(TntCharacter tntCharacter, PdfPTable outerTable, User user, boolean showRules) {
		PdfPTable specialRulesTable = new PdfPTable(8);
		specialRulesTable.setWidthPercentage(100);
		specialRulesTable.addCell("Special Rules");

		String specialRulesText = "";
		for (GeneralAbility generalAbility : tntCharacter.getGeneralAbilities()) {
			specialRulesText += generalAbility.getName() + (showRules ? ": " + generalAbility.getDescription() : "") + ", ";
		}
		PdfPCell cell = new PdfPCell(new Phrase(specialRulesText));
		cell.setColspan(7);
		specialRulesTable.addCell(cell);

		outerTable.addCell(specialRulesTable);

	}

	private static void buildInjuriesLine(TntCharacter tntCharacter, PdfPTable outerTable, User user, boolean showRules) {
		PdfPTable injuryTable = new PdfPTable(8);
		injuryTable.addCell("Injuries");

		String injuriesText = "";
		for (Injury injury : tntCharacter.getInjuries()) {
			injuriesText += injury.getName() + (showRules ? ": " + injury.getDescription() : "") + ", ";
		}

		PdfPCell cell = new PdfPCell(new Phrase(injuriesText));
		cell.setColspan(7);
		injuryTable.addCell(cell);

		outerTable.addCell(injuryTable);
	}

	private static void buildArmorLine(TntCharacter tntCharacter, PdfPTable outerTable, User user, boolean showRules) {

		PdfPTable rangedWeaponsTable = new PdfPTable(8);
		rangedWeaponsTable.setWidthPercentage(100);
		rangedWeaponsTable.addCell("Armor");

		PdfPCell cell;

		if (showRules) {
			cell = new PdfPCell(buildArmorBlah(tntCharacter));
		} else {
			String armorText = "";
			for (Armor armor : tntCharacter.getArmors()) {
				armorText += armor.getType() + ", ";
			}

			cell = new PdfPCell(new Phrase(armorText));
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
		armorTable.addCell("Special Rules");

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

			String specialRules = "";
			for (SpecialRule specialRule : armor.getSpecialRules()) {
				specialRules += specialRule.getName() + ",";
			}

			armorTable.addCell(specialRules);

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

	private static void buildRangedWeaponLine(TntCharacter tntCharacter, PdfPTable outerTable, User user, boolean showRules) {
		PdfPTable rangedWeaponsTable = new PdfPTable(8);
		rangedWeaponsTable.setWidthPercentage(100);
		rangedWeaponsTable.addCell("Ranged Weapons");

		PdfPCell cell;
		if (showRules) {
			cell = new PdfPCell(buildRangedWeaponTable(tntCharacter.getRangedWeapons()));
		} else {
			String rangedWeaponsText = "";
			for (RangedWeapon weapon : tntCharacter.getRangedWeapons()) {
				rangedWeaponsText += weapon.getType() + ", ";
			}

			cell = new PdfPCell(new Phrase(rangedWeaponsText));
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
		weaponTable.addCell("Strength");
		weaponTable.addCell("Reliability");
		weaponTable.addCell("1H/2H");
		weaponTable.addCell("Special Rules");
		weaponTable.addCell("BS Cost");

		for (RangedWeapon rangedWeapon : weapons) {
			weaponTable.addCell(rangedWeapon.getType());
			weaponTable.addCell(rangedWeapon.getMaxRange().toString());
			weaponTable.addCell(rangedWeapon.getStrength().toString());
			weaponTable.addCell(rangedWeapon.getReliability().toString());
			weaponTable.addCell(rangedWeapon.getOneHanded() ? "1H" : "2H");

			String specialRules = "";
			for (SpecialRule specialRule : rangedWeapon.getSpecialRules()) {
				specialRules += specialRule.getName() + ",";
			}

			weaponTable.addCell(specialRules);
			weaponTable.addCell(rangedWeapon.getCost().toString());
		}

		return weaponTable;
	}

	private static void buildMeleeWeaponLine(TntCharacter tntCharacter, PdfPTable outerTable, User user, boolean showRules) {
		PdfPTable meleeWeaponsTable = new PdfPTable(8);
		meleeWeaponsTable.setWidthPercentage(100);
		meleeWeaponsTable.addCell("Melee Weapons");

		PdfPCell cell;

		if (showRules) {
			cell = new PdfPCell(buildMeleeWeaponTable(tntCharacter.getMeleeWeapons()));
		} else {
			String meleeWeaponsText = "";
			for (MeleeWeapon weapon : tntCharacter.getMeleeWeapons()) {
				meleeWeaponsText += weapon.getType() + ", ";
			}

			cell = new PdfPCell(new Phrase(meleeWeaponsText));
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
		weaponTable.addCell("Strength");
		weaponTable.addCell("Reliability");
		weaponTable.addCell("1H/2H");
		weaponTable.addCell("Special Rules");
		weaponTable.addCell("BS Cost");

		for (MeleeWeapon meleeWeapon : weapons) {
			weaponTable.addCell(meleeWeapon.getType());
			weaponTable.addCell(meleeWeapon.getMeleeRange().toString());
			weaponTable.addCell(meleeWeapon.getThrownRange().toString());
			weaponTable.addCell(meleeWeapon.getStrength().toString());

			weaponTable.addCell(meleeWeapon.getReliability() > 0 ? meleeWeapon.getReliability().toString() : "");
			weaponTable.addCell(meleeWeapon.getOneHanded() ? "1H" : "2H");

			String specialRules = "";
			for (SpecialRule specialRule : meleeWeapon.getSpecialRules()) {
				specialRules += specialRule.getName() + ",";
			}

			weaponTable.addCell(specialRules);
			weaponTable.addCell(meleeWeapon.getCost().toString());
		}

		return weaponTable;
	}

	private static void buildGrenadeLine(TntCharacter tntCharacter, PdfPTable outerTable, User user) {

		PdfPTable rangedWeaponsTable = new PdfPTable(8);
		rangedWeaponsTable.setWidthPercentage(100);
		rangedWeaponsTable.addCell("Grenades");

		String grenadeText = "";
		for (Grenade grenade : tntCharacter.getGrenades()) {
			grenadeText += grenade.getType() + ", ";
		}

		PdfPCell cell = new PdfPCell(new Phrase(grenadeText));
		cell.setColspan(7);
		rangedWeaponsTable.addCell(cell);

		outerTable.addCell(rangedWeaponsTable);
	}
}
