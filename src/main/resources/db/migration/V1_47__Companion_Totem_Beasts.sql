
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost) 
values ((select id from warband_types where name = 'Tribals'), 'Giant Crow', 
(select id from warband_unit_types where type = 'Rank and File'), 6, 1, 7, 5, 0, 5, 5, 20);


insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost) 
values ((select id from warband_types where name = 'Tribals'), 'Wastewolf', 
(select id from warband_unit_types where type = 'Specialist'), 6, 1, 7, 5, 0, 6, 5, 23);


insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost) 
values ((select id from warband_types where name = 'Tribals'), 'Juvenile Landsnapper', 
(select id from warband_unit_types where type = 'Specialist'), 8, 2, 6, 5, 0, 6, 6, 70);
