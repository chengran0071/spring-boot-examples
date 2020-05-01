package com.wxblockchain.com.learning.iolearning.server;

import io.netty.channel.nio.NioEventLoop;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    public Server(int port){
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功，端口：" + port);
        } catch (IOException e) {
            System.out.println("服务端启动失败");
        }
    }

    /**
     * 服务端启动方法
     */
    public void start(){
        /**
         * 一、开启线程，子线程不会阻塞主线程的运行
         * @see NioEventLoop#run()
         */

        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    private void doStart(){
        while(true){
            try {
                /**
                 * @see NioEventLoop#select(boolean) 
                 */
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
