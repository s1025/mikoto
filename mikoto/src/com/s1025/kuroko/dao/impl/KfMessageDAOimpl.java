package com.s1025.kuroko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.KfMessageDAO;
import com.s1025.kuroko.model.KfMessage;

public class KfMessageDAOimpl implements KfMessageDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	int re = 0;


	@Override
	public int insert(KfMessage message) {
		conn = DB.getCon();
		String sql = "insert into kf_message(touser, fromuser, msgtype, content, date) values(?,?,?,?,now())";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getTouser());
			pstmt.setString(2, message.getFromuser());
			pstmt.setString(3, message.getMsgtype());
			pstmt.setString(4, message.getContent());
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
	public int delete(int kmid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public KfMessage select(int kmid) {
		conn = DB.getCon();
		String sql = "select * from media where kmid = ?";
		return null;
	}

	@Override
	public int update(KfMessage message) {
		// TODO Auto-generated method stub
		return 0;
	}

}
