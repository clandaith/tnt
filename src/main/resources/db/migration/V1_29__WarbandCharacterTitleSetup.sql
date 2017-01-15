
insert into warband_units (id, warband_type_id, title, unit_type_id) values (0, 0, 'Unknown', 1);

alter table warband_character drop column title;
alter table warband_character add column warband_unit_id int not null default 0;
ALTER TABLE warband_character ADD CONSTRAINT FK_warband_unit_id FOREIGN KEY (warband_unit_id) REFERENCES warband_units(id) ON DELETE CASCADE;



