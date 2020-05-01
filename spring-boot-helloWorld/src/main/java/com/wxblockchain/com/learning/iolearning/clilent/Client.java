package com.wxblockchain.com.learning.iolearning.clilent;

import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.nio.AbstractNioMessageChannel;

import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.util.List;

public class Client {
    private static final String HOST = "127.0.0.1";
    private static final int  PORT = 8000;
    private static final int SLEEP_TIME = 5000;

    public static void main(String[] args) throws Exception{
        final Socket socket = new Socket(HOST,PORT);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("客户端启动成功！");
                while(true){
                    try {
                        String message = "hello world!";
                        System.out.println("客户端发送数据："+ message);
                        /**
                         * 客户端拿到输出流
                         *  netty里的逻辑：
                         * @see io.netty.channel.nio.NioEventLoop#select(boolean)
                         * @see io.netty.channel.nio.NioEventLoop#processSelectedKey(SelectionKey, AbstractNioChannel)
                         * @see AbstractNioMessageChannel.NioMessageUnsafe#read()
                         * @see io.netty.channel.socket.nio.NioServerSocketChannel#doReadMessages(List) 
                         *
                         */
                        socket.getOutputStream().write(message.getBytes());
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        System.out.println("写数据错误");
                    }
                }
            }
        }).start();
    }

}
