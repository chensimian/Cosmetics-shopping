package com.wyu.goods.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyu.bean.Goods;
import com.wyu.service.GoodsService;
import com.wyu.service.impl.GoodsServiceImpl;

@WebServlet("/getGoodsList")
public class GetGoodsList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		GoodsService service = new GoodsServiceImpl();
		List<Goods> list = service.getGoodsList();
		req.getSession().setAttribute("goodsList", list);
		resp.sendRedirect("admin/showGoods.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
