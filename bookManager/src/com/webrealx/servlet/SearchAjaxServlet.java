package com.webrealx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webrealx.service.impl.BookServiceImpl;
import com.webrelax.domain.Book;
import com.webrelax.service.BookService;

/**
 * Servlet implementation class SerchAjaxServlet
 */
@WebServlet("/SearchAjaxServlet")
public class SearchAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String name=request.getParameter("name");
		System.out.println(name+"***");
		BookService bs=new BookServiceImpl();
		List<Book> booklist= bs.findBookByName(name);
		PrintWriter out=response.getWriter();
		for(Book b:booklist) {
			System.out.println(b.getName());
		}
		
		out.print("java");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
