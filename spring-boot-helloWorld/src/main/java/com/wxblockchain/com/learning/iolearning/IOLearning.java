package com.wxblockchain.com.learning.iolearning;

import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Objects;

public class IOLearning {


    public static void main(String[] args) throws Exception {
//        ImageToBase64("C:\\Users\\iacrf\\Desktop\\wx-work\\个人笔记\\images\\01.jpg");
        /**1.字节、字符流输入输出*/
        fileInputStreamLearn();
        buffReadInputStream();

        /**2.socket编程*/

    }

     private static void fileInputStreamLearn() throws Exception{
        //1.创建文件输入流对象
         InputStream in = new FileInputStream("C:\\Users\\iacrf\\Downloads\\logs-from-chicagothirdapi-in-chicagothirdapi-75fb8dfb48-zkn56.txt");
        //2.创建一个字节数组用来存放读取到的数据
         byte[] buf = new byte[10];
         //2.通过输入流对象读取数据
         in.read(buf);
         //4.将字节数组转为字符串关闭
         String str = new String(buf);
         System.out.println(str);
         //5.关闭流
         in.close();
    }


    private static void buffReadInputStream() throws  Exception{
        //1.创建一个字节输入流对象
        File file = new File("d:/b.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        InputStream in = new FileInputStream("d:/b.txt");

        //2.对输入流对象进行封装
        BufferedInputStream bin = new BufferedInputStream(in);

        byte[] buf = new byte[10];
        java.lang.String str = "";
        while(bin.read(buf) != -1){

            str += new java.lang.String(buf);
        }
        System.out.println(str);
        bin.close();
        in.close();
    }


    /**
     * 本地图片转换Base64的方法
     *
     * @param imgPath     
     */

    private static void ImageToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            //1.使用字节流，读取文件
            InputStream in = new FileInputStream(imgPath);
            //2.将字节流数组大小赋给要读的数据
            data = new byte[in.available()];
            //3.使用read方法，读取数据
            in.read(data);
            in.close();
        } catch (IOException e) {

        }
        // 4.对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 5.返回Base64编码过的字节数组字符串
        System.out.println( encoder.encode(Objects.requireNonNull(data)));
    }
}
