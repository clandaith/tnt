insert into skill_types (name) values ('Melee');

 insert into skills (name, description, skill_type_id) values ('Against All Odds', 'This model likes fighting against tough odds, the more foes the merrier. Enemies in base contact with this model do not receive melee bonuses when outnumbering this model in melee.  Instead, this model receives a +1 to its Melee stat when outnumbered in close combat.', (select id from skill_types where name = 'Melee'));

 insert into skills (name, description, skill_type_id) values ('Careful Blow', 'This model can study an enemy and find a chink in any armor. All melee attacks made by this model have the Ignore Armor (1)* ability.', (select id from skill_types where name = 'Melee'));

 insert into skills (name, description, skill_type_id) values ('Defender', 'This model is a careful and slow opponent, the better to outlast its opponents. When attacked in melee this model receives a +1 to its Melee and Defense stats.', (select id from skill_types where name = 'Melee'));

 insert into skills (name, description, skill_type_id) values ('Flurry of Blows', 'This model prefers to make numerous attacks each round, hopefully catching its enemies off balance. On any turn this model makes a melee attack, it gains an additional free AP that may only be used to make another melee attack. This second attack suffers -1 Melee stat penalty.', (select id from skill_types where name = 'Melee'));

 insert into skills (name, description, skill_type_id) values ('Opportunist', 'This model can feel the flow of battle and knows the perfect time to counterattack, catching its foes off balance. When resolving the to-hit phase of melee combat, this model treats all ties as a win instead.', (select id from skill_types where name = 'Melee'));

 insert into skills (name, description, skill_type_id) values ('Quick Charge', 'Even after suffering a misstep, this model can catch its quarry in melee. On any turn in which the model fails an Activation test, this model may take a second move action for free, but only if able to complete a charge move into contact with the enemy.', (select id from skill_types where name = 'Melee'));

 

insert into skill_types (name) values ('Marksmanship');

 insert into skills (name, description, skill_type_id) values ('Called Shot', 'This model has trained in picking out weak or exposed parts of its enemies. Prior to rolling to hit in ranged combat, this model may declare a called shot. The TN of the shot changes from 10 to 12; all other ranged combat rules apply. If the model successfully hits the target, that hit receives +1 Strength and has the Ignore Armor (1)* ability.', (select id from skill_types where name = 'Marksmanship'));

 insert into skills (name, description, skill_type_id) values ('Fast-Tracker', 'This model can easily peg a fast moving target. It ignores the -1 penalty to shooting when firing at targets that have double-moved.', (select id from skill_types where name = 'Marksmanship'));

 insert into skills (name, description, skill_type_id) values ('Field-Strip', 'This model can take apart and rebuild its weapon blindfolded, so fixing a jam is a cakewalk. When using the unjam action, this model may remove two Jammed tokens instead of just one with a single AP.', (select id from skill_types where name = 'Marksmanship'));

 insert into skills (name, description, skill_type_id) values ('Marksman', 'This model knows how to compensate when firing at concealed targets. When shooting, this model ignores the -1 penalty when shooting at a model in soft cover and only suffers a -1 penalty when shooting at a model in hard cover.', (select id from skill_types where name = 'Marksmanship'));

 insert into skills (name, description, skill_type_id) values ('Range Finder', 'This model has an eye for distances and can shoot accurately at long range. When shooting a weapon the model adds 6" to the weapon’s maximum range. This extra range does not affect or apply to any range-dependent abilities the weapon may have and may not be used with relic or support weapons or any weapon that uses the flame template.', (select id from skill_types where name = 'Marksmanship'));

 insert into skills (name, description, skill_type_id) values ('Steady Hands', 'Gunfights are won by nerve and a steady aim, all else is luck. This model receives a +1 bonus when shooting if it does not move during its activation, either before or after shooting.', (select id from skill_types where name = 'Marksmanship'));

 

insert into skill_types (name) values ('Survival');

