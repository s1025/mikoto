package com.s1025.kuroko.module.kf;

import com.google.gson.Gson;
import com.s1025.kuroko.module.ErrResult;
import com.s1025.kuroko.module.KuUtil;
import com.s1025.kuroko.module.Result;
import com.s1025.mikoto.Mikoto;

public class KfService {
	public KfMessageDAO kfMessageDAO = new KfMessageDAOimpl();
	Gson gson = new Gson();
	
	/**
	 * ���������ı���Ϣ.
	 * �������ı���Ϣ��΢���û�������¼�����ݿ��С�
	 * @param openid
	 * @param content
	 * @return
	 */
	public Result<KfMessage> sendText(String openid, String content){
		String re = Mikoto.api.kf.sendCustomText(openid, content);
		if(KuUtil.isResultSuccess(re)){
			KfMessage message = new KfMessage();
			message.setTouser(openid);
			message.setContent(content);
			message.setMsgtype("text");
			int r = kfMessageDAO.insert(message);
			Result<KfMessage> rs = new Result<KfMessage>();
			rs.setErrCode(0);
			rs.setErrMsg("ok");
			return rs;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<KfMessage> r = new Result<KfMessage>(er);
			return r;
		}
	}
	
	/**
	 * ��������ͼƬ��Ϣ.
	 * ������ͼƬ��Ϣ��΢���û�������¼�����ݿ��С�
	 * @param openid
	 * @param content
	 * @return
	 */
	public Result<KfMessage> sendImg(String openid, String mediaId){
		String re = Mikoto.api.kf.sendCustomImage(openid, mediaId);
		if(KuUtil.isResultSuccess(re)){
			KfMessage message = new KfMessage();
			message.setTouser(openid);
			message.setMedia_id(mediaId);
			message.setMsgtype("image");
			int r = kfMessageDAO.insert(message);
			Result<KfMessage> rs = new Result<KfMessage>();
			rs.setErrCode(0);
			rs.setErrMsg("ok");
			return rs;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<KfMessage> r = new Result<KfMessage>(er);
			return r;
		}
	}
	
	/**
	 * ��������������Ϣ.
	 * ������������Ϣ��΢���û�������¼�����ݿ��С�
	 * @param openid
	 * @param content
	 * @return
	 */
	public Result<KfMessage> sendVoice(String openid, String mediaId){
		String re = Mikoto.api.kf.sendCustomVoice(openid, mediaId);
		if(KuUtil.isResultSuccess(re)){
			KfMessage message = new KfMessage();
			message.setTouser(openid);
			message.setMedia_id(mediaId);
			message.setMsgtype("voice");
			int r = kfMessageDAO.insert(message);
			Result<KfMessage> rs = new Result<KfMessage>();
			rs.setErrCode(0);
			rs.setErrMsg("ok");
			return rs;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<KfMessage> r = new Result<KfMessage>(er);
			return r;
		}
	}
	
}
