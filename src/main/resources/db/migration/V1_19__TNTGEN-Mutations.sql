

insert into mutation_types (name) values ('Hidden Offense');
insert into mutation_types (name) values ('Hidden Defense');




insert into mutations (name, cost, description, mutation_type_id) values ('Acid Spit', 0, 'This model can spit the acidic components of its stomach at its enemies. Treat this ability as a ranged attack with a range of 16”, a Strength of 7, and with the Ignore Armor (1)* ability.', (select id from mutation_types where name = 'Hidden Offense'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Caustic Blood (Hidden Offense)', 0, 'This model seems normal, buts its blood is dangerously acidic when exposed to air. Whenever this model is wounded or taken out-of-action, all models within 2" suffer an immediate Strength 7 hit.', (select id from mutation_types where name = 'Hidden Offense'));

insert into mutations (name, cost, description, mutation_type_id) values ('Caustic Blood (Hidden Defense)', 0, 'This model seems normal, buts its blood is dangerously acidic when exposed to air. Whenever this model is wounded or taken out-of-action, all models within 2" suffer an immediate Strength 7 hit.', (select id from mutation_types where name = 'Hidden Defense'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Chameleon', 0, 'This model can change its appearance to naturally blend into the background while hiding. Any model that is 12" or farther away from this model must pass an Intelligence test (MET/TN 10) if it wishes to attack the model with ranged attacks. Failure means it cannot make the attack, but may target another model that it can see.', (select id from mutation_types where name = 'Hidden Defense'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Electric Aura', 0, 'This model can generate electrostatic bursts. Any enemy model that comes in base contact with this model, or starts their activation in base contact with them, must pass an Agility test (MET/TN 10) or suffer an automatic Strength 6 hit. Determine the result of this hit before any actions are performed by either enemy or the mutant. Regardless of the result of any hits, only one enemy may be affected by this ability per game turn as the mutant needs time to recharge.', (select id from mutation_types where name = 'Hidden Defense'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Energy Absorption', 0, 'This mutant is capable of withstanding substantial levels of heat to no ill-effect. This model receives a +2 bonus to its Defense from hits from weapons with the Flammable*, Laser*, and Plasma* weapon abilities and cannot be set on fire by any means.', (select id from mutation_types where name = 'Hidden Defense'));

insert into mutations (name, cost, description, mutation_type_id) values ('Flame Breath', 0, 'The model can store volatile components in its body and spew them as an attack. The mutation is a Strength 4 ranged attack that uses the flame template and has the Flammable rule*. This ability cannot be reused until the model passes a Strength test (STR/TN 10) at the beginning of its activation. This test does not count as an action and can be repeated each activation at no AP cost.', (select id from mutation_types where name = 'Hidden Defense'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Poisonous Breath', 0, 'This model can release the noxious gases contained within its digestive system in a particularly violent and disgusting fashion. Treat this mutation as a ranged attack with a range of 12”, a Strength of 6, and has the Gas*, Poison*, and Small Blast* rules.', (select id from mutation_types where name = 'Hidden Offense'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Psychic', 0, 'This mutant possesses psychic ability, whether it wants it or not. This model gains a randomly determined psychic mutation at no cost and can gain additional psychic mutations instead of Hidden or Physical Mutations, if the player so chooses. This ability may be duplicated; each level generates one additional psychic power. See the Psychic section for options.', (select id from mutation_types where name = 'Hidden Defense'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Radioactive', 0, 'This model is capable of leaking radiation from its body. During its activation the model can spend 1 AP to irradiate all models, friendly and foe, within range. Place the Large Blast Template over the irradiating model, all models underneath are affected. All affected models must pass two Survival tests (MET/TN 10) as if they were in an irradiated area with an Intensity of 2; each failure results in a -1 to victim’s Defense stat for the rest of the game. This ability cannot be reused until the model passes a Strength test (STR/TN 10) at the beginning of its activation. This test does not count as an action and can be repeated during activation at no AP cost. This model is also immune to the effects of radiation. The full rules for radiation are listed under the Radiation Zone under the Wasteland Encounters section.', (select id from mutation_types where name = 'Hidden Offense'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Vampiric Drain', 0, 'This mutant exudes a life-draining aura, weakening those around them. All models within 4" of this model suffer a -1 penalty to their Defense stat. This ability does not affect robots.', (select id from mutation_types where name = 'Hidden Defense'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Webs', 0, 'This model can shoot webbing out of concealed pouches on its hands or other parts of its body. Treat this as a 12" ranged attack with the Burst* weapon rule. Instead of rolling to wound, the target if hit counts as webbed. A webbed model cannot take any actions that require movement (shooting, melee, most non- passive special abilities) until it breaks free by passing a Strength test (STR/TN 10) at the beginning of its next turn. This Strength test (STR/TN 10) costs 1 AP. Psychic powers may be used while immobile.', (select id from mutation_types where name = 'Hidden Offense'));




 insert into mutation_types (name) values ('Physical'); 

 insert into mutations (name, cost, description, mutation_type_id) values ('Spikes', 0, 'This mutant has large spikes that jut out from various parts of its body. Any model that makes a melee attack against this model must pass Agility test (MET/TN10) or suffer a Strength 6 hit. Models armed with a weapon with a Melee Range of 1" or greater may ignore this ability.', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Big', 15, 'This mutant is larger than the majority of its kin. This model receives a +1 to its Strength and counts as having the Large general ability; which is listed under General Abilities.', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Blob Form', 5, 'This model has an amorphous mass for a body and has no discernible interior anatomy. This model receives a +2 to its Defense stat against all ranged attacks from firearms, and all of its close combat attacks have a Melee Range of 1”, regardless of the actual weapon used. However, the model cannot apply its Defense bonus against any weapon with the Flammable*, Laser*, or Plasma* special ability. Further, when affected by a weapon with the Flammable* ability it must roll two dice for the Agility test (MET/TN 10) and choose the lowest result.', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Burrow', 10, 'This model has the ability to burrow through dirt and rock, either because of large mole-like claws or the ability to secrete acidic saliva. This model may spend 1 AP to go underground. While underground, it moves normally, ignores terrain while doing so, and cannot be targeted by ranged weapons, special abilities, or melee attacks. This model must spend 1 AP to reemerge, and if enough AP is available the model may burrow, move underground, and reemerge in the same activation. This model cannot begin to burrow or reemerge in solid rock, asphalt, concrete, water, or other similar circumstances (apply common sense). However, while moving underground the model may bypass these obstructions, though it cannot enter enclosed spaces such as underground vaults or bunkers.', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Carapace', 10, 'This mutant possesses a hardened outer shell that gives it significant natural protection. This model receives an Armor Bonus (+2).', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Crushing Claws', 15, 'This mutant has large claws instead of hands, like a crab or lobster. This model cannot use any weapons and equipment and must pass an Agility test (MET/TN 10) to open doors or any other task that requires the use of their hands. However, the model counts as being equipped with natural weapons and gains a total of +3 to Strength when attack with them, instead of just +1.', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Fearful Reputation', 0, 'This mutant has a grotesque appearance or a bewildering accumulation of deformities. This mutation is identical to the Fearful Reputation skill.', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Grasping Tentacles', 0, 'This model has tentacles that snake about and grasp opponents. Any model in base contact with this model must pass a Strength test (STR/TN 10) when making a melee attack against this model or suffer a -2 to its Melee stat and a -1 to its Strength stat. The penalty goes away at the end of the attack.', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Long Arms', 3, 'This model has arms that are proportionally longer that its body size would indicate. This model gains a +1 to its Melee stat and all close combat attacks this model have a Melee Range of 1".', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Long Legs/Multiple Legs', 0, 'This mutant has legs that are abnormally long or more than two, giving it a faster gait. This model receives a +1 bonus to its Move stat.', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Multi-Limbed/Prehensile Tail', 0, 'This model has a grasping appendage which allows it to wield an additional melee weapon or to better brace a firearm. This model may choose either the Flurry of Blows skill or Steady Hands skill for free when first recruited.', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Scorpion Tail', 5, 'This model has a tail with a stinger or other form of natural weapon. On any turn this model makes a melee attack, it gains 1 free AP that may only be used to make another melee attack at the model’s normal Strength. This extra attack also has the Poison* ability.', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Suction', 10, 'This model has large sucker-like feelers on its feet and legs and can stick to vertical surfaces. This model may traverse walls and other vertical areas as if it was in open terrain. Should this model ever be hit by an attack while on a vertical service, it must pass an Agility test (MET/TN 10) or fall down, following the normal rules for falling.', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Two-Headed', 10, 'This mutant has two heads and two different personalities that may sometimes be in conflict, but is quick to react when in agreement. When taking an Activation test (MET/TN 10), the model may reroll a failed result. A second failure means the heads have had a falling out and the model may gains no AP that turn at all. Note that all rules of the normal Activation test, such as turnovers, still apply.', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Weapon Growths', 0, 'This mutant has a natural weapon in place of one of their normal hands, this can include a large claw, club fist, or sword-like bone protrusion. This model counts as being equipped with natural weapons and gains a +1 to their Melee stat. However, since the model cannot use their secondary hand to hold things, they may only ever use one-handed weapons and equipment. The model may further be equipped with a secondary natural weapon, which gives them a further +1 to their melee stat. However, if they do so they lose the ability to use any other weapons and equipment altogether and must pass an Agility test (MET/TN 10) to open doors or any other task that requires the use of their hands.', (select id from mutation_types where name = 'Physical'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Wings', 10, 'This model possesses large wings or has an ability that allows short bursts of flight or gliding. When moving, this model may ignore terrain. However, since it is not actually capable of sustained flight, the flying model must land at the end of its turn. If it lands in difficult terrain for any reason, it must pass an Agility test (MET/TN 10) or suffer a D6 Strength hit. Finally, should the model fall for any reason, they may take Agility test (MET/TN 10) to deploy their wings and avoid taking damage by landing softly.', (select id from mutation_types where name = 'Physical'));





insert into mutation_types (name) values ('Psychic');


insert into mutations (name, cost, description, mutation_type_id) values ('Cloud Mind',  0,'The psychic can cloud the minds of its enemies, hiding itself and his allies from their gaze. If successful, the psychic and all friendly models within 3” count as being in heavy cover until the beginning of the psychic’s next activation. Models already in heavy cover receive no additional benefit.', (select id from mutation_types where name = 'Psychic'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Demoralize',  0,'The psychic can implant thoughts of failure into its victim’s minds, weakening their resolve. Treat this as a 24" ranged attack. If successful, the target model and all enemy models within 3” of it must immediately pass a Morale test (MET/TN10).', (select id from mutation_types where name = 'Psychic'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Healing Touch', 0, 'The mutant can use its mental energy to stimulate the healing abilities of allies. The TN for the Will test to use this ability is 11 instead of the normal 10. If successful, one model in base contact that has gone out of action may be brought back into play. The model comes back into play with one wound and is prone. The psychic may also use this ability to return one wound to any multi-wound model currently in play, though this can never take that model above its starting wound total. This ability does not work on models with the robot type.', (select id from mutation_types where name = 'Psychic'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Levitation', 0, 'The mutant can resist the pull of gravity and float about for a short time. If successful, the model may make an immediate, free Move action that ignores terrain. However, since it is not actually capable of sustained flight, the levitating model must land at the end of its turn. If it lands in difficult terrain for any reason, it must pass an Agility test (MET/TN 10) or suffer a D6 Strength hit.', (select id from mutation_types where name = 'Psychic'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Mind Shield', 0, 'This ability allows the psychic to create a psychic shield to protect itself. If successful, the psychic receives an Armor Bonus (+2) that lasts as long as the mutant can maintain concentration. To do so, the mutant must a pass a Will test at the start of its activation. This does not cost AP and does not count as using a psychic power for the turn. If they fail this test, the Armor Bonus is lost. This ability is also automatically lost if the psychic fails any type of Will test.', (select id from mutation_types where name = 'Psychic'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Psychic Battery', 0, 'This model possesses an enhanced cerebral cortex, which acts as an amplifier for psychic abilities. This model may use two psychic powers, which may be the same power twice, except for Mind Shield, during their activation for 1 AP each. However, any time the model uses a second psychic power during the same activation, the second Will test (MET/ TN 10) suffers a -1 penalty and any Fumbles will result in a Strength 6 hit instead of Strength D6. Finally, models with psychic battery gain an additional randomly determined psychic mutation at no cost.', (select id from mutation_types where name = 'Psychic'));

 insert into mutations (name, cost, description, mutation_type_id) values ('Psychic Bolt', 0, 'The psychic can throw a bolt of pure energy towards its enemy. If successful, treat this as ranged attack with a range of 24”, a Strength of 7, and with the Small Blast* weapon ability.', (select id from mutation_types where name = 'Psychic'));




