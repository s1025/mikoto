package com.s1025.mikoto.api;

import java.util.Calendar;

import com.google.gson.Gson;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.AccessToken;
import com.s1025.mikoto.model.App;
import com.s1025.mikoto.util.HttpCon;

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
     
    
    public String getAccessToken() {
    	
    	//String tmp = "mp1agkzRYpRG7SNDmCy7pf_phFK-n49SBw0NPO3RXrHq-Gz8MmFXyDJBlCMm9VLYGPBZlgvrgatEu-m3MtN-U55iy9YWvcjX9_D-kCxLBXg";
    	//if(tmp!=null) return tmp;
    	
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.HOUR_OF_DAY, -1);
    	
    	if(time == null || cal.after(time)){
    		accessToken = obtainAccessToken(Mikoto.app);
        	time = Calendar.getInstance();
        	System.out.println(accessToken);
        }
        
    	return accessToken.getAccess_token();
    }
    
    /** 
     * 获取access_token 
     *  
     * @param appid 凭证 
     * @param appsecret 密钥 
     * @return 
     */  
    public AccessToken getAccessToken(boolean o) {
    	
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.HOUR_OF_DAY, -1);
    	
    	if(time == null || cal.after(time)){
    		accessToken = obtainAccessToken(Mikoto.app);
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