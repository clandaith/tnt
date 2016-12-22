-- Special Rules

--insert into special_rules (name, description) values (, );

insert into special_rules (name, description) values ('Armored Plating', 'Heavy armor of exceptional density, armored plating is generally found on military vehicles and famously on power armor. Able to withstand attacks from most conventional arms, armored plating is only reliably defeated by purpose-built anti-armor weaponry. A model with armored plating may roll a D10 and a D6 when making Defense rolls and may choose either result.');

insert into special_rules (name, description) values ('Shield', 'Models equipped with a shield gain a +1 bonus to their Melee stat when defending in melee, and if also equipped with armor (excluding power armor), the model may add +1 to that armors melee Armor Bonus. However, shields count as a one-handed weapon for Carrying Capacity. Models equipped with shields do not gain the melee bonus for having two one-handed weapons, though the shield may be used as a light improvised weapon.');

insert into special_rules (name, description) values ('Benefits against Gas attacks', 'Benefits against Gas attacks');
insert into special_rules (name, description) values ('Ungainly', 'Ungainly');
insert into special_rules (name, description) values ('-1 M', '-1 to Movement stat');
insert into special_rules (name, description) values ('+2 STR', '+2 to bearers strength');
insert into special_rules (name, description) values ('Biohazard Suit', 'Biohazard Suit');
insert into special_rules (name, description) values ('Malfunction Prone', 'Malfunction Prone');
insert into special_rules (name, description) values ('Special Melee Attack', 'Special Melee Attack');
insert into special_rules (name, description) values ('Test to fire', 'Test to fire at wearer from over 12"');
insert into special_rules (name, description) values ('Variable Strength: STR+1', 'Variable Strength: STR+1');
insert into special_rules (name, description) values ('+1 to Hit at 18" or more', '+1 to Hit at 18" or more');
insert into special_rules (name, description) values ('Deviate', 'Deviate');
insert into special_rules (name, description) values ('Plasma', 'Plasma');
insert into special_rules (name, description) values ('Target is knocked prone', 'Target is knocked prone');
insert into special_rules (name, description) values ('Variable Strength: D6', 'Variable Strength: D6');
insert into special_rules (name, description) values ('STR test', 'Pass STR test or target is immobilized');
insert into special_rules (name, description) values ('Causes relics to break', 'ZINGer they must roll a D10. On a score of 1 through 5, one relic* as chosen by their opponent (or the model themselves if they have the robot type) counts as malfunctioning per the Malfunction Prone rule.');
insert into special_rules (name, description) values ('Thermocycling', 'Thermocycling');

insert into special_rules (name, description) values ('Carry Capacity', 'Does not count against Carry Capacity');
insert into special_rules (name, description) values ('Variable Strength: STR-1', 'Variable Strength: STR-1');
insert into special_rules (name, description) values ('Variable Strength: STR+2', 'Variable Strength: STR+2');
insert into special_rules (name, description) values ('Variable Strength: STR+0', 'Variable Strength: STR+0');
insert into special_rules (name, description) values ('Variable Strength: STR+3', 'Variable Strength: STR+3');
insert into special_rules (name, description) values ('Ignore Armor (1)', 'Ignore Armor (1)');
insert into special_rules (name, description) values ('Ignore Armor (2)', 'Ignore Armor (2)');

insert into special_rules (name, description) values ('Balanced', 'This piece was designed and made to perfection and not simply slapped together, unlike most wasteland weapons. Models making an attack with this weapon receive a +1 to their Melee stat.'); 
 
insert into special_rules (name, description) values ('Heavy', 'Heavy weapons are large and unwieldy, though capable of great harm when used. Models using a weapon with this rule suffer a -1 penalty to their Melee stat due to the cumbersome nature of the weapon.');
 
insert into special_rules (name, description) values ('Improvised', 'Improvised weapons can be lamps, bricks, signposts or small rocks. Any model may spend 1 AP to scrounge around and immediately pick up an improvised weapon of its choice (light or heavy). Models armed with two-handed ranged weapons may use the butt of their weapon as an improvised weapon. Improvised weapons cannot also be used to gain a +1 bonus in melee for using two one-handed weapons.');

insert into special_rules (name, description) values ('Anti-Armor', 'Purpose-built for use against military vehicles, anti-armor weapons use specialized means to destroy armored plating. This can be explosive shaped charges, hardened projectiles, or something more esoteric like plasma blasts. When used against a model with the Armored Plating special rule, the targeted model may not roll the extra dice they are normally allowed.'); 
 
insert into special_rules (name, description) values ('Burst', 'Burst weapons, also known as automatic weapons, allow the shooter to keep firing as long as the trigger is pulled and ammo is available. When using a weapon with the Bust ability, the shooter is no longer limited to shooting once per turn and if they use all available AP to shoot, they gain an additional 1 AP that may only be used to fire the weapon one final time. All shooting with a Burst weapon follows the rules for multiple shots.');
 
insert into special_rules (name, description) values ('Close Range', 'Some weapons are meant to be deadly when used at extremely close distances. When this weapon is used at a range of 9" or less, the attacker adds +1 to the weapons Strength.');
 
