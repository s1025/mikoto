package com.s1025.kuroko.model;

import javax.servlet.http.HttpSession;

public class KurokoContext {
	private HttpSession httpSession;

	public HttpSession getHttpSession() {
		return httpSession;
	}

	public void setHttpSession(HttpSession httpSession) {
		this.httpSession = httpSession;
	}
}
