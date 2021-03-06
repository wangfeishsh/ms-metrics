package com.bao.msmetrics.util;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by nannan on 2018/3/1.
 */
public class TcpSend {
    //client程序
    public static void main(String[] args) {
        try {
            Socket s = new Socket();
            s.setSoLinger(true,0);//设置调用close就发送RST
            s.connect(new InetSocketAddress("127.0.0.1",3113));

            OutputStream os = s.getOutputStream();
            os.write("hello".getBytes());

            s.close();

            System.in.read();//防止程序退出
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
