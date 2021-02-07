package com.demo.model;

import java.util.List;
import java.util.Map;

public interface UserDao {
	void Demofind();

	UserVO LoginUser(UserVO userVo);

	List<Map<String, Object>> findUserList(UserVO userVo);

	List<Map<String, Object>> findUserList(UserVO userVo,String status);

	void changeStatus(String userid, String status);

	void insert(UserVO userVO);

	void update(String account, String username);

}
