package Game2048Files;

import java.awt.Component;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MovementFiles implements Interface
{	
	Game2048Driver moveGame;
	
	public int temp=0;
	public boolean restart = false;
	public KeyEvent ke;
	
	public void restartGame(){
		restart=true;
	                    
		save.setAction(game.getTime(), "Game restarted apparently???\n\n");
		
		try {
			Thread.sleep(5000);
			start.newGame();
		} catch (InterruptedException e) {
			System.err.println("idiot");
			e.printStackTrace();
		}
	}
	    
	    public void tileCombine(int x, int y)//combines tiles
	    {
	    	
	    }
	    
	    public void tileMove()//moves the tiles
	    {
	    	KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

	            public boolean dispatchKeyEvent(KeyEvent ke) {
	                synchronized (MovementFiles.class) {
	                    switch (ke.getID()) {
	                    case KeyEvent.KEY_PRESSED:
	                        if (ke.getKeyCode() == KeyEvent.VK_UP) {
	                        	save.setAction(game.getTime(), "UP");
	                            moveUp();
	                        }
	                        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
	                        	save.setAction(game.getTime(), "DOWN");
	                            moveDown();
	                        }
	                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
	                        	save.setAction(game.getTime(), "RIGHT");
	                            moveRight();
	                        }
	                        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
	                        	save.setAction(game.getTime(), "LEFT");
	                            moveLeft();
	                        }
	                        if ((ke.getKeyCode() == KeyEvent.VK_SPACE)) {
	                        	save.setAction(game.getTime(), "Starting AI");
	                        	System.out.println("Starting AI");
	                        }
	                        if ((ke.getKeyCode() == KeyEvent.VK_ENTER)) {
	                        	start.newGame();
	                        }
	                        break;

	                    case KeyEvent.KEY_RELEASED:
	                        if (ke.getKeyCode() == KeyEvent.VK_UP) {
	                        	
	                        }
	                        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
	                            
	                        }
	                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {

	                        }
	                        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {

	                        }
	                        if ((ke.getKeyCode() == KeyEvent.VK_ENTER)) {
	                        	
	                        }
	                        if ((ke.getKeyCode() == KeyEvent.VK_SPACE)) {
	                        	
	                        }
	                        break;
	                    }
	                    return false;
	                }
	            }
	        });
	    }
	
	public void moveUp()//moves up
	{
				//MERGE CELLS
				for(int in=0;in<4;in++) {//loop that changes x value to merge cells
					if(boardIntegers[in][3] == boardIntegers[in][2])
						{boardIntegers[in][2] += Integer.valueOf(boardIntegers[in][3]); boardIntegers[in][3]=0;}
						if(boardIntegers[in][2] == boardIntegers[in][1])
							{boardIntegers[in][1] += Integer.valueOf(boardIntegers[in][2]); boardIntegers[in][2]=0;}
							if(boardIntegers[in][1] == boardIntegers[in][0])
								{boardIntegers[in][0] += Integer.valueOf(boardIntegers[in][1]); boardIntegers[in][1]=0;}
				}
				
				//MOVE CELLS
				for(int loop=0;loop<4;loop++)//loops 4 times so it can get every tile in the right location
					for(int in=0;in<4;in++) {//l
						if(boardIntegers[in][0] == 0 && boardIntegers[in][1] != 0)
						{boardIntegers[in][0] = Integer.valueOf(boardIntegers[in][1]); boardIntegers[in][1]=0;}
					else if(boardIntegers[in][1] == boardIntegers[in][0])
					{boardIntegers[in][0] += Integer.valueOf(boardIntegers[in][1]); boardIntegers[in][1]=0;}
						if(boardIntegers[in][1] == 0 && boardIntegers[in][2] != 0)
						{boardIntegers[in][1] = Integer.valueOf(boardIntegers[in][2]); boardIntegers[in][2]=0;}
					else if(boardIntegers[in][2] == boardIntegers[in][1])
						{boardIntegers[in][1] += Integer.valueOf(boardIntegers[in][2]); boardIntegers[in][2]=0;}
						if(boardIntegers[in][2] == 0 && boardIntegers[in][3] != 0)
							{boardIntegers[in][2] = Integer.valueOf(boardIntegers[in][3]); boardIntegers[in][3]=0;}
						else if(boardIntegers[in][3] == boardIntegers[in][2])
							{boardIntegers[in][2] += Integer.valueOf(boardIntegers[in][3]); boardIntegers[in][3]=0;}
						
				}
				
				//MERGE CELLS
				for(int in=0;in<4;in++) {//loop that changes x value to merge cells
					if(boardIntegers[in][3] == boardIntegers[in][2])
						{boardIntegers[in][2] += Integer.valueOf(boardIntegers[in][3]); boardIntegers[in][3]=0;}
						if(boardIntegers[in][2] == boardIntegers[in][1])
							{boardIntegers[in][1] += Integer.valueOf(boardIntegers[in][2]); boardIntegers[in][2]=0;}
							if(boardIntegers[in][1] == boardIntegers[in][0])
								{boardIntegers[in][0] += Integer.valueOf(boardIntegers[in][1]); boardIntegers[in][1]=0;}}
				game.update();

				}
	
	public void moveDown()//moves down
	{
		
		//MERGE CELLS
		for(int in=0;in<4;in++) {//loop that changes x value to merge cells
			if(boardIntegers[in][3] == boardIntegers[in][2])
				{boardIntegers[in][2] += Integer.valueOf(boardIntegers[in][3]); boardIntegers[in][3]=0;}
				if(boardIntegers[in][2] == boardIntegers[in][1])
					{boardIntegers[in][1] += Integer.valueOf(boardIntegers[in][2]); boardIntegers[in][2]=0;}
					if(boardIntegers[in][1] == boardIntegers[in][0])
						{boardIntegers[in][0] += Integer.valueOf(boardIntegers[in][1]); boardIntegers[in][1]=0;}	
		}
			
		//MOVE CELLS	
		for(int loop=0;loop<4;loop++)//loops 4 times so it can get every tile in the right location
			for(int in=0;in<4;in++) {//l
				if(boardIntegers[in][3] == 0 && boardIntegers[in][2] != 0)
				{boardIntegers[in][3] = Integer.valueOf(boardIntegers[in][2]); boardIntegers[in][2]=0;}
			else if(boardIntegers[in][2] == boardIntegers[in][3])
				{boardIntegers[in][3] += Integer.valueOf(boardIntegers[in][2]); boardIntegers[in][2]=0;}	
				if(boardIntegers[in][2] == 0 && boardIntegers[in][1] != 0)
				{boardIntegers[in][2] = Integer.valueOf(boardIntegers[in][1]); boardIntegers[in][1]=0;}
			else if(boardIntegers[in][1] == boardIntegers[in][2])
				{boardIntegers[in][2] += Integer.valueOf(boardIntegers[in][1]); boardIntegers[in][1]=0;}
				if(boardIntegers[in][1] == 0 && boardIntegers[in][0] != 0)
				{boardIntegers[in][1] = Integer.valueOf(boardIntegers[in][0]); boardIntegers[in][0]=0;}
			else if(boardIntegers[in][0] == boardIntegers[in][1])
			{boardIntegers[in][1] += Integer.valueOf(boardIntegers[in][0]); boardIntegers[in][0]=0;}
			
			
			
		}
			//MERGE CELLS AGAIN
				for(int in=0;in<4;in++) {//loop that changes x value to merge cells
					if(boardIntegers[in][3] == boardIntegers[in][2])
					{boardIntegers[in][2] += Integer.valueOf(boardIntegers[in][3]); boardIntegers[in][3]=0;}
					if(boardIntegers[in][2] == boardIntegers[in][1])
					{boardIntegers[in][1] += Integer.valueOf(boardIntegers[in][2]); boardIntegers[in][2]=0;}
					if(boardIntegers[in][1] == boardIntegers[in][0])
					{boardIntegers[in][0] += Integer.valueOf(boardIntegers[in][1]); boardIntegers[in][1]=0;}	
				}
				game.update();

		
	}
	
	public void moveRight()//moves right
	{
		//MERGE CELLS	
				for(int in=0; in<4;in++)
				{
					if(boardIntegers[3][in] == boardIntegers[2][in])
						{boardIntegers[2][in] += Integer.valueOf(boardIntegers[3][in]); boardIntegers[3][in]=0;}
						if(boardIntegers[2][in] == boardIntegers[1][in])
							{boardIntegers[1][in] += Integer.valueOf(boardIntegers[2][in]); boardIntegers[2][in]=0;}
							if(boardIntegers[1][in] == boardIntegers[0][in])
								{boardIntegers[0][in] += Integer.valueOf(boardIntegers[1][in]); boardIntegers[1][in]=0;}
				}
				
				//MOVE CELLS	
				for(int loop=0;loop<4;loop++)//loops 4 times so it can get every tile in the right location
						for(int in=0;in<4;in++) {//l
							if(boardIntegers[3][in] == 0 && boardIntegers[2][in] != 0)
								{boardIntegers[3][in] += boardIntegers[2][in]; boardIntegers[2][in] = 0;}
								if(boardIntegers[2][in] == 0 && boardIntegers[1][in] != 0)
									{boardIntegers[2][in] += boardIntegers[1][in]; boardIntegers[1][in] = 0;}
									if(boardIntegers[1][in] == 0 && boardIntegers[0][in] != 0)
										{boardIntegers[1][in] += boardIntegers[0][in]; boardIntegers[0][in] = 0;}
						}
						
						//MERGE CELLS	
						for(int in=0; in<4;in++)
						{
							if(boardIntegers[3][in] == boardIntegers[2][in])
								{boardIntegers[3][in] += (boardIntegers[2][in]); boardIntegers[2][in]=0;}
								if(boardIntegers[2][in] == boardIntegers[1][in])
									{boardIntegers[2][in] += Integer.valueOf(boardIntegers[1][in]); boardIntegers[1][in]=0;}
									if(boardIntegers[1][in] == boardIntegers[0][in])
										{boardIntegers[1][in] += Integer.valueOf(boardIntegers[0][in]); boardIntegers[0][in]=0;}
						}
						game.update();

	}
	
	public void moveLeft()//moves left
	{
		//MERGE CELLS	
		for(int in=0; in<4;in++)
		{
			if(boardIntegers[3][in] == boardIntegers[2][in])
			{boardIntegers[2][in] += Integer.valueOf(boardIntegers[3][in]); boardIntegers[3][in]=0;}
				if(boardIntegers[2][in] == boardIntegers[1][in])
				{boardIntegers[1][in] += Integer.valueOf(boardIntegers[2][in]); boardIntegers[2][in]=0;}
					if(boardIntegers[1][in] == boardIntegers[0][in])
					{boardIntegers[0][in] += Integer.valueOf(boardIntegers[1][in]); boardIntegers[1][in]=0;}
		}
		
		//MOVE CELLS	
		for(int loop=0;loop<4;loop++)//loops 4 times so it can get every tile in the right location
				for(int in=0;in<4;in++) {//l
					if(boardIntegers[3][in] != 0 && boardIntegers[2][in] == 0)
					{boardIntegers[2][in] += boardIntegers[3][in]; boardIntegers[3][in] = 0;}
					if(boardIntegers[2][in] != 0 && boardIntegers[1][in] == 0)
					{boardIntegers[1][in] += boardIntegers[2][in]; boardIntegers[2][in] = 0;}
					if(boardIntegers[1][in] != 0 && boardIntegers[0][in] == 0)
					{boardIntegers[0][in] += boardIntegers[1][in]; boardIntegers[1][in] = 0;}
				}
				
				//MERGE CELLS	
				for(int in=0; in<4;in++)
				{
					if(boardIntegers[3][in] == boardIntegers[2][in])
					{boardIntegers[2][in] += Integer.valueOf(boardIntegers[3][in]); boardIntegers[3][in]=0;}
						if(boardIntegers[2][in] == boardIntegers[1][in])
						{boardIntegers[1][in] += Integer.valueOf(boardIntegers[2][in]); boardIntegers[2][in]=0;}
							if(boardIntegers[1][in] == boardIntegers[0][in])
							{boardIntegers[0][in] += Integer.valueOf(boardIntegers[1][in]); boardIntegers[1][in]=0;}
				}
				game.update();
	}
	
}



