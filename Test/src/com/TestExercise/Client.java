package com.TestExercise;

import java.net.Socket;
import java.io.OutputStream;

public class Client {

	public static void main(String[] args) {
		while(true){
		try{
		    Socket socket=new Socket("127.0.0.1",5678);
		    OutputStream ops=socket.getOutputStream();
		    ops.write("Mingying,I love you\n".getBytes());
		    ops.flush();
		    ops.close();
		    socket.close();
		}
		catch(Exception e){
			e.toString();
		}
		}
	}

}
