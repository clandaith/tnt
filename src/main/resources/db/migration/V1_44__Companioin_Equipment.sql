insert into equipment (item, cost, rarity_id) values ('Flare Gun', 5, (select id from rarity_levels where name = 'Scarce'));



--insert into equipment_special_rules_link (equipment_id, special_rule_id) values ((select id from equipment where name = 'Berserker Brew'), (select id from special_rules where name = 'Potent Potable'));
--insert into equipment_special_rules_link (equipment_id, special_rule_id) values ((select id from equipment where name  = 'Liquid Bravery'), (select id from special_rules where name = 'Potent Potable'));
