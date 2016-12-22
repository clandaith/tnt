--Grenades

--insert into special_rules (name, description) values ('', '');

insert into grenades (type, strength, cost, rarity_id) values ('Flash Bang', 0, 8, (select id from rarity_levels where name = 'Normal'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Flash Bang'), (select id from special_rules where name = 'Limited Ammo'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Flash Bang'), (select id from special_rules where name = 'Large Blast'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Flash Bang'), (select id from special_rules where name = 'Stun')); 

insert into grenades (type, strength, cost, rarity_id) values ('Fragmentation', 7, 7, (select id from rarity_levels where name = 'Normal'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Fragmentation'), (select id from special_rules where name = 'Limited Ammo'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Fragmentation'), (select id from special_rules where name = 'Small Blast')); 

insert into grenades (type, strength, cost, rarity_id) values ('Molotov Cocktail',  5, 5, (select id from rarity_levels where name = 'Normal'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Molotov Cocktail'), (select id from special_rules where name = 'Flammable'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Molotov Cocktail'), (select id from special_rules where name = 'Limited Ammo'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Molotov Cocktail'), (select id from special_rules where name = 'Small Blast'));

insert into grenades (type, strength, cost, rarity_id) values ('Sleep Grenade',  0,  7, (select id from rarity_levels where name = 'Normal'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Sleep Grenade'), (select id from special_rules where name = 'Knock Out'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Sleep Grenade'), (select id from special_rules where name = 'Limited Ammo'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Sleep Grenade'), (select id from special_rules where name = 'Small Blast'));

insert into grenades (type, strength, cost, rarity_id) values ('Tear Gas', 0,  6, (select id from rarity_levels where name = 'Normal'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Tear Gas'), (select id from special_rules where name = 'Distracting'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Tear Gas'), (select id from special_rules where name = 'Gas'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Tear Gas'), (select id from special_rules where name = 'Large Blast'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Tear Gas'), (select id from special_rules where name = 'Limited Ammo'));



--Relic Grenades


insert into grenades (type, strength, cost, rarity_id) values ('Plasma Grenade', 8,  17, (select id from rarity_levels where name = 'Rare'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Plasma Grenade'), (select id from special_rules where name = 'Limited Ammo'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Plasma Grenade'), (select id from special_rules where name = 'Plasma'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Plasma Grenade'), (select id from special_rules where name = 'Small Blast'));


insert into grenades (type, strength, cost, rarity_id) values ('Shrieker', 0, 15, (select id from rarity_levels where name = 'Scarce'));
 insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Shrieker'), (select id from special_rules where name = 'Knock Out'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Shrieker'), (select id from special_rules where name = 'Limited Ammo'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Shrieker'), (select id from special_rules where name = 'Small Blast'));
