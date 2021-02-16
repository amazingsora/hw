package com.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.demo.model.excelVO;

import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class UploadPicServlet
 */
@WebServlet("/uploadPic")
@MultipartConfig(location = "D://temp", fileSizeThreshold = 1024 * 100)
public class UploadPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadPicServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = (String) request.getParameter("action");
		System.out.println("action===" + action);
		if ("page".equals(action)) {
			RequestDispatcher sucessView = request.getRequestDispatcher("/upload/uploadPic.jsp");
			sucessView.forward(request, response);
			return;
		}
		Part file = request.getPart("file");
		System.out.println(file != null);
		if (file != null) {
			try(InputStream in =file.getInputStream();)  {
				RequestDispatcher sucessView = request.getRequestDispatcher("/upload/uploadPic.jsp");
				String pic = ToBase64(in);
				System.out.println(pic);
				request.setAttribute("Pic", pic);
				sucessView.forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String ToBase64(InputStream in) {
		byte[] data = null;
		try {
			data = new byte[in.available()];
			in.read(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new BASE64Encoder().encode(data);
	}

}
