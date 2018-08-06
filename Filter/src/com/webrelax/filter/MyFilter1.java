package com.webrelax.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Filter过滤器快速入门
 * 直接创建Filter文件，就不用配置web.xml
 * 否则跟servlet一样，需要配置。
 * 
 *  (1).Filter和Servlet比较相似，从属性以及配置方式上可以看出，可以理解为Servlet的加强版；
 *	(2).Filter中对权限的过滤、字符编码的处理、日志的记录可以看成是各个Servlet中重复代码的抽取；
 *	(3).对于字符编码的处理，request.setCharacterEncoding()对post方式的请求有效；
 *  若是get方式，可以使用new String(xxx.getBytes("iso-8859-1"), "utf-8")进行处理，
 *  否则表单的中文会乱码；也可以使用代理方式，每当通过request.getParameter()时自动进行编码处理；
 *  
 *  filter 生命周期：
 * 		当服务器启动，会创建Filter对象，并调用init方法，只调用一次.
 *	当访问资源时，路径与Filter的拦截路径匹配，会执行Filter中的doFilter方法，这个方法是真正拦截操作的方法.
 *	当服务器关闭时，会调用Filter的destroy方法来进行销毁操作.
 *  servlet生命周期：
 *  	第一次访问servlet资源时，实例化和初始化
 *  	只要应用在，就一直服务（service）
 *  	应用卸载或者服务器停止，销毁
 *  
 *  配置参数入下
 * 			 属性			类型			是否必需				说明
 *		asyncSupported	   boolean	  	        否		指定Filter是否支持异步模式
 *		dispatcherTypes	 DispatcherType[]	否	        指定Filter对哪种方式的请求进行过滤。
 *													支持的属性：ASYNC、ERROR、FORWARD、INCLUDE、REQUEST；
 *													默认过滤REQUEST
 *		filterName			String			否		Filter名称
 *		initParams		WebInitParam[]		否		配置参数
 *		displayName			String			否		Filter显示名
 *		servletNames		String[]		否		指定对哪些Servlet进行过滤
 *		urlPatterns/value	String[]		否		两个属性作用相同，指定拦截的路径
 *
 *1.REQUEST 当是从浏览器直接访问资源，或是重定向到某个资源时进行拦截方式配置的 它也是默认值
 *2.FORWARD 它描述的是请求转发的拦截方式配置
 *3.ERROR 如果目标资源是通过声明式异常处理机制调用时，那么该过滤器将被调用。除此之外，过滤器不会被调用。
 *4.INCLUDE 如果目标资源是通过RequestDispatcher的include()方法访问时，那么该过滤器将被调用。除此之外，该过滤器不会被调用
 * 
 **/
@WebFilter(filterName="MyFilter1",urlPatterns="/*",
initParams= {@WebInitParam(name = "encoding", value = "utf-8")}
		)
public class MyFilter1 implements Filter {
	FilterConfig fConfig;
	 /**
     * Default constructor. 
     */
    public MyFilter1() {
    	System.out.println("实例化");
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//可得到fConfig对象
		this.fConfig=fConfig;
		System.out.println("初始化");
	}
  
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("销毁");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter1 doFilter执行");
		
		System.out.println("filterName:"+fConfig.getFilterName());
		System.out.println("initParam:"+fConfig.getInitParameter("encoding"));
		//可以设置编码,request就会随着chain.doFilter()一直传递下去
		request.setCharacterEncoding(fConfig.getInitParameter("encoding"));
		//放行，否则资源访问不到
		chain.doFilter(request, response);
		
		System.out.println("资源过滤后");
	}

	

}
