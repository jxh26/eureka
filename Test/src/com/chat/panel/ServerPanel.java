package com.chat.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.chat.server.Server;

public class ServerPanel extends JFrame implements ActionListener {
	
	JPanel jp;
	JButton jb1,jb2;
	public static void main(String[] args) {
		ServerPanel panel = new ServerPanel();
	}
	public ServerPanel() {
		jp = new JPanel();
		jb1 = new JButton("启动");
		jb1.addActionListener(this);
		jb2 = new JButton("停止");
		jb2.addActionListener(this);
		jp.add(jb1);
		jp.add(jb2);
		
		this.add(jp);
		this.setSize(186,168);
		this.setLocation(300, 300);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			//开启服务
			new Server();
		}else if (e.getSource() == jb2) {
			//停止服务
			System.exit(0);
		}
	}

}
