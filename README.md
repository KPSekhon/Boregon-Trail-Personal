# Boregon Trail - My Personal Project

## User Stories

*User Stories* list:
- As a user, I want to select an item and add it to my inventory
- As a user, I want to see my choices reflected in the story
- As a user, I want to move further in the map and progress in the story
- As a user, I want to be able to use an item
- As a user, I want to be able to save my current game to file 
- As a user, I want to be able to load my previous save from file



What will the application do?  
- This application is a text based game that involves moving a player from one location
to the next. The player has the ability to decide what the character does from the 
options that are provided. The in-game decisions a character makes, determine 
how difficult the challenges within the game will be. For example, the weapon a player
initially chooses can have a big impact on the scalability of how difficult a challenge is.


Who will use it?
- This project can be used by any person who wants to play a simple text based game.
It provides the same joy and frustration found within in any game, thus it is available
for people of all ages.

Why is this project of interest to you?
- This specific project interest me because I am a long-time electronical game player
, and now I was given the opportunity to express my own thoughts and ideas into a playable game.
For that reason, "I jumped the gun" at the chance to design my own game.
  Thu Nov 25 13:35:45 PST 2021
  FakePlayerForEvent has gained a broken weapon which has been added to FakePlayerForEvent's inventory's first slot and set as the default weapon

#"Phase 4: Task 2"
Thu Nov 25 13:35:48 PST 2021
FakePlayerForEvent has gained a Knife which has been added to FakePlayerForEvent's inventory's first slot, set as the default weapon,  replacing the previous weapon which has been lost


Thu Nov 25 13:35:48 PST 2021
FakePlayerForEvent has spent 3 dollars


Thu Nov 25 13:35:53 PST 2021
FakePlayerForEvent has spent 3 dollars


Thu Nov 25 13:35:53 PST 2021
FakePlayerForEvent has gained Temporary Immortal Potion which has been added to FakePlayerForEvent's inventory


Thu Nov 25 13:35:55 PST 2021
FakePlayerForEvent is healed for 27hp via the healing value of Temporary Immortal Potion


Thu Nov 25 13:35:55 PST 2021
FakePlayerForEvent has gained 37hp


Thu Nov 25 13:35:55 PST 2021
FakePlayerForEvent has lost Temporary Immortal Potion


Thu Nov 25 13:36:01 PST 2021
FakePlayerForEvent has lost 35hp


Thu Nov 25 13:36:02 PST 2021
FakePlayerForEvent has gained 37hp


Thu Nov 25 13:36:02 PST 2021
FakePlayerForEvent has gained 39hp


Thu Nov 25 13:36:06 PST 2021
FakePlayerForEvent has lost 37hp


Thu Nov 25 13:36:07 PST 2021
Hytos the troll has lost 2hp


Thu Nov 25 13:36:07 PST 2021
FakePlayerForEvent has lost 36hp


Thu Nov 25 13:36:07 PST 2021
Hytos the troll has lost 3hp


Thu Nov 25 13:36:07 PST 2021
FakePlayerForEvent has lost 34hp


Thu Nov 25 13:36:08 PST 2021
Hytos the troll has lost 2hp


Thu Nov 25 13:36:08 PST 2021
FakePlayerForEvent has lost 31hp


Thu Nov 25 13:36:08 PST 2021
Hytos the troll has lost 2hp


Thu Nov 25 13:36:08 PST 2021
FakePlayerForEvent has lost 28hp


Thu Nov 25 13:36:09 PST 2021
Hytos the troll has lost 1hp


Thu Nov 25 13:36:09 PST 2021
FakePlayerForEvent has lost 25hp


Thu Nov 25 13:36:09 PST 2021
Hytos the troll has lost 3hp


Thu Nov 25 13:36:09 PST 2021
FakePlayerForEvent has lost 22hp


Thu Nov 25 13:36:09 PST 2021
Hytos the troll has lost 2hp


Thu Nov 25 13:36:10 PST 2021
FakePlayerForEvent has lost 21hp


Thu Nov 25 13:36:10 PST 2021
Hytos the troll has lost 1hp


Thu Nov 25 13:36:10 PST 2021
FakePlayerForEvent has lost 19hp


Thu Nov 25 13:36:10 PST 2021
Hytos the troll has lost 3hp


Thu Nov 25 13:36:11 PST 2021
FakePlayerForEvent has lost 18hp


Thu Nov 25 13:36:11 PST 2021
Hytos the troll has lost 2hp


Thu Nov 25 13:36:11 PST 2021
FakePlayerForEvent has gained The tooth of Hytos the troll which has been added to FakePlayerForEvent's inventory


#"Phase 4: Task 3"


If I had more time to work on the project,
is there any refactoring that I would do to improve my design?

- One major change I would like is that I would like to refactor my weapon classes to extend
a weapon class rather than implementing the basic abstract item class itself. I would
make the weapon class abstract as well and make it the only one that extends Item,
then I would add additional functionality related solely to a weapon rather than
generalizing under the sub-item class for all my items. 
- I would refactor my UI class so that it follows the single responsibility principle, 
by divvying up the work to more classes.For example, for the intro splash loading screen, it
would be its own class, but I would instantiate it within my main UI class so that it maintains
the current functionality,
- I would also like to reduce the large amount of coupling that occurs between my 
UI classes. I think this would be accomplished by following the single responsibility principal method
,as I previously mentioned, so each class would have less diverse and different methods occurring
in the same space.