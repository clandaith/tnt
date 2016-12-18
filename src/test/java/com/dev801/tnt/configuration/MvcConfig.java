package com.dev801.tnt.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("pages/warband");
		registry.addViewController("/").setViewName("pages/warband");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/about801dev").setViewName("about801dev");
		registry.addViewController("/roadmap").setViewName("roadmap");
	}

}