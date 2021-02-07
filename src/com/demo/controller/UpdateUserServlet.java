package com.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.demo.model.UserDao;
import com.demo.model.UserDaoImpl;
import com.demo.model.UserVO;
import com.demo.service.UserService;

@WebServlet("/update")

public class UpdateUserServlet extends HttpServlet {

	List<String> errList = null;

	UserService userService = new UserService();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		errList = new ArrayList<String>();
		String action = "";
		action = req.getParameter("action");
		UserVO userVO = new UserVO();
		userVO.setAccount(req.getParameter("account"));
		userVO.setPassword(req.getParameter("password"));
		userVO.setUsername(req.getParameter("username"));
		PrintWriter out = res.getWriter();

		if (StringUtils.equals("del", action)) {

			userService.del(userVO);
			List<Map<String, Object>> userList = userService.fetchUserList(new UserVO());
			StringBuffer result = new StringBuffer(
					"<table>" + "<tr>" + "    <td>動作</td>" + "    <td>帳號<td>" + "    <td>名<td>" + "</tr>");
			for (Map<String, Object> data : userList) {
				result.append("<tr>" + "<th><button onclick=\"update('" + data.get("account")
						+ "')\">修改</button><button onclick=\"del('" + data.get("account") + "')\">刪除</button><th>"
						+ "<th>" + data.get("account") + "<th>" + "<th>" + data.get("username") + "<th>");
			}
			result.append("</table>");
			out.print(result.toString());
			return;
		}

		if (StringUtils.equals("add", action)) {

			vildvalue(userVO);
			if (errList.size() > 0) {
				req.setAttribute("err", errList.get(0));
				req.setAttribute("updateVO", userVO);
				RequestDispatcher successView = req.getRequestDispatcher("user/userDetail.jsp");
				successView.forward(req, res);

				return;
			}
			UserVO checkuser = new UserVO();
			checkuser.setAccount(req.getParameter("account"));
			List<Map<String, Object>> userList = userService.fetchAllUserList(checkuser);
			if (userList != null && userList.size() > 0) {
				req.setAttribute("err", "此帳號已存在");
				req.setAttribute("updateVO", userVO);
				RequestDispatcher successView = req.getRequestDispatcher("user/userDetail.jsp");
				successView.forward(req, res);
				return;
			} else {
				// 開始更新
				userService.insertUser(userVO);
				RequestDispatcher successView = req.getRequestDispatcher("user/userQuery.jsp");
				successView.forward(req, res);
				return;
			}

		}

		if (StringUtils.equals("update", action)) {
			if ( StringUtils.isBlank(userVO.getUsername())) {
				errList.add("腳色姓名不得為空");
			}
			if (errList.size() > 0) {
				req.setAttribute("err", errList.get(0));
				req.setAttribute("action", action);
				req.setAttribute("updateVO", userVO);
				RequestDispatcher successView = req.getRequestDispatcher("user/userDetail.jsp");
				successView.forward(req, res);
				return;
			}
			else {
				userService.updateUser(userVO);
				RequestDispatcher successView = req.getRequestDispatcher("user/userQuery.jsp");
				successView.forward(req, res);
				return;
			}
		}

	}

	private void vildvalue(UserVO userVO) {
		String account = userVO.getAccount();
		String password = userVO.getPassword();
		String username = userVO.getUsername();
		if (StringUtils.isBlank(account) || StringUtils.isBlank(password) || StringUtils.isBlank(username)) {
			errList.add("請確實填寫");
		}
	}
}
