package com.hm.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.hm.common.Message;

public class MyThread extends Thread {

	private Socket s;
	
	
	public MyThread(Socket s) {
		this.s = s;
	}

	public void notice() {
		
	}

	@Override
	public void run() {
		
		while(true) {
			
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message m = (Message) ois.readObject();
				System.out.println(m.getSender()+"给"+m.getGetter()+"说"+m.getCon());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
