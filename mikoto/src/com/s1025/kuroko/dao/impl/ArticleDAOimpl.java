package com.s1025.kuroko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.s1025.kuroko.dao.ArticleDAO;
import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.model.NewsArticle;

public class ArticleDAOimpl implements ArticleDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	int re = 0;

	@Override
	public int insert(NewsArticle na) {
		String sql = "insert into article(title,thumb_media_id,content,content_source_url,digest,author,show_cover_pic,media_id,num) values(?,?,?,?,?,?,?,?,?)";
		conn = DB.getCon();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, na.getTitle());
			pstmt.setString(2, na.getThumb_media_id());
			pstmt.setString(3, na.getContent());
			pstmt.setString(4, na.getContent_source_url());
			pstmt.setString(5, na.getDigest());
			pstmt.setString(6, na.getAuthor());
			pstmt.setInt(7, na.getShow_cover_pic());
			pstmt.setString(8, na.getMedia_id());
			pstmt.setInt(9, na.getNum());
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return re;
	}

	@Override
	public int delete(int naid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NewsArticle select(int naid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(NewsArticle na) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int truncate() {
		String sql = "truncate table article";
		conn = DB.getCon();
		try {
			stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DB.close(conn, stmt, rs);
		}
		return re;
	}

}
