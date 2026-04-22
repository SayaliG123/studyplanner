package com.studyplanner;

public class Task {

	String subject;
	int difficulty_level;
	int days_left;
	
	public Task (String subject,int difficulty_level,int days_left )
	{
		this.subject=subject;
		this.difficulty_level=difficulty_level;
		this.days_left=days_left;
	}
	public String toString()
	{
		return " subject: "+subject +"| difficulty level: " + difficulty_level+"|days left: "+days_left;
	}
	

}
