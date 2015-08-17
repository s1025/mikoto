package com.fkxpjj.mikoto.demo;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.model.req.ReqText;
import com.fkxpjj.mikoto.model.resp.Media;
import com.fkxpjj.mikoto.model.resp.RespImg;
import com.fkxpjj.mikoto.model.resp.RespText;
import com.fkxpjj.mikoto.model.resp.RespVoice;

public class PassiveTest {
	public static void main(String[] args){
		RespVoice respImg = new RespVoice();
		respImg.setFromUserName("111");
		respImg.setToUserName("222");
		respImg.setMsgType("image");
		respImg.setCreateTime(123);
	    Media med = new Media();
	    med.setMediaId("mmm");
		respImg.setVoice(med);
		String xml = Mikoto.parse.RespToXML(respImg);
		System.out.println(xml);
	}

}
