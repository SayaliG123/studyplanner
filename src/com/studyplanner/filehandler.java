package com.studyplanner;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class filehandler {
	public void savetasks(ArrayList<Task>task)
	{
		
	
	try {

			FileWriter sa= new FileWriter("data.txt");
			for(Task t:task)
			{
				sa.write(t.subject+ ","+t.difficulty_level+ ","+ t.days_left);
			}
			sa.close();
			System.out.println("data saved");
		}
	catch(IOExeption e)
	{
		System.out.println("error saving file");
	}
	
}
	
	public ArrayList<Task> loadtask()
	{
		ArrayList<Task>task =new ArrayList<>();
		try {
			BufferedReader sa = new BufferedReader(new FileReader("data.txt"));
			String line;
			
			while((line=sa.readLine())!=null)
			{
				String[] parts = line.split(",");
				
				String subject=parts[0];
				int difficulty = Integer.parseInt(parts[1]);
	            int daysLeft = Integer.parseInt(parts[2]);
	            task.add(new Task(subject,difficulty,daysLeft));
	            
	            sa.close();
			}
		}
		catch (IOException e) {
            System.out.println("No previous data found.");
				
	}
		return task;
}
	
	
}
