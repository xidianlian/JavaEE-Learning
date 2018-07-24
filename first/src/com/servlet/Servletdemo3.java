/**
 * 
 */
package com.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 72761
 * 模板设计模式
 * 不能重写父类service方法
 * 服务器执行原理： 
 * Servlet servlet=new Servletdemo3();
 * Servlet是一个接口
 * servlet中没有doGet等方法，但它可以调用Servletdemo3继承其子类HttpServlet中的service方法
 * servlet.service();
 * 通过此方法再调用HttpServlet重载的service方法,判断是get还是post或者其他访问方法，来调用doGet或doPost等
 * 此时Servletdemo3通过重写doGet来实现自己想要的功能。
 */
public class Servletdemo3 extends HttpServlet {
	
	/* 
	 * doxxx方法在service中调用
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取或设置全局配置的类 
		ServletContext application=this.getServletContext();
		 application.setAttribute("lian", "456789");
		//也可以获取当前工程下任何文件路径下的文件,在服务器的路径，没有WebContent
		String path =application.getRealPath("/WEB-INF/a.text");
		System.out.println(path);
		Properties pro=new Properties();
		pro.load(new FileInputStream(path));
		System.out.println(pro.getProperty("key"));
		path =application.getRealPath("/WEB-INF/classes/b.text");
		System.out.println(path);
		pro=new Properties();
		pro.load(new FileInputStream(path));
		System.out.println(pro.getProperty("key"));
		
	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
	}
}
