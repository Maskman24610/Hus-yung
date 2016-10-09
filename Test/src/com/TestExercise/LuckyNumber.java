package com.TestExercise;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;


public class LuckyNumber extends JFrame implements ActionListener{
	
	private static final long serialVersionUID=4276832367310733568L;
	private JLabel label;
	private JButton cancel;
	private JButton start;
	private JTextField textField;
	private SwingWorker worker;
	
	public LuckyNumber(){
	  JPanel panel=new JPanel();
	  panel.setLayout(new GridLayout(2,1));
	  
	  JPanel buttons=new JPanel(new FlowLayout());
	  start=new JButton("Start");
	  start.addActionListener(this);
	  start.setDefaultCapable(true);
	  buttons.add(start);
	  cancel=new JButton("Cancel");
	  cancel.setEnabled(false);
	  cancel.addActionListener(this);
	  buttons.add(cancel);
	  panel.add(buttons);
	  
	  ImageIcon image=new ImageIcon(getClass().getClassLoader().
			  getResource("swing/demo/images/spinner.gif"));
	  
	  label=new JLabel(image);
	  JPanel answer=new JPanel(new GridLayout(1,2));
	  textField=new JTextField("");
	  answer.add(textField);
	  answer.add(label);
	  label.setVisible(false);
	  panel.add(answer);
	  
	  setTitle("Lucky Number generator");
	  setPreferredSize(new Dimension(300,100));
	  getContentPane().setLayout(new BorderLayout());
	  getContentPane().add(panel);
	}//close constructors
	
    
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				LuckyNumber luckyNumber=new LuckyNumber();
				luckyNumber.pack();
				luckyNumber.setVisible(true);
				luckyNumber.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			}//close method run
		});//close class Runnable  
	}//close method main()
	
	public void actionPerformed( ActionEvent a){
	  if(a.getSource()==start){
			  start.setEnabled(false);
			  textField.setText("");
			  worker=new NumberWorker();
			  worker.execute();
			  label.setVisible(true);
			  cancel.setEnabled(true);
	  }
	  else if(a.getSource()==cancel){
		  cancel();
	  }
	}//close method actionPerformed
		
	@Override
	public void dispose(){
		cancel();
		super.dispose();
	}//close method dispose
    
	public void cancel(){
		start.setEnabled(true);
		label.setVisible(false);
		cancel.setEnabled(false);
		if(worker!=null){
			worker.cancel(true);
			worker=null;
		}
	}//close method cancel
	
	private class NumberWorker extends SwingWorker{
		private Random r=new Random();
		
		@Override
		protected  String doInBackground() throws Exception{
			long s=System.currentTimeMillis();
			while(System.currentTimeMillis()-s<5000&&!Thread.currentThread().isInterrupted()){
				r.nextInt();
			}//end while loop
			return String.valueOf(r.nextInt(10)+1);
		}//close method doInBackground
		
		@Override
		protected void done(){
			try{
				textField.setText(get());
				LuckyNumber.this.worker=null;
				LuckyNumber.this.cancel();
			}
			catch(Exception ignore){
			}
		}
	}//close inner class NumberWorker
}//close class LuckyNumber
