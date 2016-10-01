package com.TestExercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileTest {
	static String in;
	File file;
	File f;
	public static void main(String[] args) {
		try{
			boolean check=true;
			while(check){
		                 BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
                         System.out.println("請輸入檔案path");
                         in=reader.readLine();
                         File file=new File(in);
                         if(!file.exists()){
            	                            System.out.println("檔案不存在，請從新輸入");
                         }
                         else{
                        	 check=false;
                        	 break;
                         }
            }//end while loop
		}
		catch(IOException ie){
			System.out.println(ie.toString());
		}
		File file=new File(in);
		System.out.println(file.getPath());
		System.out.println("-----------");
		for(File f:file.listFiles()){
			if (!f.isDirectory()){
			  System.out.println(f.getPath());
			  System.out.println("-----------");
			}
			else{
				for(File finn:f.listFiles()){
					System.out.println(finn.getPath());
				}
			}
		}
		File ftest=new File("D:/Mars/ArrayListMagnet.java");
		try{
		  
		  System.out.println(ftest.getPath());
		  System.out.println(ftest.getParent());
		  System.out.println(ftest.getName());
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}//close method main()

}//close class
