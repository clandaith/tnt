insert into warband_types (name) values ('Mutant Cannibals');

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values ((select id from warband_types where name = 'Mutant Cannibals'), (select id from warband_unit_types where type = 'Leader'), 'Maw-Maw', 6,2,5,6,6,6,7,85);
insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values ((select id from warband_types where name = 'Mutant Cannibals'), (select id from warband_unit_types where type = 'Leader'), 'Pa', 6,2,5,6,6,6,7,80);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values ((select id from warband_types where name = 'Mutant Cannibals'), (select id from warband_unit_types where type = 'Elite'), 'First-Born', 6,1,5,5,5,5,6,45);
insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values ((select id from warband_types where name = 'Mutant Cannibals'), (select id from warband_unit_types where type = 'Elite'), 'Petunia', 6,1,5,5,5,5,6,45);
insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values ((select id from warband_types where name = 'Mutant Cannibals'), (select id from warband_unit_types where type = 'Elite'), 'Gran-Gran', 6,1,5,4,5,5,6,48);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values ((select id from warband_types where name = 'Mutant Cannibals'), (select id from warband_unit_types where type = 'Rank and File'), 'Youngins', 6,1,5,4,5,5,5,20);
insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values ((select id from warband_types where name = 'Mutant Cannibals'), (select id from warband_unit_types where type = 'Rank and File'), 'Degenerate', 6,1,5,4,4,5,5,15);
insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values ((select id from warband_types where name = 'Mutant Cannibals'), (select id from warband_unit_types where type = 'Rank and File'), 'Critter', 0,0,0,0,0,0,0,0);

insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values ((select id from warband_types where name = 'Mutant Cannibals'), (select id from warband_unit_types where type = 'Specialist'), 'Tiny', 7,2,5,6,3,6,5,45);
insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values ((select id from warband_types where name = 'Mutant Cannibals'), (select id from warband_unit_types where type = 'Specialist'), 'Foundling', 6,1,5,4,4,5,5,27);
insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values ((select id from warband_types where name = 'Mutant Cannibals'), (select id from warband_unit_types where type = 'Specialist'), 'Psycho', 7,1,5,6,2,5,5,38);
insert into warband_units (warband_type_id, unit_type_id, title, defense, wounds, move, melee, ranged, strength, mettle, base_cost) values ((select id from warband_types where name = 'Mutant Cannibals'), (select id from warband_unit_types where type = 'Specialist'), 'Gramps', 6,1,5,4,4,4,5,30);

--+++++++++++++++++++++++++++++++++++++++

insert into skills (name, description, skill_type_id) values ('Revered Mother', 'With the exception of freelancers and critters, all models benefiting from Maw-Maw’s Motivator skill may add a +1 to their Move stat anytime it allows them to complete a charge action. ', (select id from skill_types where name = 'Special'));
insert into skills (name, description, skill_type_id) values ('Cannibal Ambush', 'At the beginning of each game, the opposing player must roll on the Cannibal Ambush Table to see if any of their warband has been tricked by Petunia. Affected models are not set up with the rest of the warband and instead come on from the player’s board edge during the Clean-Up Phase of Turn 3. They will activate normally during the next turn. ', (select id from skill_types where name = 'Special'));

insert into special_rules (name, description) values ('Bloody Mess', ' This weapon coats the target in blood or other substance enticing to savage beasts. All model’s with the Animal type gain a +1 to their Melee and Strength stats when attacking the affected model. Further, models with the Animal type will always choose this model as the target of its attacks if it has to choose between multiple targets. Friendly models may pass a Will test (MET TN/10) to resist this ability; this does not cost AP to attempt.');
insert into special_rules (name, description) values ('Gruesome Kill', 'The effect of this weapon on its victims is terrifying. If a model hit by this weapon goes out of action, all enemy models within 4" and line of sight must pass a Morale test (MET/TN 10).');
insert into special_rules (name, description) values ('Max. one per warband', 'Max. one per warband');
insert into special_rules (name, description) values ('Ignore -1 Movement Penalty', 'Ignore -1 Movement Penalty');
insert into special_rules (name, description) values ('Can immobilize target', 'Can immobilize target');
insert into special_rules (name, description) values ('Fearsome Reputation', 'Fearsome Reputation');
insert into special_rules (name, description) values ('Chameleon', 'Chameleon effect if the model does not double move');

