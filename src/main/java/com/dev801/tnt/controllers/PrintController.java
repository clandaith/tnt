package com.dev801.tnt.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev801.tnt.data.Warband;
import com.dev801.tnt.helpers.PdfPrinter;

@Controller
public class PrintController {
	private static Logger LOGGER = Logger.getLogger(PrintController.class);

	@RequestMapping(value = "/print", params = { "printWarband" }, method = RequestMethod.POST)
	public void printWarband(HttpServletResponse response, @Valid Warband warband, BindingResult bindingResult, Model model,
					HttpSession session) {
		LOGGER.info("Printing Warband");

		try {
			byte[] warbandBytes = PdfPrinter.printWarband(warband);

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