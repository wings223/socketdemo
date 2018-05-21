package com.example.socketdemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class test {

    public static void main(String[]args){
        Socket socket=null;
        OutputStream os=null;
        try {
            socket=new Socket("localhost",8081);
            os=socket.getOutputStream();
            String str="{s|d|f|a|b}";
            byte[]bytes=str.getBytes();
            os.flush();
            os.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
