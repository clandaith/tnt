create table warband_types (
	id SERIAL not null primary key,
	name varchar(64) unique not null	
);

create table warband_units(
	id SERIAL not null primary key,
	warband_type_id int not null,
	title VARCHAR(32) NOT NULL ,
	unit_type_id INTEGER NOT NULL default 0,
	defense INTEGER NOT NULL default 0 ,
	wounds INTEGER NOT NULL default 0 ,
	move INTEGER NOT NULL default 0 ,
	melee INTEGER NOT NULL default 0 ,
	ranged INTEGER NOT NULL default 0 ,
	strength INTEGER NOT NULL default 0 ,
	mettle INTEGER NOT NULL default 0 ,
	base_cost INTEGER NOT NULL default 0
);

create table warband_unit_types(
	id SERIAL not null primary key,
	type varchar(64) unique not null	
);

insert into warband_unit_types (type) values ('Leader');
insert into warband_unit_types (type) values ('Elite');
insert into warband_unit_types (type) values ('Rank and File');
insert into warband_unit_types (type) values ('Specialist');

insert into warband_types (name) values ('Caravanners');
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Caravanners'), 'Trade Master', (select id from warband_unit_types where type = 'Leader'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Caravanners'), 'Caravanner Lieutenant', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Caravanners'), 'Local Emissary', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Caravanners'), 'Tracker', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Caravanners'), 'Caravanner/Defender', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Caravanners'), 'Lugger', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Caravanners'), 'Caravan Guard', (select id from warband_unit_types where type = 'Specialist'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Caravanners'), 'Caravan Runner', (select id from warband_unit_types where type = 'Specialist'));

insert into warband_types (name) values ('Mutants');
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Mutants'), 'Omega Mutant', (select id from warband_unit_types where type = 'Leader'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Mutants'), 'Psychic Lord', (select id from warband_unit_types where type = 'Leader'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Mutants'), 'Alpha Mutant', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Mutants'), 'Mutant Emissary', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Mutants'), 'Abomination', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Mutants'), 'Mutant', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Mutants'), 'Feral Mutant', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Mutants'), 'Mondo', (select id from warband_unit_types where type = 'Specialist'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Mutants'), 'Psychic', (select id from warband_unit_types where type = 'Specialist'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Mutants'), 'Mutant Gunner', (select id from warband_unit_types where type = 'Specialist'));

insert into warband_types (name) values ('Raiders');
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Raiders'), 'Warlord', (select id from warband_unit_types where type = 'Leader'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Raiders'), 'Bandit King', (select id from warband_unit_types where type = 'Leader'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Raiders'), 'Brute', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Raiders'), 'Raider Champion', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Raiders'), 'Raider', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Raiders'), 'Wrecker', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Raiders'), 'Mongrel', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Raiders'), 'Maniac', (select id from warband_unit_types where type = 'Specialist'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Raiders'), 'Mutant Raider', (select id from warband_unit_types where type = 'Specialist'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Raiders'), 'Broiler', (select id from warband_unit_types where type = 'Specialist'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Raiders'), 'Scrap-Taker', (select id from warband_unit_types where type = 'Specialist'));

insert into warband_types (name) values ('Preservers');
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Preservers'), 'Lorekeeper', (select id from warband_unit_types where type = 'Leader'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Preservers'), 'Lord Reclaimer', (select id from warband_unit_types where type = 'Leader'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Preservers'), 'Reclaimer', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Preservers'), 'Savant', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Preservers'), 'Wreck-It-Bot', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Preservers'), 'Seeker', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Preservers'), 'Excavator', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Preservers'), 'Arbitrator', (select id from warband_unit_types where type = 'Specialist'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Preservers'), 'Tech-Bearer', (select id from warband_unit_types where type = 'Specialist'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Preservers'), 'Heal-o-Matic', (select id from warband_unit_types where type = 'Specialist'));

insert into warband_types (name) values ('Tribals');
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Tribals'), 'War Leader', (select id from warband_unit_types where type = 'Leader'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Tribals'), 'Great Shaman', (select id from warband_unit_types where type = 'Leader'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Tribals'), 'Tribal Champion', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Tribals'), 'Tribal Representative', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Tribals'), 'Lesser Shaman', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Tribals'), 'Tribal', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Tribals'), 'Tribal Warrior', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Tribals'), 'Warbeast', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Tribals'), 'Berserker', (select id from warband_unit_types where type = 'Specialist'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Tribals'), 'Tribal Scout', (select id from warband_unit_types where type = 'Specialist'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Tribals'), 'Warbringer', (select id from warband_unit_types where type = 'Specialist'));


insert into warband_types (name) values ('Peacekeepers');
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Peacekeepers'), 'Road Marshal', (select id from warband_unit_types where type = 'Leader'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Peacekeepers'), 'Hanging Judge', (select id from warband_unit_types where type = 'Leader'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Peacekeepers'), 'Warden', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Peacekeepers'), 'Outrider', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Peacekeepers'), 'Quartermaster', (select id from warband_unit_types where type = 'Elite'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Peacekeepers'), 'Officer', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Peacekeepers'), 'Deputized Settler', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Peacekeepers'), 'K-9', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Peacekeepers'), 'Sacrificial Lamb', (select id from warband_unit_types where type = 'Rank and File'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Peacekeepers'), 'K-9 Handler', (select id from warband_unit_types where type = 'Specialist'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Peacekeepers'), 'Line Breaker', (select id from warband_unit_types where type = 'Specialist'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Peacekeepers'), 'Tactical', (select id from warband_unit_types where type = 'Specialist'));
insert into warband_units (warband_type_id, title, unit_type_id) values ((select id from warband_types where name = 'Peacekeepers'), 'Cyber-Dog', (select id from warband_unit_types where type = 'Specialist'));









