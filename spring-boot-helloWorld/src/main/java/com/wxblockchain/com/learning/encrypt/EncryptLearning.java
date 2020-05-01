package com.wxblockchain.com.learning.encrypt;

import org.springframework.util.Base64Utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

/**
 * @createDate 2020-02-03
 * @description 加解密学习
 */
public class EncryptLearning {
    /*rsa 的公钥*/
    private static RSAPublicKey rsaPublicKey;
    /*rsa 的私钥*/
    private static RSAPrivateKey rsaPrivateKey;

    public static void main(String[] args) throws Exception{
        //1.明文：原始信息
        String plainText = "chengran";
        String key = "12345678";
        /**
         * 加密算法
         * 对称加密：DES(8)/AES(16)
         * 非对称加密：RSA
         */
        String encMethod = "DES";
        //2.加密：
        String encrypt = encrypt(encMethod, plainText, key);
        //3.解密：
        decrypt(encMethod,encrypt,key);

        //1.现有多种加密算法，算法名称不同（DES/AES/RSA）；
        //2.根据算法名称获取cipher实例；
        //3.根据算法名称获取对应的key值，其中对称加密使用同一把key，非兑成加密需要生成公私钥对，另外对称加密的key长度也不一样
        //4.cipher的init方法可以定义加密还是解密；
        //5.加密参数处理：明文的字节数组；       加密结果处理：base64编码处理后，生成string字符串输出；
        //6.解密参数处理：对密文base64解码处理； 解密结果处理：生成对应字节码的字符串输出；
        String cipher = encrypt(encMethod, plainText, key);
        decrypt(encMethod,cipher,key);
    }


