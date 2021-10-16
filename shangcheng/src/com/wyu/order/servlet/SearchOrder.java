package com.wyu.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyu.bean.Order;
import com.wyu.service.impl.OrderServiceImpl;

@WebServlet("/searchOrder")
public class SearchOrder extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username =req.getParameter("username");
		String status =req.getParameter("status");
		System.out.println("yonghuming::"+username+"status"+status);
		if("".equals(username) && "".equals(status)){
			resp.sendRedirect("getAllOrder");
		}else{
			System.out.println("yonghuming:"+username+"status"+status);
			List<Order> list = new ArrayList<>();
			for(Order o : new OrderServiceImpl().getAllOrder()){
				if(username.equals(o.getUsername()) || status.equals(o.getStatus())){
					list.add(o);
				}
			}
			req.getSession().setAttribute("orderList", list);
			resp.sendRedirect("admin/showAllOrder.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
