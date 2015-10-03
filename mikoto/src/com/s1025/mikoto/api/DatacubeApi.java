package com.s1025.mikoto.api;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.util.HttpCon;

/**
 * 数据统计接口.
 * @author fkxpjj
 *
 */
public class DatacubeApi {
	//用户分析
	public String getusersummary_url = "https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN";
	public String getusercumulate_url = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN";
	
	//图文分析
	public String getarticlesummary_url = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=ACCESS_TOKEN";
	public String getarticletotal_url = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN";
	public String getuserread_url = "https://api.weixin.qq.com/datacube/getuserread?access_token=ACCESS_TOKEN";
	public String getuserreadhour_url = "https://api.weixin.qq.com/datacube/getuserreadhour?access_token=ACCESS_TOKEN";
	public String getusershare_url = "https://api.weixin.qq.com/datacube/getusershare?access_token=ACCESS_TOKEN";
	public String getusersharehour_url = "https://api.weixin.qq.com/datacube/getusersharehour?access_token=ACCESS_TOKEN";
	
	//消息分析
	public String getupstreammsg_url = "https://api.weixin.qq.com/datacube/getupstreammsg?access_token=ACCESS_TOKEN";
	public String getupstreammsghour_url = "https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=ACCESS_TOKEN";
	public String getupstreammsgweek_url = "https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=ACCESS_TOKEN";
	public String getupstreammsgmonth_url = "https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=ACCESS_TOKEN";
	public String getupstreammsgdist_url = "https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=ACCESS_TOKEN";
	public String getupstreammsgdistweek_url = "https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=ACCESS_TOKEN";
	public String getupstreammsgdistmonth_url = "https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=ACCESS_TOKEN";
	
	//接口分析
	public String getinterfacesummary_url = "https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=ACCESS_TOKEN";
	public String getinterfacesummaryhour_url = "https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=ACCESS_TOKEN";
	
	/**
	 * 获取用户增减数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getusersummary(String begin_date, String end_date){
		String url = getusersummary_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取累计用户数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getusercumulate(String begin_date, String end_date){
		String url = getusercumulate_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取图文群发每日数据。
	 * @param begin_date 开始时间 年-月-日 下同
	 * @param end_date 结束时间
	 * @return
	 */
	public String getarticlesummary(String begin_date, String end_date){
		String url = getarticletotal_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取图文群发总数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getarticletotal(String begin_date, String end_date){
		String url = getarticletotal_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取图文统计数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getuserread(String begin_date, String end_date){
		String url = getuserread_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取图文统计分时数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getuserreadhour(String begin_date, String end_date){
		String url = getuserreadhour_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取图文分享转发数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getusershare(String begin_date, String end_date){
		String url = getusershare_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取图文分享转发分时数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getusersharehour(String begin_date, String end_date){
		String url = getusersharehour_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取消息发送概况数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsg(String begin_date, String end_date){
		String url = getupstreammsg_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取消息分送分时数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsghour(String begin_date, String end_date){
		String url = getupstreammsghour_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取消息发送周数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsgweek(String begin_date, String end_date){
		String url = getupstreammsgweek_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取消息发送月数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsgmonth(String begin_date, String end_date){
		String url = getupstreammsgmonth_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取消息发送分布数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsgdist(String begin_date, String end_date){
		String url = getupstreammsgdist_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取消息发送分布周数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsgdistweek(String begin_date, String end_date){
		String url = getupstreammsgdistweek_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取消息发送分布月数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsgdistmonth(String begin_date, String end_date){
		String url = getupstreammsgdistmonth_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取接口分析数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getinterfacesummary(String begin_date, String end_date){
		String url = getinterfacesummary_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * 获取接口分析分时数据.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getinterfacesummaryhour(String begin_date, String end_date){
		String url = getinterfacesummaryhour_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	
	
	
	
	
	
	
	public String datacubeBase(String url, String begin_date, String end_date){
		String post = "{\"begin_date\": \""+begin_date+"\", \"end_date\": \""+end_date+"\"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	

}
