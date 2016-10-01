package com.TestExercise;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {

	public static void main(String[] args) {
		while(true){
		try{
            ServerSocket server=new ServerSocket(5678);
            Socket socket=server.accept();
            InputStream in=socket.getInputStream();
            int c;
            StringBuffer sb=new StringBuffer();
            while((c=in.read())!=-1){
            	sb.append((char)c);
            }
            socket.close();
            server.close();
            System.out.print(sb);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
	}

}
