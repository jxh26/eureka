package com.chat.server;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServerThreadCollect {

	public static Map<String, ServerThread> map = new ConcurrentHashMap<String, ServerThread>();
	
	
	public static void addServerThread(String key, ServerThread value) {
		map.put(key, value);
	} 
	
	public static ServerThread getServerThread(String key) {
		return map.get(key);
	}

	public static String getOnLine() {
		Iterator<String> iter = map.keySet().iterator();
		String lines = "";
		while (iter.hasNext()) {
			lines += iter.next()+" ";
			
		}
		return lines;
	}
}
