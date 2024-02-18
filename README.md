Overview
This Java project presents a block puzzle game where players arrange colored blocks on a board to meet various goals. It combines strategic placement with goal-oriented tasks, providing a challenging and engaging experience. The game features different goals, such as filling the perimeter of the board with specific colors or creating large connected areas ("blobs") of the same color.

Components
Block.java: Defines the block object, including its color and position. This class is fundamental to the game's mechanics, as players will manipulate these blocks within the game board.
BlobGoal.java: Implements a game goal where players aim to create the largest possible "blob" of connected blocks of the same color.
PerimeterGoal.java: Sets a goal for players to place blocks of a specific color along the outer edges of the game board. Corner blocks count doubly towards the player's score.

Features
Strategic Gameplay: Players must think strategically to place blocks in a manner that maximizes their score according to the current goal.
Multiple Goals: The game includes different types of goals, adding variety and replayability.
Colorful Interface: Utilizes Java's graphical capabilities to create an engaging and visually appealing game board.