insert into skills (name, description, skill_type_id) values ('Brace', 'This model has stayed alive by knowing how to roll with blows or how to best take advantage of cover. This model may spend 1 AP on its turn to “Brace”. If it does so, the model receives a +1 to its Defense stat until the start of its next activation.', (select id from skill_types where name = 'Survival'));

 insert into skills (name, description, skill_type_id) values ('Hard As Nails', 'This model knows how to take a hit, either a stoic refusal to show weakness or a fervent belief in its own skills. After being hit by any attack, but before the roll to wound, this model may roll a D10. Reduce the Strength of the attack by the result of the die roll. If this would make the attack’s Strength 0 or lower, the attack is negated entirely. This special ability may only be used once per game.', (select id from skill_types where name = 'Survival'));

 insert into skills (name, description, skill_type_id) values ('Ranger', 'This model is a master of shadowing their opponent’s movements and setting up skilled ambushes. Regardless of any scenario conditions, this model may be deployed anywhere on the board that is at least 12” away from any enemy model and is behind a terrain feature large enough to conceal them. If this model’s warband deploys before the enemy, this model may be put on the table after the enemy has been deployed. A model with this rule cannot use the Reconnoiter skill in the same game it uses this skill. A warband may never have more than three models with the Ranger skill. If multiple warbands have Rangers, roll off to determine who will use this ability first.', (select id from skill_types where name = 'Survival'));

 insert into skills (name, description, skill_type_id) values ('Reactive', 'This model has an affinity for the ebb and flow of battle and can often exploit an enemy’s missteps. This model receives a +1 bonus when making Activation tests. A model cannot have this skill and the Nimble Skill.', (select id from skill_types where name = 'Survival'));

 insert into skills (name, description, skill_type_id) values ('Survivalist', 'This model has learned the way of the wastes. The model receives a +2 bonus when taking any Survival test.', (select id from skill_types where name = 'Survival'));

 insert into skills (name, description, skill_type_id) values ('Trekker', 'This model is an expert in moving through the brush. When moving through difficult terrain the model may attempt an Agility test (MET/TN 10) for free. On a success, the model moves through the terrain without penalty to its Move stat. On a failure, the model moves through the terrain with normal movement penalties.', (select id from skill_types where name = 'Survival'));

 

insert into skill_types (name) values ('Quickness');

 insert into skills (name, description, skill_type_id) values ('Flighty', 'This model is hard to come to grips with, confounding foes attempting to strike it in melee. This model may reroll a failed Agility test when attempting to disengage in close combat. This model cannot have the Push Off skill.', (select id from skill_types where name = 'Quickness'));

 insert into skills (name, description, skill_type_id) values ('Leap', 'This model is a supreme hurdler. During a move action the model may cross any linear terrain obstacle that is 1" or less high without any reduction in movement.', (select id from skill_types where name = 'Quickness'));

 insert into skills (name, description, skill_type_id) values ('Nimble', 'This model has prodigious speed and is faster than most. This model receives a +1 bonus to Activation tests. A model cannot have this skill and the Reactive skill.', (select id from skill_types where name = 'Quickness'));

 insert into skills (name, description, skill_type_id) values ('Quick', 'This model is naturally dexterous. It receives a +2 bonus when taking any Agility test.', (select id from skill_types where name = 'Quickness'));

 insert into skills (name, description, skill_type_id) values ('Reconnoiter', 'When in the field, this model prefers to be at the forefront looking for ambushes and other dangers. At the start of the game, after all models have deployed, but before Initiative is determined, this model may make a free move action.', (select id from skill_types where name = 'Quickness'));

 

