package com.chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.chat.common.Message;
import com.chat.common.User;

public class Server {
	
	
	
	public Server() {
		try {
			ServerSocket ss = new ServerSocket(10000);
			while(true) {
				System.out.println("===============================>>服务开启；");
				Socket s = ss.accept();
				
				
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User user  = (User) ois.readObject();
				ObjectOutputStream oos =  new ObjectOutputStream(s.getOutputStream());
				Message message = new Message();
				if (user.getPasswd().equals("123123")) {
					System.out.println("===============================>>"+user.getUserId()+"  "+user.getPasswd()+"来到了服务端登记了；");
					message.setMesType("1");
					oos.writeObject(message);
					ServerThread serverThread = new ServerThread(s);
					ServerThreadCollect.addServerThread(user.getUserId(), serverThread);
					serverThread.start();
					//通知我在线的好友，我上线了
					serverThread.notice(user.getUserId());
				} else {
					message.setMesType("2");
					oos.writeObject(message);
					s.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
