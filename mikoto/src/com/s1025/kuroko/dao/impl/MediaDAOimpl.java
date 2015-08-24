package com.s1025.kuroko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.IMediaDAO;
import com.s1025.kuroko.model.Media;

public class MediaDAOimpl implements IMediaDAO{
	Connection con;

	@Override
	public int insert(Media media) {
		String sql = "insert into media(media_id,url,type,permanent,created_at) values(?,?,?,?,?)";
		con = DB.getCon();
		PreparedStatement pstmt = null;
		int re = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, media.getMediaId());
			pstmt.setString(2, media.getUrl());
			pstmt.setString(3, media.getType());
			pstmt.setInt(4, media.getPermanent());
			pstmt.setString(5, media.getCreatedAt());
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
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
		return re;
	}

	@Override
	public Media select(int mid) {
		String sql = "select * from media where mid = ?";
		con = DB.getCon();
		Media media = new Media();
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				media.setMid(mid);
				media.setMediaId(rs.getString("media_id"));
				media.setUrl(rs.getString("url"));
				media.setType(rs.getString("type"));
				media.setPermanent(rs.getInt("permanent"));
				media.setCreatedAt(rs.getString("created_at"));
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
		return media;
	}

	@Override
	public int delete(int mid) {
		String sql = "delete from media where mid = ?";
		con = DB.getCon();
		int re = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mid);
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
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
		return re;
	}

	@Override
	public int update(Media media) {
		String sql = "update media set media_id=?, url=?, type=?, permanent=?, created_at=? where mid=?";
		con = DB.getCon();
		int re = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, media.getMediaId());
			pstmt.setString(2, media.getUrl());
			pstmt.setString(3, media.getType());
			pstmt.setInt(4, media.getPermanent());
			pstmt.setString(5, media.getCreatedAt());
			pstmt.setInt(6, media.getMid());
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
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
		return re;
	}
}
