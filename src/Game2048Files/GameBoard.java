package Game2048Files;

import java.awt.Color;

public class GameBoard extends Game2048Driver implements Interface
{
	
	public void arrayToString()//takes an int value from the boardIntegers array into a string placed in the board array
	{	
		for(int out=0;out<4;out++)
		{
			for(int in=0;in<4;in++)
			{
				board[in][out] = String.valueOf(boardIntegers[in][out]);
			}
		}
		
	}
	
	
	public String scoreToString()//basically the arrayToString() method but it is used for the game score
	{String value = String.valueOf(pScore);
		pScoreStr = "Score: " + value;
	return pScoreStr;
	}
	
	
	public void newTiles()
	{
		int row=0, column=0;													
		for(int loop=0;loop<2;loop++) 
		{	row=0; column=0;												
			row+=start.startTiles();
			column+=start.startTiles();			
				if(boardIntegers[row][column]==0)
					tile.NewTile(row, column);
				else
					if(loop==0){loop=0;} 
						else if(loop>0){loop=0;}	
		}
		gameB.arrayToString();
		GUI.createBoardTilesGUI(g);
	}
	
	
	
	public void printBoard()//prints board to Eclipse console (for testing)
	{	System.out.print("\n");
		System.out.println("|---|---|---|---|");
		for(int loop=0; loop<4;loop++)
		{System.out.print("| ");
			for(int loop2=0; loop2<4;loop2++)
			{
				System.out.print(boardIntegers[loop2][loop] + " | ");
			}
			System.out.print("\n|---|---|---|---|\n");
		}
		
	}
	
}
