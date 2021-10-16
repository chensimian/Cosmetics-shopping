package com.wyu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkCode")
public class CheckCode extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		//����������֤�� ��session �д洢��һ�� ���� 0 ��һ�·���1
		int res = 1;
		if(code.equalsIgnoreCase(req.getSession().getAttribute("acode").toString())){
			res = 0;
		}
		resp.getWriter().println(res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