--+++++++++++++++++++++++++++++++++++++++

insert into melee_weapons (type, melee_range, thrown_range, strength, one_handed, cost, reliability, rarity_id) values ('Mauler', 1, 0, 2, false, 8, 0, 1);
insert into melee_weapons (type, melee_range, thrown_range, strength, one_handed, cost, reliability, rarity_id) values ('Slaughter Blade', 0, 0, 1, false, 8, 0, 1);
insert into melee_weapons (type, melee_range, thrown_range, strength, one_handed, cost, reliability, rarity_id) values ('Cattle Prod', 0, 0, 0, true, 5, 0, 1);
insert into melee_weapons (type, melee_range, thrown_range, strength, one_handed, cost, reliability, rarity_id) values ('Maw-Maw’s Pry Bar', 1, 0, 2, false, 0, 0, 1);

insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Mauler'), (select id from special_rules where name = 'Heavy'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Mauler'), (select id from special_rules where name = 'Gruesome Kill'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Slaughter Blade'), (select id from special_rules where name = 'Poison'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Cattle Prod'), (select id from special_rules where name = 'Knock Out'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Maw-Maw’s Pry Bar'), (select id from special_rules where name = 'Max. one per warband'));

--+++++++++++++++++++++++++++++++++++++++

insert into ranged_weapons (type, max_range, strength, one_handed, reliability, cost, rarity_id, catagory_id) values ('Net Launcher', 16, 0, false, 1, 10, 1, (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons (type, max_range, strength, one_handed, reliability, cost, rarity_id, catagory_id) values ('Spear Fisher', 18, 7, false, 1, 7, 1, (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons (type, max_range, strength, one_handed, reliability, cost, rarity_id, catagory_id) values ('Splatter Gun', 0, 5, false, 1, 12, 1, (select id from weapon_catagories where catagory = 'Modern'));

insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Net Launcher'), (select id from special_rules where name = 'Can immobilize target'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Splatter Gun'), (select id from special_rules where name = 'Ignore -1 Movement Penalty'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Splatter Gun'), (select id from special_rules where name = 'Limited Ammo'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Splatter Gun'), (select id from special_rules where name = 'Bloody Mess'));

--+++++++++++++++++++++++++++++++++++++++

insert into grenades (type, strength, cost, rarity_id) values ('Bloody Head', 0, 5, 1);
insert into grenades (type, strength, cost, rarity_id) values ('Filth Bomb', 4, 7, 1);

insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Bloody Head'), (select id from special_rules where name = 'Limited Ammo'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Bloody Head'), (select id from special_rules where name = 'Small Blast'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Bloody Head'), (select id from special_rules where name = 'Bloody Mess'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Filth Bomb'), (select id from special_rules where name = 'Limited Ammo'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Filth Bomb'), (select id from special_rules where name = 'Gas'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Filth Bomb'), (select id from special_rules where name = 'Large Blast'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Filth Bomb'), (select id from special_rules where name = 'Distracting'));

--+++++++++++++++++++++++++++++++++++++++

insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Skin Armor', 1, 0, 6, 9, 12, 1);
insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Chameleon Suit', 1, 1, 20, 25, 30, 1);


insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Skin Armor'), (select id from special_rules where name = 'Fearsome Reputation'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Chameleon Suit'), (select id from special_rules where name = 'Chameleon'));

--+++++++++++++++++++++++++++++++++++++++

insert into equipment (item, cost, rarity_id) values ('Gran-Gran’s Stew', 20, 1);
insert into equipment (item, cost, rarity_id) values ('Hooks and Chains', 6, 1);
insert into equipment (item, cost, rarity_id) values ('Illumination Flare', 15, 1);
insert into equipment (item, cost, rarity_id) values ('Meat Cage', 10, 1);
insert into equipment (item, cost, rarity_id) values ('Midnight Snack', 6, 1);
