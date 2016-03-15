package com.fkxpjj.demo;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.model.QRCode;
import com.s1025.kuroko.model.Result;

public class QRCodeTest {
	public static void main (String[] args){
		Init.init();
		Result<QRCode> s = Kuroko.ks.qrcode.addQRCode(6000, "00010100");
		System.out.println(s);
	
	}
}
