package com.vany.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * MD5加密工具类
 *
 */
public class Md5Util {

	public static String encode(String plainText)  
    {  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(plainText.getBytes());  
            byte[] b = md.digest();  
            int i;  
            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < b.length; offset++)   
            {  
                i = b[offset];  
                if (i<0) i+=256;  
                if(i<16)  
                buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            return buf.toString();  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return plainText;  
    } 
}
