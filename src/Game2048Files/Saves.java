package Game2048Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Saves extends General2048Run implements Interface
{
	public int score,highScore;
	
	public String saveDataPath;
	public String fileName = "SaveData";
	public String n="def";
	
	public Saves()
	{
		try {
			saveDataPath = GameBoard.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();//the path to the save file 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void createSaveData(String name)//creates the sstuff for savinfs data
	{this.n=name;
		try {
			File file = new File(saveDataPath, name);//creates the file
			
			FileWriter output = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write("" + 0);//default value
			writer.close();//closes the writer
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void loadHighScore()//loads the high score data from the file
	{
		try {
			File f = new File(saveDataPath, fileName);//makes a file 
			if(!f.isFile())//if the file doesn't exist already
			{
				createSaveData(fileName);
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			highScore = Integer.parseInt(reader.readLine());//reads from file
			reader.close();//closes reader when done
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void setHighScore()//increases the high score if the current score is above it
	{
		File file = new File(saveDataPath, n);//creates the file
		
		FileWriter output;
		try {
			output = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(output);
		try {
			this.createSaveData(fileName);
			
				writer.write("" + score);//changes the high score to the current score
			
			writer.close();//closes the writer when done
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			
	}
	
	
	public String actionName = "gameActionData.zData";
	public String actionDataPath = "C:\\Users\\Cole\\Desktop\\PROGRAMS\\FINAL 2048 PROJECT\\src\\Game2048Files";
	public String previousActionText;
	
	public void setAction(String time, String input)
	{
		try {
			File actionFile = new File(actionDataPath, actionName);//creates the file
			
			FileWriter actionFileWriter = new FileWriter(actionFile, true);
			BufferedWriter actionBufferedWriter = new BufferedWriter(actionFileWriter);			
			
			actionBufferedWriter.newLine();   //Add new line
			actionFileWriter.write("[" + time + "]" + " " + input );//writes datatatatataaa
			
			actionBufferedWriter.close();
			actionFileWriter.close();//closes the writer
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
