package com.TestExercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.*;

public class SwingTest extends JFrame{
    public SwingTest(){
    	setSize(450,450);
    	//JPanel panel=new JPanel();
    	DrawPanel drawPanel=new DrawPanel();
    	//panel.setBackground(new Color(0,100,100));
    	getContentPane().add(BorderLayout.CENTER,drawPanel);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//close constructor
    
	public static void main(String[] args) {
		SwingTest frame=new SwingTest();
		
	}

}//close class SwingTest

class DrawPanel extends JPanel{
	Calendar calendar=Calendar.getInstance();
	//calendar.setTimeMillis(1000);
	int hour;
	int minute;
	int second;
  DrawPanel(){
	  //setBackground(Color.black);
	  Timer clockTimer=new Timer(1000,new ActionListener(){
		 public void actionPerformed(ActionEvent ae){
			 upTimer();
		 } 
	  });
	  clockTimer.start();
  }
  public void paintComponent(Graphics g){
	super.paintComponent(g);
	g.setColor(new Color(0,225,250));
    int cx=(this.getWidth())/2;
	int cy=(this.getHeight())/2;
	int r=Math.min(cx, cy);
	g.fillOval(cx-3,cy-3,6,6);
	g.drawOval(cx-r,cy-r,2*r,2*r);
	g.drawOval(cx-(r-25),cy-(r-25),2*(r-25),2*(r-25));
	String[] numbers={"1","2","3","4","5","6","7","8"
			,"9","10","11","12","."};
	double pi=Math.PI;
	for(int i=1;i<61;i++){
	  int s=90-6*i;
	  double ang=Math.toRadians(s);
	  int rst=r-15;
	  int dx=(int) (rst*Math.cos(ang));
	  int x=cx+dx;
	  int dy=(int) (rst*Math.sin(ang));
	  int y=cy-dy;
	  if(s%30==0){
	    g.drawString(numbers[(i/5)-1],x,y);
	  }
	  else{
		  g.drawString(numbers[12],x,y);
	  }
	}//end for loop
	second=calendar.get(Calendar.SECOND);
	minute=calendar.get(Calendar.MINUTE);
	hour=calendar.get(Calendar.HOUR_OF_DAY);
	//畫秒針
	int rse=r-20;
	int rss=25;
	double dxse= (rse*Math.cos(Math.toRadians(90-second*6)));
	double dxss=(int) (rss*Math.cos(Math.toRadians(-90-second*6)));
    double dyse= (int )(rse*Math.sin(Math.toRadians(90-second*6)));
	double dyss=(int) (rss*Math.sin(Math.toRadians(-90-second*6)));
	g.drawLine((int)(cx+dxss),(int)(cy-dyss),(int)(cx+dxse),(int)(cy-dyse));
	//畫分針
	g.setColor(new Color(100,0,200));
	int rm=r-30;
	double dxm=(rm*Math.cos(Math.toRadians(90-minute*6-second*6/60)));
	double dym=(rm*Math.sin(Math.toRadians(90-minute*6-second*6/60)));
	g.drawLine(cx,cy,(int)(cx+dxm),(int)(cy-dym));
	//畫時針
	g.setColor(new Color(150,100,200));
	int rh=r/10*6;
	double dxh=(rh*Math.cos(Math.toRadians(90-hour*30-minute*30/60)));
	double dyh=(rh*Math.sin(Math.toRadians(90-hour*30-minute*30/60)));
	g.drawLine(cx,cy,(int)(cx+dxh),(int)(cy-dyh));
  }//close method paintComponent
  public void upTimer(){
	calendar.setTimeInMillis(System.currentTimeMillis());
	repaint();
  }//close method upTimer
}//close class DrawPanel
