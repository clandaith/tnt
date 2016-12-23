insert into detriment_types (name) values ('Hidden Detriment');

 insert into detriments (name, description, detriment_type_id) values ('Atrophied Muscles', 'This mutant’s musculature is flawed and is slow to repair itself from daily use. The model suffers a -1 to its Strength stat.', (select id from detriment_types where name = 'Hidden Detriment'));

 insert into detriments (name, description, detriment_type_id) values ('Daylight Sensitivity', 'This mutant functions poorly when exposed to the sun’s harsh rays. While in daylight this model suffers a -1 penalty to its Mettle stat. Unless otherwise noted in scenario rules, all battles are assumed to happen during daylight hours. During the night time or when a fully enclosed space (indoors, for example) the model receives a +1 bonus to Mettle instead of the penalty.', (select id from detriment_types where name = 'Hidden Detriment'));

 insert into detriments (name, description, detriment_type_id) values ('Frailty', 'The mutant suffers is extremely sensitive to pain or has a weak bone structure. It suffers a -1 to its Defense stat.', (select id from detriment_types where name = 'Hidden Detriment'));

 insert into detriments (name, description, detriment_type_id) values ('Rotted Mind', 'This mutant is preoccupied with its own thoughts and can barely swing a club without being told to do so. This model receives a -1 penalty to Activation tests (MET/TN 10) if not within 3” of a friendly model.', (select id from detriment_types where name = 'Hidden Detriment'));

 insert into detriments (name, description, detriment_type_id) values ('Unending Pain', 'The culmination of this model’s mutations causes it constant agony and drives it into a near rage at the slightest provocations. This model gains the Frenzied special rule, which is described in the General Abilities section. If it possesses this special rule, the mutant receives a -2 penalty to the Intelligence test (MET/TN 10) to restrain itself.', (select id from detriment_types where name = 'Hidden Detriment'));

 insert into detriments (name, description, detriment_type_id) values ('Weakening Sight', 'The model’s eyesight has started to fade or a facial mutation partially blocks its vision. This model receives a -1 penalty to its Ranged stat.', (select id from detriment_types where name = 'Hidden Detriment'));

insert into detriment_types (name) values ('Physical Detriment');

insert into detriments (name, description, detriment_type_id) values ('Atrophied Arm', 'One of this mutant’s arms has atrophied leading to the point of uselessness. This model may use one-handed weapons normally, though they may not use two at the same time. Additionally, they may use a two-handed weapon, but suffer a -2 penalty to any roll using it as they must grip it awkwardly.', (select id from detriment_types where name = 'Physical Detriment'));

 insert into detriments (name, description, detriment_type_id) values ('Inert Twin', 'This model has a deceased conjoined sibling attached to the outside of its body, which severely affects its balance. This model receives a -1 penalty to its Move stat and a -1 penalty to all Agility tests (MET/TN 10).', (select id from detriment_types where name = 'Physical Detriment'));

 insert into detriments (name, description, detriment_type_id) values ('No Arms', 'This model has simple nubs where its arms should be, forcing it to rely on its feet for feats of dexterity. This model may only wield a single one-handed weapon, which takes some finesse, and must pass an Agility test (MET/TN 10) to use any actions normally completed with hands (opening doors, for example). Due to compensating with its feet, this model gains a +1 to its Move stat. This model loses this detriment if it ever gains any type of appendage. If this model ever gains the Prehensile Tail mutation, reroll the result.', (select id from detriment_types where name = 'Physical Detriment'));

 insert into detriments (name, description, detriment_type_id) values ('No Legs', 'This model is just a head, arms, and a torso, forcing it to move about using its hands or some other method. Since the mutant cannot brace a firearm properly while moving, all ranged weapons they carry count as having the Move or Fire ability* and they suffer a -1 penalty to their Move stat.', (select id from detriment_types where name = 'Physical Detriment'));

 insert into detriments (name, description, detriment_type_id) values ('Obese', 'This model is extremely fat and slow to act and is easily winded. The model gains +1 to its Defense stat, but also receives a -1 penalty to its Move stat and to all Agility tests and may never take more than one Move action per activation.', (select id from detriment_types where name = 'Physical Detriment'));

 insert into detriments (name, description, detriment_type_id) values ('Stumpy Leg', 'This mutant has only one good leg; the other is a twisted stump that can barely hold up the mutant’s weight. The model receives a -2 to its Move stat.', (select id from detriment_types where name = 'Physical Detriment')); 
