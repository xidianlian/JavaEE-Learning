package com.webrealx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webrealx.service.impl.BookServiceImpl;
import com.webrelax.domain.Book;
import com.webrelax.domain.Page;
import com.webrelax.service.BookService;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//如果currentPage来自网页传回 有可能为""
		//如果直接访问的ProductListServlet，currentPage=null;
		String currentPage=request.getParameter("currentPage");
		int pageSize=4;
		BookService bs=new BookServiceImpl();
		if(currentPage==null||currentPage.equals(""))
			currentPage="1";
		Page page=bs.findBooks(Integer.parseInt(currentPage), pageSize);
		List<Book>booklist=page.getBooks();
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
