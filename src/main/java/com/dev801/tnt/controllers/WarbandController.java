package com.dev801.tnt.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev801.tnt.repositories.WarbandsRepository;

@Controller
public class WarbandController {
	private static final Logger LOGGER = Logger.getLogger(WarbandController.class);

	@Autowired
	WarbandsRepository warbandsRepository;

	@RequestMapping("/warbands")
	public String blah() {

		return "";
	}
}
