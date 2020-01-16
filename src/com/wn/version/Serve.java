package com.wn.version;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Serve {
	public static void main(String[] args) throws Exception {

		ServerSocket se = new ServerSocket(9998);
		// 监听那个客户端在发起连接，监听到后，会返回一个socket对象，负责和发起连接的客户端通信
		Socket sc = se.accept();
		InputStream ins = sc.getInputStream();
		// ObjectInputStream ready = new ObjectInputStream(ins);
		DataInputStream ready = new DataInputStream(ins);
		OutputStream os = sc.getOutputStream();
		// ObjectOutputStream write = new ObjectOutputStream(os);
		DataOutputStream write = new DataOutputStream(os);

		Scanner input = new Scanner(System.in);
		while (true) {

			String acceptInfo = ready.readUTF();
			// System.out.println("[" + acceptInfo.getSender() + "]:" +sf
			// acceptInfo.getMessage());
			System.out.println(acceptInfo);

			System.out.println("请输入发送给0707的信息");

		
				String info = input.next();
		
			
			if (info.equals("bye")) {
				break;
			}
			write.writeUTF(info);
			write.flush();
			os.flush();

		}
		write.close();
		os.close();
		ready.close();
		ins.close();
		sc.close();
		se.close();
	}
}
