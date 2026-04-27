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
			//here more priority is given to difficulty level 
			//highest difficulty level subject require more time for study
					
		});
	}
	public void generateplan(ArrayList<Task> task)
	{
	    System.out.println(" --- Study Plan ---");

	    for(Task t : task)
	    {
	        int days = t.days_left == 0 ? 1 : t.days_left;

	        double totalEffort = t.difficulty_level * 30;

	        double urgencyFactor = (double)(10 - days) / 10;

	        double hours = (totalEffort / days) + (urgencyFactor * 2);

	        hours = Math.max(1.5, Math.min(hours, 8));

	        System.out.println(t.subject + " -> " + String.format("%.1f", hours) + " Hours");
	    }
	}

}
