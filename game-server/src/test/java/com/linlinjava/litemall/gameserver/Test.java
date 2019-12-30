package com.linlinjava.litemall.gameserver;

import cn.hutool.core.lang.Console;
import org.linlinjava.litemall.gameserver.util.ByteUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Test {

    public static void main(String[] args) throws IOException {
        String server = "coolwendao.xicp.io";
        // 将传送数据转化为字节数组
        int servPort = 45125;
        // 根据参数创建 Socket 实例
        Socket socket = new Socket(server, servPort);
        // 获取 socket 的输入输出流
        OutputStream out = socket.getOutputStream();


//        // 将数据写入到 Socket 的输出流中，并发送数据
//
//        ThreadUtil.execute(()->{
//            while (true) {
//                try {
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });



        InputStream inputStream = socket.getInputStream();//获取一个输入流，接收服务端的信息
        while (true) {
            byte[] body = new byte[8094];
            int len = inputStream.read(body);
            Console.log("接收的数据：{}", ByteUtil.bytesToHexString(body));
            Console.log("接受的内容为：{}" , new String(body));
        }

    }
}
