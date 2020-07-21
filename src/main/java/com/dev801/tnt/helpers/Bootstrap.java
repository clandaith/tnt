package com.dev801.tnt.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		LOGGER.info("Starting up...");
	}
}