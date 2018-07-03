package com.chat.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

import com.chat.common.Message;
import com.chat.common.MessageType;

public class ServerThread extends Thread {

	private Socket s;
	
	
	public ServerThread(Socket s) {
		this.s = s;
		System.out.println("===============================>>"+ServerThread.currentThread().getName());
	}

	/**
	 * @param 刚刚上线的好友
	 * @param userId
	 */
	public  void notice(String userId) {
		Map<String, ServerThread> map = ServerThreadCollect.map;
		Iterator<String> it = map.keySet().iterator();
		System.out.println("=====================================>>map"+map.toString());
		while(it.hasNext()) {
			Message message = new Message();
			message.setMesType(MessageType.message_ret_onLineFriend);
			message.setCon(userId);
			String temp = it.next().toString();
			try {
					System.out.println("======================================>>temp:"+temp+"  userId:"+userId);
					ObjectOutputStream oos = new ObjectOutputStream(ServerThreadCollect.getServerThread(temp).getS().getOutputStream());
					message.setGetter(temp);
					oos.writeObject(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		
		while(true) {
			System.out.println("=====================================>>服务线程"+this.currentThread().getName());
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message m = (Message) ois.readObject();
				
				if (m.getMesType().equals(MessageType.message_comm_mes)) {
					System.out.println(m.getSender()+"对"+m.getGetter()+"说:"+m.getCon());
					ServerThread serverThread = ServerThreadCollect.getServerThread(m.getGetter());
					ObjectOutputStream oos = new ObjectOutputStream(serverThread.getS().getOutputStream());
					oos.writeObject(m);
				//查询在线的好友
				} else if (m.getMesType().equals(MessageType.message_get_onLineFriend)) {
					String lines = ServerThreadCollect.getOnLine();
					Message obj = new Message();
					obj.setCon(lines);
					obj.setMesType(MessageType.message_ret_onLineFriend);
					obj.setGetter(m.getSender());
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(obj);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}
	
	
	
}
