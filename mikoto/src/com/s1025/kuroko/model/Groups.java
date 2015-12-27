package com.s1025.kuroko.model;

import java.util.List;

public class Groups {
	private List<Group> groups;

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "Groups [groups=" + groups + "]";
	}
}
