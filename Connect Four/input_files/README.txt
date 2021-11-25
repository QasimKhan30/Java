Input files in1.txt - in12.txt each include a sequence of steps.  If implemented correctly,
the GUI will start the game with an empty grid, follow the steps to allow the players
to make moves.  The final grid of each input file is given here for your own testing.

- in1.txt
	- players take turns to drop tokens in a column
	- expected final grid (winner R):
		
|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 |
| 5 || - || - || - || - || - || - || - |
| 4 || - || - || - || - || - || - || - |
| 3 || - || - || - || R || - || - || - |
| 2 || - || - || - || R || Y || - || - |
| 1 || - || - || - || R || Y || - || - |
| 0 || - || - || - || R || Y || - || - |


-----------------------------------------------

- in2.txt
	- players take turns to drop tokens along a row
	- expected final grid (winner R):
		
|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 |
| 5 || - || - || - || - || - || - || - |
| 4 || - || - || - || - || - || - || - |
| 3 || - || - || - || - || - || - || - |
| 2 || - || - || - || - || - || - || - |
| 1 || - || Y || Y || Y || - || - || - |
| 0 || - || R || R || R || R || - || - |

-----------------------------------------------

- in3.txt
	- win by 4-in-a-row in minor diagonal
	- expected final grid (winner R):
		
|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 |
| 5 || - || - || - || - || - || - || - |
| 4 || - || - || - || - || - || - || - |
| 3 || - || - || - || - || R || - || - |
| 2 || - || - || - || R || R || - || - |
| 1 || - || - || R || Y || Y || - || - |
| 0 || - || R || Y || Y || R || Y || - |

-----------------------------------------------

- in4.txt
	- win by 4-in-a-row in major diagonal
	- expected final grid (winner R):

|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 |
| 5 || - || - || - || - || - || - || - |
| 4 || - || - || - || - || - || - || - |
| 3 || - || - || - || R || - || - || - |
| 2 || - || - || - || Y || R || - || - |
| 1 || - || - || - || Y || Y || R || - |
| 0 || - || - || R || R || Y || Y || R |

-----------------------------------------------

- in5.txt
	- example that grows the board
	- expected final grid (no winner):

|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 |
| 8 || - || - || - || - || - || - || - |
| 7 || - || - || - || Y || R || - || - |
| 6 || - || - || - || R || Y || - || - |
| 5 || - || - || - || Y || R || - || - |
| 4 || - || - || - || R || Y || - || - |
| 3 || - || - || - || Y || R || - || - |
| 2 || - || - || - || R || Y || - || - |
| 1 || - || - || - || Y || R || - || - |
| 0 || - || - || - || R || Y || - || - |

-----------------------------------------------
	
- in6.txt
	- example that grows then shrinks the board
	- expected final grid (no winner):

|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 |
| 6 || - || - || - || - || - || - || - |
| 5 || - || - || - || Y || R || - || - |
| 4 || - || - || - || R || Y || - || - |
| 3 || - || - || - || Y || R || - || - |
| 2 || - || - || - || R || Y || - || - |
| 1 || - || - || - || Y || R || - || - |
| 0 || - || - || - || R || Y || - || - |

-----------------------------------------------

- in7.txt
	- example that generate the grid in Example 1 of project spec
	- expected final grid (no winner):

|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 |
| 5 || - || - || - || - || - || - || - |
| 4 || - || - || - || - || - || - || - |
| 3 || - || - || - || R || - || - || - |
| 2 || - || - || - || R || Y || - || - |
| 1 || - || Y || Y || R || R || R || - |
| 0 || - || R || Y || Y || R || Y || Y |


-----------------------------------------------
All files below are extensions of in7.txt: more steps to follow
-----------------------------------------------

- in8.txt
	- example that starts with all steps in in7.txt followed by more moves
	- expected final grid (winner R) (same as Example 2 of project spec)

|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 |
| 5 || - || - || - || - || - || - || - |
| 4 || - || - || - || R || - || - || - |
| 3 || - || - || - || R || - || - || - |
| 2 || - || - || - || R || Y || - || - |
| 1 || - || Y || Y || R || R || R || - |
| 0 || - || R || Y || Y || R || Y || Y |

-----------------------------------------------

- in9.txt
	- example that starts with all steps in in7.txt followed by more moves
	- expected final grid (winner R):

|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 |
| 5 || - || - || - || - || - || - || - |
| 4 || - || - || - || - || - || - || - |
| 3 || - || - || - || R || - || - || - |
| 2 || - || - || - || R || Y || - || - |
| 1 || - || Y || Y || R || R || R || R |
| 0 || - || R || Y || Y || R || Y || Y |

-----------------------------------------------

- in10.txt
	- example that starts with all steps in in7.txt followed by more moves
	- expected final grid (winner Y):
	
|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 |
| 5 || - || - || - || - || - || - || - |
| 4 || - || - || - || - || - || - || - |
| 3 || - || - || - || R || - || - || - |
| 2 || - || - || - || R || Y || - || - |
| 1 || - || - || Y || R || R || R || - |
| 0 || Y || Y || Y || Y || R || Y || Y |

-----------------------------------------------

- in11.txt
	- example that starts with all steps in in7.txt followed by more moves
	- powerpop
	- expected final grid (winner Y):

|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 |
| 5 || - || - || - || - || - || - || - |
| 4 || - || - || - || - || - || - || - |
| 3 || - || - || Y || - || - || - || - |
| 2 || - || - || R || Y || - || - || - |
| 1 || - || Y || Y || R || Y || R || - |
| 0 || - || R || Y || R || R || Y || Y |

-----------------------------------------------

- in12.txt
	- example that starts with all steps in in7.txt followed by more moves
	- powerdrop
	- expected final grid (winner Y):

|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 |
| 5 || - || - || - || - || - || - || - |
| 4 || - || - || - || R || - || - || - |
| 3 || - || - || - || R || - || Y || - |
| 2 || - || - || R || R || Y || Y || - |
| 1 || - || Y || Y || Y || R || R || - |
| 0 || - || R || Y || R || R || Y || Y |

