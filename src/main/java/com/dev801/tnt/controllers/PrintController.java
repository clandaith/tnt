package com.dev801.tnt.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev801.tnt.data.Warband;
import com.dev801.tnt.helpers.PdfPrinter;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class PrintController extends ControllerHelper {
	private static final Logger LOGGER = LogManager.getLogger(PrintController.class);

	@GetMapping(value = "/printWithRules")
	public void printWarbandWithRules(@RequestParam(value = "length", defaultValue = "short") String length,
			HttpServletResponse response, HttpSession session) {
		LOGGER.info("Printing Warband with rules");

		printWarband(response, session, true, length);
	}

	@GetMapping(value = "/print")
	public void printWarbandNoRules(@RequestParam(value = "length", defaultValue = "short") String length,
			HttpServletResponse response, HttpSession session) {
		LOGGER.info("Printing Warband no rules");

		printWarband(response, session, false, length);
	}

	public void printWarband(HttpServletResponse response, HttpSession session, boolean showRules, String length) {
		LOGGER.info("Printing Warband");

		try {
			Warband warband = (Warband) session.getAttribute("warband");

			if (warband.getWarbandName() == null) {
				warband.setWarbandName("Unknown");
			}

			byte[] warbandBytes = PdfPrinter.printWarband(warband, showRules,
					"short".equalsIgnoreCase(length) ? Boolean.TRUE : Boolean.FALSE);

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition",
					String.format("inline; filename=\"" + warband.getWarbandName() + ".pdf\""));
			response.setContentLength(warbandBytes.length);

			InputStream inputStream = new ByteArrayInputStream(warbandBytes);
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		} catch (IOException e) {
			LOGGER.error("Error: ", e);
		}
	}
}