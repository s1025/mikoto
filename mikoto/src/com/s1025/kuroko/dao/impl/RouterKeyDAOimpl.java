package com.s1025.kuroko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.IRouterKeyDAO;
import com.s1025.kuroko.plugin.router.Key;

public class RouterKeyDAOimpl implements IRouterKeyDAO{
	Connection con;

	@Override
	public int insert(Key key) {
		String sql = "insert into router_key values(?,?,?)";
		PreparedStatement pstmt = null;
		int re = 0;
		con = DB.getCon();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key.getRname());
			pstmt.setString(2, key.getContent());
			pstmt.setInt(3, key.getTotally());
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return re;
	}

	@Override
	public Key select(String rname, String content) {
		String sql = "select * from router_key where rname = ? and content = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Key key = new Key();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rname);
			pstmt.setString(2, content);
			rs = pstmt.executeQuery();
			while(rs.next()){
				key.setRname(rs.getString("rname"));
				key.setContent(rs.getString("content"));
				key.setTotally(rs.getInt("totally"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return key;
	}

	@Override
	public int update(Key key) {
		String sql = "update router_key set content = ?, totally=? where rname = ?";
		PreparedStatement pstmt = null;
		int re = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key.getContent());
			pstmt.setInt(2, key.getTotally());
			pstmt.setString(3, key.getRname());
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return re;
	}

	@Override
	public int delete(String rname, String content) {
		String sql = "delete from router_key where rname = ? and content = ?";
		PreparedStatement pstmt = null;
		int re = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rname);
			pstmt.setString(2, content);
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return re;
	}

}
