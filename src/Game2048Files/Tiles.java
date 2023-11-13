package Game2048Files;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Graphics;

public class Tiles extends JPanel implements Interface
{
	public static final int width=125;
	public static final int height=125;
	public static final int slideSpeed=20;
	public static final int arcWidth=15;
	public static final int arcHeight=15;
	
	public void tileGen(int x, int y, Graphics g, Color c)//generates tiles
	{
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}
	
	public void NewTile(int row, int column)//creates a new tile and inserts it into a null value space
	{
		do {
			
			if(boardIntegers[row][column]==0)
				{									
					int chance = (int)(Math.random()*100+1); chance--;
						if(chance<=90)
							boardIntegers[row][column] = 2;
						else if(chance>90)
							boardIntegers[row][column] = 4;
				}
			}while(boardIntegers[row][column]==0);
		gameB.arrayToString();
		
	}
	
	public int startTiles()//creates a random row/column for the start of the game
	{int space=0;
		do
		{space=0;
			space += (int)(Math.random()*10);	//System.out.println(space); //space--;
		}while(space>4 || space<0);
		
		if(!((space<4)&&(space>0)))
			return startTiles();
		
		return space;
	}
	
}
