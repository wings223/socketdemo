package com.example.socketdemo;

import com.example.socketdemo.socket.SocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocketdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SocketdemoApplication.class, args);
		SocketServer.startSocket(8081);
	}
}
