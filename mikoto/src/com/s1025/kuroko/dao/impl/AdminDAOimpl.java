package com.s1025.kuroko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.IAdminDAO;
import com.s1025.kuroko.model.Admin;

public class AdminDAOimpl implements IAdminDAO{
	Connection con;

	@Override
	public int insert(Admin admin) {
		String sql = "insert into admin(aid,passwd,name,email,registered,lv,status,openid) values(?,?,?,?,now(),?,?,?)";
		PreparedStatement pstmt = null;
		int re = 0;
		con = DB.getCon();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, admin.getAid());
			pstmt.setString(2, admin.getPasswd());
			pstmt.setString(3, admin.getName());
			pstmt.setString(4, admin.getEmail());
			pstmt.setInt(5, admin.getLv());
			pstmt.setInt(6, admin.getStatus());
			pstmt.setString(7, admin.getOpenid());
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null){
					pstmt.close();
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return re;
	}

	@Override
	public Admin select(String aid) {
		String sql = "select * from admin where aid = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DB.getCon();
		Admin admin = new Admin();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, aid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				admin.setAid(rs.getString("aid"));
				admin.setPasswd(rs.getString("passwd"));
				admin.setName(rs.getString("name"));
				admin.setEmail(rs.getString("email"));
				admin.setRegistered(rs.getString("registered"));
				admin.setLv(rs.getInt("lv"));
				admin.setStatus(rs.getInt("status"));
				admin.setOpenid(rs.getString("openid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return admin;
	}

}
