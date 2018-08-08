package com.webrelax.download;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charsert=utf-8");
		response.setCharacterEncoding("UTF-8");//响应编码
		//设置一个要下载的文件
		String filename="销售榜单.csv";
		if(request.getHeader("User-Agent").toLowerCase().contains("chrome")) {
			filename=new String(filename.getBytes("UTF-8"),"iso-8859-1");
		}
		else {
			//IE浏览器
			filename=URLEncoder.encode(filename,"UTF-8");
		}
		
		//告诉浏览器下载文件
		response.setHeader("content-disposition", "attachment;filename="+filename);
		//文件类型
		//	response.setHeader("content-type","imag/jpeg");
		//自动根据文件名设置类型
		response.setContentType(this.getServletContext().getMimeType(filename));
		
		//创建一个文件输出流
		PrintWriter out = response.getWriter();
		out.write("电视,60\n");
		out.write("冰箱,40\n");
		out.write("洗衣机,101\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
