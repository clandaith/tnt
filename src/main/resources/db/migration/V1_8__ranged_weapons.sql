
--+++++++++++++++++++++
CREATE TABLE ranged_weapons (
	id SERIAL  not null primary key,
	type VARCHAR(32) unique NOT NULL ,
	max_range INTEGER NOT NULL ,
	strength INTEGER NOT NULL ,
	one_handed BOOLEAN NOT NULL ,
	reliabiltiy INTEGER NOT NULL ,
	cost INTEGER NOT NULL ,
	rarity_id  INTEGER NOT NULL 
);
ALTER TABLE ranged_weapons ADD CONSTRAINT FK_ranged_weapons_rarity FOREIGN KEY (rarity_id) REFERENCES rarity_levels(id) ON DELETE CASCADE;

--+++

create table ranged_weapons_special_rules_link(
	ranged_weapons_id INTEGER NOT NULL ,
	special_rule_id INTEGER NOT NULL 
);
ALTER TABLE ranged_weapons_special_rules_link ADD CONSTRAINT FK_rw_srl1 FOREIGN KEY (ranged_weapons_id ) REFERENCES ranged_weapons(id) ON DELETE CASCADE;
ALTER TABLE ranged_weapons_special_rules_link ADD CONSTRAINT FK_rw_srl2 FOREIGN KEY (special_rule_id) REFERENCES special_rules(id) ON DELETE CASCADE;


