package com.hernan.main;

import java.util.Date;

import java.util.Timer;
 
import java.util.TimerTask;
 
public class EjecutorTarea { 
 
    long delay = 600000; // delay in milliseconds
    LoopTask task = new LoopTask();
    Timer timer = new Timer("TaskName");
    CambioApp app=new CambioApp();
 
    public void start() { 
        timer.cancel();
        timer = new Timer("TaskName");
        Date executionDate = new Date(); // no params = now
        timer.scheduleAtFixedRate(task, executionDate, delay);
    } 
 
    private class LoopTask extends TimerTask {
        public void run() { 
        	try {
				app.AppCambioMonedas();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("This message will print every 10 minutes.");
        } 
    } 
 
    public static void main(String[] args) {
    	EjecutorTarea executingTask = new EjecutorTarea();
        executingTask.start();
    } 
 
 
} 