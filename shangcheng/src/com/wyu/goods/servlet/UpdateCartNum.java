package com.wyu.goods.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyu.bean.Cart;
import com.wyu.bean.User;
import com.wyu.service.CartService;
import com.wyu.service.impl.CartServiceImpl;
import com.wyu.utils.StrUtils;

@WebServlet("/updateCartNum")
public class UpdateCartNum extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user!=null){
			String pid = req.getParameter("pid");
			String num = req.getParameter("num");
			String price = req.getParameter("price");
			if(StrUtils.empty(pid,num,price)){
				CartService service = new CartServiceImpl();
				int n = Integer.parseInt(num);
				if(n!=0){//ÐÞ¸Ä
					service.update(new Cart(user.getId(), Integer.parseInt(pid), Integer.parseInt(num), Integer.parseInt(price)));
				}else{//É¾³ý
					service.delete(user.getId(), Integer.parseInt(pid));
				}
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
