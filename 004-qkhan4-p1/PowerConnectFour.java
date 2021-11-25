

/**
 * Power Connect Four class used to play the game.
 * @author Qasim Khan
 */
public class PowerConnectFour {

	/**
	 *  The grid to contain tokens. Cells can be empty.
	 */
	private static Column<Token>[] grid; //	REMOVE STATIC DUMBASS REMOVE STATIC DUMBASS


	/**
	 *  The fixed number of columns the game grid should have.
	 */
	private static final int NUM_COLS = 7;

	/**
	 *  The minimum number of rows of the grid _for display_.
	 */
	private static final int MIN_ROWS = 6;

	/**
	 * The two players of the game.
	 * playerOne is always the first to make a move when the game starts.
	 */
	private static final Token playerOne = Token.RED;
	
	/**
	 * Second player of the game.
	 * Moves second.
	 */
	private static final Token playerTwo = Token.YELLOW;

	/**
	 * The character used to represent empty cells when the grid is displayed.
	 */
	private static final Character empty = Character.valueOf('-');

	/**
	 * When grid is displayed, the top row of the grid should always be empty.
	 */  
	private static final int MARGIN_ROWS = 1;


	/**
	 * Number used to indicate whose turn it currently is.
	 */
	private int turn;

	/**
	 * Used to calculate if there are more rows that need to be displayed.
	 */
	private int updatedRows = MIN_ROWS;



	/**
	 * Default Constructor which creates a grid and initializes game rules.
	 */
	@SuppressWarnings("unchecked")	
	public PowerConnectFour() {

		grid = (Column<Token>[]) new Column[NUM_COLS];


		for(int i = 0 ; i <= MIN_ROWS; i++)
		{

			grid[i] = new Column<Token>(); // each row is filled with a column of default capacity
		}
		turn = 0; // current player is initialized to be player one.


	}

	/**
	 * Private function used to change turn from one player to another.
	 */
	private void changeTurn() 
	{
		if(turn == 0 ) 
		{
			turn = 1;
		}
		else 
		{
			turn = 0;
		}
	}


	/**
	 * This method returns the number of columns in a grid.
	 * @return int the number of columns of the grid.
	 */
	public int sizeCol() { 
		// O(1)

		return NUM_COLS;
	}

	/**
	 * This method returns the size of the biggest row in the grid.
	 * @return int the size of the row that will be displayed.
	 */
	public int sizeRow() {
		// O(1)	

		int max = 0;
		for(int i = 0 ; i < grid.length ; i ++) 
		{
			if(grid[i].size() > max) 
			{
				max = grid[i].size();
			}
		}

		if (max < MIN_ROWS) 
		{
			return MIN_ROWS;
		}

		return max + MARGIN_ROWS; //default return, make sure to remove/change


	}

	/**
	 * This method returns the character defined for empty cells.
	 * @return character that signifies an empty cell.
	 */
	public Character getEmptySymbol(){	
		// O(1)

		return empty;
	}


	/**
	 * Returns the token at the given column and row of the grid.
	 * @param col the column we want to get our token from.
	 * @param row the row we want to get our token from.
	 * @return the token at the specified row and column.
	 */
	public Token get(int col, int row){
		// O(1)


		if(row < 0 || col > grid.length || col < 0) 
		{

			throw new IndexOutOfBoundsException("Col " + col + ", Row "+ row + " out of bounds!");
		}


		if (row >= grid[col].capacity())
		{
			return null;
		}


		return grid[col].get(row);

	}


	/**
	 * This method returns the column at a given index.
	 * @param col index of column we want to return.
	 * @return Column of type token.
	 */
	public Column<Token> getColumn(int col){
		// O(1)
		if(col < 0 || col > grid.length) 
		{
			throw new IndexOutOfBoundsException("Col " + col + " out of bounds!");
		}

		return grid[col]; //default return, make sure to remove/change
	}


	/**
	 * This method return the player that can make the next move.
	 * @return Token player who can make the next move
	 */
	public Token currentPlayer(){ 
		// Return the player that can make the next move.
		// O(1)
		if(turn == 0) 
		{
			return playerOne;
		}
		return playerTwo;

	}

