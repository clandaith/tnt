
-- Equipment

insert into equipment (item, cost, rarity_id) values ('Berserker Brew', 3, (select id from rarity_levels where name = 'Normal'));
insert into equipment (item, cost, rarity_id) values ('Climbing Gear', 7, (select id from rarity_levels where name = 'Normal'));
insert into equipment (item, cost, rarity_id) values ('Electric Torch', 3, (select id from rarity_levels where name = 'Normal'));
insert into equipment (item, cost, rarity_id) values ('Fischer Glow-B-Gone', 7, (select id from rarity_levels where name = 'Normal'));
insert into equipment (item, cost, rarity_id) values ('Gas Mask', 3, (select id from rarity_levels where name = 'Normal'));
insert into equipment (item, cost, rarity_id) values ('Geiger Counter', 5, (select id from rarity_levels where name = 'Normal'));
insert into equipment (item, cost, rarity_id) values ('Large Caliber Upgrade', 0, (select id from rarity_levels where name = 'Normal'));
insert into equipment (item, cost, rarity_id) values ('Liquid Bravery', 0, (select id from rarity_levels where name = 'Normal'));
insert into equipment (item, cost, rarity_id) values ('Masterwork Upgrade', 0, (select id from rarity_levels where name = 'Normal'));
insert into equipment (item, cost, rarity_id) values ('Net', 4, (select id from rarity_levels where name = 'Normal'));
insert into equipment (item, cost, rarity_id) values ('Poison Vial', 5, (select id from rarity_levels where name = 'Normal'));
insert into equipment (item, cost, rarity_id) values ('Shiny Object', 5, (select id from rarity_levels where name = 'Normal'));
insert into equipment (item, cost, rarity_id) values ('War Banner', 8, (select id from rarity_levels where name = 'Normal'));
insert into equipment (item, cost, rarity_id) values ('War Totem', 4, (select id from rarity_levels where name = 'Normal'));


--Relic Equipment
insert into equipment (item, cost, rarity_id) values ('Auto-Injector', 15, (select id from rarity_levels where name = 'Rare'));
insert into equipment (item, cost, rarity_id) values ('Battle Force Field', 25, (select id from rarity_levels where name = 'Rare'));
insert into equipment (item, cost, rarity_id) values ('Grappler', 10, (select id from rarity_levels where name = 'Scarce'));
insert into equipment (item, cost, rarity_id) values ('Personal Targeting Array', 10, (select id from rarity_levels where name = 'Scarce'));
insert into equipment (item, cost, rarity_id) values ('Pre-Fall Ammo', 10, (select id from rarity_levels where name = 'Sporadic'));
insert into equipment (item, cost, rarity_id) values ('SPAMsuit', 20, (select id from rarity_levels where name = 'Scarce'));
