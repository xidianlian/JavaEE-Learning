package com.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

/**
 * Servlet implementation class Verification
 */
@WebServlet("/Verification")
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//告诉不同浏览器不缓存，刷新网页也能改变验证码
		response.setHeader("pragma", "no-cahe");
		response.setHeader("cache-control", "no-cahe");
		response.setHeader("expires", "0");
		
		//validateCode(response);
	
		//刷新页面
		//response.setHeader("refresh","1");
		//response.setIntHeader("refresh",1);
		//1s后跳转一个页面
		response.setHeader("refresh","1;url=/HttpServlet/Verification");
		//1.调用jar包
//		ValidateCode vc=new ValidateCode(100, 25, 4, 5) ;
//		vc.write(response.getOutputStream());
		//2.自写
		validateCode(response);
	}
	/**
	 * @param response
	 * @throws IOException
	 */
	private void validateCode(HttpServletResponse response) throws IOException {
		int width=100;
		int height=25;
		//在内存中创建一个图像对象
		BufferedImage img=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		//创建一个画笔
		Graphics g=img.getGraphics();
		//给图片添加背景色,图片原点为（0,0）
		g.setColor(Color.orange);
		g.fillRect(1, 1, width-2, height-2);
		
		//图片边框
		g.setColor(Color.blue);
		g.drawRect(0,0,width-1,height-1);
		
		//设置文本样式
		g.setFont(new Font("华文新魏",Font.BOLD|Font.ITALIC,20));
		
		Random rd=new Random();
		//给图片添加文本
		for(int i=1,pos=15;i<=4;i++)
		{
			
			String str=""+(char)(rd.nextInt(26)+'a');
			g.drawString(str, pos, 17);
			pos+=20;
		}
		
		//给图片添加干扰线
		for(int  i=1;i<=4;i++)
		{
			int x1=rd.nextInt(width);
			int y1=rd.nextInt(height);
			int x2=rd.nextInt(width);
			int y2=rd.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		
		//将图片对象以流的方式输出给客户端
		ImageIO.write(img, "jpg",response.getOutputStream());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
