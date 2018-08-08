
/**  
 * @Title:  Page.java   
 * @Package com.webrelax.domain   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年8月2日 上午11:01:58   
 * @version V1.0  
 */
    
package com.webrelax.domain;

import java.util.List;

/**   
 * @ClassName:  Page   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年8月2日 上午11:01:58       
 */

public class Page {
	private int currentPage;
	private long count;
	private int pageSize;
	private int totalPage;
	private List<Book> books;
	
	/**
	 * @return currentPage
	 */
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	/**
	 * @return count
	 */
	
	public long getCount() {
		return count;
	}
	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setCount(long count) {
		this.count = count;
	}
	
	/**
	 * @return pageSize
	 */
	
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * @return totalPage
	 */
	
	public int getTotalPage() {
		return totalPage;
	}
	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	/**
	 * @return books
	 */
	
	public List<Book> getBooks() {
		return books;
	}
	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
