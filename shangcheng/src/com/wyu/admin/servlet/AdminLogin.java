package com.wyu.admin.servlet;

import com.wyu.bean.User;
import com.wyu.service.UserService;
import com.wyu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String url = "admin/login.jsp";
		if(username.length()>0 && password.length()>0){
			UserService service = new UserServiceImpl();
			User user = service.findAdmin(username);
			if(user!=null){
				if(user.getPassword().equals(password)){
					req.getSession().setAttribute("admin", username);
					url = "admin/admin.jsp";
				}
			}
		}
		resp.sendRedirect(url);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
