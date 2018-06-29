package com.lzt.test;

/**
 * @Title
 * @Description
 * @Author:lizitao
 * @Create 2018/5/21
 * @Version 1.0
 * @Copyright:2016 www.jointem.com
 */
public class MyTest {


    public static void main(String[] args) {
        StringBuffer sb =  new StringBuffer("");
        System.out.println(get2(sb,100));
    }


    public static String get2(StringBuffer sb,int a){
        if(a==1){
            return "1";
        }
        int b = a%2;
        a = a/2;
        if(a==1){
            sb.append(b).append(1);
            return sb.reverse().toString();
        }else{
            sb.append(b);
            get2(sb,a);
        }
        return sb.toString();
    }
}
