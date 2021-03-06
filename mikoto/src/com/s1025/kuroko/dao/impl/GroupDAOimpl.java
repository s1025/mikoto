package com.s1025.kuroko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.GroupDAO;
import com.s1025.kuroko.model.Group;

public class GroupDAOimpl implements GroupDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	int re = 0;
	
	@Override
	public int insert(Group group) {
		conn = DB.getCon();
		String sql = "insert into groups values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, group.getId());
			pstmt.setString(2, group.getName());
			pstmt.setInt(3, group.getCount());
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
		conn = DB.getCon();
		String sql = "delete from groups where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			re = pstmt.executeUpdate();
			DB.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Group select(int id) {
		conn = DB.getCon();
		String sql = "select * from groups where id = ?";
		Group group = new Group();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()){
				group.setId(rs.getInt("id"));
				group.setName(rs.getString("name"));
				group.setCount(rs.getInt("count"));
			}
			DB.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return group;
	}

	@Override
	public int update(Group group) {
		conn = DB.getCon();
		String sql = "update groups set name=?, count=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, group.getName());
			pstmt.setInt(2, group.getCount());
			pstmt.setInt(3, group.getId());
			re = pstmt.executeUpdate();
			DB.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public int clean() {
		conn = DB.getCon();
		String sql = "delete from groups";
		try {
			stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, stmt, rs);
		}
		return re;
	}

	@Override
	public int updateName(int id, String name) {
		conn = DB.getCon();
		String sql = "update groups set name=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			re = pstmt.executeUpdate();
			DB.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public List<Group> select() {
		conn = DB.getCon();
		String sql = "select * from groups";
		List<Group> groups = new ArrayList<Group>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()){
				Group group = new Group();
				group.setId(rs.getInt("id"));
				group.setName(rs.getString("name"));
				group.setCount(rs.getInt("count"));
				groups.add(group);
			}
			DB.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return groups;
	}

	

}
