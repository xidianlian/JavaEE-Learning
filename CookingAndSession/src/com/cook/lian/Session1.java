package com.cook.lian;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session
 */
@WebServlet("/Session1")
public class Session1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * session:
	 * 一个浏览器独占一个session对象。
	 * 后台程序，需要将存储的内容存储到服务器（随机生成sessionID用于服务不同的用户），.
	 * 当同一个浏览器访问另外的servlet使用session里内容时，将sessionID发送给浏览器保存。
	 *
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		name=new String(name.getBytes("iso-8859-1"),"UTF-8");
		HttpSession session = request.getSession();
		session.setAttribute("name", name);//session可以存对象，cookie只能存字符串
		
		System.out.println(session.getId());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
