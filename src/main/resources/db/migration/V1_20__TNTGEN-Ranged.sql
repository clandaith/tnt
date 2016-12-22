--Primitive Ranged Weapons




insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Aerosol Gun', 0, 5, 1, false, 10, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Primitive'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Aerosol Gun'), (select id from special_rules where name = 'Flamer Template')); 
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Aerosol Gun'), (select id from special_rules where name = 'Gas'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Aerosol Gun'), (select id from special_rules where name = 'Limited Ammo'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Aerosol Gun'), (select id from special_rules where name = 'Poison')); 

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Bow', 20, 0, 1,false, 5, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Primitive'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Black Powder Pistol', 8, 6, 2, true, 3, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Primitive'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Black Powder Pistol'), (select id from special_rules where name = 'Pistol'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Blunderbuss', 6, 5, 1, false, 5, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Primitive'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Blunderbuss'), (select id from special_rules where name = 'Small Blast'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Crossbow', 24, 6, 1, false, 6, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Primitive'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Crossbow Pistol', 8, 5, 1, true,  3, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Primitive'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Crossbow Pistol'), (select id from special_rules where name = 'Pistol'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Musket', 18, 7, 1,false,  3, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Primitive'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Musket'), (select id from special_rules where name = 'Move or Fire'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Spear Gun', 18, 7, 1, false, 7, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Primitive'));



-- Modern Ranged Weapons

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Assault Rifle',  24, 7, 2, false, 15, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Assault Rifle'), (select id from special_rules where name = 'Burst')); 

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Compound Bow',  24, 0, 1, false, 7, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Compound Bow'), (select id from special_rules where name = 'Variable Strength: STR+1'));


insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Machine Pistol',  12, 6, 2, true,  7, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Machine Pistol'), (select id from special_rules where name = 'Burst'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Machine Pistol'), (select id from special_rules where name = 'Pistol'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Pistol',  12, 6 ,1, true,  5, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Pistol'), (select id from special_rules where name = 'Pistol'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Rifle',  30, 7, 1, false,  10, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Modern'));


insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Shotgun',  18, 7, 1, false,  10, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Shotgun'), (select id from special_rules where name = 'Close Range'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Sniper Rifle',  36, 7, 1, false , 20, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Sniper Rifle'), (select id from special_rules where name = 'Move or Fire'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Sniper Rifle'), (select id from special_rules where name = '+1 to Hit at 18" or more'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Submachine Gun',  16, 6, 2, false,  10, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Submachine Gun'), (select id from special_rules where name = 'Burst'));



-- Support Weapons

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Flamethrower', 0, 6, 2, false , 15, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Support'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Flamethrower'), (select id from special_rules where name = 'Flammable'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Flamethrower'), (select id from special_rules where name = 'Limited Ammo'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Flamethrower'), (select id from special_rules where name = 'Flamer Template'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Grenade Launcher', 24, 7, 2, false, 20, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Support'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Grenade Launcher'), (select id from special_rules where name = 'Limited Ammo'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Grenade Launcher'), (select id from special_rules where name = 'Deviate'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Grenade Launcher'), (select id from special_rules where name = 'Small Blast')); 

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Light Machine Gun', 36, 8, 2, false,  25, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Support'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Light Machine Gun'), (select id from special_rules where name = 'Burst'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Light Machine Gun'), (select id from special_rules where name = 'Move or Fire'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Minigun', 36, 6, 3, false,  25, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Support'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Minigun'), (select id from special_rules where name = 'Burst'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Minigun'), (select id from special_rules where name = 'Hail of Lead'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Minigun'), (select id from special_rules where name = 'Move or Fire'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Missile Launcher', 36, 9, 2, false,  30, (select id from rarity_levels where name = 'Normal'), (select id from weapon_catagories where catagory = 'Support'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Missile Launcher'), (select id from special_rules where name = 'Limited Ammo'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Missile Launcher'), (select id from special_rules where name = 'Move or Fire'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Missile Launcher'), (select id from special_rules where name = 'Anti-Armor'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Missile Launcher'), (select id from special_rules where name = 'Small Blast'));


