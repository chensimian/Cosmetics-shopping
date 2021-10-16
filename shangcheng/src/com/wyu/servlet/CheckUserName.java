package com.wyu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyu.bean.User;
import com.wyu.service.UserService;
import com.wyu.service.impl.UserServiceImpl;

@WebServlet("/checkUserName")
public class CheckUserName extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username =req.getParameter("username");
		UserService service = new UserServiceImpl();
		User user = service.checkName(username);
		int msg = 0;
		if(user!=null){
			msg = 1;
		}
		resp.getWriter().print(msg);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
