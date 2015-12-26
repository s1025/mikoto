package com.s1025.kuroko.ks.impl;

import java.util.List;

import com.s1025.kuroko.dao.GroupDAO;
import com.s1025.kuroko.dao.impl.GroupDAOimpl;
import com.s1025.kuroko.ks.UserKs;
import com.s1025.kuroko.model.Group;
import com.s1025.kuroko.model.Result;


public class UserKsImpl implements UserKs{

	GroupDAO groupDAO = new GroupDAOimpl();


	@Override
	public Result<Group> getGroups(boolean r) {
		List<Group> groups = groupDAO.select();
		Result<Group> rs = new Result<Group>(0,"ok",null,groups);
		return rs;
	}
	
	@Override
	public List<Group> getGroups() {
		Result<Group> rs = getGroups(true);
		List<Group> groups = rs.getDatas();
		return groups;
	}

}
