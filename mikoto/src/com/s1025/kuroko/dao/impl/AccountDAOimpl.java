package com.s1025.kuroko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.s1025.kuroko.dao.AccountDAO;
import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.model.Account;

public class AccountDAOimpl implements AccountDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	int re = 0;

	@Override
	public int insert(Account account) {
		String sql = "insert into account values(?,?)";
		conn = DB.getCon();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAccount());
			pstmt.setString(2, account.getPasswd());
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
		String sql = "delete from account where id=?";
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

	@Override
	public Account select(int id) {
		String sql = "select * from account where id=?";
		conn = DB.getCon();
		Account account = new Account();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				account.setId(rs.getInt("id"));
				account.setAccount(rs.getString("account"));
				account.setPasswd(rs.getString("passwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return account;
	}

	@Override
	public int update(Account account) {
		String sql = "update account set account=?,passwd=? where id=?";
		conn = DB.getCon();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAccount());
			pstmt.setString(2, account.getPasswd());
			pstmt.setInt(3, account.getId());
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
	public Account select(String accounts) {
		String sql = "select * from account where account=?";
		conn = DB.getCon();
		Account account = new Account();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accounts);
			rs = pstmt.executeQuery();
			while(rs.next()){
				account.setId(rs.getInt("id"));
				account.setAccount(rs.getString("account"));
				account.setPasswd(rs.getString("passwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return account;
	}

}
