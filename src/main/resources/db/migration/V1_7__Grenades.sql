
--+++++++++++++++++++++
CREATE TABLE grenades (
	id SERIAL  not null primary key,
	type VARCHAR(32) unique NOT NULL ,
	strength INTEGER NOT NULL ,
	cost INTEGER NOT NULL ,
	rarity_id  INTEGER NOT NULL 
);
ALTER TABLE grenades ADD CONSTRAINT FK_grenades_rarity FOREIGN KEY (rarity_id) REFERENCES rarity_levels(id) ON DELETE CASCADE;



create table grenades_special_rules_link(
	grenade_id INTEGER NOT NULL ,
	special_rule_id INTEGER NOT NULL 
);
ALTER TABLE grenades_special_rules_link ADD CONSTRAINT FK_gr_srl1 FOREIGN KEY (grenade_id ) REFERENCES grenades(id) ON DELETE CASCADE;
ALTER TABLE grenades_special_rules_link ADD CONSTRAINT FK_gr_srl2 FOREIGN KEY (special_rule_id) REFERENCES special_rules(id) ON DELETE CASCADE;


create view grenades_view as
select grenades.*, rarity_levels.name as rarity_level_name from grenades join rarity_levels on grenades.rarity_id = rarity_levels.id
