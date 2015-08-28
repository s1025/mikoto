package com.s1025.kuroko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.IInfoDAO;
import com.s1025.kuroko.model.Info;

public class InfoDAOimpl implements IInfoDAO{
	Connection con;

	@Override
	public int insert(Info info) {
		String sql = "insert into info(type,msg_type,openid,content,created_at) values(?,?,?,?,?)";
		con = DB.getCon();
		int re = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getType());
			pstmt.setString(2, info.getMsgType());
			pstmt.setString(3, info.getOpenid());
			pstmt.setString(4, info.getContent());
			pstmt.setString(5, info.getCreatedAt());
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Info select(int iid) {
		String sql = "select * from info where iid=?";
		con = DB.getCon();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Info info = new Info();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, iid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				info.setIid(iid);
				info.setType(rs.getString("type"));
				info.setMsgType(rs.getString("msg_type"));
				info.setOpenid(rs.getString("openid"));
				info.setContent(rs.getString("content"));
				info.setCreatedAt(rs.getString("creat_at"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public int update(Info info) {
		String sql = "update info set type=?, msg_type=?, openid=?, content=?, created_at=? where iid=?";
		con = DB.getCon();
		int re = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getType());
			pstmt.setString(2, info.getMsgType());
			pstmt.setString(3, info.getOpenid());
			pstmt.setString(4, info.getContent());
			pstmt.setString(5, info.getCreatedAt());
			pstmt.setInt(6, info.getIid());
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public int delete(int iid) {
		String sql = "delete from info where iid=?";
		con = DB.getCon();
		int re = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, iid);
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}

}
