package com.fkxpjj.mikoto.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.model.MsgType;
import com.fkxpjj.mikoto.model.ReqBase;
import com.fkxpjj.mikoto.model.ReqText;
import com.fkxpjj.mikoto.model.RespNews;
import com.fkxpjj.mikoto.model.RespText;

public class PassiveApi {
	public RespText getRespText(ReqBase reqBase, String content){
		RespText respText = new RespText();
		respText.setFromUserName(reqBase.getToUserName());
		respText.setToUserName(reqBase.getFromUserName());
		respText.setContent(content);
		respText.setMsgType(MsgType.TEXT);
		respText.setCreateTime(System.currentTimeMillis());
		return respText;
	}
	
	public RespNews getRespNews(ReqBase reqBase){
		RespNews respNews = new RespNews();
		respNews.setFromUserName(reqBase.getToUserName());
		return null;
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
