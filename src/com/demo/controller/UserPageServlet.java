package com.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.demo.model.UserVO;
import com.demo.service.UserService;

@WebServlet("/userAction")
public class UserPageServlet extends HttpServlet {

	UserService userService = new UserService();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = "";
		action = req.getParameter("action");
		UserVO userVO = new UserVO();
		userVO.setAccount(req.getParameter("account"));
		userVO.setPassword(req.getParameter("password"));
		userVO.setUsername(req.getParameter("username"));

		if (StringUtils.equals("add", action)) {
			RequestDispatcher successView = req.getRequestDispatcher("/user/userDetail.jsp");
			successView.forward(req, res);
			return;
		}

		if (StringUtils.equals("update", action)) {
			RequestDispatcher successView = req.getRequestDispatcher("/user/userDetail.jsp");
			List<Map<String, Object>> userList = userService.fetchUserList(userVO);
			req.setAttribute("updateVO", userList.get(0));
			req.setAttribute("action", action);

			successView.forward(req, res);
			return;

		}

	}
}
