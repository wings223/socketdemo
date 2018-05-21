package com.example.socketdemo.utils;

import com.example.socketdemo.controller.WebSocketTest;
import com.example.socketdemo.model.ClientSocket;
import com.example.socketdemo.model.Sku;
import com.example.socketdemo.repository.SkuDao;
import com.example.socketdemo.socket.SocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;

@Service
public class DataUtils {
    @Value("${storeId}")
    private String storeId;
    public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //接收信息方法
    public  void inputMannage(Socket socket){
        try {
            InputStream in = socket.getInputStream();
            int byteLength=2*1024;
            byte[] result = new byte[byteLength];
            int dataStart = 0;
            int i = 0;
            int len;
            while (true) {

                len = in.read();

//                if (len == '{') {
//                    dataStart++;
//
//                } else if (len == '}' && dataStart > 0) {
//                    dataStart--;
//                    if (dataStart == 0) {
////                        new Thread(new AnalysisResources(socket, new String(result, 1, result.length - 1, "utf-8"))).start();
//
//                        datamanage(socket, new String(result, 1, result.length - 1, "utf-8"));
//                        result=new byte[byteLength];
//                        i=0;
//                    }
//                }
//                if (dataStart > 0) {
//                    result[i] = (byte) len;
//                    i++;
//                    if (i > byteLength) {
//                        result = new byte[byteLength];
//                        i=0;
//                        dataStart = 0;
//                    }
//                }
                if(len=='{'){
                    dataStart=1;
                }
                if(len=='}'){
                    dataStart=0;
                    i=0;
                    datamanage(socket, new String(result, 1, result.length - 1, "utf-8"));//以utf-8编码将字节数组转换为字符串
                    result=new byte[byteLength];
                }
                if(dataStart==1){
                    result[i]=(byte)len;
                    i++;
                }
            }
        }catch (IOException e){
//            e.printStackTrace();

            SocketServer.countUser--;
            System.out.println("1个客户端断开连接,剩余："+SocketServer.countUser+"个客户端");
            Map<String,Socket>map=ClientSocket.getInstance();
            for(Map.Entry<String,Socket> entry:map.entrySet()){
                if(entry.getValue()==socket){
                    map.remove(entry.getKey());
                }
            }
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }


    int xxx=0;
    //信息处理方法
    public void datamanage(Socket socket,String datas){
        String data=datas.trim();
        Set<WebSocketTest>webSocketTests= WebSocketTest.getWebSocketSet();
        String [] strs=datas.split("\\|");
        Map<String,Socket>socketMap= ClientSocket.getInstance();
        if(strs.length<2)return;
        if("shake".equals(strs[1])){
            System.out.print("握手认证==="+data+"====");
                try {
                    socket.setSoTimeout(60000);
                } catch (SocketException e) {
                    e.printStackTrace();
                }
            for(WebSocketTest w :webSocketTests){
                try {
                    w.sendMessage("握手认证==="+data+"===="+sdf.format(System.currentTimeMillis()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(!"myStore".equals(strs[0])){//判断连接的门店id是否存在
                System.out.println();
                System.out.println("认证失败:门店id不存在");
                outputMannage(socket,"{"+data+"|fail}");
                return;
            }
            socketMap.put(strs[0],socket);//握手验证成功则放入socketMap中
            System.out.println(socketMap);
            System.out.println();
            outputMannage(socket,"{"+data+"|success}");
        }
        if("sku_req_1".equals(strs[1])){
            System.out.println("商店提交绑定事件==="+data);
            for(WebSocketTest w :webSocketTests){
                try {
                    w.sendMessage("商店提交绑定事件==="+data+"===="+sdf.format(System.currentTimeMillis()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
        if("sku_push_1".equals(strs[1])){
            System.out.println("门店返回的推送结果==="+data);
            for(WebSocketTest w :webSocketTests){
                try {
                    w.sendMessage("门店返回的推送结果==="+data+"===="+sdf.format(System.currentTimeMillis()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }


    //发送信息方法
    public void outputMannage(Socket socket,String datas){
        try {
            OutputStream os=socket.getOutputStream();
            BufferedOutputStream bos=new BufferedOutputStream(os);
            bos.write(datas.getBytes());
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String outputMannage2(Socket socket,String datas){
        try {
            OutputStream os=socket.getOutputStream();
            os.write(datas.getBytes());
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
