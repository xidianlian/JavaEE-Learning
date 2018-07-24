package com.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadFile
 */
@WebServlet("/DownloadFile")
public class DownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到文件真实路径
		String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/风景.jpg");
		
//		从文件系统中的某个文件中获得输入流
		FileInputStream fis=new FileInputStream(realPath);
		
		//创建字节输出流
		ServletOutputStream sos = response.getOutputStream();
		
		//获取文件名
		String filename=realPath.substring(realPath.lastIndexOf("\\")+1);
		
		//设置文件名的编码
		filename=URLEncoder.encode(filename,"UTF-8");
		
		//告知客户端要下载文件
		response.setHeader("content-disposition","attachement;filename="+filename);
		response.setHeader("content-type","image/jpeg");
		
		//执行输出操作
		int len=1;
		byte[] b=new byte[2048];
		while((len=fis.read(b))!=-1)
		{
			sos.write(b,0,len);
		}
		sos.close();
		fis.close();
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
