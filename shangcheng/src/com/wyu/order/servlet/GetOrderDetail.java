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
import com.wyu.bean.Order;
import com.wyu.bean.OrderDetail;
import com.wyu.bean.User;
import com.wyu.service.impl.OrderServiceImpl;
import com.wyu.service.impl.UserServiceImpl;
import com.wyu.utils.StrUtils;

@WebServlet("/getOrderDetail")
public class GetOrderDetail extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user!=null){
			String oid = req.getParameter("oid");//订单编号
			if(StrUtils.empty(oid)){
				//获取订单 order 根据订单编号 获取订单 
				Order order = new OrderServiceImpl().getSingle(oid);
				//获取地址 根据order id - aid - address表中获取 信息
				Address address = new UserServiceImpl().getSingle(order.getAid());
				//获取订单详情 -->商品信息
				List<BuyGoods> list = new OrderServiceImpl().getOrderDetail(oid);
				OrderDetail od = new OrderDetail(order, address, list);
				req.getSession().setAttribute("od", od);
				resp.sendRedirect("orderDetail.jsp");
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
