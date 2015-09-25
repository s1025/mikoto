package com.s1025.kuroko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public Reply select(String rname, String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Reply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String rname, String content) {
		String sql = "";
		return 0;
	}

}
