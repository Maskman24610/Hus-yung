package com.TestExercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LoopTest {
     static int n;
     static final double CONS_A=(1+Math.sqrt(5))/2;
     static final double CONS_B=(1-Math.sqrt(5))/2;
     static final double CONS_C=Math.sqrt(5)/5;
     double v1=0;
     int v2=0;
	public static void main(String[] args) {
		LoopTest loop=new LoopTest();
		try{
		  boolean isOK=true;
		  while(isOK){
		    System.out.println("請輸入想知道費波納西數列項數 n");
		    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            n=Integer.parseInt(reader.readLine());
            if(n<=0){
        	     System.out.println("項數是大於零的，請重新輸入");
            }
            else{
            	isOK=false;
            	break;
            }
            
		  }//end while loop
		  long crt_time=System.currentTimeMillis();
		  System.out.println("第 "+n+" 項為:"+loop.febo(n));
		  long febotime=System.currentTimeMillis()-crt_time;
		  System.out.println(febotime);
          System.out.println("-------------------");
//          double crt_time2=System.currentTimeMillis();
//          System.out.println("第 "+n+" 項為:"+loop.febo2(n));
//          double febotime2=System.currentTimeMillis()-crt_time2;
//          System.out.println(febotime2);
		}  
		catch(IOException e){
			System.out.println(e.toString());
		}
		
	}
  private  int febo(int n){      //遞迴解
	  if(n==1||n==2){
		return 1;
	  }
	  else{
		  return febo(n-1)+febo(n-2);
	  }
  }//close method int febo(int n)
  private  int febo2(int n){           //公式解
	  if(n>0){
	    v1= CONS_C*(Math.pow(CONS_A, n)-Math.pow(CONS_B,n));
	    v2=(int) v1;
	  }
	  return v2;
  }//close method int febe2()
}//close class
