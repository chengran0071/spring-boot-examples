package com.wxblockchain.com.learning.iolearning.server;


import io.netty.channel.ChannelHandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler {
    private static final int MAX_DATA_LEN = 1024;

    private  final Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    public void start(){
        System.out.println("新客户端接入");

        /**
         * 二、clientHandler 开启线程，为了读写客户端的数据
         *  对应netty的：
         * @see io.netty.channel.nio.NioEventLoop
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    private void doStart(){
        try {
            InputStream inputStream  = socket.getInputStream();
            /**
             * netty使用
             * @see io.netty.channel.nio.NioEventLoop#pollScheduledTask(long)
             */
            while(true){
                byte[] data = new byte[MAX_DATA_LEN];

                int len ;
                //利用io读写将数据写入socket
                //客户端与服务端通信时，可能会自定义一个二进制协议，首先要进行拆包，解析成一个自定义的java对象
                //netty使用channel进行处理，每个数据包对应一个分包器，用户可以使用一个channel
                //pipeLine 底层是一系列的ChanelHandle
                /**
                 *
                 * @see io.netty.channel.AbstractChannel
                 * @see io.netty.channel.DefaultChannelPipeline#addAfter(String, String, ChannelHandler) 
                 */
                while ((len = inputStream.read(data)) != -1){
                    String message = new String(data, 0, len);
                    System.out.println("客户端传来的消息：" + message);
                    socket.getOutputStream().write(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
