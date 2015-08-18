package com.s1025.mikoto.exception;
/**
 * 
 * 这个异常是公众号调用接口时，对错误返回码进行封装的异常。
 * 
 * <P>公众号每次调用接口时，可能获得正确或错误的返回码，开发者可以根据返回码信息调试接口，排查错误。</p>
 * 
 * <p>具体返回码请查看公共平台开发文档。</p>
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
