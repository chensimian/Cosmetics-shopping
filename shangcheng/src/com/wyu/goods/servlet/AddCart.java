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

@WebServlet("/addCart")
public class AddCart extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user!=null){
			String goodsId = req.getParameter("goodsId");
			String price = req.getParameter("price");
			if(StrUtils.empty(goodsId,price)){
				Cart cart = new Cart(user.getId(), Integer.parseInt(goodsId), 1, Integer.parseInt(price));
				CartService service = new CartServiceImpl();
				if(service.add(cart)){
					//Ìí¼Ó³É¹¦
					resp.sendRedirect("cartSuccess.jsp");
				}
			}else{
				resp.sendRedirect("index.jsp");
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
