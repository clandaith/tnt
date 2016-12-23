


insert into melee_weapons (type, melee_range, thrown_range, strength, one_handed, cost, rarity_id) values ('Bayonet',  0,0, 0, true, 4, (select id from rarity_levels where name = 'Normal'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Bayonet'), (select id from special_rules where name = 'Carry Capacity'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Bayonet'), (select id from special_rules where name = 'Variable Strength: STR+1'));

insert into melee_weapons (type, melee_range, thrown_range, strength, one_handed, cost, rarity_id) values ('Fist', 0,0, 0, true, 0, (select id from rarity_levels where name = 'Normal'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Fist'), (select id from special_rules where name = 'Variable Strength: STR-1'));


insert into melee_weapons (type, melee_range, thrown_range, strength, one_handed, cost, rarity_id) values ('Heavy Improvised',  0,  0, 0, false,  0, (select id from rarity_levels where name = 'Normal'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Heavy Improvised'), (select id from special_rules where name = 'Variable Strength: STR+1'));


insert into melee_weapons (type, melee_range, thrown_range, strength, one_handed, cost, rarity_id) values ('Heavy Weapon',  0, 0, 0, false, 5, (select id from rarity_levels where name = 'Normal'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Heavy Weapon'), (select id from special_rules where name = 'Heavy'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Heavy Weapon'), (select id from special_rules where name = 'Variable Strength: STR+2'));


insert into melee_weapons (type, melee_range, thrown_range, strength, one_handed, cost, rarity_id) values ('Light Improvised',  0,  3, 0, false,   0, (select id from rarity_levels where name = 'Normal'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Light Improvised'), (select id from special_rules where name = 'Improvised'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Light Improvised'), (select id from special_rules where name = 'Variable Strength: STR+0'));


insert into melee_weapons (type, melee_range, thrown_range, strength, one_handed, cost, rarity_id) values ('Light Weapon',  0,  0, 0, false,  3, (select id from rarity_levels where name = 'Normal'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Light Weapon'), (select id from special_rules where name = 'Variable Strength: STR+1'));


insert into melee_weapons (type, melee_range, thrown_range, strength, one_handed, cost, rarity_id) values ('Natural Weapons',  0, 0,0, true, 0, (select id from rarity_levels where name = 'Normal'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Natural Weapons'), (select id from special_rules where name = 'Variable Strength: STR+1'));


insert into melee_weapons (type, melee_range, thrown_range, strength, one_handed, cost, rarity_id) values ('Spear',  1, 3, 0, false,  5, (select id from rarity_levels where name = 'Normal'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Spear'), (select id from special_rules where name = 'Variable Strength: STR+1'));


insert into melee_weapons (type, melee_range, thrown_range, strength, one_handed, cost, rarity_id) values ('Small Blade',  0,  6, 0, false,  4, (select id from rarity_levels where name = 'Normal'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Small Blade'), (select id from special_rules where name = 'Variable Strength: STR+1'));



insert into melee_weapons (type, melee_range, thrown_range, strength, reliability, one_handed, cost, rarity_id) values ('Actuated Gauntlet',  0,  0, 0, 2, true, 25 , (select id from rarity_levels where name = 'Rare'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Actuated Gauntlet'), (select id from special_rules where name = 'Malfunction Prone')); 
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Actuated Gauntlet'), (select id from special_rules where name = 'Variable Strength: STR+3'));

insert into melee_weapons (type, melee_range, thrown_range, strength, reliability, one_handed, cost, rarity_id) values ('Blast Hammer',  0,  0, 0, 2,false,   30 , (select id from rarity_levels where name = 'Ultra Rare'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Blast Hammer'), (select id from special_rules where name = 'Heavy'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Blast Hammer'), (select id from special_rules where name = 'Ignore Armor (1)'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Blast Hammer'), (select id from special_rules where name = 'Malfunction Prone'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Blast Hammer'), (select id from special_rules where name = 'Variable Strength: STR+3'));

insert into melee_weapons (type, melee_range, thrown_range, strength, reliability, one_handed, cost, rarity_id) values ('Chainblade',  0,  0, 0, 1, true,  15 , (select id from rarity_levels where name = 'Sporadic'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Chainblade'), (select id from special_rules where name = 'Balanced'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Chainblade'), (select id from special_rules where name = 'Malfunction Prone')); 
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Chainblade'), (select id from special_rules where name = 'Variable Strength: STR+2'));

insert into melee_weapons (type, melee_range, thrown_range, strength, reliability, one_handed, cost, rarity_id) values ('Force Blade',  0,  0, 0, 2, true , 20, (select id from rarity_levels where name = 'Rare'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Force Blade'), (select id from special_rules where name = 'Ignore Armor (2)'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Force Blade'), (select id from special_rules where name = 'Malfunction Prone')); 
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Force Blade'), (select id from special_rules where name = 'Variable Strength: STR+2'));

insert into melee_weapons (type, melee_range, thrown_range, strength, reliability, one_handed, cost, rarity_id) values ('Monofilament Whip',  2, 0, 0, 1, true, 20 , (select id from rarity_levels where name = 'Scarce'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Monofilament Whip'), (select id from special_rules where name = 'Ignore Armor (2)'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Monofilament Whip'), (select id from special_rules where name = 'Malfunction Prone'));
insert into melee_weapons_special_rules_link (melee_weapon_id, special_rule_id) values ((select id from melee_weapons where type = 'Monofilament Whip'), (select id from special_rules where name = 'Variable Strength: STR+1'));



