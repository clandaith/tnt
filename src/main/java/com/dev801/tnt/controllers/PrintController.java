package com.dev801.tnt.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev801.tnt.data.Warband;
import com.dev801.tnt.helpers.PdfPrinter;

@Controller
public class PrintController extends ControllerHelper {
	private static Logger LOGGER = Logger.getLogger(PrintController.class);

	@RequestMapping(value = "/printWithRules", method = RequestMethod.GET)
	public void printWarbandWithRules(@RequestParam(value = "length", defaultValue = "short") String length,
					HttpServletResponse response, HttpSession session) {
		LOGGER.info("Printing Warband with rules");

		printWarband(response, session, true, length);
	}

	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public void printWarbandNoRules(@RequestParam(value = "length", defaultValue = "short") String length,
					HttpServletResponse response, HttpSession session) {
		LOGGER.info("Printing Warband no rules");

		printWarband(response, session, false, length);
	}

	public void printWarband(HttpServletResponse response, HttpSession session, boolean showRules, String length) {
		LOGGER.info("Printing Warband");

		try {
			Warband warband = (Warband)session.getAttribute("warband");

			if (warband.getWarbandName() == null) {
				warband.setWarbandName("Unknown");
			}

			byte[] warbandBytes = PdfPrinter.printWarband(warband, getUser(session), showRules, "short".equalsIgnoreCase(length) ? true
							: false);

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + warband.getWarbandName() + ".pdf\""));
			response.setContentLength(warbandBytes.length);

			InputStream inputStream = new ByteArrayInputStream(warbandBytes);
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		} catch (IOException e) {
			LOGGER.error("Error: ", e);
		}
	}
}