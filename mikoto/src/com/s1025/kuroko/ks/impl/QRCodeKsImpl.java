package com.s1025.kuroko.ks.impl;

import com.google.gson.Gson;
import com.s1025.kuroko.ks.QRCodeKs;
import com.s1025.kuroko.model.ErrResult;
import com.s1025.kuroko.model.KfMessage;
import com.s1025.kuroko.model.KuUtil;
import com.s1025.kuroko.model.QRCode;
import com.s1025.kuroko.model.Result;
import com.s1025.mikoto.Mikoto;

public class QRCodeKsImpl implements QRCodeKs{

	Gson gson = new Gson();
	
	@Override
	public Result<QRCode> addQRCode(int seconds, long scene) {
		String re = Mikoto.api.qrcode.createQRCode(seconds, scene);
		if(KuUtil.isResultSuccess(re)){
			QRCode qrcode = gson.fromJson(re, QRCode.class);
			Result<QRCode> rs = new Result<QRCode>();
			rs.setData(qrcode);
			rs.setErrcode(0);
			rs.setErrmsg("ok");
			return rs;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<QRCode> rs = new Result<QRCode>(er);
			return rs;
		}
	}

	@Override
	public Result<QRCode> addQRCode(int seconds, String scene) {
		return addQRCode(seconds, Long.parseLong(scene, 16));
	}

	@Override
	public Result<QRCode> addQRCode(int seconds, String func, String para1, String para2, String para3) {
		return addQRCode(seconds, Long.parseLong(func+para1+para2+para3, 16));
	}
	
}
