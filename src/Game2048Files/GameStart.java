package Game2048Files;

import java.awt.Color;

public class GameStart extends General2048Run implements Interface 
{
	public int num=0;//number value for detectLoss() class
	
	public void newGame(){
		save.setAction(game.getTime(), "New game created");
		
		game.startGame();//starts the game
		
		GUI.Create_GUI();//creates the GUI
		
	}
	
	public void StartBoard()//creates a random board for the start of the game
	{		int row=0, column=0;													
		for(int loop=0;loop<2;loop++) 
		{			row=0; column=0;												
			row=startTiles();
			column=startTiles();			
				if(boardIntegers[row][column]==0)
					tile.NewTile(row, column);
				else if(boardIntegers[row][column]!=0)
					{if(loop==0){loop=0;} else if(loop>0){loop=1;}	}			
		}
		
		save.setAction(game.getTime(), "New game board created");
	}
	
	public int startTiles()//creates a random row/column for the start of the game
	{int space=0; num=0;
	
		if(game.detectLoss()!=200 || game.detectWin()!=100)//doesn't enter infinite loop if the player lost 
			do
			{space=0;
				num=game.detectLoss();
				space += (int)(Math.random()*10+1); space-=1; //System.out.println(space);
			}while(space>4 || space<0 && num==0 && num == 200);
			
			if((!((space<4)&&(space>=0))) && (num!=0 | num!=200))
				return startTiles();
			return space;
		}
	
}
