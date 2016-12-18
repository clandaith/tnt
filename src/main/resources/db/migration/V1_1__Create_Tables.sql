create SEQUENCE  hibernate_sequence;



--+++++++++++++++++++++
CREATE TABLE skills
(
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL ,
	type  INTEGER NOT NULL ,
	description	 VARCHAR(32) unique NOT NULL 
);




--+++++++++++++++++++++
CREATE TABLE skill types
(
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL 
);




--+++++++++++++++++++++
CREATE TABLE mutations
(
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL ,
	cost INTEGER NOT NULL ,
	description VARCHAR(32) unique NOT NULL 
);




--+++++++++++++++++++++
CREATE TABLE mutation type
(
	id SERIAL  not null primary key,
	name  VARCHAR(32) unique NOT NULL -- (hidden offence and defience)
);




--+++++++++++++++++++++
CREATE TABLE detriments
(
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL ,
	description VARCHAR(32) unique NOT NULL 
);




--+++++++++++++++++++++
CREATE TABLE detriment types
(
	id SERIAL  not null primary key,
	name  VARCHAR(32) unique NOT NULL 
);

	


--+++++++++++++++++++++
CREATE TABLE general abilities 
(
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL ,
	description VARCHAR(32) unique NOT NULL 
);

--+++++++++++++++++++++
CREATE TABLE rarity_levels
(
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL 
);


--+++++++++++++++++++++
CREATE TABLE melee weapons
(
	id SERIAL  not null primary key,
	type VARCHAR(32) unique NOT NULL ,
	melee_range INTEGER NOT NULL ,
	thrown_range INTEGER NOT NULL ,
	strength INTEGER NOT NULL ,
	1H,
	-- special rules,
	cost INTEGER NOT NULL ,
	rarity  INTEGER NOT NULL 
);


CREATE TABLE armor_special_rules
(
	armor_id,
	special_rule_id
);	





--+++++++++++++++++++++
CREATE TABLE ranged weapons
(
	id SERIAL  not null primary key,
	type VARCHAR(32) unique NOT NULL ,
	max_range INTEGER NOT NULL ,
	strength INTEGER NOT NULL ,
	1H,
	reliabiltiy INTEGER NOT NULL ,
	-- special_rules,
	cost INTEGER NOT NULL ,
	rarity  INTEGER NOT NULL 
);


CREATE TABLE armor_special_rules
(
	armor_id,
	special_rule_id
);	





--+++++++++++++++++++++
CREATE TABLE weapon catagories
(
	id SERIAL  not null primary key,
	catagory  VARCHAR(32) unique NOT NULL 
	--primitive
	--modern
	--support
);







--+++++++++++++++++++++
CREATE TABLE grenades
(
	id SERIAL  not null primary key,
	type VARCHAR(32) unique NOT NULL ,
	strength INTEGER NOT NULL ,
	--special rules,
	cost INTEGER NOT NULL ,
	rarity  INTEGER NOT NULL 
);


CREATE TABLE armor_special_rules
(
	armor_id,
	special_rule_id
);	






--+++++++++++++++++++++
CREATE TABLE armor
(
	id SERIAL  not null primary key,
	type VARCHAR(32) unique NOT NULL ,
	melee_bonus INTEGER NOT NULL ,
	ranged_bonus INTEGER NOT NULL ,
	--special_rules,
	cost_by_wound_1 INTEGER NOT NULL ,
	cost_by_wound_2 INTEGER NOT NULL ,
	cost_by_wound_3 INTEGER NOT NULL ,
	rarity INTEGER NOT NULL 
);


CREATE TABLE armor_special_rules
(
	armor_id,
	special_rule_id
);	

--+++++++++++++++++++++
CREATE TABLE equipment
(
	id SERIAL  not null primary key,
	item VARCHAR(32) unique NOT NULL ,
	cost INTEGER NOT NULL ,
	rarity INTEGER NOT NULL 
);



--+++++++++++++++++++++
CREATE TABLE special_rule
(
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL ,
	description  VARCHAR(512) unique NOT NULL 
);




--+++++++++++++++++++++
CREATE TABLE warband
(
	id SERIAL  not null primary key,
	warband_name VARCHAR(64) NOT NULL ,
	background VARCHAR(512) default ''
);

	


--+++++++++++++++++++++
CREATE TABLE unit_type
(
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL 
	
--Animal, Human, mutant, fungus, robot
);



--+++++++++++++++++++++
CREATE TABLE unit
(
	id SERIAL  not null primary key,
	warband_id INTEGER NOT NULL ,
	title VARCHAR(32) NOT NULL ,
	name  VARCHAR(32) NOT NULL ,
	background VARCHAR(512) default '',
	unit_type INTEGER NOT NULL ,
	defense INTEGER NOT NULL ,
	wounds INTEGER NOT NULL ,
	move INTEGER NOT NULL ,
	melee INTEGER NOT NULL ,
	ranged INTEGER NOT NULL ,
	strength INTEGER NOT NULL ,
	mettle INTEGER NOT NULL ,
	--skills,
	--special_abilities,
	cost INTEGER NOT NULL ,
	--	melee_weapons,
	--	ranged_weapons,
	--	armor,
	--	equipment,
);



