package com.s1025.mikoto;

import java.io.IOException;
import java.util.Properties;

import com.s1025.mikoto.api.AccessTokenApi;
import com.s1025.mikoto.api.DatacubeApi;
import com.s1025.mikoto.api.GroupApi;
import com.s1025.mikoto.api.KfApi;
import com.s1025.mikoto.api.MassApi;
import com.s1025.mikoto.api.MaterialApi;
import com.s1025.mikoto.api.MediaApi;
import com.s1025.mikoto.api.MenuApi;
import com.s1025.mikoto.api.UserApi;
import com.s1025.mikoto.model.App;
import com.s1025.mikoto.util.Dev;

public class Mikoto {
	
	/**
	 * �����������.
	 * ���ʼ����
	 * ��ʹ�� new APP(appid, appsecret) ��ʽ��ֵ
	 */
	public static App app;
	
	/**
	 * ����˽�����֤���ֶΣ���ʼ��ʱע�롣
	 */
	public static String token;
	
	/**
	 * api�࣬������api���µ�ʵ��.
	 * @author fkxpjj
	 *
	 */
	public static class api{
		public static AccessTokenApi access = AccessTokenApi.getAccessTokenApi();
		public static GroupApi group = new GroupApi();
		public static KfApi kf = new KfApi();
		public static MassApi mass = new MassApi();
		public static MaterialApi material = new MaterialApi();
		public static MediaApi media = new MediaApi();
		public static MenuApi menu = new MenuApi();
		public static UserApi user = new UserApi();
		public static DatacubeApi datacube = new DatacubeApi();
	}

	
	/**
	 * ������������֤.
	 * ��ȡ�ĸ���ز������������Ƿ���֤�ɹ�
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return �����Ƿ�ɹ���������
	 * @throws IOException
	 */
	public static boolean validate(String signature, String timestamp, String nonce, String echostr) throws IOException{
		return Dev.validate(signature, timestamp, nonce, echostr, token);
	}
}
