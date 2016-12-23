--+++++++++++++++++++++

CREATE TABLE detriment_types(
	id SERIAL  not null primary key,
	name  VARCHAR(32) unique NOT NULL 
);
--insert into detriment_types (name) values ('');

CREATE TABLE detriments(
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL ,
	description VARCHAR(4096) unique NOT NULL ,
	detriment_type_id INTEGER not null
);
ALTER TABLE detriments ADD CONSTRAINT FK_detriments FOREIGN KEY (detriment_type_id) REFERENCES detriment_types(id) ON DELETE CASCADE;

create view detriments_view as
select detriments.*, detriment_types.name as detriment_type_name from detriments join detriment_types on detriments.detriment_type_id = detriment_types.id


