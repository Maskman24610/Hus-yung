package com.TestExercise;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;

public class CalculatorMechTest {
  JFrame frame;
  JPanel panel;
  JTextField textField;
  String[] num;
  public static void main(String[] args) {
     CalculatorMechTest cal=new CalculatorMechTest();
     cal.gui();
  }//close method main()

  void gui(){
	frame=new JFrame("CalculatorMechine");
	textField=new JTextField(20);
	GridLayout gl=new GridLayout(4,4);
	gl.setVgap(3);
	gl.setHgap(3);
	panel=new JPanel(gl);
//	String[] num={"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
//	for(int i=0;i<num.length;i++){
//	    JButton button=new JButton(num[i]);
//	    panel.add(button);
//	}//end for loop
	go();
	frame.getContentPane().add(BorderLayout.NORTH,textField);
	frame.getContentPane().add(BorderLayout.CENTER,panel);
	frame.setSize(300,400);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.setVisible(true);
  }//close method gui()
  
 void go(){
   String[] num={"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
	 try{
	 for(int i=0;i<num.length;i++){
	    JButton button=new JButton(num[i]);
	    panel.add(button);
	 }//end for loop
	 }
	 catch(Exception e){go();}
 }//close method go()
}//close class
