package com.wyu.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wyu.bean.User;
import com.wyu.service.UserService;
import com.wyu.service.impl.UserServiceImpl;

@WebServlet("/getUserList")
public class GetUserList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		UserService service = new UserServiceImpl();
		List<User> list = service.getUserList();
		//将list集合 转换成 json格式字符串
		String json = new Gson().toJson(list);
		resp.getWriter().print(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
