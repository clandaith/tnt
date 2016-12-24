package com.dev801.tnt.helpers;

import java.io.ByteArrayOutputStream;

import org.apache.log4j.Logger;

import com.dev801.tnt.data.Warband;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfPrinter {
	private static final Logger LOGGER = Logger.getLogger(PdfPrinter.class);

	public static byte[] printWarband(Warband warband) {
		try {
			Document document = new Document();

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, out);
			document.open();
			Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
			Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
			Chunk chunk = new Chunk("Warband '" + warband.getWarbandName() + "'", chapterFont);
			Chapter chapter = new Chapter(new Paragraph(chunk), 1);
			chapter.setNumberDepth(0);
			chapter.add(new Paragraph("This is the paragraph", paragraphFont));
			document.add(chapter);
			document.close();

			return out.toByteArray();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return warband.toString().getBytes();
		}

	}
}
