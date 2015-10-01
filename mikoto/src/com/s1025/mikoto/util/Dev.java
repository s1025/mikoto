package com.s1025.mikoto.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;

/**
 * 一些基础函数.
 * 服务器接入，app初始化。
 * @author fkxpjj
 *
 */
public class Dev {
	
	/**
	 * 验证服务器地址有效性.
	 * 接入服务器，只有接入成功后微信才能主动发送信息到服务器上。
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @param token
	 * @return 是否接入成功
	 */
	public static boolean validate(String signature, String timestamp, String nonce, String echostr, String token){
		String[] arr = new String[] { token, timestamp, nonce };  
		Arrays.sort(arr);  
		StringBuilder content = new StringBuilder();  
		for (int i = 0; i < arr.length; i++) {  
			content.append(arr[i]);  
			}  
		MessageDigest md = null;  
		String tmpStr = null;  
		try {  
			md = MessageDigest.getInstance("SHA-1");  
			byte[] digest = md.digest(content.toString().getBytes());  
			tmpStr = byteToStr(digest);  
			} catch (NoSuchAlgorithmException e) {  
				e.printStackTrace();  
				}  
		content = null;  
		boolean val = tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
		return val;
	}
	
	private static String byteToStr(byte[] byteArray) {  
        String strDigest = "";  
        for (int i = 0; i < byteArray.length; i++) {  
            strDigest += byteToHexStr(byteArray[i]);  
        }  
        return strDigest;  
    }  
	
	private static String byteToHexStr(byte mByte) {  
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
        char[] tempArr = new char[2];  
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];  
        tempArr[1] = Digit[mByte & 0X0F];  
  
        String s = new String(tempArr);  
        return s;  
    }  
	
}
