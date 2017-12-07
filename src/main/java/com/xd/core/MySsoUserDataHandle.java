package com.xd.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sso.client.entity.SsoUser;
import com.sso.client.service.handle.SsoHandle;
import com.xd.model.User;
import com.xd.service.UserService;
import com.xd.util.GsonUtil;

public class MySsoUserDataHandle implements SsoHandle{
    
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService userService;
	@Override
	public boolean isExistUser(String username) {
		// TODO Auto-generated method stub
		logger.info("------回调是否存在用户username:{}", username);
		User user = userService.getUser(username);
		if(user == null){
			logger.info("------不存在是否存在用户username:{}", username);
			return false;
		}
		return true;
	}
 
	@Override
	public void synchUserInfo(SsoUser ssoUser) {
		// TODO Auto-generated method stub
		System.out.println("------这是回调同步用户数据："+GsonUtil.toJson(ssoUser));
		if(ssoUser == null){
			return;
		}
		
		User user = new User();
		user.setUsername(ssoUser.getUsername());
		user.setPhoneNumber(ssoUser.getUserPhone());
		user.setRecordTime(ssoUser.getRecordTime());
		user.setName(ssoUser.getName());
		user.setStatus(ssoUser.getStatus());
		userService.saveUser(user);
	}
	
	

}
