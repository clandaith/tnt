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




insert into warband_types (name) values ('Renegade Reclaimers');
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Renegade Reclaimers'), 'Renegade Lord Reclaimer', 
 (select id from warband_unit_types where type = 'Leader'), 6, 2, 5, 6, 6, 6, 7, 80);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Renegade Reclaimers'), 'Renegade Reclaimer', 
 (select id from warband_unit_types where type = 'Elite'), 6, 1, 5, 5, 5, 5, 6, 50);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Renegade Reclaimers'), 'Repressor', 
 (select id from warband_unit_types where type = 'Elite'), 6, 1, 5, 5, 5, 5, 6, 55);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Renegade Reclaimers'), 'Adjudicator', 
 (select id from warband_unit_types where type = 'Elite'), 6, 1, 5, 5, 5, 5, 6, 60);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Renegade Reclaimers'), 'Aspiring Reclaimer', 
 (select id from warband_unit_types where type = 'Rank and File'), 6, 1, 5, 4, 4, 5, 5, 25);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Renegade Reclaimers'), 'Indentured Wastelander', 
 (select id from warband_unit_types where type = 'Rank and File'), 6, 1, 5, 4, 4, 5, 5, 15);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Renegade Reclaimers'), 'Renegade Arbitrator', 
 (select id from warband_unit_types where type = 'Specialist'), 6, 1, 5, 4, 4, 5, 5, 35);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Renegade Reclaimers'), 'Renegade Tech-Bearer', 
 (select id from warband_unit_types where type = 'Specialist'), 6, 1, 5, 4, 4, 5, 5, 30);
insert into warband_units (warband_type_id, title, unit_type_id, defense, wounds, move, melee, ranged, strength, mettle, base_cost)
 values ((select id from warband_types where name = 'Renegade Reclaimers'), 'Hijacked Robot', 
 (select id from warband_unit_types where type = 'Specialist'), 7, 1, 5, 6, 3, 5, 5, 37);



