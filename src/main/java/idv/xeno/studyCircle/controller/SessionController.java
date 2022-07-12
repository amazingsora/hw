package idv.xeno.studyCircle.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.xeno.studyCircle.model.dto.SessionDTO;

@Controller
public class SessionController {
	private String sessionId ;

	final static String MAIN = "jsp/sc/main";

	@RequestMapping(value = "/sc/main")
	public String main(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session =  request.getSession(true);

	
		sessionId = session.getId();
		if(org.jooq.tools.StringUtils.isBlank(sessionId)) {
			System.out.println("SESSION為空");
			request.getSession(true);
			sessionId = session.getId();

		}
		System.out.println(sessionId);
		System.out.println(request.getSession().getAttribute("color"));
		request.getSession().setAttribute("sessionId", sessionId);
		request.getSession().setAttribute("t", "tttttttt");

		

		return MAIN;
		
	}
	
	@PostMapping(value = "/sc/setSession")
	public String setSession(SessionDTO data,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("id ===>"+data.getId());
		HttpSession session =  request.getSession();
		Cookie cookie = new Cookie("JSESSIONID",data.getId().trim());		
		cookie.setMaxAge(session.getMaxInactiveInterval());
		cookie.setPath(session.getServletContext().getContextPath());

		response.addCookie(cookie);
		return "redirect:" + "/sc/main";
		
	}
	
	@PostMapping(value = "/sc/setColor")
	public String setBlue(String color,HttpServletRequest request,HttpServletResponse response) {
		HttpSession session =  request.getSession();

		System.out.println("color ==="+color);
		request.getSession().setAttribute("color", color);
		return main(request,response);
		
	}
	
	

	
	
	

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
