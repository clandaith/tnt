--+++++++++++++++++++++
CREATE TABLE melee_weapons (
	id SERIAL  not null primary key,
	type VARCHAR(32) unique NOT NULL ,
	melee_range INTEGER NOT NULL ,
	thrown_range INTEGER NOT NULL ,
	strength INTEGER NOT NULL ,
	one_handed BOOLEAN NOT NULL ,
	cost INTEGER NOT NULL ,
	rarity_id  INTEGER NOT NULL 
);
ALTER TABLE melee_weapons ADD CONSTRAINT FK_melee_weapons_rarity FOREIGN KEY (rarity_id) REFERENCES rarity_levels(id) ON DELETE CASCADE;

--+++

create table melee_weapons_special_rules_link(
	melee_weapons_id INTEGER NOT NULL ,
	special_rule_id INTEGER NOT NULL 
);
ALTER TABLE melee_weapons_special_rules_link ADD CONSTRAINT FK_mw_srl1 FOREIGN KEY (melee_weapons_id ) REFERENCES melee_weapons(id) ON DELETE CASCADE;
ALTER TABLE melee_weapons_special_rules_link ADD CONSTRAINT FK_mw_srl2 FOREIGN KEY (special_rule_id) REFERENCES special_rules(id) ON DELETE CASCADE;


