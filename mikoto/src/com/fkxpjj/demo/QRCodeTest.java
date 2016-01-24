package com.fkxpjj.demo;

import com.s1025.kuroko.Kuroko;

public class QRCodeTest {
	public static void main (String[] args){
		Init.init();
		String s = Kuroko.ks.qrcode.addQRCode(300, 5);
		System.out.println(s);
	}
	
	
}
