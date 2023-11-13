package Game2048Files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI_Updates extends General2048Run implements Interface
{
	//GUI size stuff
	public static final int width=800;
	public static final int height=800;
	
	//Game Board size stuff
	public static final int Bwidth=600;
	public static final int Bheight=600;
	
	//tile size
	public static int x=128;//x coordinate for starting tile
	public static int y=150;//y coordinate for starting tile
	public static final int tSizeX = 128;//holds starting value for x'
	public static final int tSizeY = 150;//holds starting value for y
	
	//text in tiles location
	public static int xS=175;//x coordinate for starting tile 
	public static int yS=228;//y coordinate for starting tile
	public static final int tSX = xS;//holds starting value for x'
	public static final int tSY = yS;//holds starting value for y
	
	public String tileVal="";//Stores the String version of tile value
	
	public static final int slideSpeed=20;
	public static final int arcWidth=15;
	public static final int arcHeight=15;
	
	public BufferedImage tileImg;
	public BorderLayout borderL = new BorderLayout();
	public Container GUI1 = new Container();
	public JPanel gPanel = new JPanel();
	public JTextArea gText = new JTextArea();
	public JLabel gLabel;
	public Font gFont;
	public JButton gButton;
	
	public JFrame getGUI()//JFrame object creation of the GUI
	{
		
		JFrame gui = new JFrame("2048 Game");
		gui.setSize(width, height);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends program whenever GUI is closed
        gui.setLocationRelativeTo(null);					//puts GUI in center of screen
        gui.setBackground(Color.DARK_GRAY);
        gui.setFocusable(true);
        
        gui.setVisible(true);
        
        //save.setAction(game.getTime(), "GUI Created");
		
		return gui;
	}
	
	public Graphics getGra()//graphics object into interface 
	{Graphics g = gui.getGraphics();
		return g;
	}
	public String score2="";
			//||__||
			//||__||
			//||  ||
				
				public void paintBoard(Graphics g)//creates background and title of the game in the GUI
				{
					g.setColor(Color.LIGHT_GRAY);//makes board
					g.fillRect(100, 55, Bwidth, Bheight+100);
					gui.setLocationRelativeTo(null);
					
					//"2048" \n "Made by Cole Marino" square stuff
					g.setColor(Color.YELLOW);
					g.fillRect(103, 58, 100, 50);
					
					//Text within yellow square
					g.setColor(Color.BLACK);
					g.setFont(new Font("ComicSans", Font.BOLD, 35));
					g.drawString("2048", 103, 88);
					g.setFont(new Font("ComicSans", Font.BOLD, 9));
					g.drawString("Made by Cole Marino", 103, 103);
					scoreGUI(g);
					createBoardTilesGUI(g);
					gui.setVisible(true);
				}
				
				
				public void scoreGUI(Graphics g)
				{save.loadHighScore();
					//score text
					g.setColor(Color.YELLOW);
					g.fillRect(250, 60, 150, 26);
					g.setColor(Color.BLACK);
					g.setFont(new Font("ComicSans", Font.BOLD, 25));
					g.drawString("Score: " + save.score, 250, 80);
					
					g.setColor(Color.YELLOW);
					g.fillRect(250, 100, 220, 26);
					g.setColor(Color.BLACK);
					g.setFont(new Font("ComicSans", Font.BOLD, 25));
					g.drawString("High score: " + save.highScore, 250, 120);
				}
				
				
				public void updateBoardGUI(Graphics g)//updates the board after a movement occurs
				{xS=0; xS=tSX;
				yS=0;yS=tSY;
					
					g.setColor(Color.WHITE);
					g.setFont(new Font("ComicSans", Font.BOLD, 45));
					gui.setVisible(true);
					for(int out=0;out<4; xS+=125+15)
					{
						yS=tSY;
						for(int in=0;in<4;yS+=125+15)
						{
							tileVal=(board[out][in]);
							
								if(tileVal==null)
								{tileVal="0";}
							
							g.drawString(tileVal, xS, yS);
							in+=1; 
						}
						out+=1; 
						
					}
					
					
				}
				
				
				public void createBoardTilesGUI(Graphics g)//creates empty tiles on the board *dab*
				{x=128;
				y=150;
					
						for(int out=0;out<4; x+=125+15)
						{
							for(int in=0;in<4;y+=125+15)//makes the tile color change depending on the value
							{
								if(boardIntegers[out][in]==0)
									tile.tileGen(x,y, g, Color.GRAY);
								else if(boardIntegers[out][in]==2)
									tile.tileGen(x,y, g, Color.GREEN);
								else if(boardIntegers[out][in]==4)
									tile.tileGen(x,y, g, Color.RED);
								else if(boardIntegers[out][in]==8)
									tile.tileGen(x,y, g, Color.BLUE);
								else if(boardIntegers[out][in]==16)
									tile.tileGen(x,y, g, Color.PINK);
								else if(boardIntegers[out][in]==32)
									tile.tileGen(x,y, g, Color.ORANGE);
								else if(boardIntegers[out][in]==64)
									tile.tileGen(x,y, g, Color.MAGENTA);
								else if(boardIntegers[out][in]==128)
									tile.tileGen(x,y, g, Color.CYAN);
								else if(boardIntegers[out][in]==256)
									tile.tileGen(x,y, g, Color.RED);
								else if(boardIntegers[out][in]==512)
									tile.tileGen(x,y, g, Color.BLUE);
								else if(boardIntegers[out][in]==1024)
									tile.tileGen(x,y, g, Color.GREEN);
								else if(boardIntegers[out][in]==2048)
									tile.tileGen(x,y, g, Color.YELLOW);
								in++;
							}
							out++; 
							y=tSizeY;
						}
						g.setColor(Color.RED);
						gui.setVisible(true);
						updateBoardGUI(g);
				}
				
				
				public void lostGame(Graphics g)//displays if the player lost the game
				{
					g.setColor(Color.YELLOW);
					g.fillRect(140, 140, 520, 520);
					g.setColor(Color.RED);
					g.fillRect(150, 150, 500, 500);
					g.setColor(Color.BLACK);
					g.setFont(new Font("ComicSans", Font.BOLD, 80));
					g.drawString("YOU LOST! Press ENTER to Continue", 180, 250);
					gui.setVisible(true);
					
					save.setAction(game.getTime(), "Game lost");
					
					move.restartGame();
				}
				
				public void winGame(Graphics g)//displays if the player won the game by getting the 2048 tile
				{
					g.setColor(Color.YELLOW);
					g.fillRect(140, 140, 520, 520);
					g.setColor(Color.BLUE);
					g.fillRect(150, 150, 500, 500);
					g.setColor(Color.BLACK);
					g.setFont(new Font("ComicSans", Font.BOLD, 45));
					g.drawString("Using facts and logic,", 180, 200);
					g.drawString("YOU WON!", 275, 250);
					
					save.setAction(game.getTime(), "Game won");
					
					gui.setVisible(true);
				}
				
				
				public void Game_GUI() //method that creates the GUI
				{
					gui.setPreferredSize(new Dimension(width, height));
					gui.setVisible(true);
			  }
	
	public void Create_GUI() //basically a method creates the GUI 
	{
		paintBoard(g);
		Game_GUI();
		
		gui.setVisible(true);
	}
}