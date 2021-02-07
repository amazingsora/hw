package com.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.UserDao;
import com.demo.model.UserDaoImpl;
import com.demo.model.UserVO;
import com.demo.service.LoginService;
import com.demo.service.UserService;
@WebServlet("/userQuery")
public class UserQueryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();

	LoginService loginService = new LoginService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Map<String, String[]> map = req.getParameterMap();
		PrintWriter out = res.getWriter();
		// 封裝
		UserVO user = new UserVO(req);
		List<Map<String, Object>> userList = userService.fetchUserList(user);
		StringBuffer result = new StringBuffer(
				"<table>" + "<tr>" + "    <td>動作</td>" + "    <td>帳號<td>" + "    <td>名<td>" + "</tr>");
		for (Map<String, Object> data : userList) {
			result.append("<tr>" + "<th><button onclick=\"update('"+data.get("account")+"')\">修改</button><button onclick=\"del('"+data.get("account")+"')\">刪除</button><th>" + "<th>" + data.get("account")
					+ "<th>" + "<th>" + data.get("username") + "<th>");
		}
		result.append("</table>");
		out.print(result.toString());
	}

}
