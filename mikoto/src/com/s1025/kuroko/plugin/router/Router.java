package com.s1025.kuroko.plugin.router;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s1025.mikoto.plugin.IRouter;

/**
 * ·���� �ṩ���ӵĹؼ��ֻظ�����.
 * 
 * @author fkxpjj
 *
 */
public class Router implements IRouter{
	private List<Rule> rules = new ArrayList<Rule>();

	@Override
	public boolean service(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return false;
	}
}
