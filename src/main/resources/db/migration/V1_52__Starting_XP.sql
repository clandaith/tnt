
alter table warband_units add column starting_xp int;

update warband_units set starting_xp = 75 where unit_type_id = (select id from warband_unit_types where type = 'Leader');
update warband_units set starting_xp = 46 where unit_type_id = (select id from warband_unit_types where type = 'Elite');
update warband_units set starting_xp = 0 where unit_type_id = (select id from warband_unit_types where type = 'Rank and File');
update warband_units set starting_xp = 21 where unit_type_id = (select id from warband_unit_types where type = 'Specialist');
update warband_units set starting_xp = 0  where unit_type_id = (select id from warband_unit_types where type = 'Freelancers');

	