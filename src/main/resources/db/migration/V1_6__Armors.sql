
--+++++++++++++++++++++
CREATE TABLE armors (
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
ALTER TABLE armors ADD CONSTRAINT FK_armor_rarity FOREIGN KEY (rarity_id) REFERENCES rarity_levels(id) ON DELETE CASCADE;


create table armor_special_rules_link(
	armor_id INTEGER NOT NULL ,
	special_rule_id INTEGER NOT NULL 
);
ALTER TABLE armor_special_rules_link ADD CONSTRAINT FK_ar_srl1 FOREIGN KEY (armor_id ) REFERENCES armors(id) ON DELETE CASCADE;
ALTER TABLE armor_special_rules_link ADD CONSTRAINT FK_ar_srl2 FOREIGN KEY (special_rule_id) REFERENCES special_rules(id) ON DELETE CASCADE;


create view armors_view as
select armors.*, rarity_levels.name as rarity_level_name from armors join rarity_levels on armors.rarity_id = rarity_levels.id
