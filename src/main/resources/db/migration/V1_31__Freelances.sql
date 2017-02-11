insert into warband_types (name) values ('Freelancers');
insert into warband_unit_types (type) values ('Freelancers');

-- Freelancers

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Bounty Hunter', 6, 1, 5, 5, 5, 5, 6, 55);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Deadman', 8, 1, 6, 7, 3, 5, 6, 50);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Depend-O-Bot', 8, 1, 5, 5, 5, 5, 5, 50);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Mercenary Gunsmith', 6, 1, 5, 4, 5, 5, 6, 50);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Merchant', 6, 1, 5, 4, 4, 5, 6, 55);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Rogue Psychic', 6, 1, 5, 4, 5, 5, 6, 45);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Sawbones', 6, 1, 5, 4, 4, 5, 6, 50);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Veteran Scout', 6, 1, 6, 4, 5, 5, 6, 45);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Wandering Mutant', 6, 1, 5, 5, 4, 5, 6, 45);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Wasteland Hunter', 6, 1, 5, 4, 5, 5, 6, 50);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Johnny Atomic', 7, 3, 5, 6, 6, 6, 7, 150);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Wasteland DJ', 6, 1, 5, 4, 5, 5, 6, 50);



insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'B-HO1DR', 8, 1, 5, 4, 4, 5, 5, 35);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Scrapper Robot', 8, 1, 5, 5, 3, 6, 5, 35);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Depend-O-Hulk', 8, 2, 5, 5, 5, 5, 5, 65);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'TANK-R', 9, 2, 5, 4, 4, 5, 5, 75);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Mister Couteau', 8, 1, 5, 7, 2, 6, 5, 50);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values 
((select id from warband_types where name = 'Freelancers'), (select id from warband_unit_types where type = 'Freelancers'), 'Vendo', 8, 1, 5, 5, 5, 5, 5, 50);

