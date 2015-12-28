package com.s1025.kuroko.ks.impl;

import com.google.gson.Gson;
import com.s1025.kuroko.dao.KfMessageDAO;
import com.s1025.kuroko.dao.impl.KfMessageDAOimpl;
import com.s1025.kuroko.ks.MessageKs;
import com.s1025.kuroko.model.ErrResult;
import com.s1025.kuroko.model.KfMessage;
import com.s1025.kuroko.model.KuUtil;
import com.s1025.kuroko.model.Result;
import com.s1025.mikoto.Mikoto;

public class MessageKsImpl implements MessageKs{
	public KfMessageDAO kfMessageDAO = new KfMessageDAOimpl();
	Gson gson = new Gson();
	
	/**
	 * 主动发送文本消息.
	 * 将发送文本消息给微信用户，并记录在数据库中。
	 * @param openid
	 * @param content
	 * @return
	 */
	public Result<KfMessage> sendText(String to, String from, String content, boolean r){
		String re = Mikoto.api.kf.sendCustomText(to, content);
		if(KuUtil.isResultSuccess(re)){
			KfMessage message = new KfMessage();
			message.setTouser(to);
			message.setFromuser(from);
			message.setContent(content);
			message.setMsgtype("text");
			int ri = kfMessageDAO.insert(message);
			Result<KfMessage> rs = new Result<KfMessage>();
			rs.setErrcode(0);
			rs.setErrmsg("ok");
			return rs;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<KfMessage> rs = new Result<KfMessage>(er);
			return rs;
		}
	}


	@Override
	public int sendText(String to, String from, String content) {
		Result<KfMessage> rs = sendText(to, from, content, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}

}
