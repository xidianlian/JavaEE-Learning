
/**  
 * @Title:  BookService.java   
 * @Package com.webrelax.service   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年8月1日 上午9:56:26   
 * @version V1.0  
 */
    
package com.webrelax.service;

import java.util.List;

import com.webrelax.domain.Book;
import com.webrelax.domain.Page;

/**   
 * @ClassName:  BookService   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年8月1日 上午9:56:26       
 */

public interface BookService {
	public List<Book> findAllBook();
	public void addBook(Book book);
	public Book findBookById(String id);
	public void updateBook(Book book);
	public void deleteBook(Book book);
	public void deleteSomeBooks(String[] ids);
	public List<Book> findBooksByCondition(String id, String name, String category, String minprice, String maxprice);
	public Page findBooks(int currentPage,int pageSize);
	public List<Book> findBookByName(String name);
}
