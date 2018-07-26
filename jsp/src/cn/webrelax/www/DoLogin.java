package cn.webrelax.www;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoLogin
 * jsp文件原理，xx.jsp->xx_jsp.java->xx_jsp.class
 * 在.metadata\.plugins\org.eclipse.wst.server.core目录下查看，
 * 或者tomcat下work目录下查看，看eclipse配置
 * 查看源码可发现，jsp本质就是servlet,继承org.apache.jasper.runtime.HttpJspBase
 * 而HttpJspBase继承了HttpServlet,重写方法为_jspInit，_jspService，_jspDestroy
 **/
/**
 * jsp最佳实践
 * Servlet:控制器，重点编写Java代码逻辑（获取表单数据、处理业务逻辑、分发转向）
 * Jsp:代码显示模板，重点在于显示数据。
 **/
@WebServlet("/DoLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		if(username.equals("lian")&&pwd.equals("123456"))
		{
		
			//请求转发
			//RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			//requestDispatcher.forward(request, response);
			//最好将username用session保存
			request.getSession().setAttribute("username", username);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		else 
		{	//重定向,不会将网页传过来的数据传到下个网页，只是给客户端访问面的网页
			//response.sendRedirect(request.getContextPath()+"/login.jsp");
			//如果需要提示信息，则不能重定向，用转发
			request.setAttribute("msg","密码或用户名错误");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
			requestDispatcher.forward(request, response);
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
