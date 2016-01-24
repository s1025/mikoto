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
	public Result<QRCode> addQRCode(int seconds, int scene, boolean r) {
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
	public String addQRCode(int seconds, int scene) {
		Result<QRCode> rs = addQRCode(seconds, scene, true);
		if(rs.getErrcode()==0)
			return rs.getData().getTicket();
		return "";
	}

}
