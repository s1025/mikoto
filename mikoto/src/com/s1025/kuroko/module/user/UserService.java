package com.s1025.kuroko.module.user;

import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.s1025.kuroko.module.ErrResult;
import com.s1025.kuroko.module.KuUtil;
import com.s1025.kuroko.module.Result;
import com.s1025.mikoto.Mikoto;

public class UserService {
	
	Gson gson = new Gson();
	GroupDAO groupDAO = new GroupDAOimpl();
	UserDAO userDAO = new UserDAOimpl();
	
	public Result<Group> createGroup(String name){
		String re = Mikoto.api.group.createGroup(name);
		if(KuUtil.isResultSuccess(re)){
			GroupRe group = gson.fromJson(re, GroupRe.class);
			Result<Group> rs = new Result<Group>(group.getGroup());
			
			groupDAO.insert(group.getGroup());
			
			return rs;
		}else{
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<Group> rs = new Result<Group>(er);
			return rs;
		}
	}
	
	public Result<Group> deleteGroup(int id){
		String re = Mikoto.api.group.deleteGroup(id);System.out.println(re);
		if(KuUtil.isResultSuccess(re)){
			ErrResult er = new ErrResult();
			er.setErrcode("0");
			er.setErrmsg("ok");
			Result<Group> rs = new Result<Group>(er);
			
			groupDAO.delete(id);
			
			return rs;
		}else{
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<Group> rs = new Result<Group>(er);
			return rs;
		}
	}
	
	public Result<Group> changeGroupName(int id, String name){
		String re = Mikoto.api.group.updateGroup(id, name);
		
		ErrResult er = gson.fromJson(re, ErrResult.class);
		
		if(er.getErrcode().equals("0")){
			groupDAO.updateName(id, name);
		}
		
		Result<Group> rs = new Result<Group>(er);
		return rs;
	}
	
	public Result<Group> getAllGroup(){
		String re = Mikoto.api.group.getGroup();
		
		if(KuUtil.isResultSuccess(re)){
			Groups groups = gson.fromJson(re, Groups.class);
			Result<Group> rs = new Result<Group>(groups.getGroups());
			
			List<Group> list = groups.getGroups();
			groupDAO.clean();
			for(Group group:list){
				groupDAO.insert(group);
			}
			
			return rs;
		}else{
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<Group> rs = new Result<Group>(er);
			return rs;
		}
	}
	
	/**
	 * ͬ�������û���Ϣ.
	 * �Ե����û�����Ϣ����ͬ��������ȡ�û���Ϣ�����ݿ��С�
	 * @param openid �û�openid
	 * @return �Ƿ�ɹ�
	 */
	public boolean syncUser(String openid){
		String re = Mikoto.api.user.infoUser(openid);
		
		if(KuUtil.isResultSuccess(re)){
			User user = gson.fromJson(re, User.class);
			
			if(userDAO.update(user)>0){
				return true;
			}
			
			return false;
		}else{
			ErrResult er = gson.fromJson(re, ErrResult.class);
			return false;
		}
	}
	
	public boolean syncUserIdList(){
		String re = Mikoto.api.user.usersList(null);
		if(KuUtil.isResultSuccess(re)){
			userDAO.clean();
			UserList userList = gson.fromJson(re, UserList.class);
			List<String> openids = userList.getData().getOpenid();
			
			userDAO.insertOpenids(openids);
			if(!syncUsers(openids)){
				return false;
			}
			
			
			int time = userList.getTotal()/10000;
			
			for(int i = 0;i<time;i++){
				re = Mikoto.api.user.usersList(openids.get(openids.size()-1));
				if(!KuUtil.isResultSuccess(re)){
					return false;
				} else {
					userList = gson.fromJson(re, UserList.class);
					openids = userList.getData().getOpenid();
					userDAO.insertOpenids(openids);
					if(!syncUsers(openids)){
						return false;
					}
				}
			}
			return true;
		}else{
			ErrResult er = gson.fromJson(re, ErrResult.class);
			return false;
		}
	}
	
	/**
	 * ͬ������û���Ϣ.
	 * ����һ��openid���ϣ�Ȼ���������ͬ���û���Ϣ������
	 * @param openids openid����
	 * @return �Ƿ�ɹ�
	 */
	public boolean syncUsers(List<String> openids){
		for(String openid:openids){
			if(!syncUser(openid))
				return false;
		}
		return true;
	}
}
