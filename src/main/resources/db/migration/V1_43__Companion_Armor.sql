
insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Scavenged Power Armor', 2, 2, 30, 50, 70, (select id from rarity_levels where name = 'Rare'));

insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Scavenged Power Armor'), (select id from special_rules where name = '+1 STR')); 
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Scavenged Power Armor'), (select id from special_rules where name = 'Biohazard Suit')); 
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Scavenged Power Armor'), (select id from special_rules where name = 'Malfunction Prone'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Scavenged Power Armor'), (select id from special_rules where name = 'Armored Plating'));
