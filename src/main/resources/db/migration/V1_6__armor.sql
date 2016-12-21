
--+++++++++++++++++++++
CREATE TABLE armor (
	id SERIAL  not null primary key,
	type VARCHAR(32) unique NOT NULL ,
	melee_bonus INTEGER NOT NULL ,
	ranged_bonus INTEGER NOT NULL ,
	--special_rules,
	cost_by_wound_1 INTEGER NOT NULL ,
	cost_by_wound_2 INTEGER NOT NULL ,
	cost_by_wound_3 INTEGER NOT NULL ,
	rarity_id INTEGER NOT NULL 
);
ALTER TABLE armor ADD CONSTRAINT FK_armor_rarity FOREIGN KEY (rarity_id) REFERENCES rarity_levels(id) ON DELETE CASCADE;


create table armour_special_rules_link(
	armour_id INTEGER NOT NULL ,
	special_rule_id INTEGER NOT NULL 
);
ALTER TABLE armour_special_rules_link ADD CONSTRAINT FK_ar_srl1 FOREIGN KEY (armour_id ) REFERENCES armor(id) ON DELETE CASCADE;
ALTER TABLE armour_special_rules_link ADD CONSTRAINT FK_ar_srl2 FOREIGN KEY (special_rule_id) REFERENCES special_rules(id) ON DELETE CASCADE;


