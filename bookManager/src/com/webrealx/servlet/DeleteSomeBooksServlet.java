package com.webrealx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webrealx.service.impl.BookServiceImpl;
import com.webrelax.domain.Book;
import com.webrelax.service.BookService;

/**
 * Servlet implementation class DeleteSomeBooksServlet
 */
@WebServlet("/DeleteSomeBooksServlet")
public class DeleteSomeBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到要删除的一批id
		String[] ids=request.getParameterValues("id");
	
		BookService bs=new BookServiceImpl();
		//方法一	
//		Book book=new Book();
//		for(int i=0;i<ids.length;i++) {
//			book.setId(ids[i]);
//			bs.deleteBook(book);
//		}
		//方法二，在DAO里用batch
		bs.deleteSomeBooks(ids);
		request.getRequestDispatcher("BookListServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
