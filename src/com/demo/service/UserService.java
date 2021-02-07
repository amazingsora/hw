package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.model.UserDao;
import com.demo.model.UserDaoImpl;
import com.demo.model.UserVO;

public class UserService {
	UserDao dao = new UserDaoImpl();

	public List<Map<String, Object>> fetchUserList(UserVO userVo) {

		return dao.findUserList(userVo);
	}
	public List<Map<String, Object>> fetchAllUserList(UserVO userVo) {

		return dao.findUserList(userVo,null);
	}
	public void del(UserVO userVO) {
		dao.changeStatus(userVO.getAccount(), "N");
	}

	public void insertUser(UserVO userVO) {
		userVO.setStatus("Y");
		userVO.setNote("手動新增");
		dao.insert(userVO);
	}

	public void updateUser(UserVO userVO) {
		dao.update(userVO.getAccount(), userVO.getUsername());
	}
}
