package Game2048Files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.OutputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Log extends General2048Run implements Interface 
{
		public JTextArea lText = null;
		public JScrollPane lScroll = new JScrollPane(lText);
		public JLabel LogLabel = new JLabel();
		public JFrame gameLog = new JFrame("2048 Log");
		public JTextField LogOut = new JTextField();
		public JPanel lPanel = new JPanel();
		
		public int lX=50, lY=50;
	
		public void getLog()//JFrame object creation of the GUI
		{
			JFrame logGUI = new JFrame("2048 Log (Testing)");
			logGUI.setSize(400, 300);
			logGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends program whenever GUI is closed
			logGUI.setLocationRelativeTo(null);					//puts GUI in center of screen
			logGUI.setBackground(Color.DARK_GRAY);
			logGUI.setFocusable(true);
			logGUI.setLocationRelativeTo(null);
			logGUI.setVisible(true);
			startLog();
			
		}
		
	public void startLog()//starts the log
	{
		LogOut = new JTextField(12);
		
		gameLog.setSize(400, 300);								//default GUI window size
		
		gameLog.setBackground(Color.BLACK);						//default background color
        
		gameLog.setTitle("Log");								//Title of the GUI
        
		gameLog.setResizable(true);								//Allows user to resize tab
        
		gameLog.setVisible(true);								//Makes GUI be visible and appear
		printLog("Log opened", gLog);
	}
	public void printLog(String str, Graphics g)//prints text to the log
	{lX+=15; lY+=15;
		g.setColor(Color.BLUE);
		g.drawString(str,lX,lY);
		gameLog.setVisible(true);
	}
	
}
