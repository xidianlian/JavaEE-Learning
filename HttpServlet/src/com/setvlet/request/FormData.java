package com.setvlet.request;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormData
 */
@WebServlet("/FormData")
public class FormData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//告诉服务器用什么编码，主要看浏览器使用的什么编码，这里longin.html用的UTF-8
		//post提交的表单没问题，如果get提交的用 new String(name.getBytes("ios-8859-1"),"UTF-8");
		//name是要转码的字符串
		request.setCharacterEncoding("UTF-8");
		//获取表单数据的三种方法
		//method1(request);
		//method2(request);
		method3(request);
	}

	/**
	 * @param request
	 */
	private void method3(HttpServletRequest request) {
		Map<String,String[]>mp=request.getParameterMap();
		for(Map.Entry<String, String[]>m:mp.entrySet())
		{
			String name=m.getKey();
			String[] values=m.getValue();
			System.out.println("****"+name+"****");
			for(int i=0;values!=null&&i<values.length;i++)
			{
				System.out.println(values[i]);
			}
		}
	}

	/**
	 * @param request
	 */
	private void method2(HttpServletRequest request) {
		//可以先通过获取所有的参数名获取参数值
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements())
		{
			String name=names.nextElement();
			String[] values=request.getParameterValues(name);
			System.out.println("****"+name+"****");
			for(int i=0;values!=null&&i<values.length;i++)
			{
				System.out.println(values[i]);
			}
		}
	}

	/**
	 * @param request
	 */
	private void method1(HttpServletRequest request) {
		String username = request.getParameter("username");
		String psw = request.getParameter("psw");
		//获取同名的数据
		String[] str= request.getParameterValues("hobby");
		System.out.println(username);
		System.out.println(psw);
		for(int  i=0;str!=null&&i<str.length;i++)
		{
			System.out.println(str[i]);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
