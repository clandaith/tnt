Insert into skill_types (name) values ('Special');

insert into skills (name, description, skill_type_id) values ('Man’s Best Friend', 'All friendly K-9 and cyber-dog models within 6” of the Handler receive a +1 bonus to Activation tests (MET/TN 10).', (select id from skill_types where name = 'Special'));

--++++++++++++++++++++++++

insert into skills (name, description, skill_type_id) values ('Hover', 'This model has the ability to float above the ground. When moving, this model may ignore rough and linear terrain up to 1" tall and takes no damage from falling. It can travel up linear obstacles using normal movement, but must remain within 1" of a surface at all times (it cannot fly). When malfunctioning, this model counts as prone and must stand up to hover again; while prone it may not move at all. ', (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('Scrap-Bot', 'When this model malfunctions it does not gain the normal +2 on the Intelligence test to fix itself. ', (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('Welded Together', 'Anytime this model rolls on the Survival Table, upgrade the result by one step. For example, a Severely Wounded becomes Seriously Wounded, Seriously Wounded becomes Banged-Up, and so forth. Note a fumble will still result in death and Close Call is not upgraded to a Lucky Break.', (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('Camp Cook', 'If this model takes a model out of action in melee combat, the player does not have to pay upkeep for this model during the next end of game sequence.', (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('Vendor', 'At the end of each game, roll a D10. On a 2-10 the warband may add that much BS to their inventory. On a fumble, they must roll a D10 and lose that much instead.', (select id from skill_types where name = 'Special'));

