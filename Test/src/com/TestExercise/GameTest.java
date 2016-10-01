package com.TestExercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameTest extends JFrame{
	public GameTest(){
		setLayout(new BorderLayout());
        add(BorderLayout.CENTER,new GameView());
        
        setSize(640,480);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//close construstor GameTest
	private class GameView extends JPanel{
		private Timer timer;
		private LinkedList<Ball> balls;
		GameView(){
			balls=new LinkedList<>();
			timer=new Timer();
			timer.schedule(new TimerTask(){
				@Override
				public void run() {
					repaint();
				}//close method run
			},0,40);
			addMouseListener(new MyMouse());
		}//close constructor GameView
		
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2d=(Graphics2D) g;
			g2d.setColor(new Color(0,150,200));
			for(Ball ball:balls){
				g2d.fillOval(ball.x-15,ball.y-15,30,30);
			}
		}//close method paintComponent
		
		class MyMouse extends MouseAdapter{
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Ball ball=new Ball(e.getX(),e.getY());
				timer.schedule(ball,1000,60 );
				balls.add(ball);
			}//close method mouseClicked
		}//close inner class MyMouse of inner class GameView
		
		class Ball extends TimerTask{
			int x,y,dx,dy;
			
			Ball(int x,int y){
				dx=dy=4;
				this.x=x;
				this.y=y;
			}//close construcstor Ball
			@Override
			public void run() {
				if(x-15<0||x+15>getWidth()){
					dx*=-1;
				}
				if(y-15<0||y+15>getHeight()){
					dy*=-1;
				}
				x+=dx;
				y+=dy;
			}//close method run
		}//close inner class Ball of inner class GameView
	}//close inner class GameView
	
	public static void main(String[] args) {
		new GameTest();
	}//close method main()

}//close class GameTest
