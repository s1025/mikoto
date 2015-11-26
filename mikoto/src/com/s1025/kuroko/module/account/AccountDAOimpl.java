package com.s1025.kuroko.module.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.s1025.kuroko.dao.DB;

public class AccountDAOimpl implements AccountDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	int re = 0;
	@Override
	public int insert(Account account) {
		conn = DB.getCon();
		String sql = "insert into account values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getUid());
			pstmt.setString(2, account.getUpw());
			pstmt.setInt(3, account.getLevel());
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
	public int delete(String uid) {
		conn = DB.getCon();
		String sql = "delete from account where uid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
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
	public Account select(String uid) {
		conn = DB.getCon();
		Account account = new Account();
		String sql = "select * from account where uid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				account.setUid(rs.getString("uid"));
				account.setUpw(rs.getString("upw"));
				account.setLevel(rs.getInt("level"));
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
		conn = DB.getCon();
		String sql = "update account set upw = ?, level = ? where uid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getUpw());
			pstmt.setInt(2, account.getLevel());
			pstmt.setString(3, account.getUid());
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
	public String selectPeopleUid(String openid) {
		conn = DB.getCon();
		String sql = "select * from people where openid = ?";
		String re = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, openid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				re = rs.getString("uid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return re;
	}
	@Override
	public List<Account> selectAll() {
		conn = DB.getCon();
		List<Account> list = new ArrayList<Account>();
		String sql = "select * from account";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Account account = new Account();
				account.setUid(rs.getString("uid"));
				account.setUpw(rs.getString("upw"));
				account.setLevel(rs.getInt("level"));
				list.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, stmt, rs);
		}
		return list;
	}
	


}
