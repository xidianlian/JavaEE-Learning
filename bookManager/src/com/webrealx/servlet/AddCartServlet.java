package com.webrealx.servlet;

import java.io.IOException;
import java.util.HashMap;
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
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 购物车
     * 思路：将购物车中的商品以map集合形式存入session
     * @param request
     * @param response
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		BookService bs= new BookServiceImpl();
		Book book=bs.findBookById(id);
		HttpSession session = request.getSession();
		Map<Book,Integer> cart=(Map<Book, Integer>) session.getAttribute("cart");
		int num=1;
		if(cart==null) {
			cart=new HashMap<Book,Integer>();
		}
		if(cart.containsKey(book)) {
			num=cart.get(book)+1;
		}
		cart.put(book, num);
		session.setAttribute("cart", cart);
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
