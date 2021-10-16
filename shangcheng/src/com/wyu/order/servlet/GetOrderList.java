package com.wyu.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyu.bean.Order;
import com.wyu.bean.User;
import com.wyu.service.OrderService;
import com.wyu.service.impl.OrderServiceImpl;

@WebServlet("/getOrderList")
public class GetOrderList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user!=null){
			OrderService service = new OrderServiceImpl();
			List<Order> list = service.getOrderList(user.getId());
			req.getSession().setAttribute("orderList", list);
			resp.sendRedirect("orderList.jsp");
		}else{
			resp.sendRedirect("login.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
