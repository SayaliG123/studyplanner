package com.studyplanner;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> task;

        filehandler sa = new filehandler();
        Planner planner = new Planner();

        task = sa.loadtask();

        System.out.println("Enter no. of subjects:");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++)
        {
            sc.nextLine();

            System.out.println("Subject name:");
            String sub = sc.nextLine();

            System.out.println("Difficulty level (1-5):");
            int difficulty_level = sc.nextInt();

            System.out.println("Days left:");
            int days_left = sc.nextInt();

            task.add(new Task(sub, difficulty_level, days_left));
        }

        planner.sorttask(task);
        planner.generateplan(task);

        sa.savetasks(task);

        sc.close();
    }
}