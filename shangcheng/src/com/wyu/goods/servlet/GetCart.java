package com.wyu.goods.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyu.bean.BuyGoods;
import com.wyu.bean.User;
import com.wyu.service.CartService;
import com.wyu.service.impl.CartServiceImpl;

@WebServlet("/getCart")
public class GetCart extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user!=null){
			CartService service = new CartServiceImpl();
			List<BuyGoods> list = service.getAll(user.getId());
			if(list!=null){
				req.getSession().setAttribute("carts", list);
			}else{
				System.out.println("没有找到购物车");
			}
			req.getRequestDispatcher("cart.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("login.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
