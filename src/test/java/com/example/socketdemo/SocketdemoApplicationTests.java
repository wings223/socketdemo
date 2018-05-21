package com.example.socketdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocketdemoApplicationTests {

	@Test
	public void contextLoads() {
//		Client client=new Client();
//		client.connSocket(8088);
		Socket socket=null;
		try {
			socket=new Socket("localhost",8088);
			OutputStream outputStream=socket.getOutputStream();
			String message="你好  yiwangzhibujian";
			Scanner scanner=new Scanner(System.in);

			// 建立连接后获得输出流
			outputStream.write(message.getBytes("UTF-8"));
			while(true){
				message=scanner.nextLine();
				outputStream.write(message.getBytes("UTF-8"));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
/*
	public static void main(String[]args){
		Socket socket=null;
		try {
			socket=new Socket("localhost",8088);
			String message="你好  yiwangzhibujian";
			Scanner scanner=new Scanner(System.in);
			OutputStream out = socket.getOutputStream();
			BufferedOutputStream bos=new BufferedOutputStream(out);
			//OutputStreamWriter osw = new OutputStreamWriter(out, true);
//			OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
//			PrintWriter pw = new PrintWriter(osw, true);
			// 建立连接后获得输出流
			bos.write(message.getBytes("utf-8"));
			bos.flush();
//			pw.println(message);

			while(true){
				message=scanner.nextLine()+"\n";
//				pw.println(message);
				bos.write(message.getBytes("utf-8"));
//				osw.write(message);
				bos.flush();
				System.out.println(message);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	*/

//	public static void main(String[]args){
//		char a='{';
//		byte b=97;
//		System.out.println((int)a);
//		System.out.println((char)b);
//	}

	public static void main(String[]args){
		char a='{';
		byte b=97;
		String str="{sdfa}";
		byte[]bytes=str.getBytes();
		System.out.println(bytes[0]);
		System.out.println((char)b);
	}
}
