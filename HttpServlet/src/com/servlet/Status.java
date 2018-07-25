package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Status
 */
@WebServlet("/Status")
public class Status extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("hello 你好");
	
		//先告诉浏览器重定向，然后通过头部设置Url
		response.setStatus(302);
		response.setHeader("location", "/HttpServlet/login.html");
	
		//请求转发能够传递数据，重定向不能
		//重定向相当于告诉客户端新地址重新发起请求。
		//相当于上面两句话
		response.sendRedirect("/HttpServlet/login.html");
		//服务端设置头部相应给浏览器，浏览器收到后，才跳转，所以下面的语句会输出内容
		//输出顺序："hello 你好"->"hello 杰瑞"->login.html
		//虽然，重定向到该网址后不会回来，服务器就不管浏览器转不转发。
		System.out.println("hello 杰瑞");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
