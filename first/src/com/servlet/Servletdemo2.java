/**
 * 
 */
package com.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



/**
 * @author 72761
 *	设计方法：适配器方法
 */
/**
 * 这里是创建的类，不是servlet,访问，见WEB-INF/web.xml servlet-mapping标签
 * */
public class Servletdemo2 extends GenericServlet {
	/**
	 * GenericServlet是抽象类，实现了Servlet接口，service为他的抽象方法
	 * 服务器new并初始化init方法，客户连接就调用service，删除则destory()
	 */
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("yes dsf ");
	
		
	}

	
}
