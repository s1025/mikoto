package com.fkxpjj.mikoto.exception;
/**
 * 
 * ����쳣�ǹ��ںŵ��ýӿ�ʱ���Դ��󷵻�����з�װ���쳣��
 * 
 * <P>���ں�ÿ�ε��ýӿ�ʱ�����ܻ����ȷ�����ķ����룬�����߿��Ը��ݷ�������Ϣ���Խӿڣ��Ų����</p>
 * 
 * <p>���巵������鿴����ƽ̨�����ĵ���</p>
 * 
 * @author fkxpjj
 *
 */
public class WeixinResultException extends Exception{

	public WeixinResultException(){
		super();
	}
	
	public WeixinResultException(String message){
		super(message);
	}
}
