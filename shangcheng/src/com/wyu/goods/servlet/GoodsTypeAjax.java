package com.wyu.goods.servlet;

import com.google.gson.Gson;
import com.wyu.service.GoodsService;
import com.wyu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodsTypeAjax")
public class GoodsTypeAjax extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		GoodsService service = new GoodsServiceImpl();
		//json ¸ñÊ½×Ö·û´®
		String json = new Gson().toJson(service.getGoodsTypeAjax());
		resp.getWriter().println(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
