package Game2048Files;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.Graphics;

public class Game2048Driver extends JPanel implements Interface
{
	public int pScore=0;
	public String pScoreStr="";
	public static void main(String[] args)
	{
		System.out.println("Starting new game");
		move.tileMove();
		start.newGame();
		
	}
}
