package com.s1025.kuroko.module.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.s1025.kuroko.dao.DB;

public class UserDAOimpl implements UserDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	int re = 0;

	@Override
	public int insert(User user) {
		conn = DB.getCon();
		String sql = "insert into users values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getOpenid());
			pstmt.setInt(2, user.getSubscribe());
			pstmt.setString(3, user.getNickname());
			pstmt.setInt(4, user.getSex());
			pstmt.setString(5, user.getLanguage());
			pstmt.setString(6, user.getCity());
			pstmt.setString(7, user.getProvince());
			pstmt.setString(8, user.getCountry());
			pstmt.setString(9, user.getHeadimgurl());
			pstmt.setString(10, user.getSubscribe_time());
			pstmt.setString(11, user.getUnionid());
			pstmt.setString(12, user.getRemark());
			pstmt.setInt(13, user.getGroupid());
			re = pstmt.executeUpdate();
			DB.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public int delete(String openid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User select(String openid) {
		conn = DB.getCon();
		String sql = "select * from users where openid=?";
		User user = new User();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, openid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				user.setOpenid(rs.getString("openid"));
				user.setSubscribe(rs.getInt("subscribe"));
				user.setNickname(rs.getString("nickname"));
				user.setSex(rs.getInt("sex"));
				user.setLanguage(rs.getString("language"));
				user.setCity(rs.getString("city"));
				user.setProvince(rs.getString("province"));
				user.setCountry(rs.getString("country"));
				user.setHeadimgurl(rs.getString("headimgurl"));
				user.setSubscribe_time(rs.getString("subscribe_time"));
				user.setUnionid(rs.getString("unionid"));
				user.setRemark(rs.getString("remark"));
				user.setGroupid(rs.getInt("groupid"));
			}
			DB.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int update(User user) {
		conn = DB.getCon();
		String sql = "update users set subscribe=?, nickname=?, sex=?, language=?, "
				+ "city=?, province=?, country=?, headimgurl=?, subscribe_time=?, "
				+ "unionid=?, remark=?, groupid=? where openid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getSubscribe());
			pstmt.setString(2, user.getNickname());
			pstmt.setInt(3, user.getSex());
			pstmt.setString(4, user.getLanguage());
			pstmt.setString(5, user.getCity());
			pstmt.setString(6, user.getProvince());
			pstmt.setString(7, user.getCountry());
			pstmt.setString(8, user.getHeadimgurl());
			pstmt.setString(9, user.getSubscribe_time());
			pstmt.setString(10, user.getUnionid());
			pstmt.setString(11, user.getRemark());
			pstmt.setInt(12, user.getGroupid());
			pstmt.setString(13, user.getOpenid());
			re = pstmt.executeUpdate();
			DB.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public int insertOpenids(List<String> openids) {
		conn = DB.getCon();
		StringBuilder sb = new StringBuilder();
		sb.append("insert into users(openid) values");
		for(String openid:openids){
			sb.append("(\"");
			sb.append(openid);
			sb.append("\")");
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		try {
			stmt = conn.createStatement();
			re = stmt.executeUpdate(sb.toString());
			DB.close(conn, stmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public int clean() {
		conn = DB.getCon();
		String sql = "delete from users";
		try {
			stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
			DB.close(conn, stmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public int selectGroupUserNum(int groupid) {
		conn = DB.getCon();
		String sql = "select count(*) as count from users where groupid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				re = rs.getInt("count");
			}
			DB.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public int updateUserGroup(int groupid, int groupid2) {
		conn = DB.getCon();
		String sql = "update users set groupid = ? where groupid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupid2);
			pstmt.setInt(2, groupid);
			re = pstmt.executeUpdate();
			DB.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

}
