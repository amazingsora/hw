package com.demo.model;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class UserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String account;
	private String password;
	private String status;
	private String username;
	private String note;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public UserVO(HttpServletRequest req) {

		try {
			Map<String, String[]> map = req.getParameterMap();
			for (Map.Entry<String, String[]> data : map.entrySet()) {
				String name = data.getKey();
				String[] value = data.getValue();
				PropertyDescriptor pd = new PropertyDescriptor(name, UserVO.class);
				Method setter = pd.getWriteMethod();
				// 判斷參數數量
				if (value.length == 1) {
					setter.invoke(this, value[0]);
				} else {
					setter.invoke(this, (Object) value);
				}
			}
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	
	public UserVO() {
		super();
	}

	@Override
	public String toString() {
		return "UserVO [account=" + account + ", password=" + password + ", status=" + status + ", username=" + username
				+ ", note=" + note + "]";
	}
}
