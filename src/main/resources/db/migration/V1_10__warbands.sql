


--+++++++++++++++++++++
CREATE TABLE unit_type (
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL 
);
insert into unit_type (name) values ('Animal');
insert into unit_type (name) values ('Human');
insert into unit_type (name) values ('Mutant');
insert into unit_type (name) values ('Fungus');
insert into unit_type (name) values ('Robot');


--+++++++++++++++++++++
CREATE TABLE warband (
	id SERIAL  not null primary key,
	warband_name VARCHAR(64) NOT NULL ,
	background VARCHAR(512) default ''
);


--+++++++++++++++++++++
--+++++++++++++++++++++
--+++++++++++++++++++++
CREATE TABLE warband_character (
	id SERIAL  not null primary key,
	warband_id INTEGER NOT NULL ,
	title VARCHAR(32) NOT NULL ,
	name  VARCHAR(32) NOT NULL ,
	background VARCHAR(512) default '',
	unit_type_id INTEGER NOT NULL ,
	defense INTEGER NOT NULL ,
	wounds INTEGER NOT NULL ,
	move INTEGER NOT NULL ,
	melee INTEGER NOT NULL ,
	ranged INTEGER NOT NULL ,
	strength INTEGER NOT NULL ,
	mettle INTEGER NOT NULL ,
	base_cost INTEGER NOT NULL
);
ALTER TABLE warband_character ADD CONSTRAINT FK_warband_id FOREIGN KEY (warband_id) REFERENCES warband(id) ON DELETE CASCADE;
ALTER TABLE warband_character ADD CONSTRAINT FK_unit_type_id FOREIGN KEY (unit_type_id) REFERENCES unit_type(id) ON DELETE CASCADE;

--+++
create table warband_character_skills_link
(
	warband_character_id integer NOT NULL ,
	skill_id integer NOT NULL, 
	CONSTRAINT PK_warband_character_skills_link UNIQUE (warband_character_id, skill_id)
);
ALTER TABLE warband_character_skills_link ADD CONSTRAINT FK_wcskl1 FOREIGN KEY (warband_character_id) REFERENCES warband_character(id) ON DELETE CASCADE;
ALTER TABLE warband_character_skills_link ADD CONSTRAINT FK_wcskl2 FOREIGN KEY (skill_id) REFERENCES skills(id) ON DELETE CASCADE;

--+++
--+++
--+++
--+++
create table warband_character_equipment_link
(
	warband_character_id integer NOT NULL ,
	equipment_id integer NOT NULL, 
	CONSTRAINT PK_warband_character_equipment_link UNIQUE (warband_character_id, equipment_id)
);
ALTER TABLE warband_character_equipment_link ADD CONSTRAINT FK_wceql1 FOREIGN KEY (warband_character_id) REFERENCES warband_character(id) ON DELETE CASCADE;
ALTER TABLE warband_character_equipment_link ADD CONSTRAINT FK_wceql2 FOREIGN KEY (equipment_id) REFERENCES equipment(id) ON DELETE CASCADE;

--+++
--+++
--+++
--+++
create table warband_character_melee_weapon_link
(
	warband_character_id integer NOT NULL ,
	melee_weapon_id integer NOT NULL, 
	CONSTRAINT PK_warband_character_melee_weapon_link UNIQUE (warband_character_id, melee_weapon_id)
);
ALTER TABLE warband_character_melee_weapon_link ADD CONSTRAINT FK_wcmwl1 FOREIGN KEY (warband_character_id) REFERENCES warband_character(id) ON DELETE CASCADE;
ALTER TABLE warband_character_melee_weapon_link ADD CONSTRAINT FK_wcmwl2 FOREIGN KEY (melee_weapon_id) REFERENCES melee_weapons(id) ON DELETE CASCADE;

--+++
--+++
--+++
--+++
create table warband_character_ranged_weapon_link
(
	warband_character_id integer NOT NULL ,
	ranged_weapon_id integer NOT NULL, 
	CONSTRAINT PK_warband_character_ranged_weapon_link UNIQUE (warband_character_id, ranged_weapon_id)
);
ALTER TABLE warband_character_ranged_weapon_link ADD CONSTRAINT FK_wcrwl1 FOREIGN KEY (warband_character_id) REFERENCES warband_character(id) ON DELETE CASCADE;
ALTER TABLE warband_character_ranged_weapon_link ADD CONSTRAINT FK_wcrwl2 FOREIGN KEY (ranged_weapon_id) REFERENCES ranged_weapons(id) ON DELETE CASCADE;

--+++
--+++
--+++
--+++
create table warband_character_armor_link
(
	warband_character_id integer NOT NULL ,
	armor_id integer NOT NULL, 
	CONSTRAINT PK_warband_character_armor_link UNIQUE (warband_character_id, armor_id)
);
ALTER TABLE warband_character_armor_link ADD CONSTRAINT FK_wcarl1 FOREIGN KEY (warband_character_id) REFERENCES warband_character(id) ON DELETE CASCADE;
ALTER TABLE warband_character_armor_link ADD CONSTRAINT FK_wcarl2 FOREIGN KEY (armor_id) REFERENCES armor(id) ON DELETE CASCADE;

--+++
--+++
--+++
--+++
create table warband_character_mutation_link
(
	warband_character_id integer NOT NULL ,
	mutation_id integer NOT NULL, 
	CONSTRAINT PK_warband_character_mutation_link UNIQUE (warband_character_id, mutation_id)
);
ALTER TABLE warband_character_mutation_link ADD CONSTRAINT FK_wcmul1 FOREIGN KEY (warband_character_id) REFERENCES warband_character(id) ON DELETE CASCADE;
ALTER TABLE warband_character_mutation_link ADD CONSTRAINT FK_wcmul2 FOREIGN KEY (mutation_id) REFERENCES mutations(id) ON DELETE CASCADE;


--+++
--+++
--+++
--+++
create table warband_character_detriment_link
(
	warband_character_id integer NOT NULL ,
	detriment_id integer NOT NULL, 
	CONSTRAINT PK_warband_character_detriment_link UNIQUE (warband_character_id, detriment_id)
);
ALTER TABLE warband_character_detriment_link ADD CONSTRAINT FK_wcdel1 FOREIGN KEY (warband_character_id) REFERENCES warband_character(id) ON DELETE CASCADE;
ALTER TABLE warband_character_detriment_link ADD CONSTRAINT FK_wcdel2 FOREIGN KEY (detriment_id) REFERENCES detriments(id) ON DELETE CASCADE;

