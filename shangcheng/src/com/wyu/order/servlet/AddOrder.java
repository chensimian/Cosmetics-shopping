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
			String aid = req.getParameter("aid");//��ȡǰ�˴�������address id
			if(StrUtils.empty(aid)){
				//���ɶ���
				//��ȡָ���û��Ĺ��ﳵ��Ϣ
				List<BuyGoods> cartList = new CartServiceImpl().getAll(user.getId());
				//�����ܽ��
				int money = 0;
				for(BuyGoods bg : cartList){
					money +=bg.getMoney(); //��ȡ���� �����ܽ��
				}
				//status 1:δ֧�� 2:��֧�������� 3:�ѷ������ջ� 4:�������
				//�������� ��װ����
				Order order = new Order(RandomUtils.createOrderId(), user.getId(), money, "1", null, Integer.parseInt(aid));
				OrderService service = new OrderServiceImpl();
				boolean flag = service.addOrder(order, cartList);
				if(flag){
					resp.sendRedirect("getOrderList");
				}else{
					System.out.println("���ɶ���ʧ��");
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
