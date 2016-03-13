package com.s1025.kuroko.util;

public class QRUtil {

	public static String[] spliteScene(String sceneHec){	
		String[] sp = new String[4];
		
		for(int i = sceneHec.length();i<8;i++){
			sceneHec = sceneHec + "0";
		}
		
		for(int i = 0; i<4; i++){
			sp[i] = sceneHec.substring(0, 2);
			sceneHec = sceneHec.substring(2);
		}
		
		return sp;
	}
	
	public static String[] spliteScene(long scene){
		String sc = Long.toHexString(scene);
		return spliteScene(sc);
	}
	
	public static String getFunc(String scene){
		return spliteScene(scene)[0];
	}
	
	public static String getFunc(long scene){
		return spliteScene(scene)[0];
	}
	
	public static String getPara(String scene, int i){
		return spliteScene(scene)[i];
	}
	
	public static String getPara(long scene, int i){
		return spliteScene(scene)[i];
	}
}
