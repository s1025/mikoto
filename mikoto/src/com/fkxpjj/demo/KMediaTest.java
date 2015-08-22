package com.fkxpjj.demo;

import java.io.IOException;

import com.s1025.kuroko.biz.MediaBiz;
import com.s1025.kuroko.result.ErrCode;
import com.s1025.kuroko.result.MediaResult;
import com.s1025.kuroko.result.ResultBase;
import com.s1025.kuroko.result.ResultType;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.util.Builder;

public class KMediaTest {
	public static void main (String[] args) throws IOException{
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		
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