insert into skill_types (name) values ('Smarts');

 insert into skills (name, description, skill_type_id) values ('Clever', 'This model is naturally intelligent. The model receives a +2 bonus when taking any Intelligence test.', (select id from skill_types where name = 'Smarts'));

 insert into skills (name, description, skill_type_id) values ('Gunsmith', 'The model is a talented gunsmith, which makes weapon malfunctions less common. The entire warband ignores the first Jam result of the game, regardless of the number of Jammed tokens generated. This ability may not be saved up and occurs during the first Fumble when shooting.', (select id from skill_types where name = 'Smarts'));

 insert into skills (name, description, skill_type_id) values ('Haggler', 'This model is silver-tongued and is a masterful barterer. After each game, when buying new items, the model may roll a D10 and reduce the cost of a single piece of equipment’s cost by the die result, to a minimum of 1. This may only be done once per game and the item must be declared before the roll is made. Note that the player is not required to purchase the reduced-price item and the item counts its full cost when determining the model’s total cost.', (select id from skill_types where name = 'Smarts'));

 insert into skills (name, description, skill_type_id) values ('Maintainer', 'This model takes pride in keeping its weapons in top working order. This skill reduces the Reliability rating of any weapon carried by the model by 1, to a minimum of 1.', (select id from skill_types where name = 'Smarts'));

 insert into skills (name, description, skill_type_id) values ('Resourceful', 'Either due to a regular income or simply a knack for finding treasure among trash, this model brings home the irradiated bacon. This model adds an additional D10 BS to the warband’s total when determining income after each game during a campaign. Only two models may have this ability per warband at any one time.', (select id from skill_types where name = 'Smarts'));

 insert into skills (name, description, skill_type_id) values ('Scavenger', 'This model is a master scrounger and always comes with extra supplies and rations. When taking any weapon with the Limited Ammo special rule, this model may roll 2D3 when determining ammo quantity and take the highest result of the two; adding an additional 2 afterwards. Additionally, after a campaign game, upkeep costs do not need to be paid for this model during the End of Game sequence. Freelancers cannot take this skill; they only play for pay.', (select id from skill_types where name = 'Smarts'));

 insert into skills (name, description, skill_type_id) values ('Spring-Heeled', 'This model is quick to its feet and hard to keep pinned down. When prone this model may stand without paying any AP; this ability may only be used during the model’s activation.', (select id from skill_types where name = 'Smarts'));

 

insert into skill_types (name) values ('Brawn');

 insert into skills (name, description, skill_type_id) values ('Brute', 'This model is a bruiser with arms like tree trunks. The model receives a +1 to its Strength stat when making melee attacks. It also ignores the Heavy weapon rule for any weapon it uses.', (select id from skill_types where name = 'Brawn'));

 insert into skills (name, description, skill_type_id) values ('Blitzer', 'This model likes to trample its opponent into the dust. When charging, this model may choose to receive +2 to Strength for its melee attack, but if they do they suffer a -1 penalty to hit.', (select id from skill_types where name = 'Brawn'));

 insert into skills (name, description, skill_type_id) values ('Bully', 'This model likes to make its enemies eat dirt. All enemies defeated by this model in close combat are knocked prone in addition to any other combat result.', (select id from skill_types where name = 'Brawn'));

 insert into skills (name, description, skill_type_id) values ('Muscular', 'This model is naturally brawny. The model receives a +2 bonus when taking any Strength test.', (select id from skill_types where name = 'Brawn'));

 insert into skills (name, description, skill_type_id) values ('Push Off', 'When this model does not want to fight, it simply pushes its opponents away. This model may reroll any failed Strength test (STR/TN 10) to attempt to disengage in close combat. This model cannot have the Flighty skill.', (select id from skill_types where name = 'Brawn'));

 insert into skills (name, description, skill_type_id) values ('Strong Point', 'This model is accustomed to the rigors of wearing heavy armor and suffers no penalties to its Move stat or Agility tests when wearing any type of armor.', (select id from skill_types where name = 'Brawn'));

 insert into skills (name, description, skill_type_id) values ('Tosser', 'Instead of attempting to wound after hitting an enemy model in melee, this model may force the enemy model to make an opposed Strength test against it. If the model with this ability wins, the enemy is picked up and thrown 3" in a direction of the thrower’s choice. The thrown model, and any intervening model hit by the thrown model, takes a Strength 5 hit after landing, and the thrown model becomes prone. If the enemy model wins the opposed Strength roll, nothing further happens and combat continues as normal, counting that round as a tie.', (select id from skill_types where name = 'Brawn'));

 

