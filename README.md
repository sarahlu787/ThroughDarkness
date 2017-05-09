# ThroughDarkness

Sarah Lu and Ally Wang
5/22/17

Description: 
	This program is a maze game in which the player controls a character (a circle), and the objective is to escape the randomly generated maze from the starting point to a designated exit which position is unclear to the player. The character can only move in four directions (up, down, left, right) and cannot pass through walls. From the starting point, the character is surrounded by darkness, unable to see the whole structure of the maze. However, there will be a light circle around the character—the circle—that allows the player to clearly the maze within the area of the light circle, which has a radius several times larger than the circle. The player will be guided toward the exit by the directions at the bottom of the window indicating the exit’s direction to the character from its current position. There are eight possible general directions, with a difference of 45 degrees between every two. Only one direction will be given at a time, which will be lit up, for the player to follow.  
This single-player game is created to help people deal with boredom. It also trains one’s ability to imagine what the unknown parts of the maze look like and to strategize accordingly.  

Instructions:
Right Arrow Key: moves the character right
Left Arrow Key: moves the character left
Up Arrow Key: moves the character up
Down Arrow Key: moves the character down
(want-to-have) S: saves the current state of the game
Q: closes the window
R: starts a new game
(want-to-have) Space bar: pressed down to show the whole maze

Features List:
Must-haves: 
Arrows showing where the exit is (eight directions)
A character that moves in the maze
A maze (randomly generated or pre-designed)
A light circle around the character that shows the maze around the character
A main screen that allows the player to start or quit the game
Starts a new game (generate a different maze) when R is pressed.
Want-to-haves: 
A hint to light the screen up, showing the whole maze (the player cannot move the character when the screen is lit up and the hint may only be used for a limited number of times)
A button that saves the current state of the game
A button that lets the character to start from the entrance or start a new game
Sound effects when the character moves
A success screen when player gets to the exit of the screen
Stretch features: 
Boosters that can make the light circle around the character larger (a few boosters spread randomly in the maze)
Boosters that speed up the character
Power-downs that move the character to a random position in the maze
An option on the start screen that allows the player to choose the color of the character
An option on the start screen that allows players to choose the size of the maze

Class List:
Main - runs the program
Direction - displays the eight directions and shows the direction in which the character should move toward.
Position - contains the position of the character (power-ups and power-downs if possible)
Maze - contains the algorithm that creates the maze
Wall - defines the walls to the maze
Character - defines the features and actions of the character
HomeScreen - displays the home screen (allows the player to customize the character or background music if possible)

Responsibility List:
Ally - Main, Direction, Maze, HomeScreen
Sarah - Position, Maze, Character, Wall
