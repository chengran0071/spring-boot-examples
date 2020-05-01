package com.wxblockchain.com.learning.encrypt.factory;

/**
 * 加解密接口
 */
public interface IEncryptDemo {
    /**
     * 加密
     */
    String encrypt(String plainText,String privKey);

    /**
     * 解密
     */
    String decrypt(String cipherText,String key);
}
