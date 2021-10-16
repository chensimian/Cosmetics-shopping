package com.wyu.filter;

import com.wyu.bean.User;
import com.wyu.service.UserService;
import com.wyu.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/*")
public class AutoLoginFilter implements Filter{

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String p = uri.substring(path.length()+1);
		if(!"userLogin".equals(p) || !p.contains("admin")){
			User u = (User)request.getSession().getAttribute("loginUser");
			if(u == null){
				String username = "";
				String password = "";
				Cookie[] cookies = request.getCookies();
				for(int i=0;cookies!=null && i<cookies.length;i++){
					if("autoUser".equals(cookies[i].getName())){
						String value = cookies[i].getValue();
						String[] s = value.split(":");
						username = s[0];
						password = s[1];
					}
				}
				UserService service = new UserServiceImpl();
				User user = service.checkName(username);
				if(user!=null){
					if(user.getPassword().equals(password)){
						request.getSession().setAttribute("loginUser", user);
						
					}
				}
			}
		}
		arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
