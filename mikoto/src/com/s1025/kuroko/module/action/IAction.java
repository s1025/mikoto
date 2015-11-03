package com.s1025.kuroko.module.action;

public interface IAction {
	public void init();
	public boolean service();
	public void destory();
}