-- Relic Ranged Weapons

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Needler', 18, 6, 2, true, 18 , (select id from rarity_levels where name = 'Scarce'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Needler'), (select id from special_rules where name = 'Malfunction Prone'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Needler'), (select id from special_rules where name = 'Poison'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Laser Carbine', 24, 7, 2, false, 33 , (select id from rarity_levels where name = 'Scarce'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Laser Carbine'), (select id from special_rules where name = 'Laser'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Laser Carbine'), (select id from special_rules where name = 'Malfunction Prone')); 

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Laser Pistol', 12, 6, 2, true, 15 , (select id from rarity_levels where name = 'Sporadic'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Laser Pistol'), (select id from special_rules where name = 'Laser'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Laser Pistol'), (select id from special_rules where name = 'Malfunction Prone'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Laser Pistol'), (select id from special_rules where name = 'Pistol')); 

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Plasma Pistol', 12, 8, 2, true, 25 , (select id from rarity_levels where name = 'Scarce'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Plasma Pistol'), (select id from special_rules where name = 'Plasma'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Plasma Pistol'), (select id from special_rules where name = 'Malfunction Prone'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Plasma Pistol'), (select id from special_rules where name = 'Pistol')); 

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Plasma Rifle', 24, 9, 2, false, 35 , (select id from rarity_levels where name = 'Rare'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Plasma Rifle'), (select id from special_rules where name = 'Malfunction Prone'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Plasma Rifle'), (select id from special_rules where name = 'Plasma')); 

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Thunder Gun', 0, 0, 2, false, 30 , (select id from rarity_levels where name = 'Rare'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Thunder Gun'), (select id from special_rules where name = 'Knock Out'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Thunder Gun'), (select id from special_rules where name = 'Malfunction Prone'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Thunder Gun'), (select id from special_rules where name = 'Target is knocked prone')); 
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Thunder Gun'), (select id from special_rules where name = 'Flamer Template'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Thunder Gun'), (select id from special_rules where name = 'Variable Strength: D6'));

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Web Gun', 24, 0, 2, false,25 , (select id from rarity_levels where name = 'Sporadic'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Web Gun'), (select id from special_rules where name = 'Malfunction Prone'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Web Gun'), (select id from special_rules where name = 'STR test')); 

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('ZINGer', 24, 7, 2, false, 18, (select id from rarity_levels where name = 'Scarce'), (select id from weapon_catagories where catagory = 'Modern'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'ZINGer'), (select id from special_rules where name = 'Malfunction Prone'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'ZINGer'), (select id from special_rules where name = 'Causes relics to break')); 

-- Relic Support Weapons

insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Gatling Laser', 24, 6, 3, false, 55, (select id from rarity_levels where name = 'Ultra Rare'), (select id from weapon_catagories where catagory = 'Support'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Gatling Laser'), (select id from special_rules where name = 'Burst'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Gatling Laser'), (select id from special_rules where name = 'Hail of Lead'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Gatling Laser'), (select id from special_rules where name = 'Laser'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Gatling Laser'), (select id from special_rules where name = 'Move or Fire'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Gatling Laser'), (select id from special_rules where name = 'Malfunction Prone'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Gatling Laser'), (select id from special_rules where name = 'Thermocycling'));


insert into ranged_weapons (type, max_range, strength, reliability, one_handed, cost, rarity_id, catagory_id) values ('Plasma Caster', 24, 9, 2, false, 65, (select id from rarity_levels where name = 'Ultra Rare'), (select id from weapon_catagories where catagory = 'Support'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Plasma Caster'), (select id from special_rules where name = 'Burst'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Plasma Caster'), (select id from special_rules where name = 'Malfunction Prone'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Plasma Caster'), (select id from special_rules where name = 'Plasma'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Plasma Caster'), (select id from special_rules where name = 'Small Blast'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Plasma Caster'), (select id from special_rules where name = 'Thermocycling')); 


