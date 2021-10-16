package com.wyu.goods.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyu.bean.User;
import com.wyu.service.CartService;
import com.wyu.service.impl.CartServiceImpl;

@WebServlet("/clearCart")
public class ClearCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("loginUser");
		int pid = Integer.parseInt(req.getParameter("pid"));
		if(user!=null){
			CartService service = new CartServiceImpl();
			if(service.delete(user.getId(),pid)){
				resp.sendRedirect("getCart");
			}else{
				System.out.println("É¾³ýÊ§°Ü");
			}
		}else{
			resp.sendRedirect("login.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
