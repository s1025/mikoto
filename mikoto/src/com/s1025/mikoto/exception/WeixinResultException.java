package com.s1025.mikoto.exception;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WeixinResultException(){
		super();
	}
	
	public WeixinResultException(String message){
		super(message);
	}
}
