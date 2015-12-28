package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.KfMessage;

public interface MessageKs {
	public Result<KfMessage> sendText(String to, String from, String content, boolean r);
	public int sendText(String to, String from, String content);
}
