create view warband_unit_types_view as
select wUnits.*, wTypes.type as type_name from warband_units wUnits join warband_unit_types wTypes on wUnits.unit_type_id = wTypes.id;

--++++++++++++++++++++++++++

insert into warband_types (id, name) values (0, 'Unknown');

alter table warband add column warband_type_id int not null default 0;
ALTER TABLE warband ADD CONSTRAINT FK_warband_type_id FOREIGN KEY (warband_type_id) REFERENCES warband_types(id) ON DELETE CASCADE;

--++++++++++++++++++++++++++

ALTER TABLE warband_units ADD CONSTRAINT FK_warband_type_id FOREIGN KEY (warband_type_id) REFERENCES warband_types(id) ON DELETE CASCADE;
ALTER TABLE warband_units ADD CONSTRAINT FK_warband_unit_type_id FOREIGN KEY (unit_type_id) REFERENCES warband_unit_types(id) ON DELETE CASCADE;

--++++++++++++++++++++++++++

