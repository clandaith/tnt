insert into grenades (type, strength, cost, rarity_id) values ('Smoke Grenade', 0,  7, (select id from rarity_levels where name = 'Scarce'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Smoke Grenade'), (select id from special_rules where name = 'Limited Ammo'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Smoke Grenade'), (select id from special_rules where name = 'Smoke'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Smoke Grenade'), (select id from special_rules where name = 'Small Blast'));


insert into grenades (type, strength, cost, rarity_id) values ('Flare', 0,  5, (select id from rarity_levels where name = 'Scarce'));
insert into grenades_special_rules_link (grenade_id, special_rule_id) values ((select id from grenades where type = 'Flare'), (select id from special_rules where name = 'Limited Ammo'));
