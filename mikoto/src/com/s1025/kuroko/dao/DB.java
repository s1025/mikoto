package com.s1025.kuroko.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	public static String url = "jdbc:mysql://localhost:3306/kuroko?useUnicode=true&characterEncoding=utf-8";
	public static String user = "root";
	public static String passwd = "pjjclub209";
	
	public static void init(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getCon(){
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,user,passwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
