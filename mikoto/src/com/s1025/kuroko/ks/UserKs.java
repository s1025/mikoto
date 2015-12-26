package com.s1025.kuroko.ks;

import java.util.List;


import com.s1025.kuroko.model.Group;
import com.s1025.kuroko.model.Result;


public interface UserKs {
	public List<Group> getGroups();
	public Result<Group> getGroups(boolean r);
}
