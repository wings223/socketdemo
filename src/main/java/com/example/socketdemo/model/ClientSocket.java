package com.example.socketdemo.model;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientSocket {
    private static Map<String,Socket> socketMap;
    private ClientSocket(){}
    public static Map<String,Socket> getInstance(){
        if(socketMap==null){
            socketMap = new HashMap<String, Socket>();

        }
        return socketMap;
    }
    public static void delete(){
        socketMap=null;
    }
}
