package com.s1025.kuroko.ks.impl;

import java.util.List;

import com.google.gson.Gson;
import com.s1025.kuroko.dao.GroupDAO;
import com.s1025.kuroko.dao.UserDAO;
import com.s1025.kuroko.dao.impl.GroupDAOimpl;
import com.s1025.kuroko.dao.impl.UserDAOimpl;
import com.s1025.kuroko.ks.UserKs;
import com.s1025.kuroko.model.ErrResult;
import com.s1025.kuroko.model.Group;
import com.s1025.kuroko.model.GroupRe;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.User;
import com.s1025.kuroko.module.user.UserList;
import com.s1025.kuroko.model.Groups;
import com.s1025.kuroko.model.KuUtil;
import com.s1025.mikoto.Mikoto;


public class UserKsImpl implements UserKs{

	Gson gson = new Gson();
	GroupDAO groupDAO = new GroupDAOimpl();
	UserDAO userDAO = new UserDAOimpl();


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

	/**
	 * ����һ���µ��û�����.
	 * ͬʱ��д�����ݿ��У��û���Ĭ��Ϊ0��
	 * @param name �����������30����
	 * @return
	 */
	@Override
	public Result<Group> createGroup(String name, boolean r) {
		String re = Mikoto.api.group.createGroup(name);
		if(KuUtil.isResultSuccess(re)){
			GroupRe group = gson.fromJson(re, GroupRe.class);
			Result<Group> rs = new Result<Group>(0,"ok",group.getGroup(),null);
			
			groupDAO.insert(group.getGroup());
			
			return rs;
		}else{
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<Group> rs = new Result<Group>(er);
			return rs;
		}
	}
	
	@Override
	public int createGroup(String name) {
		Result<Group> rs = createGroup(name, true);
		if(rs.getErrcode()==0){
			return 1;
		}
		return 0;
	}


	/**
	 * ���ķ�����.
	 * ͬʱд�����ݿ⡣
	 * @param id
	 * @param name
	 * @return
	 */
	@Override
	public Result<Group> changeGroupName(int id, String name, boolean r){
		String re = Mikoto.api.group.updateGroup(id, name);
		
		ErrResult er = gson.fromJson(re, ErrResult.class);
		
		if(er.getErrcode().equals("0")){
			groupDAO.updateName(id, name);
		}
		
		Result<Group> rs = new Result<Group>(er);
		return rs;
	}

