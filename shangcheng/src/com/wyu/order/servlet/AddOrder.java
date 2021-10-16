package com.wyu.order.servlet;

import com.wyu.bean.BuyGoods;
import com.wyu.bean.Order;
import com.wyu.bean.User;
import com.wyu.service.OrderService;
import com.wyu.service.impl.CartServiceImpl;
import com.wyu.service.impl.OrderServiceImpl;
import com.wyu.utils.RandomUtils;
import com.wyu.utils.StrUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addOrder")
public class AddOrder extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user!=null){
			String aid = req.getParameter("aid");//获取前端传过来的address id
			if(StrUtils.empty(aid)){
				//生成订单
				//获取指定用户的购物车信息
				List<BuyGoods> cartList = new CartServiceImpl().getAll(user.getId());
				//计算总金额
				int money = 0;
				for(BuyGoods bg : cartList){
					money +=bg.getMoney(); //获取单价 计算总金额
				}
				//status 1:未支付 2:已支付代发货 3:已发货待收货 4:订单完成
				//创建订单 封装对象
				Order order = new Order(RandomUtils.createOrderId(), user.getId(), money, "1", null, Integer.parseInt(aid));
				OrderService service = new OrderServiceImpl();
				boolean flag = service.addOrder(order, cartList);
				if(flag){
					resp.sendRedirect("getOrderList");
				}else{
					System.out.println("生成订单失败");
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
