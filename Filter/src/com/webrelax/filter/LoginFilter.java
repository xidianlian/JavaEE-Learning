package com.webrelax.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webrelax.domain.User;
import com.webrelax.service.UserService;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="MyFilter1",urlPatterns="/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		//先判断下是否需要在登陆页面
		String uri=req.getRequestURI();//  /Filter/login.jsp
		String path=req.getContextPath();// /Filter
		path=uri.substring(path.length());
		if(!"/login.jsp".equals(path)){
			//如果访问其他页面，就不必再自动登陆了，直接看session里的值
			User user1=(User)req.getSession().getAttribute("user");
			if(user1==null) {
				//得到cookies数组
				Cookie[] cookies=req.getCookies();
				Cookie cook=null;
				UserService us=new UserService();
				User user=new User();
			
				for(int i=0;cookies!=null&&i<cookies.length;i++) {
					if("user".equals(cookies[i].getName())) {
						cook=cookies[i];
						String value=cook.getValue();//tom&123
						String[] values=value.split("&");
						String username=values[0];
						String password=values[1];
						user.setUsername(username);
						user.setPassword(password);
					}
				}
				user=us.findUser(user);
				//如果登陆成功，把用户信息存到session
				if(user!=null) {
					req.getSession().setAttribute("user", user);
				}
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
