package Game2048Files;
import java.awt.*;

import java.awt.event.*;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.Graphics2D;
import java.awt.Graphics;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.time.*; 
import java.time.format.*; 

public interface Interface
{

	public GUI_Updates GUI = new GUI_Updates();
	public JFrame gui = GUI.getGUI();
	
	
	public Scanner scan = new Scanner(System.in);
	
	
	public JTextArea Jtext = new JTextArea(50, 10);
	public PrintStream printStream=null;
	
	public Color startingColor = new Color(0xFFEBCD);
	public Color gridColor = new Color(0xBBADA0);
	public Color logColor = new Color(000000);
    
    public Graphics g = GUI.getGra();	//graphics object
    
	public Log log = new Log();
    
	public Graphics gLog = null;
    
	
	public Panel pnl = new Panel();          // Panel is a container
	public Button btn = new Button("Press"); // Button is a component
 	
	//CLASSES (mostly)
	public General2048Run game = new General2048Run();
	public GameStart start=new GameStart();
	public MovementFiles move = new MovementFiles();
	public Tiles tile = new Tiles();
	public GameBoard gameB=new GameBoard();
	public Saves save=new Saves();
	
	public String[][] board = new String[4][4];   //Board that will be displayed
	public int[][] boardIntegers = new int[4][4]; //board filled with integers
	
	public DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE_TIME; //Date and time
	public LocalDateTime localTime = game.getTimeObject();  

	public String currentTime = (dateFormat.format(localTime));
}
