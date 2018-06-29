package com.lzt.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @Title
 * @Description
 * @Author:lizitao
 * @Create 2018/5/17
 * @Version 1.0
 * @Copyright:2016 www.jointem.com
 */
public class Md5Util {

    public static String getPasswordByMd5(String password){
        String algorithmName = "md5";
        String salt = "lzt";
        int hashIterations = 2;
        SimpleHash hash = new SimpleHash(algorithmName, password, salt, hashIterations);
        return hash.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPasswordByMd5("123456"));
    }

}
