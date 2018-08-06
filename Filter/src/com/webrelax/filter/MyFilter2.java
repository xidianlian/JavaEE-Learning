package com.webrelax.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


/**
 * 过滤器链，如果多个过滤器同时过滤一个文件，每个过滤器都会执行，最后执行的那个过滤器chain.doFilter跳到资源页面,chain.doFilter执行到下一个锅炉其
 * 过滤器的执行顺序看web.xml的配置
 */
@WebFilter(filterName="MyFilter2",urlPatterns="/login.jsp")
public class MyFilter2 implements Filter {

    public MyFilter2() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter2 doFilter执行");

		HttpServletRequest req=(HttpServletRequest) request;
//		post提交可用
//		req.setCharacterEncoding("utf-8");
		req = new MyRequest(req);
		chain.doFilter(req, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
//全局编码过滤器
//适配器模式
//实现与被包装对象相同的接口
//定义一个与被包装类对象的引用
//定义一个构造方法，把被包装对象传过来
//对于不需要改写方法，直接调用原来的方法
//对于需要改写的方法，写自己的方法体
class MyRequest extends HttpServletRequestWrapper{
	HttpServletRequest request;
	boolean flag=true;//true代表需要编码，false：表示不需要再此编码
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
//	@Override
//	public String getParameter(String name) {
//		 name = request.getParameter(name);//乱码
//		 try {
//			return new String (name.getBytes("iso-8859-1"),"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@Override
	public String getParameter(String name) {
		
		Map<String ,String[] >map=this.getParameterMap();
		return map.get(name)[0];
	}
	@Override
	public String[] getParameterValues(String name) {
		Map<String ,String[] >map=this.getParameterMap();
		return map.get(name);
	}
	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String,String[]>map=request.getParameterMap();//乱码
		if(flag) {
			for (Map.Entry<String,String[]> mp : map.entrySet()) {
				String[] values=mp.getValue();
				for(int i=0;i<values.length;i++) {
					try {
						values[i]=new String(values[i].getBytes("iso-8859-1"),"utf-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			flag=false;
		}
		return map;
	}
	
}
