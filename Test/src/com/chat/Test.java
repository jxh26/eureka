package com.chat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * java实现爬虫
 */
public class Test {
    public static void main(String[] args) {
    	Map<String,String> map = new HashMap<String, String>();
    	map.put(1+"", 1+"");
    	map.put(2+"", 2+"");
    	map.put(3+"", 3+"");
    	map.put(4+"", 4+"");
    	Iterator<String> iterator = map.keySet().iterator();
    	while(iterator.hasNext()) {
    		System.out.println(iterator.next()+"&&"+iterator.next()+"&&"+iterator.next()+"&&"+iterator.next());
    		System.out.println("");//上升趋势
    	}
    }
}

