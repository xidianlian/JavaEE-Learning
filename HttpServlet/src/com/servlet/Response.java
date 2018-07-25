package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Response
 * 1.响应消息行 HTTP/1.1 200 OK
 * 		setStatus(int sc)设置响应状态码
 * 2.响应消息头
 * 		sendRedirect(String location)请求重定向
 * 		setHeader(String name,String value)设置响应头信息
 * 	例如：告诉浏览器编码：
 * 		response.setHeader("content-type","text/html;charset=UTF-8")
 * 		   告诉浏览器不要缓存：
 * 		response.setHeader("pragma","no-cache");
 * 3.响应正文
 * 		getWrite();字符输出流
 * 		getOutputStream();字节输出流
 * 		setCharacterEncoding(String charset);服务器使用什么编码
 */
@WebServlet("/Response")
public class Response extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//服务器使用ISO-8859-1编码，不支持中文
	/*
		//告诉服务器使用UTF-8
		response.setCharacterEncoding("UTF-8");
		//告诉浏览器使用UTF-8
		response.setHeader("content-type", "text/html;charset=UTF-8");
	*/
		/*此函数完成了以上两个函数的任务*/
		response.setContentType("text/html;charset=UTF-8");
		//得到一个字符输出流
		PrintWriter out = response.getWriter();
		out.write("你好吗tom 杰瑞!!");
	 // out.getWriter()和getOutputStream()。不能同时用，
//		ServletOutputStream sos = response.getOutputStream();
//		sos.write("哈喽大家好，我是字节流".getBytes());//getBytes()默认是用操作系统的编码（即：GBK）;

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
