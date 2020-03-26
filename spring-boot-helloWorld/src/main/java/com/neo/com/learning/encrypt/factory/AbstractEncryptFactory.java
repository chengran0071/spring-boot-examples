package com.neo.com.learning.encrypt.factory;

import lombok.Data;
import lombok.Getter;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

@Data
@Getter
public class AbstractEncryptFactory {

    /**明文*/
    private String plainText;
    /**key*/
    private String key ;

    private Cipher cipher ;

    public AbstractEncryptFactory(String encMethod,String priKey) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance(encMethod);
        SecretKeySpec key = getKey(priKey,encMethod);
    }

    /**
     *获取参数key
     */
    private static SecretKeySpec getKey(String originKey,String algorithm){
        //根据给定的字节数组构造一个m密钥
        SecretKeySpec secretKeySpec = new SecretKeySpec(originKey.getBytes(), algorithm);
        return secretKeySpec;
    }


}
