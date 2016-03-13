package com.fkxpjj.demo;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.util.QRUtil;

public class QRCodeTest {
	public static void main (String[] args){
		Init.init();
		//String s = Kuroko.ks.qrcode.addQRCode(600, 5);
		//System.out.println(s);
		String[] a = QRUtil.spliteScene("3e81");
		for(String i:a){
			System.out.println(i);
		}
		
	}
}
