--+++++++++++++++++++++
CREATE TABLE equipment (
	id SERIAL  not null primary key,
	item VARCHAR(32) unique NOT NULL ,
	cost INTEGER NOT NULL ,
	rarity_id INTEGER NOT NULL 
);

ALTER TABLE equipment ADD CONSTRAINT FK_equipment_rarity FOREIGN KEY (rarity_id) REFERENCES rarity_levels(id) ON DELETE CASCADE;


create view equipment_view as
select equipment.*, rarity_levels.name as rarity_level_name from equipment join rarity_levels on equipment.rarity_id = rarity_levels.id


