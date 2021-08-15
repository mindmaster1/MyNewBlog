package com.xhd.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 10:56
 * @Description: MD5加盐(salt)加密
 * @version:
 */
public class MD5Util {
    private static final String SALT = "tamboo";

    public String encode(String password) {
        password = password + SALT;
        MessageDigest md5 = null;
        try {
            //拿到一个MD5转换器
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //将字符串转换为了字符数组
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            //将字符数组转换为字节数组
            byteArray[i] = (byte) charArray[i];
        }

        //转换并返回结果，也是字节数组，包含16个元素
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}

