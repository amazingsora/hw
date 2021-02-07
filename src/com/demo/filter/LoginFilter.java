package com.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

public class LoginFilter implements Filter {
	private String excludedPages;
	private String[] excludedPageArray;

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		// 排除
		boolean isExcludedPage = false;
		for (String page : excludedPageArray) {// 判斷是否在過濾url之外
			if (request.getServletPath().equals(page)) {
				isExcludedPage = true;
				break;
			}
		}

		if (session.getAttribute("login") != null) {
			chain.doFilter(request, response);
			return;
		} else {
			if (isExcludedPage) {// 在過濾url之外
				chain.doFilter(request, response);
				return;
			}
			response.sendRedirect(request.getContextPath() + "/login");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		excludedPages = fConfig.getInitParameter("excludedPages");
		if (StringUtils.isNotEmpty(excludedPages)) {
			excludedPageArray = excludedPages.split(",");
		}
		return;
	}
}
