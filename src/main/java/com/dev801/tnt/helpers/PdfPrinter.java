package com.dev801.tnt.helpers;

import java.io.ByteArrayOutputStream;

import org.apache.log4j.Logger;

import com.dev801.tnt.data.Detriment;
import com.dev801.tnt.data.Equipment;
import com.dev801.tnt.data.GeneralAbility;
import com.dev801.tnt.data.MeleeWeapon;
import com.dev801.tnt.data.Mutation;
import com.dev801.tnt.data.RangedWeapon;
import com.dev801.tnt.data.TntCharacter;
import com.dev801.tnt.data.Warband;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfPrinter {
	private static final Logger LOGGER = Logger.getLogger(PdfPrinter.class);

	public static byte[] printWarband(Warband warband) {
		try {
			Document document = new Document();

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, out);
			document.open();

			Chapter chapter = new Chapter(1);
			handleWarbandSection(warband, chapter);

			chapter.setNumberDepth(0);
			handleCharacters(warband, chapter);

			document.add(chapter);
			document.close();

			return out.toByteArray();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return warband.toString().getBytes();
		}
	}

	private static void handleWarbandSection(Warband warband, Chapter chapter) {
		Paragraph p = new Paragraph("Warband '" + warband.getWarbandName() + "'");
		chapter.add(p);

		p = new Paragraph("Warband Backstory: '" + warband.getBackground() + "'");
		chapter.add(p);
	}

	private static void handleCharacters(Warband warband, Chapter chapter) {
		for (TntCharacter tntCharacter : warband.getTntCharacters()) {
			handleCharacter(tntCharacter, chapter);
		}
	}

	private static void handleCharacter(TntCharacter tntCharacter, Chapter chapter) {
		Paragraph p = new Paragraph("Name: '" + tntCharacter.getName() + "'");
		chapter.add(p);
		p = new Paragraph("Background: '" + tntCharacter.getBackground() + "'");
		chapter.add(p);

		chapter.add(setCharacterStats(tntCharacter));

	}

	private static PdfPTable setCharacterStats(TntCharacter tntCharacter) {
		PdfPTable pTable = new PdfPTable(1);
		pTable.setWidthPercentage(100);

		buildBasicInfo(tntCharacter, pTable);
		buildStatLine(tntCharacter, pTable);

		if (!tntCharacter.getMutations().isEmpty()) {
			buildMutationsLine(tntCharacter, pTable);
		}

		if (!tntCharacter.getDetriments().isEmpty()) {
			buildDetrimentsLine(tntCharacter, pTable);
		}

		if (!tntCharacter.getGeneralAbilities().isEmpty()) {
			buildSpecialRulesLine(tntCharacter, pTable);
		}

		if (!tntCharacter.getEquipment().isEmpty()) {
			buildEquipmentLine(tntCharacter, pTable);
		}

		// if(!tntCharacter.getInjuries().isEmpty()){
		// buildInjuriesLine(tntCharacter, pTable);
		// }

		if (!tntCharacter.getArmors().isEmpty()) {
			buildArmorLine(tntCharacter, pTable);
		}

		if (!tntCharacter.getRangedWeapons().isEmpty()) {
			buildRangedWeaponLine(tntCharacter, pTable);
		}

		if (!tntCharacter.getMeleeWeapons().isEmpty()) {
			buildMeleeWeaponLine(tntCharacter, pTable);
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

		basicInfoTable.addCell(tntCharacter.getTitle());
		basicInfoTable.addCell(tntCharacter.getUnitTypeId().toString());
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

	private static void buildMutationsLine(TntCharacter tntCharacter, PdfPTable outerTable) {
		PdfPTable mutationTable = new PdfPTable(8);
		mutationTable.setWidthPercentage(100);
		mutationTable.addCell("Mutations");

		String mutationText = "";
		for (Mutation mutation : tntCharacter.getMutations()) {
			mutationText += mutation.getName() + "[" + mutation.getMutationTypeName() + "]" + " : " + mutation.getDescription() + ", ";
		}

		PdfPCell cell = new PdfPCell(new Phrase(mutationText));
		cell.setColspan(7);
		mutationTable.addCell(cell);

		outerTable.addCell(mutationTable);
	}

	private static void buildDetrimentsLine(TntCharacter tntCharacter, PdfPTable outerTable) {
		PdfPTable detrimentTable = new PdfPTable(8);
		detrimentTable.setWidthPercentage(100);
		detrimentTable.addCell("Detriments");

		String detrimentsText = "";
		for (Detriment detriment : tntCharacter.getDetriments()) {
			detrimentsText += detriment.getName() + "[" + detriment.getDetrimentTypeId() + "]" + " : " + detriment.getDescription()
							+ ", ";
		}

		PdfPCell cell = new PdfPCell(new Phrase(detrimentsText));
		cell.setColspan(7);
		detrimentTable.addCell(cell);

		outerTable.addCell(detrimentTable);
	}

	private static void buildSpecialRulesLine(TntCharacter tntCharacter, PdfPTable outerTable) {
		PdfPTable specialRulesTable = new PdfPTable(8);
		specialRulesTable.setWidthPercentage(100);
		specialRulesTable.addCell("Special Rules");

		String specialRulesText = "";
		for (GeneralAbility generalAbility : tntCharacter.getGeneralAbilities()) {
			specialRulesText += generalAbility.getName() + ": " + generalAbility.getDescription() + ", ";
		}
		PdfPCell cell = new PdfPCell(new Phrase(specialRulesText));
		cell.setColspan(7);
		specialRulesTable.addCell(cell);

		outerTable.addCell(specialRulesTable);

	}

	// private static void buildInjuriesLine(TntCharacter tntCharacter, PdfPTable outerTable) {
	// PdfPTable injuryTable = new PdfPTable(8);
	// injuryTable.addCell("Injuries");
	//
	// // String equipmentText = "";
	// // for (Equipment equipment : tntCharacter.getEquipment()) {
	// // equipmentText += equipment.getItem() + ", ";
	// // }
	// PdfPCell cell = new PdfPCell(new Phrase(""));
	// cell.setColspan(7);
	// injuryTable.addCell(cell);
	//
	// outerTable.addCell(injuryTable);
	//
	// }

	private static void buildArmorLine(TntCharacter tntCharacter, PdfPTable outerTable) {

	}

	private static void buildRangedWeaponLine(TntCharacter tntCharacter, PdfPTable outerTable) {
		PdfPTable rangedWeaponsTable = new PdfPTable(8);
		rangedWeaponsTable.setWidthPercentage(100);
		rangedWeaponsTable.addCell("Ranged Weapons");

		String rangedWeaponsText = "";
		for (RangedWeapon rangedWeapon : tntCharacter.getRangedWeapons()) {
			rangedWeaponsText += rangedWeapon.getType() + "[" + rangedWeapon.getRarityLevelName() + "]" + " : "
							+ rangedWeapon.getStrength() + ", ";
		}

		PdfPCell cell = new PdfPCell(new Phrase(rangedWeaponsText));
		cell.setColspan(7);
		rangedWeaponsTable.addCell(cell);

		outerTable.addCell(rangedWeaponsTable);
	}

	private static void buildMeleeWeaponLine(TntCharacter tntCharacter, PdfPTable outerTable) {
		PdfPTable meleeWeaponsTable = new PdfPTable(8);
		meleeWeaponsTable.setWidthPercentage(100);
		meleeWeaponsTable.addCell("Melee Weapons");

		String meleeWeaponsText = "";
		for (MeleeWeapon meleeWeapon : tntCharacter.getMeleeWeapons()) {
			meleeWeaponsText += meleeWeapon.getType() + "[" + meleeWeapon.getRarityLevelName() + "]" + " : "
							+ meleeWeapon.getStrength() + ", ";
		}

		PdfPCell cell = new PdfPCell(new Phrase(meleeWeaponsText));
		cell.setColspan(7);
		meleeWeaponsTable.addCell(cell);

		outerTable.addCell(meleeWeaponsTable);
	}
}
