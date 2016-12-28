
create table injuries
(
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL ,
	description  VARCHAR(1024) unique NOT NULL 
);


create table warband_character_injuries_link
(
	warband_character_id integer NOT NULL ,
	injury_id integer NOT NULL 
	-- , CONSTRAINT PK_warband_character_skills_link UNIQUE (warband_character_id, injury_id)
);

ALTER TABLE warband_character_injuries_link ADD CONSTRAINT FK_wcil1 FOREIGN KEY (warband_character_id) REFERENCES warband_character(id) ON DELETE CASCADE;
ALTER TABLE warband_character_injuries_link ADD CONSTRAINT FK_wcil2 FOREIGN KEY (injury_id) REFERENCES injuries(id) ON DELETE CASCADE;

insert into injuries (name, description) values ('Banged Head', 'The model receives a -1 penalty to its Mettle stat.');
insert into injuries (name, description) values ('Gashed Leg', 'The model receives a -1 penalty to its Move stat.');
insert into injuries (name, description) values ('Brain Sprain', 'The model gains the Dumb general ability.');
insert into injuries (name, description) values ('Hand Injury', 'The Model receives a -1 penalty to its Ranged stat.');
insert into injuries (name, description) values ('Horrible Scarring', 'The model gains the Fearful Reputation skill for free.');
insert into injuries (name, description) values ('Insensible', 'The model receives the Softbellied general ability.');
insert into injuries (name, description) values ('Shaky Nerves', 'The model gains the Coward general ability.');
insert into injuries (name, description) values ('Bum Leg', 'Regardless of available AP, the model may only move once per turn.');
insert into injuries (name, description) values ('Reckless', 'The model gains the Frenzied general ability.');
insert into injuries (name, description) values ('Flashbacks', 'This model must make a Will test (MET/ TN 10) at the beginning of each game. If failed, the model may not be used in that game. Remove the model from the game; it does not count as a casualty or having gone out-of-action.');
insert into injuries (name, description) values ('Hardened', 'The model gains the Brave skill for free.');
insert into injuries (name, description) values ('Gaping Wound', 'The model receives a -1 penalty to its Defense stat.');
insert into injuries (name, description) values ('Weak Hands', 'The model receives a -1 penalty to its Melee and Ranged stats when using any two-handed weapon.');
insert into injuries (name, description) values ('Bent Elbow', 'The model receives a -1 penalty to its Melee stat.');
insert into injuries (name, description) values ('Nervous Tic', 'The model receives a -1 penalty to all Activations tests (MET/TN 10).');
insert into injuries (name, description) values ('Vengeance', 'The model gains the Hatred special rule. It applies to all members of the specific warband that caused the injury.');