	/**
	 * This method drops a token to the bottom of a column.
	 * @param col the column in which we want to drop a piece.
	 * @return true if the piece successfully drops and false otherwise.
	 */
	public boolean drop(int col){
		// Amortized O(1)		

		if(col > NUM_COLS || col < 0) // return false if the column provided is invalid.
		{
			return false;
		}

		if(grid[col].size() == grid[col].capacity()) // if the size of the column is equal to capacity.
		{
			grid[col].add(currentPlayer());
			changeTurn();
			return true;
		}
		else
		{
			for(int i = 0 ; i < grid[col].capacity(); i++) 
			{
				if (grid[col].get(i) == null) //
				{
					grid[col].add(currentPlayer());
					changeTurn();
					return true;
				}	
			}
		}


		return false; //default return, make sure to remove/change
	}



	/**
	 * This method will  place a Piece at a specific place on the board.
	 * @param col the column we want to place our piece.
	 * @param row the row we want to place the piece in.
	 * @return true if the piece has been successfully power dropped.
	 */
	public boolean powerDrop(int col, int row){    
		// O(N) where N is the number of tokens in the involved column


		if(col > NUM_COLS || col < 0 || row < 0 || row > grid[col].size()) 
		{
			return false;
		}

		grid[col].add(row, currentPlayer());
		changeTurn();
		return true; //default return, make sure to remove/change
	}


	/**
	 * This method removes a piece from the bottom of the column.
	 * Only works if it is the same as the current player.
	 * @param col the column the piece needs to be popped from.
	 * @return boolean true if piece has been popped successfully.
	 */
	public boolean pop(int col){
		// O(N) where N is the number of tokens in the involved column


		if(col > NUM_COLS || col < 0) 
		{

			return false;
		}

		if(grid[col].get(0) == currentPlayer()) 
		{
			grid[col].delete(0);
			changeTurn();
			return true;
		}

		return false;

	}


	/**
	 * This method removes a piece anywhere on the board.
	 * Only works if it is the same as the current player.
	 * @param col the column where the token we want to remove is located.
	 * @param row the row where the token we want to remove is located.
	 * @return boolean true if piece has been popped successfully.
	 */
	public boolean powerPop(int col, int row){
		// O(N) where N is the number of tokens in the involved column
		if(col > NUM_COLS || col < 0 || row < 0) 
		{
			return false;
		}

		if(grid[col].get(row) == currentPlayer()) 
		{
			grid[col].delete(row);
			changeTurn();
			if(grid[col].size() < MIN_ROWS) 
			{
				updatedRows = MIN_ROWS;
			}

			return true;

		}

		return false;
	}


	/**
	 * This method checks each row for counting.
	 * @param col column of starting point for counting.
	 * @param row of of starting point for counting.
	 * @param player the player we want to count for.
	 * @return the number of consecutive tokens starting from the specified column and index.
	 */
	public int countRow(int col, int row, Token player){
		// O(1)

		if(col > NUM_COLS || col < 0 || row < 0 || row > grid.length) 
		{
			return 0;
		}

		int positiveCount = 0, negativeCount = 0;



		for(int i = col ; i < grid.length;i++) 
		{
			if(this.get(i, row) == player) 
			{
				positiveCount++;
			}

			else 
			{
				break;
			}

		}

		for(int i = col ; i > 0 ;i--) 
		{
			if(this.get(i, row) == player) 
			{

				negativeCount++;
			}

			else 
			{
				break;
			}

		}

		if(positiveCount > negativeCount) 
		{
			return positiveCount;
		}
		return negativeCount;
	}


