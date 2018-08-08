
/**  
 * @Title:  BookServiceImpl.java   
 * @Package com.webrealx.service.impl   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年8月1日 上午9:57:59   
 * @version V1.0  
 */
    
package com.webrealx.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.webrealx.dao.impl.BookDaoImpl;
import com.webrelax.domain.Book;
import com.webrelax.domain.Page;
import com.webrelax.service.BookService;

/**   
 * @ClassName:  BookServiceImpl   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年8月1日 上午9:57:59       
 */

public class BookServiceImpl implements BookService {
	
	BookDaoImpl bookDao=new BookDaoImpl();
	/** 
	 * @return
	 * @see com.webrelax.service.BookService#findAllBook()
	 **/
	@Override
	public List<Book> findAllBook() {
		try {
			return bookDao.findAllBook();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** 
	 * @param book
	 * @see com.webrelax.service.BookService#addBook(com.webrelax.domain.Book)
	 **/
	    
	@Override
	public void addBook(Book book) {
		try {
			bookDao.addBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/** 
	 * @param id
	 * @return
	 * @see com.webrelax.service.BookService#findBookById(java.lang.String)
	 **/
	    
	@Override
	public Book findBookById(String id) {
		try {
			return bookDao.findBookById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void updateBook(Book book) {
		try {
			bookDao.updateBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/** 
	 * @param book
	 * @see com.webrelax.service.BookService#deleteBook(com.webrelax.domain.Book)
	 **/
	@Override
	public void deleteBook(Book book) {
		try {
			bookDao.deleteBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/** 
	 * @param ids
	 * @see com.webrelax.service.BookService#deleteSomeBooks(java.lang.String[])
	 **/
	    
	@Override
	public void deleteSomeBooks(String[] ids) {
		try {
			bookDao.deleteSomeBooks(ids);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
	/** 
	 * @param id
	 * @param name
	 * @param category
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 * @see com.webrelax.service.BookService#findBooksByCondition(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 **/
	    
	@Override
	public List<Book> findBooksByCondition(String id, String name, String category, String minprice, String maxprice) {
		try {
			return bookDao.findBooksByCondition(id, name, category, minprice, maxprice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/** 
	 * @param currentpage
	 * @param pageSize
	 * @return
	 * @see com.webrelax.service.BookService#findBooks(int, int)
	 **/
	    
	@Override
	public Page findBooks(int currentPage, int pageSize) {
		Page page=new Page();
		long count;
		int totalPage;
		List<Book> books;
		try {
			count = bookDao.count();
			books=bookDao.findBooks(currentPage, pageSize);
			
			totalPage=(int)Math.ceil((double)count/pageSize);
			page.setCount(count);
			page.setTotalPage(totalPage);
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setBooks(books);
			return page;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	/** 
	 * @param name
	 * @return
	 * @see com.webrelax.service.BookService#findBookByName(java.lang.String)
	 **/
	    
	@Override
	public List<Book> findBookByName(String name) {
		try {
			return bookDao.findBookByName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
