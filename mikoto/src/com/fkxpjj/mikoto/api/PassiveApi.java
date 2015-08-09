package com.fkxpjj.mikoto.api;

import com.fkxpjj.mikoto.model.MsgType;
import com.fkxpjj.mikoto.model.ReqText;
import com.fkxpjj.mikoto.model.RespText;

public class PassiveApi {
	public RespText getRespText(ReqText reqText, String content){
		RespText respText = new RespText();
		respText.setFromUserName(reqText.getToUserName());
		respText.setToUserName(reqText.getFromUserName());
		respText.setContent(content);
		respText.setMsgType(MsgType.TEXT);
		respText.setCreateTime(System.currentTimeMillis());
		return respText;
	}
}
