package com.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.model.UserVO;
import com.demo.service.LoginService;
import com.demo.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginService loginService = new LoginService();
	UserService userService = new UserService();
	public static Map<String, HttpSession> userSession = new HashMap<String, HttpSession>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		Map<String, String[]> map = req.getParameterMap();
		if (req.getSession().getAttribute("login") != null) {
			res.sendRedirect(req.getContextPath() + "/homePage.jsp");
			return;
		}
		// 封裝
		if (map.size() > 0) {
			UserVO user = new UserVO(req);
			List<String> err = new ArrayList<String>();
			err = loginService.validLogin(user);
			if (err.size() > 0) {
				RequestDispatcher failView = req.getRequestDispatcher("/login/login.jsp");
				req.setAttribute("err", err.get(0));
				failView.forward(req, res);
				return;
			} else {
				List<Map<String, Object>> loginmap = userService.fetchUserList(user);
				System.out.println(loginmap);
				removeUser((String) loginmap.get(0).get("username"));
				req.getSession().setAttribute("login", loginmap.get(0).get("username"));
				userSession.put((String) loginmap.get(0).get("username"), req.getSession());
				res.sendRedirect(req.getContextPath() + "/homePage.jsp");
				System.out.println("userSession"+userSession);
				return;
			}
		} else {
			RequestDispatcher failView = req.getRequestDispatcher("/login/login.jsp");
			failView.forward(req, res);

			return;
		}

	}

	private void removeUser(String user) {
		if (userSession.containsKey(user))
			userSession.get(user).invalidate();
	}

}
