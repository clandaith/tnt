

insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost) 
values ((select id from warband_types where name = 'Caravanners'), 'Big Lug', 
(select id from warband_unit_types where type = 'Specialist'), 6, 2, 5, 6, 3, 6, 5, 50);

insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost) 
values ((select id from warband_types where name = 'Peacekeepers'), 'Bloodhound', 
(select id from warband_unit_types where type = 'Specialist'), 6, 1, 5, 4, 4, 5, 5, 30);

insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost) 
values ((select id from warband_types where name = 'Tribals'), 'Chronicler', 
(select id from warband_unit_types where type = 'Specialist'), 6, 1, 5, 4, 4, 5, 5, 30);

insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost) 
values ((select id from warband_types where name = 'Mutants'), 'Dominant (Mutant)', 
(select id from warband_unit_types where type = 'Specialist'), 0, 0, 0, 0, 0, 0, 0, 30);

insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost) 
values ((select id from warband_types where name = 'Mutants'), 'Dominant (Feral Mutant)', 
(select id from warband_unit_types where type = 'Specialist'), 0, 0, 0, 0, 0, 0, 0, 28);

insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost) 
values ((select id from warband_types where name = 'Raiders'), 'Fire Bug', 
(select id from warband_unit_types where type = 'Specialist'), 6, 1, 6, 4, 3, 5, 5, 25);

insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost) 
values ((select id from warband_types where name = 'Mutant Cannibals'), 'Gimp', 
(select id from warband_unit_types where type = 'Specialist'), 6, 1, 5, 4, 4, 5, 5, 25);

insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost) 
values ((select id from warband_types where name = 'Preservers'), 'Semi-Autonomous Drone', 
(select id from warband_unit_types where type = 'Specialist'), 7, 1, 6, 2, 4, 5, 5, 35);