insert into skill_types (name) values ('Tenacity');

 insert into skills (name, description, skill_type_id) values ('Brave', 'This model is naturally courageous. This model receives a +2 bonus when taking any Will tests.', (select id from skill_types where name = 'Tenacity')); 

 insert into skills (name, description, skill_type_id) values ('Confident', 'This model has faith in a higher power, supreme confidence in itself, or just believes it is extreme lucky. It may reroll all failed Morale and Grazed tests.', (select id from skill_types where name = 'Tenacity'));

 insert into skills (name, description, skill_type_id) values ('Fearful Reputation', 'This model has a reputation throughout the wasteland, either as a cold-hearted killer, a maniac, or just someone not to be trifled with. All enemy models that attempt to charge this model or move within base contact must pass a Will test (MET/TN 10). If the attacker fails this test they may perform any alternative action instead, but cannot get closer to the model this turn.', (select id from skill_types where name = 'Tenacity'));

 insert into skills (name, description, skill_type_id) values ('Frother', 'This model chooses to lose control of itself when entering combat. This model receives the Frenzied rule if it does not have it already. While frenzied which takes place after the model has failed its Intelligence test (MET/TN 10) to resist Frenzy– the model receives a +1 to its Melee and Strength stats until end of the game. Also, this model may voluntarily choose to fail any Intelligence test for going frenzied. Frenzied is discussed under the General Abilities section.', (select id from skill_types where name = 'Tenacity'));

 insert into skills (name, description, skill_type_id) values ('Gung Ho', 'This model takes the “do or die” ethos a little too literally. When this model is taken out-of-action, do not remove them from the table or place them prone. Instead, the model remains on the table for one more turn until the end of its next Activation, after which it succumbs to its wounds and is taken out-of-action as normal. During this final round of activation, the Gung Ho model is immune to all Will tests and adds +2 to its Defense stat. If this model suffers any further wounds prior to its next activation, then remove the model as normal.', (select id from skill_types where name = 'Tenacity'));

 insert into skills (name, description, skill_type_id) values ('Unfazed', 'This model cares little for the buzzing of bullets, considering them less than flies. This model automatically passes all Grazed tests, but may choose to fail as normal.', (select id from skill_types where name = 'Tenacity'));

 

insert into skill_types (name) values ('Leadership');

 insert into skills (name, description, skill_type_id) values ('All Together', 'By focusing their attention the leader encourages its fellows to better coordinate their movements. To use this ability the model must spend an AP on their activation. Immediately afterwards, any number of friendly models within 3" may activate, this counts as their activation for their turn and no Activation test is required. The models all activate simultaneously and may only make a single move action, which may be a charge. If necessary resolve any charge attacks for one model before moving onto the next.', (select id from skill_types where name = 'Leadership'));

 insert into skills (name, description, skill_type_id) values ('Assertive', 'Naturally persistent, this model presses any advantage given to them. If this model rolls a Critical result on an Activation test, they receive 3 AP instead of the normal 2.', (select id from skill_types where name = 'Leadership'));

 insert into skills (name, description, skill_type_id) values ('Bold', 'This model is a natural leader and inspires courage in all those around it. Any friendly models within 12" of this model and in line of sight gain +1 to all Will tests. This ability is not cumulative with other models that have the same skill.', (select id from skill_types where name = 'Leadership'));

 insert into skills (name, description, skill_type_id) values ('Motivator', 'Through inspiring speeches, bullying or threats, this model can get others to give their all. All friendly models within 6" of this model receive a +1 bonus when making Activation tests. A model may only benefit from the Motivator skill once per Activation test, regardless if multiple sources are within range.', (select id from skill_types where name = 'Leadership'));

 insert into skills (name, description, skill_type_id) values ('Tactician', 'This model is a student of warfare and can adjust its plans to react to enemy movements. At the start of the game, after all models are placed, but before initiative is determined, the owning player may roll a D6 and redeploy that many members of their warband. The models must be redeployed using the same scenario restrictions. This ability may only be used by each player once and if two opposing warbands have this ability, both roll a die and the highest scorer may choose to redeploy first or second.', (select id from skill_types where name = 'Leadership'));

 
