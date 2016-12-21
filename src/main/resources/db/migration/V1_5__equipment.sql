--+++++++++++++++++++++
CREATE TABLE equipment (
	id SERIAL  not null primary key,
	item VARCHAR(32) unique NOT NULL ,
	cost INTEGER NOT NULL ,
	rarity_id INTEGER NOT NULL 
);

ALTER TABLE equipment ADD CONSTRAINT FK_equipment_rarity FOREIGN KEY (rarity_id) REFERENCES rarity_levels(id) ON DELETE CASCADE;




