create SEQUENCE  hibernate_sequence;

--+++++++++++++++++++++
CREATE TABLE special_rules(
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL ,
	description  VARCHAR(4096) unique NOT NULL 
);
--insert into special_rule (name, description) values ('', '');



--+++++++++++++++++++++
CREATE TABLE general_abilities (
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL ,
	description VARCHAR(4096) unique NOT NULL 
);
--insert into general_abilities (name, description) values ('', '');



--+++++++++++++++++++++
CREATE TABLE rarity_levels(
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL 
);
insert into rarity_levels (name) values ('Normal');
insert into rarity_levels (name) values ('Sporadic');
insert into rarity_levels (name) values ('Scarce');
insert into rarity_levels (name) values ('Rare');
insert into rarity_levels (name) values ('Ultra Rare');


--+++++++++++++++++++++
CREATE TABLE weapon_catagories(
	id SERIAL  not null primary key,
	catagory  VARCHAR(32) unique NOT NULL 
);
insert into weapon_catagories (catagory) values ('Primitive');
insert into weapon_catagories (catagory) values ('Modern');
insert into weapon_catagories (catagory) values ('Support');



--++++++++++++++++++++++++++++++++++++
--++++++++++++++++++++++++++++++++++++
--++++++++++++++++++++++++++++++++++++
--++++++++++++++++++++++++++++++++++++
--++++++++++++++++++++++++++++++++++++

CREATE TABLE users(
	id SERIAL not null primary key
	,username VARCHAR(250) unique NOT NULL 
	,password VARCHAR(250) NOT NULL 
	,enabled boolean NOT NULL default 'FALSE' 
);
create index users_index_username on users(username);

-- Create Table: user_roles
--------------------------------------------------------------------------------
CREATE TABLE user_roles (
 	id SERIAL not null primary key
	,username VARCHAR(250) NOT NULL
	,role VARCHAR(45) NOT NULL
	,CONSTRAINT user_roles_unique_values UNIQUE (username, role)
);
create index user_roles_index_username on user_roles(username);

-- Create Foreign Key: user_roles.user_id -> users.id
ALTER TABLE user_roles ADD CONSTRAINT FK_user_roles_username_id FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE;

--++++++++++++++++++++++++++++++++++++++++++
-- Users
insert into users (username, password, enabled) values 
('clandaith', '$2a$04$ydsvdKyOpQqYzO68aSdQAub6UIu3rK9HeDk//kvAFzN/x/aospQZm', 'true');

--++++++++++++++++++++++++++++++++++++++++++
-- User Roles
INSERT INTO user_roles (username, role) VALUES ('clandaith', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role) VALUES ('clandaith', 'ROLE_USER');


