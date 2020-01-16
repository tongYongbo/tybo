package com.wn.version;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cinet {
	public static void main(String[] args) throws Exception {
		Socket sc = new Socket("localhost", 9998);

		OutputStream os = sc.getOutputStream();
		ObjectOutputStream write = new ObjectOutputStream(os);

		InputStream ins = sc.getInputStream();
		ObjectInputStream ready = new ObjectInputStream(ins);

		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("请输入发送给0101的信息");
			String message = input.next();
			Info sendInfo = new Info("0707", message);

			if (message.equals("bye")) {
				break;
			}
			write.writeObject(sendInfo);
			write.flush();
			os.flush();
			Info acceptInfo = (Info) ready.readObject();
			System.out.println("[" + acceptInfo.getSender() + "]:" + acceptInfo.getMessage());
		}

		ins.close();
		ready.close();
		write.close();
		os.close();
		sc.close();

	}

}
