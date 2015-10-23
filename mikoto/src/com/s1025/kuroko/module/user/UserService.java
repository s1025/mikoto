package com.s1025.kuroko.module.user;

import java.util.List;

import com.google.gson.Gson;
import com.s1025.kuroko.module.ErrResult;
import com.s1025.kuroko.module.KuUtil;
import com.s1025.kuroko.module.Result;
import com.s1025.mikoto.Mikoto;

/**
 * �û�����.
 * �����еĺ�������û��Լ�������й���
 * sync��ͷ�ĺ���������ȡ΢�ŷ����������ݵ��������ݿ⣬�����ʼ����ʱ����ȡһ�Σ�һ�㷵��һ������ֵ��
 * get��ͷ�ĺ���Ϊֱ�������ݿ��л�ȡ����,һ��᷵��Result<User> �� Result<Group> ����
 * �����󲿷ֺ�����ͬʱ����΢�źͱ�������,һ��᷵��Result<User> �� Result<Group> ����
 * @author fkxpjj
 *
 */
public class UserService {
	
	Gson gson = new Gson();
	GroupDAO groupDAO = new GroupDAOimpl();
	UserDAO userDAO = new UserDAOimpl();
	
	/**
	 * ����һ���µ��û�����.
	 * ͬʱ��д�����ݿ��У��û���Ĭ��Ϊ0��
	 * @param name �����������30����
	 * @return
	 */
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
	
	/**
	 * ɾ�����飬�û������Ĭ�Ϸ���.
	 * ͬʱ�����ݿ���ɾ��,�����û�����Ĭ���飬�޸�Ĭ����������
	 * @param id Ҫɾ���ķ���id
	 * @return
	 */
	public Result<Group> deleteGroup(int id){
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
	
	/**
	 * ���ķ�����.
	 * ͬʱд�����ݿ⡣
	 * @param id
	 * @param name
	 * @return
	 */
	public Result<Group> changeGroupName(int id, String name){
		String re = Mikoto.api.group.updateGroup(id, name);
		
		ErrResult er = gson.fromJson(re, ErrResult.class);
		
		if(er.getErrcode().equals("0")){
			groupDAO.updateName(id, name);
		}
		
		Result<Group> rs = new Result<Group>(er);
		return rs;
	}
	
	/**
	 * �����û����ڷ���.
	 * ͬʱ�������ݿ���Ϣ�������û���groupid�����������������
	 * @param openid �û���openid
	 * @param groupid �·����id
	 * @return
	 */
	public Result<Group> changeUserGroup(String openid, int groupid){
		User user = userDAO.select(openid);
		Group group = groupDAO.select(groupid);
		Group ogroup = groupDAO.select(user.getGroupid());
		Result<Group> re = new Result<Group>();
		re.setErrCode(-1);
		re.setErrMsg("δ֪����");
		if(!group.getName().equals("")){
			String json = Mikoto.api.group.updateGroup(openid, groupid);
			if(KuUtil.isResultSuccess(json)){
				user.setGroupid(groupid);
				group.setCount(group.getCount()+1);
				ogroup.setCount(ogroup.getCount()-1);
				userDAO.update(user);
				groupDAO.update(group);
				groupDAO.update(ogroup);
				re.setErrCode(0);
				re.setErrMsg("ok");
			}
		}
		return re;
	}
	
	/**
	 * �޸��û���ע.
	 * ͬʱ����Ϣд�����ݿ⡣
	 * @param openid Ҫ�޸ĵ��û���id
	 * @param remark ��ע
	 * @return
	 */
	public Result<User> changeUserRemark(String openid, String remark){
		String re = Mikoto.api.user.updateUser(openid, remark);
		if(KuUtil.isResultSuccess(re)){
			userDAO.updateUserRemark(openid, remark);
		}
		ErrResult er = gson.fromJson(re, ErrResult.class);
		Result<User> rs = new Result<User>(er);
		return rs;
	}
	
	/**
	 * ��ȡ���з���.
	 * �����ݿ���ֱ�ӻ�á�
	 * @return
	 */
	public Result<Group> getAllGroup(){
		List<Group> groups = groupDAO.select();
		Result<Group> re = new Result<Group>(groups);
		re.setErrCode(0);
		re.setErrMsg("ok");
		return re;
	}
	
	/**
	 * ��ȡ�����û���Ϣ.
	 * @param openid �û�id
	 * @return
	 */
	public Result<User> getUser(String openid){
		User user = userDAO.select(openid);
		Result<User> re = new Result<User>(user);
		if(!(user.getOpenid()==null)){
			re.setErrCode(0);
			re.setErrMsg("ok");
		} else {
			re.setErrCode(-1);
			re.setErrMsg("���ݿ��ȡʧ��");
		}
		return re;
	}
	
	/**
	 * ��ȡĳһ��������������Ϣ.
	 * @param groupid ����id
	 * @return
	 */
	public Result<User> getGroupUsers(int groupid){
		List<User> users = userDAO.selectGroupUsers(groupid);
		Result<User> re = new Result<User> (users);
		if(users.size()>0){
			re.setErrCode(0);
			re.setErrMsg("ok");
		} else {
			re.setErrCode(-1);
			re.setErrMsg("���ݿ��ȡʧ��");
		}
		return re;
	}
	
	/**
	 * ��÷�ҳ�û�.
	 * ע����ͬһҳ����ÿҳ������Ҫ�ı䣬ֻ�ı�ҳ�������ˡ�
	 * @param page ҳ��
	 * @param row ÿҳ����
	 * @return
	 */
	public Result<User> getPageUsers(int page, int row){
		int offset = (page-1)*row;
		List<User> users = userDAO.selectPageUsers(offset, row);
		Result<User> re = new Result<User> (users);
		if(users.size()>0){
			re.setErrCode(0);
			re.setErrMsg("ok");
		} else {
			re.setErrCode(-1);
			re.setErrMsg("���ݿ��ȡʧ��");
		}
		return re;
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
			return false;
		}
	}
	
	/**
	 * ͬ�������û���Ϣ.
	 * ��ȡ�����û���openid����ί����������������Ϣ��ȡ��
	 * @return �Ƿ�ͬ���ɹ�
	 */
	public boolean syncAllUsers(){
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
	
	/**
	 * ͬ�����з�����Ϣ.
	 * @return ͬ���Ƿ�ɹ�
	 */
	public boolean syncAllGroups(){
		String re = Mikoto.api.group.getGroup();
		
		if(KuUtil.isResultSuccess(re)){
			Groups groups = gson.fromJson(re, Groups.class);
			
			List<Group> list = groups.getGroups();
			groupDAO.clean();
			for(Group group:list){
				if(groupDAO.insert(group)<1){
					return false;
				}
			}
			
			return true;
		}else{
			return false;
		}
	}
}
