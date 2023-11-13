package Game2048Files;

import java.awt.Color;
import java.time.*; 
import java.time.format.*; 

public class General2048Run extends Game2048Driver implements Interface
{
	public boolean loss1=false,loss2=false,loss3=false,loss4=false;

	public LocalDateTime t;
	public String localTimeString;
	
	public LocalDateTime getTimeObject(){

		  t = (LocalDateTime.now());  
		  
		  return t;
	}

  public String getTime(){
    localTimeString = (dateFormat.format(t));
    return localTimeString;
  }
	
	
	public void createArrays()//enters the values in the arrays as 0 or null
	{
		for(int loop=0; loop<4;loop++)
		{
			for(int loop2=0;loop2<4;loop2++)
			{
				boardIntegers[loop][loop2]=0;
				board[loop][loop2]="0";
			}
		}
		
		save.setAction(game.getTime(), "Arrays created");
		//log.printLog("Array Creation = true\n");
	}
	
	public int detectLoss()//checks if all tiles are fill, if true then the player lost
	{int num1=0,num2=0; loss1=false;loss2=false;loss3=false;loss4=false;
		if(boardIntegers[0][0]!=0 && boardIntegers[0][1]!=0 && boardIntegers[0][2]!=0 && boardIntegers[0][3]!=0)
		{
			loss1=true;
		}
		if(boardIntegers[1][0]!=0 && boardIntegers[1][1]!=0 && boardIntegers[1][2]!=0 && boardIntegers[1][3]!=0)
		{
			loss2=true;
		}
		if(boardIntegers[2][0]!=0 && boardIntegers[2][1]!=0 && boardIntegers[2][2]!=0 && boardIntegers[2][3]!=0)
		{
			loss3=true;
		}
		if(boardIntegers[3][0]!=0 && boardIntegers[3][1]!=0 && boardIntegers[3][2]!=0 && boardIntegers[3][3]!=0)//very efficient yesyes
		{
			loss4=true;
		}
		if(loss4==true && loss3==true && loss2==true && loss1==true)
		{
			GUI.lostGame(g);
			return 200;
		}
		return 0;
	}
	
	
	public void update()//updates the game GUI and scores and stuff
	{
		scoreCalc();
		
		GUI.paintBoard(g);
		gameB.newTiles();
		gameB.arrayToString();
		GUI.createBoardTilesGUI(g);
	}
	
	public int detectWin()//checks if the player got the 2048 tile
	{
		
		for(int loop=0; loop<4;loop++)
		{
			for(int loop2=0;loop2<4;loop2++)
			{
				if(boardIntegers[loop][loop2]==2048)
				{
					GUI.winGame(g);
					save.setAction(game.getTime(), "Game won!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					return 100;
				}
				
			}
		}
		return 0;
		
	}
	
	public String scoreCalc()
	{save.score=0;
		for(int loop=0; loop<4;loop++)
		{
			for(int loop2=0;loop2<4;loop2++)
			{
				save.score += Integer.valueOf(boardIntegers[loop][loop2]);
			}
		}
		gameB.scoreToString();
		if(save.score>save.highScore)
		{save.setHighScore();}
		
		GUI.scoreGUI(g);
		return gameB.scoreToString();
		
	}
	
	public void resetBoardValues() {
		changeValues();
		gameB.arrayToString();
	}
	
	public void changeValues() {
		int loop=0, loop2 = 0;
		for(loop=0; loop<4; loop++){
			for(loop2=0; loop2<4; loop2++) {
				boardIntegers[loop][loop2]=0; 
				board[loop][loop2]="0";
			}
			loop2=0;
		}
	}
	
	public void startGame()//enters methods needed to start a new game
	{
		resetBoardValues();
		scoreCalc();
		start.StartBoard();
		save.setAction(game.getTime(), "Game Started");
	}
	
	
}