insert into special_rules (name, description) values ('Distracting', 'This weapon is usually non-lethal, but it is instead meant to irritate or otherwise distract its targets, making them easier to incapacitate. Models hit by a weapon with this rule must pass a Survival test (MET/TN 10) or suffer a -2 penalty to all Stat tests and Opposed tests on their next activation. This includes all Melee and Ranged tests.');
 
insert into special_rules (name, description) values ('Flammable', 'Flamethrowers were built to sweep enemies out of cover and to cause horrific injuries, a tradition that continues to this day. Models hit by a weapon with this ability, suffer the following effects. First, instead of taking the normal Grazed test for being hit by a ranged attack, they must take a Morale test (MET/TN 10); however, a Fumble on this test is treated as a normal failure, i.e. they are not removed from play. Two, there is a chance they will ignite and take secondary damage. Any model hit by a weapon with the Flammable rule, whether wounded or not, must pass an Agility test (MET/TN 10) during the Cleanup Phase of the game turn or suffer a D6 Strength hit. If the Agility test is passed then the flames are put out and no additional damage is taken.'); 
 
insert into special_rules (name, description) values ('Flamer Template', 'Some unusual weapons do not fire singly, but instead spray out their deadly payload over multiple targets. To use the flamer template, take the teardrop-shaped template and place its small end so it is touching the firers base at any point. All models (enemy and friendly) even partially covered by the template are possible targets of the weapon. All models with their bases fully covered, or Large/Huge models with half or more of their bases covered, are hit automatically. Models with their bases only partially covered, or Large/Huge models with less than half of their bases covered, may make an Agility test (MET/TN 10) to avoid the attack; if the Agility test is successful move the model outside the template area by the shortest means possible. As flamer template weapons do not roll to hit, all range modifiers are ignored.'); 
 
insert into special_rules (name, description) values ('Hail of Lead', 'Weapons with this ability are usually heavy automatic weapons designed to unleash a torrent of fire at the target. Weapons with this ability may shoot twice per AP spent. Models using this ability suffer a -1 to hit ranged modifier for all shots and the multiple shots rules apply. Note that Hail of Lead may be combined with the Burst rule.');

insert into special_rules (name, description) values ('Laser', 'Weapons with this ability are usually heavy automatic weapons designed to unleash a torrent of fire at the target. Weapons with this ability may shoot twice per AP spent. Models using this ability suffer a -1 to hit ranged modifier for all shots and the multiple shots rules apply.');
 
insert into special_rules (name, description) values ('Gas', 'This weapon releases toxins or other dangerous substances during the attack, sickening the target and even penetrating unsealed armor. Ranged attacks with this ability ignore all Armor Bonuses.');
 
insert into special_rules (name, description) values ('Knock Out', 'This weapon is capable of rendering its victims unconscious without killing them. Any model hit by a weapon with this ability must pass a Survival test (MET/TN 10) or immediately go unconscious; no to-wound roll is made. While unconscious, the model is prone and may not take actions. Instead, at the beginning of its next activation it may take a free Survival test (MET/TN 10) to recover. If the model recovers it may act as normal. Failure means it remains unconscious. This test may be repeated each turn.'); 
 
insert into special_rules (name, description) values ('Limited Ammo', 'Some weapons are always short on ammo, either due to scarcity or bulk. At the start of the game, roll a D3+2 to determine the number of times this weapon may be used. Ammo is replenished in between games.'); 
 
insert into special_rules (name, description) values ('Large Blast', 'Weapons with this ability explode upon hitting their target. When fired, the shooter should designate a single model as the target. If hit, place the large 5" template over that model; all models at least partially under the template are affected by the weapon. When first setting the template, it may be shifted about to catch other models as long as the original target continues to be fully covered.'); 
 
insert into special_rules (name, description) values ('Move or Fire', 'Many larger weapons need to be braced properly before they can be fired. Weapons with the Move or Fire rule cannot be fired if the attacker moved or intends to move during the same activation.');


insert into special_rules (name, description) values ('Pistol', 'Pistols are very effective weapons at point blank range and count as one-handed melee weapons. If used in close combat, resolve any attacks with the users Melee stat instead of Ranged, but use the Strength of the pistol instead of the users Strength when rolling to wound. Brawn skills cannot be used in conjunction with pistol attacks. Any weapon ability of the pistol still applies, but ignore any ability that specifically affects making ranged attacks (such as Burst), and fumbles still result in jams.'); 
 
insert into special_rules (name, description) values ('Poison', 'Some weapons are either naturally poisonous or are made so by design. Poison weapons allow even the slightest injury to fester long after the injured thought themselves safe. Any model hit by a weapon with the Poison special rule, but not wounded, must pass a Survival test (MET/TN 10) during the Cleanup Phase or suffer a D6 Strength hit.'); 
 
insert into special_rules (name, description) values ('Small Blast', 'Small blast weapons are either less potent or use a much more concentrated radius for improved effect than their larger cousins. Weapons with this ability work the same as Large Blast, but the small 3" template is used instead.'); 
 
insert into special_rules (name, description) values ('Stun', 'Stunning weapons are meant to temporarily blind opponents in order to drop their defenses, leaving them vulnerable. Weapons with the Stun special ability do not roll to wound. Instead the model must pass a Survival test (MET/ TN 10) or lose all AP during its next activation. Note: should this happen, the models controller should take an Activation test (MET/TN 10) as normal for the model to check for turnover.');




