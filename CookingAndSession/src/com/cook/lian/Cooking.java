package com.cook.lian;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cooking
 */
@WebServlet("/Cooking")
public class Cooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		
		Cookie[] cookies=request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++)
		{
			
			if("lastTime".equals(cookies[i].getName()))
			{
				out.write("上一次访问的时间："+cookies[i].getValue()+"  ");
			}
		}
		
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat dateFormat= new SimpleDateFormat("hh:mm:ss");
		String str=dateFormat.format(calendar.getTime());
		
		//创建cookie
		Cookie ck=new Cookie("lastTime",str);
		//MaxAge值默认为-1,浏览器关闭时就清除了，可以设置浏览器关闭后多少秒后清除。
		//原理是浏览器将数据存入了磁盘。
		ck.setMaxAge(60*5);
		
		//path:默认值是写Cookie的那个程序的访问路径
		//如果url：http://localhost:8081/CookingAndSession/Cooking
		//这path值为 /CookingAndSession
		//如果url：http://localhost:8081/CookingAndSession/test/Cooking
		//这path值为 /CookingAndSession/test，只有在这个路径前缀下才能使用这个cookie
		//因此在其他不同路径servlet中想要使用此servlet的cookie，那么需要设置路径
		//ck.setPath()
		
		
		//把它写回到客户端
		response.addCookie(ck);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
