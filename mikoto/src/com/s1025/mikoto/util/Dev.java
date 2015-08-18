package com.s1025.mikoto.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s1025.mikoto.Mikoto;

public class Dev {
	public static boolean validate(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		String token = Mikoto.token;
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
		if(val) {
			PrintWriter out = resp.getWriter();
			out.print(echostr);
			out.close();
		}
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
