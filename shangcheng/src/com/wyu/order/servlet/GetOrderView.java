package com.wyu.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyu.bean.Address;
import com.wyu.bean.BuyGoods;
import com.wyu.bean.User;
import com.wyu.service.impl.CartServiceImpl;
import com.wyu.service.impl.UserServiceImpl;

@WebServlet("/getOrderView")
public class GetOrderView extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user!=null){
			//根据userid 获取 购物车
			List<BuyGoods> cartList = new CartServiceImpl().getAll(user.getId());
			//根据userid 获取 地址信息
			List<Address> addressList = new UserServiceImpl().getAddressList(user.getId());
			req.setAttribute("cartList", cartList);
			req.setAttribute("addList", addressList);
			req.getRequestDispatcher("order.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("login.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
