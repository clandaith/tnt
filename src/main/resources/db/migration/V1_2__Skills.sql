--+++++++++++++++++++++

CREATE TABLE skill_types (
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL 
);
--insert into skills_type (name) values ('');

CREATE TABLE skills (
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL ,
	description VARCHAR(32) unique NOT NULL  ,
	skill_type_id  INTEGER NOT NULL
);

ALTER TABLE skills ADD CONSTRAINT FK_skills FOREIGN KEY (skill_type_id) REFERENCES skill_types(id) ON DELETE CASCADE;

create view skills_view as
select skills.*, skill_types.name as skill_type_name from skills join skill_types on skills.skill_type_id = skill_types.id

