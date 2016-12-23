package com.dev801.tnt.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ForgotPasswordController {
	private static final Logger LOGGER = Logger.getLogger(ForgotPasswordController.class);

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public String getPage() {

		return "forgotpassword";
	}
}
