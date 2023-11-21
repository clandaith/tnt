package com.dev801.tnt.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev801.tnt.data.TntCharacter;
import com.dev801.tnt.data.Warband;
import com.dev801.tnt.repositories.TntCharactersRepository;
import com.dev801.tnt.repositories.WarbandsRepository;

@Service
public class WarbandService {
	private static final Logger LOGGER = LogManager.getLogger(WarbandService.class);

	@Autowired
	WarbandsRepository warbandsRepository;
	@Autowired
	TntCharactersRepository tntCharactersRepository;

	public boolean saveWarband(Warband warband) {
		try {
			LOGGER.info("Pre:  " + warband.toString());

			List<TntCharacter> chars = warband.getTntCharacters();
			warband.setTntCharacters(new ArrayList<TntCharacter>());

			if (warband.getId() == null) {
				warband = warbandsRepository.save(warband);
			} else {
				for (TntCharacter tntChar : chars) {
					if (tntChar.getId() > 0) {
						warband.addTntCharacter(tntChar);
					}
				}
			}

			for (TntCharacter tntCharacter : chars) {
				LOGGER.info("Pre:  " + tntCharacter);

				if (tntCharacter.getId() != null && tntCharacter.getId() < 0) {
					tntCharacter.setId(null);
				}

				tntCharacter.setWarband(warband);
				tntCharacter.setId(tntCharactersRepository.save(tntCharacter).getId());

				LOGGER.info("Post: " + tntCharacter);
			}

			warband.setTntCharacters(chars);
			warband = warbandsRepository.save(warband);

			LOGGER.info("Post: " + warband.toString());
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return false;
		}
	}
}