  /**
     * 加密
     */
    private static String encrypt(String encMethod, String plainText,String key) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        //1.获取加密算法工具类对象
        Cipher cipher = Cipher.getInstance(encMethod);
        //2.对工具类对象进行初始化
        //mode:加密/解密模式
        //key:对原始密钥处理后的密钥
        SecretKeySpec secretKeySpec = getKey(key,encMethod);
        if ("rsa".equalsIgnoreCase(encMethod)){
            cipher.init(Cipher.ENCRYPT_MODE,rsaPublicKey);
        }else{
            cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
        }
        //3.用加密工具类
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        String encryptResult = new String(Base64Utils.encode(cipherText));
        System.out.println(plainText + "使用"+ encMethod +"加密之后的密文：" + encryptResult);
        return encryptResult;
    }

    /**
     * 解密
     */
    private static String decrypt(String decMethod, String cipherText,String key) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException {
        //1.获取加密算法工具类对象
        Cipher cipher = Cipher.getInstance(decMethod);
        //2.对工具类对象进行初始化
        //mode:加密/解密模式
        //key:对原始密钥处理后的密钥
        if ("rsa".equalsIgnoreCase(decMethod)){
            cipher.init(Cipher.DECRYPT_MODE,rsaPrivateKey);
        }else {
            SecretKeySpec secretKeySpec = getKey(key, decMethod);
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
        }
        //3.用加密工具类
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText.getBytes()));
        String decryptResult = new String(plainText, "GB2312");
        System.out.println(cipherText + "使用"+decMethod+"解密之后的明文：" + decryptResult);
        return decryptResult;
    }

    /**
     * des加密算法
     */
    private static String  desEncrypt(String plainText,String priKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //1.获取加密算法工具类对象
        Cipher cipher = Cipher.getInstance("DES");
        //2.对工具类对象进行初始化
        //mode:加密/解密模式
        //key:对原始密钥处理后的密钥
        SecretKeySpec key = getKey(priKey,"DES");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        //3.用加密工具类
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        String encryptResult = new String(Base64Utils.encode(cipherText));
        System.out.println(plainText + "使用DES加密之后的密文：" + encryptResult);
        return encryptResult;
    }

    /**
     * des解密算法
     */
    private static String  desDecrypt(String cipherText,String priKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        //1.获取加密算法工具类对象
        Cipher cipher = Cipher.getInstance("DES");
        //2.对工具类对象进行初始化
        //mode:加密/解密模式
        //key:对原始密钥处理后的密钥
        SecretKeySpec key = getKey(priKey,"DES");

        cipher.init(Cipher.DECRYPT_MODE,key);
        //3.用加密工具类
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText.getBytes()));
        String decryptResult = new String(plainText, "GB2312");
        System.out.println(cipherText + "使用DES解密之后的明文：" + decryptResult);
        return decryptResult;
    }

    /**
     * des加密算法
     */
    private static String  aesEncrypt(String plainText,String priKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //1.获取加密算法工具类对象
        Cipher cipher = Cipher.getInstance("AES");
        //2.对工具类对象进行初始化
        //mode:加密/解密模式
        //key:对原始密钥处理后的密钥
        SecretKeySpec key = getKey(priKey,"AES");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        //3.用加密工具类
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        String encryptResult = new String(Base64Utils.encode(cipherText));
        System.out.println(plainText + "使用AES加密之后的密文：" + encryptResult);
        return encryptResult;
    }

    /**
     * aes解密算法
     */
    private static String  aesDecrypt(String cipherText,String priKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        //1.获取加密算法工具类对象
        Cipher cipher = Cipher.getInstance("AES");
        //2.对工具类对象进行初始化
        //mode:加密/解密模式
        //key:对原始密钥处理后的密钥
        SecretKeySpec key = getKey(priKey,"AES");

        cipher.init(Cipher.DECRYPT_MODE,key);
        //3.用加密工具类
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText.getBytes()));
        String decryptResult = new String(plainText,"GB2312");
        System.out.println(cipherText + "使用AES解密之后的密文：" + decryptResult);
        return decryptResult;
    }

    /**
     * rsa加密算法
     */
    private static String  rsaEncrypt(String plainText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //1.获取加密算法工具类对象
        Cipher cipher = Cipher.getInstance("RSA");
        //2.获取公私钥，存储到静态变量中
        getPubAndPrivKey();
        //3.对工具类对象进行初始化
        cipher.init(Cipher.ENCRYPT_MODE,rsaPublicKey);
        //4.用加密工具类
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        String encryptResult = new String(Base64Utils.encode(cipherText));
        System.out.println(plainText + "使用rsa加密之后的密文：" + encryptResult);
        return encryptResult;
    }

    /**
     * rsa解密算法
     */
    private static String  rsaDecrypt(String cipherText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        //1.获取加密算法工具类对象
        Cipher cipher = Cipher.getInstance("RSA");
        //2.对工具类对象进行初始化
        cipher.init(Cipher.ENCRYPT_MODE,rsaPrivateKey);

        //3.用加密工具类
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText.getBytes()));
        String decryptResult = new String(plainText,"GB2312");
        System.out.println(cipherText + "使用RSA解密之后的密文：" + decryptResult);
        return decryptResult;
    }

    /**
     *获取参数key
     */
    private static SecretKeySpec getKey(String originKey,String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(originKey.getBytes());
        int radix = 0;
        switch (algorithm){
            case "DES":
                radix = 8;
                break;
            case "AES":
                radix = 16;
                break;
            case "RSA":
                getPubAndPrivKey();
                break;
            default:{

            }
        }
        originKey = new BigInteger(1, md.digest()).toString(radix);
        //根据给定的字节数组构造一个m密钥
        SecretKeySpec secretKeySpec = new SecretKeySpec(originKey.getBytes(), algorithm);
        return secretKeySpec;
    }
    private static void getPubAndPrivKey() throws NoSuchAlgorithmException {
        System.out.println("getPubAndPrivKey start...");
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024,new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 得到私钥
        rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 得到公钥
        rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        System.out.println("privateKey: " + rsaPrivateKey.toString());
        System.out.println("rsaPublicKey: " + rsaPublicKey.toString());
        System.out.println("getPubAndPrivKey end...");
    }
}
