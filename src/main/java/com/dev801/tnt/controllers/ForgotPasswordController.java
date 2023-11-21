package com.dev801.tnt.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/forgotpassword")
public class ForgotPasswordController extends ControllerHelper {
	private static final Logger LOGGER = LogManager.getLogger(ForgotPasswordController.class);

	@GetMapping
	public String getPage() {
		return "forgotpassword";
	}

	@PostMapping
	public String resetPassword(Model model, HttpServletRequest request) {
		LOGGER.info("Resetting password for user: " + request.getParameter("multipassName"));

		forgotPasswordService.resetPassword(request.getParameter("multipassName"));

		model.addAttribute("message",
				"Password reset email has been sent.  If you do not receive it within 24 hours, please try again.");

		return "forgotpassword";
	}

}
