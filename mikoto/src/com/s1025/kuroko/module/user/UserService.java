package com.s1025.kuroko.module.user;

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
	
	/**
	 * 创建一个新的用户分组.
	 * 同时将写入数据库中，用户数默认为0。
	 * @param name 分组名，最多30个字
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
	 * 删除分组，用户会进入默认分组.
	 * 同时从数据库中删除,并将用户移入默认组，修改默认组人数。
	 * @param id 要删除的分组id
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
	 * 更改分组名.
	 * 同时写入数据库。
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
	 * 更改用户所在分组.
	 * 同时更改数据库信息，更改用户的groupid和两个分组的人数。
	 * @param openid 用户的openid
	 * @param groupid 新分组的id
	 * @return
	 */
	public Result<Group> changeUserGroup(String openid, int groupid){
		User user = userDAO.select(openid);
		Group group = groupDAO.select(groupid);
		Group ogroup = groupDAO.select(user.getGroupid());
		Result<Group> re = new Result<Group>();
		re.setErrCode(-1);
		re.setErrMsg("未知错误");
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
	 * 获取所有分组.
	 * 从数据库中直接获得。
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
	 * 同步单个用户信息.
	 * 对单个用户的信息进行同步，将拉取用户信息到数据库中。
	 * @param openid 用户openid
	 * @return 是否成功
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
	 * 同步所有用户信息.
	 * 拉取所有用户的openid，并委托其他函数进行信息拉取。
	 * @return 是否同步成功
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
	 * 同步多个用户信息.
	 * 接受一个openid集合，然后逐个调用同步用户信息函数。
	 * @param openids openid集合
	 * @return 是否成功
	 */
	public boolean syncUsers(List<String> openids){
		for(String openid:openids){
			if(!syncUser(openid))
				return false;
		}
		return true;
	}
	
	/**
	 * 同步所有分组信息.
	 * @return 同步是否成功
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
