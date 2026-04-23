package com.studyplanner;

import java.util.ArrayList;
import java.util.*;

public class Planner {

	public void sorttask(ArrayList<Task>task)
	{
		Collections.sort(task,(a,b)->
		{
			int p1= a.difficulty_level*2+(10-a.days_left);
			int p2= b.difficulty_level*2+(10-b.days_left);
			return p2-p1;
					
		});
	}
	public void generateplan (ArrayList<Task>task)
	{
		System.out.println(" --- Study Plan ---");
		
		for(Task t:task)
		{
			int hours= t.difficulty_level*2;
			
			if(t.days_left<3)//this is panic mode more hours for study are required
			{
				hours=+2;
			}
			System.out.println(t.subject+ " -> "+ hours+" Hours");
			
		}
	}

}
