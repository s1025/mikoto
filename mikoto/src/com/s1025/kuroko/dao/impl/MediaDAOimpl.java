package com.s1025.kuroko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.MediaDAO;
import com.s1025.kuroko.model.Media;

public class MediaDAOimpl implements MediaDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	int re = 0;

	@Override
	public int insert(Media media) {
		conn = DB.getCon();
		String sql = "insert into media(type, temp, media_id, url, created_at,name) values(?,?,?,?,now(),?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, media.getType());
			pstmt.setInt(2, media.getTemp());
			pstmt.setString(3, media.getMedia_id());
			pstmt.setString(4, media.getUrl());
			pstmt.setString(5, media.getName());
			re = pstmt.executeUpdate();
			DB.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public int delete(int mid) {
		conn = DB.getCon();
		String sql = "delete from media where mid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			re = pstmt.executeUpdate();
			DB.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Media select(int mid) {
		conn = DB.getCon();
		String sql = "select * from media where mid = ?";
		Media media = new Media();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				media.setMid(rs.getInt("mid"));
				media.setName(rs.getString("name"));
				media.setTemp(rs.getInt("temp"));
				media.setType(rs.getString("type"));
				media.setMedia_id(rs.getString("media_id"));
				media.setUrl(rs.getString("url"));
				media.setCreated_at(rs.getString("created_at"));
			}
			DB.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return media;
	}

	@Override
	public int update(Media media) {
		// TODO Auto-generated method stub
		return 0;
	}

}
