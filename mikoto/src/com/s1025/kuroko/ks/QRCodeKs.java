package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.QRCode;
import com.s1025.kuroko.model.Result;

public interface QRCodeKs {
	public Result<QRCode> addQRCode(int seconds, int scene, boolean r);
	public String addQRCode(int seconds, int scene);

}
