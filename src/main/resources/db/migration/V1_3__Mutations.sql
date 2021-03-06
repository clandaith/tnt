--+++++++++++++++++++++

CREATE TABLE mutation_types (
	id SERIAL  not null primary key,
	name  VARCHAR(32) unique NOT NULL -- (hidden offence and defience)
);
--insert into mutation_type (name) values ('');
--insert into mutation_type (name) values ('');
--insert into mutation_type (name) values ('');
--insert into mutation_type (name) values ('');


CREATE TABLE mutations (
	id SERIAL  not null primary key,
	name VARCHAR(32) unique NOT NULL ,
	cost INTEGER NOT NULL ,
	description VARCHAR(4096) NOT NULL   ,
	mutation_type_id  INTEGER NOT NULL
);
ALTER TABLE mutations ADD CONSTRAINT FK_mutl1 FOREIGN KEY (mutation_type_id) REFERENCES mutation_types(id) ON DELETE CASCADE;

create view mutations_view as
select mutations.*, mutation_types.name as mutation_type_name from mutations join mutation_types on mutations.mutation_type_id = mutation_types.id