	@Override
	public int changeGroupName(int id, String name) {
		Result<Group> rs = changeGroupName(id, name, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}
	
	/**
	 * �����û����ڷ���.
	 * ͬʱ�������ݿ���Ϣ�������û���groupid�����������������
	 * @param openid �û���openid
	 * @param groupid �·����id
	 * @return
	 */
	public Result<Group> changeUserGroup(String openid, int groupid, boolean r){
		User user = userDAO.select(openid);
		Group group = groupDAO.select(groupid);
		Group ogroup = groupDAO.select(user.getGroupid());
		Result<Group> re = new Result<Group>();
		re.setErrcode(-1);
		re.setErrmsg("δ֪����");
		if(!group.getName().equals("")){
			String json = Mikoto.api.group.updateGroup(openid, groupid);
			if(KuUtil.isResultSuccess(json)){
				user.setGroupid(groupid);
				group.setCount(group.getCount()+1);
				ogroup.setCount(ogroup.getCount()-1);
				userDAO.update(user);
				groupDAO.update(group);
				groupDAO.update(ogroup);
				re.setErrcode(0);
				re.setErrmsg("ok");
			}
		}
		return re;
	}
	
	public int changeUserGroup(String openid, int groupid){
		Result<Group> rs = changeUserGroup(openid, groupid, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}
	
	/**
	 * ɾ�����飬�û������Ĭ�Ϸ���.
	 * ͬʱ�����ݿ���ɾ��,�����û�����Ĭ���飬�޸�Ĭ����������
	 * @param id Ҫɾ���ķ���id
	 * @return
	 */
	@Override
	public Result<Group> deleteGroup(int id, boolean r){
		String re = Mikoto.api.group.deleteGroup(id);
		if(KuUtil.isResultSuccess(re)){
			ErrResult er = new ErrResult();
			er.setErrcode("0");
			er.setErrmsg("ok");
			Result<Group> rs = new Result<Group>(er);
			
			Group group = groupDAO.select(0);
			group.setCount(group.getCount()+userDAO.selectGroupUserNum(id));
			groupDAO.delete(id);
			userDAO.updateUserGroup(id, 0);
			groupDAO.update(group);
			
			return rs;
		}else{
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<Group> rs = new Result<Group>(er);
			return rs;
		}
	}
	
	@Override
	public int deleteGroup(int id){
		Result<Group> rs = deleteGroup(id, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}
	
	/**
	 * ͬ�����з�����Ϣ.
	 * @return ͬ���Ƿ�ɹ�
	 */
	@Override
	public Result<Group> syncGroups(boolean r){
		String re = Mikoto.api.group.getGroup();
		
		if(KuUtil.isResultSuccess(re)){
			Groups groups = gson.fromJson(re, Groups.class);
			
			List<Group> list = groups.getGroups();
			groupDAO.clean();
			for(Group group:list){
				if(groupDAO.insert(group)<1){
					Result<Group> rs = new Result<Group>(-2,"���ݿ����",null,null);
					return rs;
				}
			}
			
			return new Result<Group>(0,"ok",null,null);
		}
		
		ErrResult er = gson.fromJson(re, ErrResult.class);
		Result<Group> rs = new Result<Group>(er);
		return rs;
	}

	@Override
	public boolean syncGroups() {
		Result<Group> rs = syncGroups(true);
		if(rs.getErrcode()==0)
			return true;
		return false;
	}
	
	
	/**
	 * �޸��û���ע.
	 * ͬʱ����Ϣд�����ݿ⡣
	 * @param openid Ҫ�޸ĵ��û���id
	 * @param remark ��ע
	 * @return
	 */
	@Override
	public Result<User> changeUserRemark(String openid, String remark, boolean r){
		String re = Mikoto.api.user.updateUser(openid, remark);
		if(KuUtil.isResultSuccess(re)){
			userDAO.updateUserRemark(openid, remark);
		}
		ErrResult er = gson.fromJson(re, ErrResult.class);
		Result<User> rs = new Result<User>(er);
		return rs;
	}
	
	@Override
	public int changeUserRemark(String openid, String remark){
		Result<User> rs = changeUserRemark(openid, remark, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}
	
	
	
	/**
	 * ͬ�������û���Ϣ.
	 * �Ե����û�����Ϣ����ͬ��������ȡ�û���Ϣ�����ݿ��С�
	 * @param openid �û�openid
	 * @return �Ƿ�ɹ�
	 */
	@Override
	public Result<User> syncUser(String openid, boolean r){
		String re = Mikoto.api.user.infoUser(openid);
		
		if(KuUtil.isResultSuccess(re)){
			User user = gson.fromJson(re, User.class);
			
			if(userDAO.update(user)>0){
				return new Result<User>(0,"ok",null,null);
			}
			
			return new Result<User>(-2,"���ݿ����",null,null);
		}else{
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<User> rs = new Result<User>(er);
			return rs;
		}
	}
	
	@Override
	public boolean syncUser(String openid) {
		Result<User> rs = syncUser(openid, true);
		if(rs.getErrcode()==0)
			return true;
		return false;
	}
	
	/**
	 * ͬ������û���Ϣ.
	 * ����һ��openid���ϣ�Ȼ���������ͬ���û���Ϣ������
	 * @param openids openid����
	 * @return �Ƿ�ɹ�
	 */
	public Result<User> syncUsers(List<String> openids){
		for(String openid:openids){
			Result<User> rs = syncUser(openid, true);
			if(rs.getErrcode()!=0)
				return rs;
		}
		return new Result<User>(0,"ok",null,null);
	}
	
	/**
	 * ͬ�������û���Ϣ.
	 * ��ȡ�����û���openid����ί����������������Ϣ��ȡ��
	 * @return �Ƿ�ͬ���ɹ�
	 */
	@Override
	public Result<User> syncUsers(boolean r){
		String re = Mikoto.api.user.usersList(null);
		if(KuUtil.isResultSuccess(re)){
			userDAO.clean();
			UserList userList = gson.fromJson(re, UserList.class);
			List<String> openids = userList.getData().getOpenid();
			
			userDAO.insertOpenids(openids);
			if(syncUsers(openids).getErrcode()!=0){
				ErrResult er = gson.fromJson(re, ErrResult.class);
				Result<User> rs = new Result<User>(er);
				return rs;
			}
			
			
			int time = userList.getTotal()/10000;
			
			for(int i = 0;i<time;i++){
				re = Mikoto.api.user.usersList(openids.get(openids.size()-1));
				if(!KuUtil.isResultSuccess(re)){
					ErrResult er = gson.fromJson(re, ErrResult.class);
					Result<User> rs = new Result<User>(er);
					return rs;
				} else {
					userList = gson.fromJson(re, UserList.class);
					openids = userList.getData().getOpenid();
					userDAO.insertOpenids(openids);
					if(syncUsers(openids).getErrcode()!=0){
						ErrResult er = gson.fromJson(re, ErrResult.class);
						Result<User> rs = new Result<User>(er);
						return rs;
					}
				}
			}
			return new Result<User>(0,"ok",null,null);
		}else{
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<User> rs = new Result<User>(er);
			return rs;
		}
	}

	@Override
	public boolean syncUsers() {
		Result<User> rs = syncUsers(true);
		if(rs.getErrcode()==0)
			return true;
		return false;
	}

	@Override
	public Result<User> pullUser(String openid, boolean r) {
		boolean flag = userDAO.check(openid);
		
		String re = Mikoto.api.user.infoUser(openid);
		
		if(KuUtil.isResultSuccess(re)){
			User user = gson.fromJson(re, User.class);
			
			if(flag==true&&userDAO.update(user)>0){
				return new Result<User>(0,"ok",null,null);
			} else if(flag==false&&userDAO.insert(user)>0){
				return new Result<User>(0,"ok",null,null);
			}
			
			return new Result<User>(-2,"���ݿ����",null,null);
		}else{
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<User> rs = new Result<User>(er);
			return rs;
		}
	}

	@Override
	public boolean pullUser(String openid) {
		Result<User> rs = pullUser(openid, true);
		if(rs.getErrcode()==0)
			return true;
		return false;
	}

	@Override
	public Result<User> delUser(String openid, boolean r) {
		int re = userDAO.delete(openid);
		if(re>0)
			return new Result<User>(0,"ok",null,null);
		else
			return new Result<User>(-2,"���ݿ����",null,null);
	}

	@Override
	public boolean delUser(String openid) {
		Result<User> rs = delUser(openid, true);
		if(rs.getErrcode()==0)
			return true;
		return false;
	}

	@Override
	public Result<User> getUsers(int page, int num, boolean r) {
		List<User> users = userDAO.selectPageUsers((page-1)*num, num);
		if(users.size()>1)
			return new Result<User>(0,"ok",null,users);
		return new Result<User>(-2,"���ݿ����",null,users);
	}

	@Override
	public List<User> getUsers(int page, int num) {
		Result<User> rs = getUsers(page, num, true);
		return rs.getDatas();
	}


}
