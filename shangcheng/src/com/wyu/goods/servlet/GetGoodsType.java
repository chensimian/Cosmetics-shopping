package com.wyu.goods.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyu.bean.GoodsType;
import com.wyu.service.GoodsService;
import com.wyu.service.impl.GoodsServiceImpl;

@WebServlet("/getGoodsType")
public class GetGoodsType extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String flag = req.getParameter("flag");
		GoodsService service = new GoodsServiceImpl();
		List<GoodsType> list = service.getGoodsTypeList();
		req.getSession().setAttribute("goodsTypeList", list);
		if("show".equals(flag)){
			resp.sendRedirect("admin/showGoodsType.jsp");
		}
		if("add".equals(flag)){
			resp.sendRedirect("admin/addGoodsType.jsp");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
