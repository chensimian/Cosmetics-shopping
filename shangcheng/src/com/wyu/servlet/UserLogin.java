package com.wyu.servlet;

import com.wyu.bean.User;
import com.wyu.service.UserService;
import com.wyu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String msg = "";
		
		
		UserService service = new UserServiceImpl();
		User user = service.checkName(username);
		if(user!=null){
			//自动登录 无需加密 因为 cookie中存储的密码 是加密过的
			//如果不是自动登录 需要 对密码进行 MD5加密转换 才能和 User中的密码进行匹配
			if(user.getPassword().equals(password)){
				//判断 是否选中两周自动登录
				String auto = req.getParameter("auto");
				if(auto !=null){
					Cookie[] cookies = req.getCookies();
					boolean r = false;
					for(Cookie c : cookies){
						if("autoUser".equals(c.getName())){
							r = true;
							break;
						}
					}
					if(!r){
						Cookie cookie = new Cookie("autoUser", user.getUsername()+":"+user.getPassword());
						cookie.setPath("/");
						cookie.setMaxAge(14*24*60*60);
						resp.addCookie(cookie);
					}
				}
			}else{
				msg = " 密码 不匹配";
			}
		}else{
			msg = "用户名  不匹配";
		}
		if(msg.length()==0){
			//登录成功
			req.getSession().setAttribute("loginUser", user);
			resp.sendRedirect("index.jsp");
		}else{
			req.getSession().setAttribute("msg", msg);
			resp.sendRedirect("login.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
