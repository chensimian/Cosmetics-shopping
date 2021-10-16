package com.wyu.goods.servlet;

import com.wyu.bean.Goods;
import com.wyu.service.GoodsService;
import com.wyu.service.impl.GoodsServiceImpl;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/getGoodsById")
public class GetGoodsById extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		GoodsService service = new GoodsServiceImpl();
		List id1 = change(id); //这里产生随机搭配
		Goods goods = service.getGoodsById(Integer.parseInt(id));
		Goods goods1=service.getGoodsById((Integer) id1.get(1));
		Goods goods2=service.getGoodsById((Integer) id1.get(2));
		Goods goods3=service.getGoodsById((Integer) id1.get(3));
		Goods goods4=service.getGoodsById((Integer) id1.get(4));
		Goods goods5=service.getGoodsById((Integer) id1.get(5));
		if (goods != null) {
			req.getSession().setAttribute("goods", goods);
			req.getSession().setAttribute("goods1", goods1);
			req.getSession().setAttribute("goods2", goods2);
			req.getSession().setAttribute("goods3", goods3);
			req.getSession().setAttribute("goods4", goods4);
			req.getSession().setAttribute("goods5", goods5);
			resp.sendRedirect("goods.jsp");
		} else {
			System.out.println("goods 没找到");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	//	int random=new Random().nextInt(10);
	public List change(String s) {
		int a;//十位数
		int b;//个位数
		int c = Integer.parseInt(s); //传进来的数
		b = c / 10;
		a = c % 10;
		System.out.println("a"+a);
		System.out.println("b"+b);
		int k[] = {a, b};
		// 创建Random对象
		Random r = new Random();
		List list=new ArrayList();
		list.add(c);
		if(c==10||c==20||c==30||c==40)
		{
			b=b-1;
		}
		while (true){
			int random=new Random().nextInt(10)+b*10+1;
			if(list.contains(random))
				continue;
			list.add(random);
			if (list.size()==6) //摇五个数
				break;
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;

	}
	@Test
	public void ta(){
		GetGoodsById a=new GetGoodsById();
		List change = a.change("40");
	}

}