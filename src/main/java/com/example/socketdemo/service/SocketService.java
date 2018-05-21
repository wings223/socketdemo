package com.example.socketdemo.service;

import com.example.socketdemo.model.ClientSocket;
import com.example.socketdemo.model.PriceTag;
import com.example.socketdemo.model.Sku;
import com.example.socketdemo.repository.PriceTagDao;
import com.example.socketdemo.repository.SkuDao;
import com.example.socketdemo.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

@Service
public class SocketService {

    @Autowired
    private SkuDao skuDao;
    public void changeProduct(String str){
        if(str==null)return;
        String[]ss=str.split("\\|");
        if(ss.length>1){
            Socket socket= ClientSocket.getInstance().get(ss[0]);
            if(socket!=null){
                try {
                    OutputStream os=socket.getOutputStream();
                    os.write(("{"+str+"}").getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public List<Sku> listSku(){
        return skuDao.findAll();
    }
    //云端推送更新信息
    public String changeSku(String[] strs,String storeId) {
        StringBuilder strbd=new StringBuilder("{" + storeId + "|sku_push_1|req_id|");
        Socket socket = ClientSocket.getInstance().get(storeId);
        if (socket == null) return "该店铺未连接";
        for (String str : strs) {
            Sku sku = skuDao.findOne(str);
            if (sku == null) return "sku不存在";
//            String datas = "{" + storeId + "|sku_push_1|req_id|sku:|" + sku.toString() + "}";
            String d = sku.toString();
            strbd.append(d);
        }
        DataUtils.outputMannage2(socket, strbd.append("}").toString());
        return "success";
    }
}