	/**
	 * This method checks each column for counting.
	 * @param col column of starting point for counting.
	 * @param row of of starting point for counting.
	 * @param player the player we want to count for.
	 * @return the number of consecutive tokens starting from the specified column and index.
	 */
	public int countCol(int col, int row, Token player){
		// O(N) where N is the number of tokens in the involved column
		if(col > NUM_COLS || col < 0 || row < 0 || row > grid.length) 
		{
			return 0;
		}

		int positiveCount = 0, negativeCount = 0;


		if(this.get(col, row) == player) 
		{

			for(int i = row ; i < grid[col].size();i++) 
			{
				if(grid[col].get(i) == player) 
				{
					positiveCount++;
				}

				else 
				{
					break;
				}

			}

			for(int i = row ; i > 0 ;i--) 
			{
				if(grid[col].get(i) == player) 
				{
					negativeCount++;
				}

				else 
				{
					break;
				}

			}

		}

		if(positiveCount > negativeCount) 
		{
			return positiveCount;
		}
		return negativeCount;
	}



	/**
	 * This method counts the major diagonals.
	 * Checks up and to the left, and down and to the right.
	 * @param col column of starting point for counting.
	 * @param row of of starting point for counting.
	 * @param player the player we want to count for.
	 * @return the number of consecutive tokens starting from the specified column and index.
	 */
	public int countMajorDiagonal(int col, int row, Token player){
		// O(1)

		if(col > NUM_COLS || col < 0 || row < 0 || row > grid.length) 
		{
			return 0;
		}

		int positiveCount = 0, negativeCount = 0;

		//Checking up and to the left
		for(int i = col, j = row ; i > 0 && j < grid.length; i--, j++) 
		{
			if(this.get(i, j) == player)

			{
				positiveCount++;

			}
			else {break;}




		}
		//Checking DOWN and to the RIGHT.
		for(int i = col, j = row ; i < grid[i].size()  && j > 0; i++, j--) 
		{
			if(this.get(i, j) == player) 
			{
				negativeCount ++;
			}
			else {break;}
		}

		if(positiveCount > negativeCount) 
		{
			return positiveCount;
		}
		return negativeCount;		
	}

	/**
	 * This method counts the minor diagonals.
	 * Checks up and to the right, and down and to the left.
	 * @param col column of starting point for counting.
	 * @param row of of starting point for counting.
	 * @param player the player we want to count for.
	 * @return the number of consecutive tokens starting from the specified column and index.
	 */
	public int countMinorDiagonal(int col, int row, Token player){
		// Count and return the number of consecutive tokens for the given player
		// in a minor diagonal such that one of those tokens is at the given row and col 
		// of the grid.  A minor diagonal line covering (col, row) can extend diagonally 
		// up and to the right as well as down and to the left from the given 
		// location (col, row).  

		// Return 0 if out of bounds
		// O(1)
		if(col > NUM_COLS || col < 0 || row < 0 || row > grid.length) 
		{
			return 0;
		}

		int positiveCount = 0, negativeCount = 0;
		//Checking down and to the left

		for(int i = col, j = row ; i > 0 && j > 0; i--, j--) 
		{
			if(this.get(i, j)== player) 
			{
				positiveCount ++;
			}
			else 
			{
				break;
			}
		}
		//Checking up and to the right.
		for(int i = col, j = row ; i < grid[i].size()  && j < grid.length; i++, j++) 
		{
			if(this.get(i, j)== player) 
			{
				negativeCount ++;
			}
			else 
			{
				break;
			}
		}

		if(positiveCount > negativeCount) 
		{
			return positiveCount;
		}
		return negativeCount;

	}



	//******************************************************
	//*******  DO NOT EDIT ANYTHING IN THIS SECTION  *******
	//*******        But do read this section!       *******
	//******************************************************

	/**
	 * The method that checks whether the specified player has four connected tokens
	 * horizontally, vertically, or diagonally.  It relies on the methods of countRow(),
	 * countCol(), countMajorDiagonal(), and countMinorDiagonal() to work correctly.
	 *
	 * @param player the token to be checked
	 * @return whether the given player has four tokens connected
	 */
	public boolean hasFourConnected(Token player){
		// Check whether the specified player has four tokens either in a row,
		// in a column, or in a diagonal line (major or minor). Return true if 
		// so; return false otherwise.	

		for (int j = 0; j<sizeCol(); j++){
			for (int i = 0; i<sizeRow(); i++){
				if (countRow(j, i, player)>=4 || countCol(j, i, player)>=4
						|| countMajorDiagonal(j, i, player)>=4 
						|| countMinorDiagonal(j, i, player)>=4 )
					return true;
			}
		}
		return false;

	}

