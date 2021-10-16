package com.wyu.order.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyu.bean.Order;
import com.wyu.service.OrderService;
import com.wyu.service.impl.OrderServiceImpl;

@WebServlet("/getAllOrder")
public class GetAllOrder extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderService service = new OrderServiceImpl();
		List<Order> list = service.getAllOrder();
		req.getSession().setAttribute("orderList", list);
		resp.sendRedirect("admin/showAllOrder.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
