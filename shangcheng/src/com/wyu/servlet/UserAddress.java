package com.wyu.servlet;

import com.wyu.bean.Address;
import com.wyu.bean.User;
import com.wyu.service.UserService;
import com.wyu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userAddress")
public class UserAddress extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String flag = req.getParameter("flag");
		User loginUser = (User)req.getSession().getAttribute("loginUser");
		
		System.out.println(loginUser.getId());
		UserService service = new UserServiceImpl();
		if("default".equals(flag)){
			String addressId = req.getParameter("id");
			System.out.println("addressId+++"+addressId);
			System.out.println("userId===="+loginUser.getId());
			if(service.defaultAddress(Integer.parseInt(addressId), loginUser.getId())){
				flag = "show";
			}
		}
		if("update".equals(flag)){
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			String detail = req.getParameter("detail");
			String id = req.getParameter("id");
			String level = req.getParameter("level");
			Address address = new Address(detail, name, phone, loginUser.getId(), Integer.parseInt(level));
			address.setId(Integer.parseInt(id));
			if(service.updateAddress(address)){
				flag = "show";
			}
			
		}
		if("delete".equals(flag)){
			System.out.println("delete:::"+loginUser.getId());
			String id = req.getParameter("id");
			if(service.deleteAddress(Integer.parseInt(id))){
				
				req.getRequestDispatcher("userAddress?flag=show").forward(req, resp);
			}else{
				System.out.println("error");
			}
		}
		if("add".equals(flag)){
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			String detail = req.getParameter("detail");
			String uid = req.getParameter("uid");
			//等级 默认是0
			Address address = new Address(detail, name, phone, Integer.parseInt(uid), 0);
			boolean b = service.addAddress(address);
			if(b){
				flag = "show";
			}else{
				System.out.println("error");
			}
		}
		if("show".equals(flag)){
			System.out.println("show:::"+loginUser.getId());
			List<Address> list = service.getAddressList(loginUser.getId());
			if(list!=null){
				req.getSession().setAttribute("addList", list);
			}
			resp.sendRedirect("self_info.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
