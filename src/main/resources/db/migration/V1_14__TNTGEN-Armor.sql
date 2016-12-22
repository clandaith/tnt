



insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Ballistic Shield', 1, 1, 8, 10, 12, (select id from rarity_levels where name = 'Normal'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Ballistic Shield'), (select id from special_rules where name = 'Shield'));

insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Biohazard Suit', 1, 0,  5, 7, 9, (select id from rarity_levels where name = 'Normal'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Biohazard Suit'), (select id from special_rules where name = 'Benefits against Gas attacks'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Biohazard Suit'), (select id from special_rules where name = 'Ungainly'));

insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Combat Armor', 1, 2,  15, 20, 25, (select id from rarity_levels where name = 'Normal'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Combat Armor'), (select id from special_rules where name = '-1 M'));

insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Combat Shield', 2, 0,  6, 8, 10, (select id from rarity_levels where name = 'Normal'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Combat Shield'), (select id from special_rules where name = 'Shield'));

insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Heavy Metal Armor', 2, 0 ,5, 7, 10, (select id from rarity_levels where name = 'Normal'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Heavy Metal Armor'), (select id from special_rules where name = '-1 M'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Heavy Metal Armor'), (select id from special_rules where name = 'Ungainly'));

insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Mesh Armor', 0, 1,  6, 7, 8, (select id from rarity_levels where name = 'Normal'));

insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Primitive Shield', 1, 0,  3, 4, 5, (select id from rarity_levels where name = 'Normal'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Primitive Shield'), (select id from special_rules where name = 'Shield'));

insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Riot Armor', 1, 1,  10, 15, 20, (select id from rarity_levels where name = 'Normal'));

insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Scrap Armor', 1, 0, 3, 4, 5, (select id from rarity_levels where name = 'Normal'));




-- Relic Armor

insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Power Armor', 4, 4, 50, 75, 100, (select id from rarity_levels where name = 'Ultra Rare'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Power Armor'), (select id from special_rules where name = '+2 STR')); 
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Power Armor'), (select id from special_rules where name = 'Biohazard Suit')); 
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Power Armor'), (select id from special_rules where name = 'Malfunction Prone'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Power Armor'), (select id from special_rules where name = 'Armored Plating'));

insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Shock Shield', 2, 0, 10, 15, 20, (select id from rarity_levels where name = 'Scarce'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Shock Shield'), (select id from special_rules where name = 'Malfunction Prone')); 
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Shock Shield'), (select id from special_rules where name = 'Shield'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Shock Shield'), (select id from special_rules where name = 'Special Melee Attack')); 

insert into armors (type, melee_bonus, ranged_bonus, cost_by_wound_1, cost_by_wound_2, cost_by_wound_3, rarity_id) values ('Stealth Armor', 1, 2, 20, 25, 30, (select id from rarity_levels where name = 'Rare'));
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Stealth Armor'), (select id from special_rules where name = '-1 M')); 
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Stealth Armor'), (select id from special_rules where name = 'Test to fire')); 
insert into armor_special_rules_link (armor_id, special_rule_id) values ((select id from armors where type = 'Stealth Armor'), (select id from special_rules where name = 'Malfunction Prone')); 
