package com.webrelax.autologin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webrelax.domain.User;
import com.webrelax.service.UserService;

/**
 * 自动登陆
 * 判断是否勾选了复选框，把用户名和密码保存到cookie
 * 下次用户再访问 home.jsp，先拦截取出用户名和密码，
 * 在执行登陆操作
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameterValues("username")[0];
		String password=request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user=new UserService().findUser(user);
		if(user!=null) {
			String autologin=request.getParameter("autologin");
			Cookie cookie=new Cookie("user",user.getUsername()+"&"+user.getPassword());
			cookie.setPath("/");
			if(autologin!=null) {//保存到cookie
				cookie.setMaxAge(60);//30s
			}else {//清除cookie
				cookie.setMaxAge(0);
			}
			//把cookie保存到客户端
			response.addCookie(cookie);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
		else {
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
