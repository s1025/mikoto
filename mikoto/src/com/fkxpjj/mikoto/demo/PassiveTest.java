package com.fkxpjj.mikoto.demo;

import java.util.ArrayList;
import java.util.List;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.req.ReqText;
import com.s1025.mikoto.model.resp.Media;
import com.s1025.mikoto.model.resp.RespArticle;
import com.s1025.mikoto.model.resp.RespImg;
import com.s1025.mikoto.model.resp.RespNews;
import com.s1025.mikoto.model.resp.RespText;
import com.s1025.mikoto.model.resp.RespVoice;

public class PassiveTest {
	public static void main(String[] args){
		
		ReqText reqText = new ReqText();
		reqText.setFromUserName("1");
		reqText.setToUserName("1");
		reqText.setCreateTime(3);
		
		RespArticle a1 = Mikoto.api.passive.getRespArticle("a1t", "a1d", "http://mmbiz.qpic.cn/mmbiz/CedLmsO1IMHWRrKiawKXWZI5GpN4S7Ilbv8suCyWgntjGyYPBGrGTLBF8aMLfLUugm4G2XIic2HQwFS2wvefySiaA/0", "http://baidu.com");
		RespArticle a2 = Mikoto.api.passive.getRespArticle("a2t", "a2d", "http://mmbiz.qpic.cn/mmbiz/CedLmsO1IMHWRrKiawKXWZI5GpN4S7Ilbv8suCyWgntjGyYPBGrGTLBF8aMLfLUugm4G2XIic2HQwFS2wvefySiaA/0", "http://baidu.com");
		
		List<RespArticle> list = new ArrayList<RespArticle>();
		list.add(a1);
		list.add(a2);
		RespNews news = Mikoto.api.passive.getRespNews(reqText, 2, list);
		
		System.out.println(news);
	}

}
