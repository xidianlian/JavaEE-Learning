
/**  
 * @Title:  BookDaoImpl.java   
 * @Package com.webrealx.dao.impl   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年8月1日 上午9:05:46   
 * @version V1.0  
 */
    
package com.webrealx.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.webrealx.dao.BookDao;
import com.webrelax.domain.Book;
import com.webrelax.util.C3P0Util;

/**   
 * @ClassName:  BookDaoImpl   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年8月1日 上午9:05:46       
 */

public class BookDaoImpl implements BookDao{

	@Override
	public List<Book> findAllBook() throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book", new BeanListHandler<Book>(Book.class));
	}    
	@Override
	public void addBook(Book book) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into book values(?,?,?,?,?,?,?)", 
				book.getId(),book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getImgurl());
	}
	@Override
	public Book findBookById(String id) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book where id=?", new BeanHandler<Book>(Book.class),id);
	}
	@Override
	public void updateBook(Book book) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		qr.update("update book set name=?,price=?,pnum=?,category=?,description=?,imgurl=? where id=?", 
				book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getImgurl(),book.getId());
	}  
	@Override
	public void deleteBook(Book book) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from book where id=?",book.getId());
	}
	
	/** 
	 * @param ids
	 * @throws SQLException
	 * @see com.webrealx.dao.BookDao#deleteSomeBooks(java.lang.String[])
	 **/
	    
	@Override
	public void deleteSomeBooks(String[] ids) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		Object[][] params=new Object[ids.length][];
		for(int i=0;i<params.length;i++) {
			params[i]=new Object[] {ids[i]};
		}
		qr.batch("delete from book where id=?", params);
	}
	
	/** 
	 * 根据条件查询
	 * @param id
	 * @param name
	 * @param category
	 * @param minPrice
	 * @param maxPrice
	 * @throws SQLException
	 * @see com.webrealx.dao.BookDao#findBooksByCondition(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 **/
	    
	@Override
	public List<Book> findBooksByCondition(String id, String name, String category, String minprice, String maxprice)
			throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		List<String> list=new ArrayList<String>();
		String sql="select * from book where 1=1";
		if(!"".equals(id)) {
			// sql语句应该为"id like '%id%'";如果用?它会自动加上''，所以，%写在list里
			sql+=" and id like ?";
			list.add("%"+id+"%");
		}
		if(!"".equals(name)) {
			sql+=" and name like ?";
			list.add("%"+name+"%");
		}
		if(!"".equals(category)) {
			sql+=" and category=?";
			list.add(category);
		}
		if(!"".equals(minprice)) {
			sql+=" and price>=?";
			list.add(minprice);
		}
		if(!"".equals(maxprice)) {
			sql+=" and price<=?";
			list.add(maxprice);
		}
		//返回一个list<Book>
		return qr.query(sql, new BeanListHandler<Book>(Book.class),list.toArray());
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see com.webrealx.dao.BookDao#count()
	 **/
	    
	@Override
	public Long count() throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return (Long)qr.query("select count(*) from book", new ScalarHandler(1));
	}
	
	/** 
	 * @param currentPage
	 * @param pageSize
	 * @return List<Book>
	 * @throws SQLException
	 * @see com.webrealx.dao.BookDao#findBooks(int, int)
	 **/
	    
	@Override
	public List<Book> findBooks(int currentPage, int pageSize) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		int startNum=(currentPage-1)*pageSize;
		return qr.query("select * from book limit ?,?", new BeanListHandler<Book>(Book.class),startNum,pageSize);
	}
	
	/** 
	 * @param name
	 * @return
	 * @throws SQLException
	 * @see com.webrealx.dao.BookDao#findBookByName(java.lang.String)
	 **/
	    
	@Override
	public List<Book> findBookByName(String name) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book where name like ?", new BeanListHandler<Book>(Book.class),name+"%");
		
	}

}
