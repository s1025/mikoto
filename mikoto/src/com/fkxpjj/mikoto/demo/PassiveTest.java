package com.fkxpjj.mikoto.demo;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.model.ReqText;
import com.fkxpjj.mikoto.model.RespText;

public class PassiveTest {
	public static void main(String[] args){
		ReqText reqText = new ReqText();
		reqText.setToUserName("1");
		reqText.setFromUserName("2");
		reqText.setContent("h");
		reqText.setCreateTime(123L);
		reqText.setMsgType("text");
		RespText respText = Mikoto.api.passive.getRespText(reqText, "huifu");
		System.out.println(respText);
	}

}
