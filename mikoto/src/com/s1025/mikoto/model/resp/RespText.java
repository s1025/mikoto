package com.s1025.mikoto.model.resp;

public class RespText extends RespBase{
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String toString() {
		return "RespText [Content=" + Content + ", toString()="
				+ super.toString() + "]";
	}


	
}
