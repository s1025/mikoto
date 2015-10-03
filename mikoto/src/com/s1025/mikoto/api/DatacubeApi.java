package com.s1025.mikoto.api;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.util.HttpCon;

/**
 * ����ͳ�ƽӿ�.
 * @author fkxpjj
 *
 */
public class DatacubeApi {
	//�û�����
	public String getusersummary_url = "https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN";
	public String getusercumulate_url = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN";
	
	//ͼ�ķ���
	public String getarticlesummary_url = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=ACCESS_TOKEN";
	public String getarticletotal_url = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN";
	public String getuserread_url = "https://api.weixin.qq.com/datacube/getuserread?access_token=ACCESS_TOKEN";
	public String getuserreadhour_url = "https://api.weixin.qq.com/datacube/getuserreadhour?access_token=ACCESS_TOKEN";
	public String getusershare_url = "https://api.weixin.qq.com/datacube/getusershare?access_token=ACCESS_TOKEN";
	public String getusersharehour_url = "https://api.weixin.qq.com/datacube/getusersharehour?access_token=ACCESS_TOKEN";
	
	//��Ϣ����
	public String getupstreammsg_url = "https://api.weixin.qq.com/datacube/getupstreammsg?access_token=ACCESS_TOKEN";
	public String getupstreammsghour_url = "https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=ACCESS_TOKEN";
	public String getupstreammsgweek_url = "https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=ACCESS_TOKEN";
	public String getupstreammsgmonth_url = "https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=ACCESS_TOKEN";
	public String getupstreammsgdist_url = "https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=ACCESS_TOKEN";
	public String getupstreammsgdistweek_url = "https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=ACCESS_TOKEN";
	public String getupstreammsgdistmonth_url = "https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=ACCESS_TOKEN";
	
	//�ӿڷ���
	public String getinterfacesummary_url = "https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=ACCESS_TOKEN";
	public String getinterfacesummaryhour_url = "https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=ACCESS_TOKEN";
	
	/**
	 * ��ȡ�û���������.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getusersummary(String begin_date, String end_date){
		String url = getusersummary_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡ�ۼ��û�����.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getusercumulate(String begin_date, String end_date){
		String url = getusercumulate_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡͼ��Ⱥ��ÿ�����ݡ�
	 * @param begin_date ��ʼʱ�� ��-��-�� ��ͬ
	 * @param end_date ����ʱ��
	 * @return
	 */
	public String getarticlesummary(String begin_date, String end_date){
		String url = getarticletotal_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡͼ��Ⱥ��������.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getarticletotal(String begin_date, String end_date){
		String url = getarticletotal_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡͼ��ͳ������.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getuserread(String begin_date, String end_date){
		String url = getuserread_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡͼ��ͳ�Ʒ�ʱ����.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getuserreadhour(String begin_date, String end_date){
		String url = getuserreadhour_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡͼ�ķ���ת������.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getusershare(String begin_date, String end_date){
		String url = getusershare_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡͼ�ķ���ת����ʱ����.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getusersharehour(String begin_date, String end_date){
		String url = getusersharehour_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡ��Ϣ���͸ſ�����.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsg(String begin_date, String end_date){
		String url = getupstreammsg_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡ��Ϣ���ͷ�ʱ����.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsghour(String begin_date, String end_date){
		String url = getupstreammsghour_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡ��Ϣ����������.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsgweek(String begin_date, String end_date){
		String url = getupstreammsgweek_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡ��Ϣ����������.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsgmonth(String begin_date, String end_date){
		String url = getupstreammsgmonth_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡ��Ϣ���ͷֲ�����.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsgdist(String begin_date, String end_date){
		String url = getupstreammsgdist_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡ��Ϣ���ͷֲ�������.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsgdistweek(String begin_date, String end_date){
		String url = getupstreammsgdistweek_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡ��Ϣ���ͷֲ�������.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getupstreammsgdistmonth(String begin_date, String end_date){
		String url = getupstreammsgdistmonth_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡ�ӿڷ�������.
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public String getinterfacesummary(String begin_date, String end_date){
		String url = getinterfacesummary_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		return datacubeBase(url, begin_date, end_date);
	}
	
	/**
	 * ��ȡ�ӿڷ�����ʱ����.
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
