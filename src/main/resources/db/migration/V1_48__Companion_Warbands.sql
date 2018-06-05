insert into warband_types (name) values ('Settlers');
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Settlers'), 'Settlement Leader', 
 (select id from warband_unit_types where type = 'Leader'), 6, 2, 5, 6, 6, 6, 7, 65);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Settlers'), 'Militant Leader', 
 (select id from warband_unit_types where type = 'Leader'), 6, 2, 5, 6, 6, 6, 7, 70);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Settlers'), 'Sheriff', 
 (select id from warband_unit_types where type = 'Elite'), 6, 2, 5, 6, 6, 6, 7, 50);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Settlers'), 'Missionary', 
 (select id from warband_unit_types where type = 'Elite'), 6, 2, 5, 6, 6, 6, 7, 40);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Settlers'), 'Prominent Citizen', 
 (select id from warband_unit_types where type = 'Elite'), 6, 2, 5, 6, 6, 6, 7, 45);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Settlers'), 'Mysterious Stranger', 
 (select id from warband_unit_types where type = 'Elite'), 6, 2, 5, 6, 6, 6, 7, 50);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Settlers'), 'Militiaman', 
 (select id from warband_unit_types where type = 'Rank and File'), 6, 2, 5, 6, 6, 6, 7, 18);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Settlers'), 'Citizen', 
 (select id from warband_unit_types where type = 'Rank and File'), 6, 2, 5, 6, 6, 6, 7, 13);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Settlers'), 'Militia Gunsmith', 
 (select id from warband_unit_types where type = 'Specialist'), 6, 2, 5, 6, 6, 6, 7, 32);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Settlers'), 'Citizen Medic', 
 (select id from warband_unit_types where type = 'Specialist'), 6, 2, 5, 6, 6, 6, 7, 30);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Settlers'), 'Regular', 
 (select id from warband_unit_types where type = 'Specialist'), 6, 2, 5, 6, 6, 6, 7, 28);


 Leader 65
 Leader 70
 Elite 50
 Elite 40

 Elite 45 Scavenger and one skill
 Elite 50 Dark Past
 Rank and File 18 Replaceable, Soft-bellied
 Rank and File 13 Ragtag and Soft-bellied
 Specialist 32 Gunsmith and Up-Armed
 Specialist 30 Medic and Soft-bellied
Regular Specialist 28


insert into warband_types (name) values ('Caravanners');
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Caravanners'), 'Trade', 
 (select id from warband_unit_types where type = 'Leader'), 6, 2, 5, 6, 6, 6, 7, 80);