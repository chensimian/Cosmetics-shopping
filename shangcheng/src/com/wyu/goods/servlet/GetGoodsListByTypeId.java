package com.wyu.goods.servlet;

import com.wyu.bean.Goods;
import com.wyu.service.GoodsService;
import com.wyu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getGoodsListByTypeId")
public class GetGoodsListByTypeId extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String typeid = req.getParameter("typeid");
		GoodsService service = new GoodsServiceImpl();
		List<Goods> list = service.getGoodsListByTypeId(Integer.parseInt(typeid));
		if(list!=null){
			req.getSession().setAttribute("glist", list);
			resp.sendRedirect("list.jsp");
		}else{
			System.out.println("没找到商品");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
