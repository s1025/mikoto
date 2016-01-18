package com.s1025.kuroko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.s1025.kuroko.dao.AccountUserDAO;
import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.model.AccountUser;

public class AccountUserDAOimpl implements AccountUserDAO{

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	int re = 0;
	
	@Override
	public int insert(AccountUser accountUser) {
		String sql = "insert into account_user values(?,?,?,?)";
		conn = DB.getCon();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountUser.getId());
			pstmt.setString(2, accountUser.getOpenid());
			pstmt.setInt(3, accountUser.getLev());
			pstmt.setInt(4, accountUser.getType());
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
	public int delete(int id, String openid) {
		String sql = "delete from account_user where id=? and openid=?";
		conn = DB.getCon();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, openid);
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
	public AccountUser select(int id, String openid) {
		String sql = "select * from account_user where id=? and openid=?";
		conn = DB.getCon();
		AccountUser accountUser = new AccountUser();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, openid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				accountUser.setId(rs.getInt("id"));
				accountUser.setOpenid(rs.getString("openid"));
				accountUser.setLev(rs.getInt("lev"));
				accountUser.setType(rs.getInt("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return accountUser;
	}

	@Override
	public int update(AccountUser accountUser) {
		String sql = "update account_user set lev=?,type=? where id=? and openid=?";
		conn = DB.getCon();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountUser.getLev());
			pstmt.setInt(2, accountUser.getType());
			pstmt.setInt(3, accountUser.getId());
			pstmt.setString(4, accountUser.getOpenid());
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
	public int delete(int id) {
		String sql = "delete from account_user where id=?";
		conn = DB.getCon();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return re;
	}

}
