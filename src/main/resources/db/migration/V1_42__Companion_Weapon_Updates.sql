
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Submachine Gun'), (select id from special_rules where name = 'Compact'));
insert into ranged_weapons_special_rules_link (ranged_weapon_id, special_rule_id) values ((select id from ranged_weapons where type = 'Machine Pistol'), (select id from special_rules where name = 'Compact'));