	//******************************************************
	//*******     BELOW THIS LINE IS TESTING CODE    *******
	//*******      Edit it as much as you'd like!    *******
	//*******		Remember to add JavaDoc			 *******
	//******************************************************

	/**
	 * main method used for testing.
	 * @param args command line arguments.
	 */
	public static void main(String[] args) {

		// init with an empty grid
		PowerConnectFour myGame = new PowerConnectFour();


		if (myGame.sizeCol() == NUM_COLS && myGame.sizeRow() == MIN_ROWS
				&& myGame.getColumn(2).size() == 0 && myGame.currentPlayer() == Token.RED
				&& myGame.get(0,0) == null){
			System.out.println("Yay 1!");		
		}


		// drop
		if (!myGame.drop(10) && myGame.drop(2) && myGame.getColumn(2).size() == 1 && 
				myGame.get(2,0) == Token.RED && myGame.currentPlayer() == Token.YELLOW ){
			System.out.println("Yay 2!");					
		}

		// drop, pop, column growing/shrinking, board display changed
		boolean ok = true;
		for (int i=0; i<5; i++){
			ok = ok && myGame.drop(2); //take turns to drop to column 2 for five times

		}



		//		System.out.println("===Current Grid===");		
		//		PowerConnectFourGUI.displayGrid(myGame); //uncomment to check the grid display

		if (ok && myGame.getColumn(2).size() == 6 && myGame.sizeRow() == 7
				&& myGame.pop(2) && myGame.sizeRow() == 6 && myGame.get(2,1) == Token.RED){
			System.out.println("Yay 3!");							
		}

		//		System.out.println();
		//		PowerConnectFourGUI.displayGrid(myGame); //uncomment to check the grid display


		// power drop
		if (!myGame.powerDrop(3,1) && myGame.powerDrop(3,0) && myGame.powerDrop(2,2)
				&& myGame.getColumn(2).size() == 6 && myGame.get(2,2) == Token.RED
				&& myGame.get(2,3) == Token.YELLOW && myGame.getColumn(3).size() == 1){
			System.out.println("Yay 4!");							
		}
		//PowerConnectFourGUI.displayGrid(myGame); //uncomment to check the grid display

		//power pop

		if (!myGame.powerPop(2,1) && myGame.powerPop(2,3) 
				&& myGame.getColumn(2).size() == 5 && myGame.get(2,3).getSymbol()=='R'){
			System.out.println("Yay 5!");									
		}

		//		myGame.drop(3);
		//		PowerConnectFourGUI.displayGrid(myGame); //uncomment to check the grid display
		//		PowerConnectFourGUI.reportcurrentPlayer(myGame);
		// expected display:
		//|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 |
		//| 5 || - || - || - || - || - || - || - |
		//| 4 || - || - || Y || - || - || - || - |
		//| 3 || - || - || R || - || - || - || - |
		//| 2 || - || - || R || - || - || - || - |
		//| 1 || - || - || R || - || - || - || - |
		//| 0 || - || - || Y || Y || - || - || - |
		//Player R's turn

		//		myGame.drop(3);
		//		System.out.println(myGame.countMajorDiagonal(3,1,Token.RED));

		//counting
		if (myGame.countRow(3,0,Token.YELLOW) == 2 && myGame.countRow(3,0,Token.RED) == 0
				&& myGame.countCol(2,3,Token.RED) == 3 && myGame.drop(3) /*one more R*/
				&& myGame.countMajorDiagonal(3,1,Token.RED) == 2 /* (3,1) and (2,2) */
				&& myGame.countMinorDiagonal(2,0,Token.YELLOW) == 1){
			System.out.println("Yay 6!");												
		}


	}
}