insert into skills (name, description, skill_type_id) values ('Lethal Blow', 'This model strikes to kill – any other result is unacceptable. All tests to attempt to revive a model taken out-of-action by this model during close combat suffer a -4 penalty. Further, this model receives +1 EXP at the end of a scenario if it made a melee attack that caused at least one enemy models to go out-of-action.', (select id from skill_types where name = 'Melee'));
insert into skills (name, description, skill_type_id) values ('Ground Fighter', 'A master of takedowns and grappling, this model knows how to even the odds. Enemy models never gain melee bonuses for this model being prone. Additionally, if the model wins a round of close combat, it can force its opponent to take an opposed Agility test. If the opponent succeeds, nothing happens, and combat continues normally. If the ground fighter wins, both the ground fighter and its opponent are placed prone.', (select id from skill_types where name = 'Melee'));


insert into skills (name, description, skill_type_id) values ('Desperado', 'This model may fire two pistols at once in a stunning display of ambidexterity. If a model with this skill is armed with a pistol in each hand, it may spend 2 AP to fire both pistols, simultaneously. Both shots must target the same model. Resolve hits and effects separately. This skill may not be combined with the Burst weapon ability. Additionally, this skill may not be taken by a model that lacks at least two appendages that are capable of firing a pistol.', (select id from skill_types where name = 'Marksmanship'));
insert into skills (name, description, skill_type_id) values ('Careful Shooting', 'This model can fire into a crowded room and still hit its intended target. When firing into a melee combat, this model may elect to reroll the dice roll that determines which model is hit by the shot (or shots).', (select id from skill_types where name = 'Marksmanship'));


insert into skills (name, description, skill_type_id) values ('Dive For Cover', 'This model makes for cover whenever possible, diving if necessary. Once per turn, after taking a move action, this model may move an additional 3”. The model does not have to end this extra move in cover. This move may not bring it into base to base contact with an enemy model. After diving for cover, this model must be placed prone.', (select id from skill_types where name = 'Survival'));
insert into skills (name, description, skill_type_id) values ('Titanium Jaw', 'This model can take a punch and just keep smiling. This model gains a +1 bonus to its Defense stat against melee attacks. This bonus is not negated by the Ignore Armor rule.', (select id from skill_types where name = 'Survival'));


insert into skills (name, description, skill_type_id) values ('Scramble', 'This model is a practiced climber and a natural at quickly surmounting high obstacles. After declaring a climb action, this model may take an Agility test (MET/TN 10). If successful the model may climb up to its normal Move stat instead of the normal rate for climbing. If unsuccessful, the figure simply climbs at the normal rate.', (select id from skill_types where name = 'Quickness'));
insert into skills (name, description, skill_type_id) values ('Duck and Weave', 'This model moves in an unpredictable fashion that minimizes its size and makes targeting it difficult. If a model with this skill made one or more movement actions during its last activation, all ranged attacks targeting this model receive a -1 penalty to hit. For the purpose of this skill, a move caused by a failed morale test does not count as a “movement action”. Also, this bonus is cumulative with the penalty to hit a target that used two move actions during the current turn.', (select id from skill_types where name = 'Quickness'));


insert into skills (name, description, skill_type_id) values ('Looter', 'This model has a passing familiarity with most weapons in the wastes, giving it an advantage when looting the dead or injured. This model does not suffer the normal -1 penalty for using weapons looted from models that have been taken out-of-action. Additionally, if this model is in possession of one or more looted weapons at the end of the scenario, the model’s owner may select one (and only one), looted weapon (excluding relics and support weapons), and roll a D10. On a roll of 8 or more, the weapon may be permanently added to the warband’s inventory. Failure means the weapon is lost as normal.', (select id from skill_types where name = 'Smarts'));
insert into skills (name, description, skill_type_id) values ('Tinkerer', 'This model has mastered many of the relics of the Last Americans. This model may reroll failed attempts to remove a Malfunction token. Remember, a reroll may not be rerolled.', (select id from skill_types where name = 'Smarts'));


insert into skills (name, description, skill_type_id) values ('Arm Cannon', 'This model has an arm like a rocket. This model may add 6" to the range of any thrown weapon.', (select id from skill_types where name = 'Brawn'));
insert into skills (name, description, skill_type_id) values ('Drive Back', 'This model likes to push people around. ``If this model wins a melee and elects to push the losing model, the losing model may be moved up to 3", instead of the normal 1". If the “pushed” model has the Large or Huge general ability, it may attempt to resist the involuntary move, but to do so it must roll 2D10 and accept the lowest result.', (select id from skill_types where name = 'Brawn'));


insert into skills (name, description, skill_type_id) values ('Hero', 'This model is well-known for its exploits and always seems to come out on top no matter the odds. This model may reroll any failed Activation test. However, once successfully used, to pass an Activation test, the Hero skill may not be used for the rest of the game.', (select id from skill_types where name = 'Tenacity'));
insert into skills (name, description, skill_type_id) values ('No Surrender', 'This model simply refuses to give up, even when surrounded by the enemy. A model with this skill receives a +1 to all Will tests if it is within 12” of an enemy model. Additionally, this model may elect to ignore the ”Captured” result on the Injury Table, and instead treat the injury as ‘Banged Up’ result from the Survival Table. This skill does not preclude it from being captured by a Bounty Hunter if the model with this skill receives a Dead result from the Survival Table.', (select id from skill_types where name = 'Tenacity'));


insert into skills (name, description, skill_type_id) values ('Audacity', 'This model inspires the warband through sheer brazenness. This boldness can take many forms, from a take-charge attitude to more physical forms of bad-assery, such as a flamboyant costume or inspiring oration. Once per game, a warband that includes one or more models with this skill may elect to receive a +2 to its Initiative roll. This need not be declared before rolling. This bonus cannot be claimed if all the warband''s models with the Audacity skill have gone out-of-action or is currently suffering the penalties from the Distracting, Stun, or Knock Out rule (See Ranged Weapon Abilities).', (select id from skill_types where name = 'Leadership'));
insert into skills (name, description, skill_type_id) values ('Iron Discipline', 'Failure is not an option. Friendly Rank and File model within 6” of this model must reroll failed Activation tests. However, if this second test is failed the model is “disciplined” and must pass an Agility test (MET/TN 10) or suffer an automatic hit with a Strength of D6. Such is the price of failure.', (select id from skill_types where name = 'Leadership'));
insert into skills (name, description, skill_type_id) values ('Mentor', 'Whether through trust, fear, or simple cajoling, this model can influence the actions of his fellows. During its activation, this model may spend 1 AP to give another friendly model within 6” a +1 to their Mettle stat until the beginning of the Mentor’s next activation.', (select id from skill_types where name = 'Leadership'));
insert into skills (name, description, skill_type_id) values ('Observe', 'This model is able to take a step back and survey the battlefield. By taking a moment to evaluate the ebb and flow of the battle, this model knows when to act at the most opportune time. This model may choose to spend 1 AP during its current activation to receive a +2 bonus to its next Activation Test. This may only be used once an activation. Remember, when rolling a Stat test, rolling a natural 1 is always a failure.', (select id from skill_types where name = 'Leadership'));