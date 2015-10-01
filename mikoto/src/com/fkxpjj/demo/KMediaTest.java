package com.fkxpjj.demo;

import java.io.IOException;

import com.s1025.kuroko.biz.MediaBiz;
import com.s1025.kuroko.model.result.ErrCode;
import com.s1025.kuroko.model.result.MediaResult;
import com.s1025.kuroko.model.result.ResultBase;
import com.s1025.kuroko.model.result.ResultType;
import com.s1025.mikoto.Mikoto;

public class KMediaTest {
	public static void main (String[] args) throws IOException{
		Mikoto.build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		
		String path = "D:\\2.jpg";
		
		ResultBase r = MediaBiz.uploadMedia(path, true);
		if(r.getResultType().endsWith(ResultType.MEDIA)){
			MediaResult mr = (MediaResult)r;
			System.out.println(mr);
		} else{
			ErrCode er = (ErrCode)r;
			System.out.println(er);
		}
		
	}
}
