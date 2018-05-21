package com.example.socketdemo.controller;

import com.example.socketdemo.model.ClientSocket;
import com.example.socketdemo.model.Sku;
import com.example.socketdemo.repository.SkuDao;
import com.example.socketdemo.service.SocketService;
import com.example.socketdemo.socket.SocketServer;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class SocketController {

    @Autowired
    private SocketService socketService;

    @RequestMapping("/socket")
    public String socket(Model model){
        model.addAttribute("skus",socketService.listSku());
        ClientSocket.getInstance();
        return "socket";
    }
    @RequestMapping(value = "/change")
    @ResponseBody
    public String changeProduct(@RequestParam(value="strs[]") String [] strs,String storeId){
            String msg=socketService.changeSku(strs,storeId);

        return msg;
    }

    @RequestMapping("/sku")
    @ResponseBody
    public List<Sku> listUser(){
        return socketService.listSku();
    }


    @Autowired
    SkuDao skuDao;
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        Sku sku=skuDao.findOne("AAA");
        return null;
    }
@RequestMapping("/websocket")
    public String websocket(){
        return "websocket";
}
}
