package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.QRCode;
import com.s1025.kuroko.model.Result;

public interface QRCodeKs {
	public Result<QRCode> addQRCode(int seconds, long scene);
	public Result<QRCode> addQRCode(int seconds, String scene);
	public Result<QRCode> addQRCode(int seconds, String func, String para1, String para2, String para3);
}
