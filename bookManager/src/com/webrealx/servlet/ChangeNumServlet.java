package com.webrealx.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webrealx.service.impl.BookServiceImpl;
import com.webrelax.domain.Book;
import com.webrelax.service.BookService;

/**
 * Servlet implementation class ChangeNumServlet
 */
@WebServlet("/ChangeNumServlet")
public class ChangeNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String num=request.getParameter("num");
		
//		BookService bs= new BookServiceImpl();
//		Book book=bs.findBookById(id);
		Book book=new Book();
		book.setId(id);
		HttpSession session =request.getSession();
		Map<Book,Integer>cart=(Map<Book, Integer>) session.getAttribute("cart");
		if(cart.containsKey(book)) {
			if(num.equals("0")) {
				cart.remove(book);
			}else {
				cart.put(book, Integer.parseInt(num));
			}
		}
		
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
