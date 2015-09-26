package com.s1025.kuroko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.s1025.kuroko.dao.IRouterReplyDAO;
import com.s1025.kuroko.plugin.router.Reply;

public class RouterReplyDAOimpl implements IRouterReplyDAO{
	Connection con;

	@Override
	public int insert(Reply reply) {
		String sql = "insert into router_reply values(?,?,?)";
		PreparedStatement pstmt = null;
		int re = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reply.getRname());
			pstmt.setInt(2, reply.getType());
			pstmt.setString(3, reply.getContent());
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return re;
	}

	@Override
	public Reply select(String rname, String content) {
		String sql = "select * from router_reply where rname = ?, content = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reply reply = new Reply();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rname);
			pstmt.setString(2, content);
			rs = pstmt.executeQuery();
			while(rs.next()){
				reply.setRname(rs.getString("rname"));
				reply.setType(rs.getInt("type"));
				reply.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return reply;
	}

	@Override
	public int update(Reply reply) {
		String sql = "update router_reply set type = ? where rname =? and content =?";
		PreparedStatement pstmt = null;
		int re = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reply.getType());
			pstmt.setString(2, reply.getRname());
			pstmt.setString(3, reply.getContent());
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
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
		String sql = "delete from router_reply where rname = ?, content = ?";
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
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return re;
	}

}
