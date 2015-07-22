package com.fkxpjj.mikoto.api;

import java.util.Calendar;

import com.alibaba.fastjson.JSON;
import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.model.AccessToken;
import com.fkxpjj.mikoto.model.App;
import com.fkxpjj.mikoto.util.HttpCon;
import com.fkxpjj.mikoto.util.MyX509TrustManager;
import com.google.gson.Gson;

/** 
 * 公众平台通用接口工具类 
 *  
 * @author liuyq 
 * @date 2013-08-09 
 */  
public class AccessTokenApi {  
	
	private static AccessTokenApi accessTokenApi = new AccessTokenApi();
	
	private AccessToken accessToken;
	private Calendar time;
	private Gson gson = new Gson();
    
	private AccessTokenApi(){};
	
	public static AccessTokenApi getAccessTokenApi() {
		return accessTokenApi;
	}
	
    public final String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";  
      
    /** 
     * 获取access_token 
     *  
     * @param appid 凭证 
     * @param appsecret 密钥 
     * @return 
     */  
    public AccessToken getAccessToken() {
    	App app = Mikoto.appApi.getApp();
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.HOUR_OF_DAY, -1);
    	
    	if(time == null || cal.after(time)){
    		accessToken = obtainAccessToken(app);
        	time = Calendar.getInstance();
        }
        
    	return accessToken;
    }  
    
    public AccessToken obtainAccessToken(App app){
    	
        AccessToken accessToken = null;  
        
        String requestUrl = access_token_url.replace("APPID", app.getAppID()).replace("APPSECRET", app.getAppSecret());  
        String response = HttpCon.httpRequest(requestUrl, "GET", null);  
        // 如果请求成功  
        if (null != response) {  
        	accessToken = gson.fromJson(response,AccessToken.class);
        }  
        return accessToken; 
    	
    }
     
}  