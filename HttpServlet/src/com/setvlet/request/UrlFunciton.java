package com.setvlet.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UrlFunciton
 */
@WebServlet("/UrlFunciton")
public class UrlFunciton extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//比如请求的url为：http://localhost:8080/HttpServlet/UrlFunciton?name=123&val=88
		//获取请求方式：get
		System.out.println(request.getMethod());
		//完整url地址 http://localhost:8080/HttpServlet/UrlFunciton
		System.out.println(request.getRequestURL());
		//获取请求中资源名部分 /HttpServlet/UrlFunciton
		System.out.println(request.getRequestURI());
		//参数部分 name=123&val=88
		System.out.println(request.getQueryString());
		//当前应用的虚拟目录 /HttpServlet
		System.out.println(request.getContextPath());
		
		//获取请求消息头的信息
		String header=request.getHeader("User-Agent");//浏览器版本信息
		System.out.println(header);
		System.out.println("***********************");
		//获取所有请求消息头的name
		Enumeration<String> arr = request.getHeaderNames();
		while(arr.hasMoreElements())
		{
			String e=(String) arr.nextElement();
			System.out.println(e+":"+request.getHeader(e));
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
