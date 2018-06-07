insert into skills (name, description, skill_type_id) values ('Take ‘em Alive', 
'After each game, the Bloodhound may attempt an Intelligence test (MET/TN 10). If they pass, the warband gains 20 BS if any enemy models were killed or captured as a result of rolling on the Survival Table. This bonus may only be claimed once per Bloodhound per game.'
, (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('Recorder of Feats', 
'At the end of each game, the player may nominate one non-leader model to gain 2 additional Experience Points. The nominated model must have earned an Experience Point during the last game for something other than participating in the current scenario.'
, (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('Fire Bomb', 
'The fire bug may set off its bomb any time the controlling player has initiative. Treat the bomb’s explosion as a Molotov cocktail, except it uses the large blast rule and the blast is centered on the fire bug. Should the fire bug explode they are automatically killed and removed from the game, nothing can save them. However, they are replaced for free with a new fire bug at the beginning of the next game, and the replacement comes equipped with the same starting weapon (light or heavy) and fire bomb; any other items are considered lost.'
, (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('Shoot and Scoot', 
'This model does not suffer any ranged penalties due to movement.'
, (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('Pack Mentality', 
'This model receives +1 to all Morale tests when within 3" of another Wastewolf; however they suffer a -1 penalty when no other pack mate is within range.'
, (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('Amphibious', 
'Treats water terrain features as open ground.'
, (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('Oblivious', 
'Automatically passes all Will tests.'
, (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('Snap', 
'Should the Juvenile Landsnapper ever roll a Critical when making a melee attack, the model is automatically wounded. No Defense die is rolled. The landsnapper has landed a telling blow with its vicious bite.'
, (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('More Than Human', 
'The Mysterious Stranger is a secret mutant hiding among the settlers. The stranger’s type changes to Mutant and they gain two Hidden Mutations. While the warband may eventually come to trust the Mysterious Stranger, the initial secrecy has caused much distrust. The Mysterious Stranger gains the Mistrusted general ability.'
, (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('Haunted Gun Fighter', 
'The Mysterious Stranger is a master weapons handler, but is haunted by the faces of those they failed to protect. The Mysterious Stranger gains a random Marksmanship skill. Furthermore, when making a ranged attack the Mysterious Stranger may roll 2D10 and pick the highest result. However, should a double be rolled, a painful flashback is suffered and an opposing player must choose the target of the attack. If this occurs, the stranger cannot themselves be the target, and if no other legal target exists the shot is treated as a miss instead. This ability cannot be used with support weapons or weapons with the Laser rule.'
, (select id from skill_types where name = 'Special'));

insert into skills (name, description, skill_type_id) values ('Wolf Among Sheep',
'Reformed by the love of someone long since dead, the Mysterious Stranger is a former champion of a raider king. The Mysterious Stranger has the Bully and Hard As Nails skills and gains a +1 to their Melee stat; however, they receive a -1 to their Ranged stat.'
, (select id from skill_types where name = 'Special'));