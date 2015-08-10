package com.fkxpjj.mikoto.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fkxpjj.mikoto.Mikoto;
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
	
	public void sendRespText(ReqText reqText, String content, HttpServletResponse resp) throws IOException{
		RespText respText = getRespText(reqText, content);
		String xml = Mikoto.parse.RespToXML(respText);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(xml);
		out.close();
	}
}
