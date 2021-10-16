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
			//�Զ���¼ ������� ��Ϊ cookie�д洢������ �Ǽ��ܹ���
			//��������Զ���¼ ��Ҫ ��������� MD5����ת�� ���ܺ� User�е��������ƥ��
			if(user.getPassword().equals(password)){
				//�ж� �Ƿ�ѡ�������Զ���¼
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
				msg = " ���� ��ƥ��";
			}
		}else{
			msg = "�û���  ��ƥ��";
		}
		if(msg.length()==0){
			//��¼�ɹ�
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
