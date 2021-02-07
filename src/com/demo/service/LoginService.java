package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.demo.model.UserDao;
import com.demo.model.UserDaoImpl;
import com.demo.model.UserVO;

public class LoginService {
	UserDao dao = new UserDaoImpl();

	public List<String> validLogin(UserVO userVo) {
		List<String> err = new ArrayList<String>();
		if (StringUtils.isBlank(userVo.getAccount()) && StringUtils.isBlank(userVo.getPassword())) {
			err.add("請確實填寫");
			return err;
		}
		UserVO user = dao.LoginUser(userVo);
		if(user == null) {
			err.add("帳號密碼異常 查無使用者");
		}
		else {
			if(!"Y".equals(user.getStatus().trim())) {
				err.add(user.getAccount()+"尚未啟用");
			}
		}
		return err;
	}
}
