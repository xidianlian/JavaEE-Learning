
/**  
 * @Title:  BookDao.java   
 * @Package com.webrealx.dao   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年8月1日 上午9:02:35   
 * @version V1.0  
 */
    
package com.webrealx.dao;

import java.sql.SQLException;
import java.util.List;

import com.webrelax.domain.Book;

/**   
 * @ClassName:  BookDao   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年8月1日 上午9:02:35       
 */

public interface BookDao {
	public List<Book> findAllBook()throws SQLException;
	public void addBook(Book book)throws SQLException;
	public Book findBookById(String id)throws SQLException;
	public void updateBook(Book book)throws SQLException;
	public void deleteBook(Book book)throws SQLException;
	public void deleteSomeBooks(String[] ids)throws SQLException;
	public List<Book> findBooksByCondition(String id,String name,String category,String minprice,String maxprice)throws SQLException;
	public Long count()throws SQLException;
	public List<Book> findBooks(int currentPage,int pageSize)throws SQLException;
	public List<Book> findBookByName(String name)throws SQLException;
}
