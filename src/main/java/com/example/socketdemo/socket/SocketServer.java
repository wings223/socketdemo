package com.example.socketdemo.socket;

import com.example.socketdemo.model.ClientSocket;
import com.example.socketdemo.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
@Component
public class SocketServer {
 public static int countUser=0;

    public static void startSocket(int port){
        // 监听指定的端口

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Socket>socketMap= ClientSocket.getInstance();
        while (true) {

                System.out.println("等待客户端连接。。。");
                //方法会产生阻塞，直到某个Socket连接，返回请求连接的Socket8


            Socket socket = null;
            try {
                socket = server.accept();
                System.out.println(++countUser+"个客户端已连接！");
                socket.setSoTimeout(5000);
                new Thread(new SocketRunnable(socket)).start();
                System.out.println(socket.getInetAddress());

            } catch (IOException e) {
                e.printStackTrace();

            }




        }

    }


    //接收信息处理

    //发送信息处理











}
class SocketRunnable implements Runnable{
    private Socket newSocket;
    public SocketRunnable(Socket socket){
        this.newSocket=socket;
    }

    @Override
    public void run() {
            new DataUtils().inputMannage(newSocket);

    }
}
