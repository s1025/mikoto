package com.s1025.kuroko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.RuleDAO;
import com.s1025.kuroko.model.Key;
import com.s1025.kuroko.model.Reply;
import com.s1025.kuroko.model.Rule;

public class RuleDAOimpl implements RuleDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	int re = 0;

	@Override
	public int insert(Rule rule) {
		conn = DB.getCon();
		List<Key> keys = rule.getKeys();
		List<Reply> replys = rule.getReplys();
		String sql = "insert into router_rule values(?,?)";
		
		try {
			conn.setAutoCommit(false);
			
			for(Key key:keys){
				key.setRname(rule.getName());
				insertKey(key);
			}
			for(Reply reply:replys){
				reply.setRname(rule.getName());
				insertReply(reply);
			}

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rule.getName());
			pstmt.setInt(2, rule.getRespAll());
			re = pstmt.executeUpdate();
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return re;
	}

	@Override
	public int delete(String name) {
		conn = DB.getCon();
		String sql = "delete from router_rule where name = ?";
		try {
			conn.setAutoCommit(false);
			
			deleteKey(name);
			deleteReply(name);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			re = pstmt.executeUpdate();
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return re;
	}

	@Override
	public Rule select(String name) {
		conn = DB.getCon();
		String sql = "select * from router_rule where name = ?";
		Rule rule = new Rule();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				rule.setName(rs.getString("name"));
				rule.setRespAll(rs.getInt("resp_all"));
			}
			rule.setKeys(selectKeys(name));
			rule.setReplys(selectReply(name));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return rule;
	}
	
	@Override
	public List<Rule> selectAll() {
		conn = DB.getCon();
		String sql = "select name from router_rule";
		List<Rule> rules = new ArrayList<Rule>();
		List<String> names = new ArrayList<String>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				names.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		
		for(String name:names){
			rules.add(select(name));
		}
		
		return rules;
	}
	
	public int insertKey(Key key) throws SQLException{
		String sql = "insert into router_key values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, key.getRname());
		pstmt.setString(2, key.getContent());
		pstmt.setInt(3, key.getTotally());
		re = pstmt.executeUpdate();
		DB.close(null, pstmt, null);
		return re;
	}
	
	public int deleteKey(String rname) throws SQLException{
		String sql = "delete from router_key where rname = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, rname);
		re = pstmt.executeUpdate();
		DB.close(null, pstmt, null);
		return re;
	}
	
	public List<Key> selectKeys(String rname){
		conn = DB.getCon();
		List<Key> keys = new ArrayList<Key>();
		String sql = "select * from router_key where rname = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rname);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Key key = new Key();
				key.setRname(rs.getString("rname"));
				key.setContent(rs.getString("content"));
				key.setTotally(rs.getInt("totally"));
				keys.add(key);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		
		return keys;
	}
	
	public int insertReply(Reply reply) throws SQLException{
		String sql = "insert into router_reply values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, reply.getRname());
		pstmt.setString(2, reply.getType());
		pstmt.setString(3, reply.getContent());
		re = pstmt.executeUpdate();
		DB.close(null, pstmt, null);
		return re;
	}
	
	public int deleteReply(String rname) throws SQLException{
		String sql = "delete from router_reply where rname = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, rname);
		re = pstmt.executeUpdate();
		DB.close(null, pstmt, null);
		return re;
	}
	
	public List<Reply> selectReply(String rname){
		conn = DB.getCon();
		String sql = "select * from router_reply where rname = ?";
		List<Reply> replys = new ArrayList<Reply>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rname);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Reply reply = new Reply();
				reply.setRname(rs.getString("rname"));
				reply.setType(rs.getString("type"));
				reply.setContent(rs.getString("content"));
				replys.add(reply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return replys;
	}

	@Override
	public List<Key> selectMatchKey(String content) {
		conn = DB.getCon();
		List<Key> keys = new ArrayList<Key>();
		String sql = "select * from router_key where content like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+content+"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Key key = new Key();
				key.setRname(rs.getString("rname"));
				key.setContent(rs.getString("content"));
				key.setTotally(rs.getInt("totally"));
				keys.add(key);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		
		return keys;
	}

	@Override
	public Rule selectRuleOnly(String name) {
		conn = DB.getCon();
		String sql = "select * from router_rule where name = ?";
		Rule rule = new Rule();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				rule.setName(rs.getString("name"));
				rule.setRespAll(rs.getInt("resp_all"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return rule;
	}




}
