
/**  
 * @Title:  Account.java   
 * @Package com.webrelax.domain   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月31日 下午3:58:55   
 * @version V1.0  
 */
    
package com.webrelax.domain;


/**   
 * @ClassName:  Account   
 * @TODO(账户类)   
 * @author: xidian_lian 
 * @date:   2018年7月31日 下午3:58:55       
 */

public class Account {
	private int id;
	private String name;
	private double money;
	
	/**
	 * @return id
	 */
	
	public int getId() {
		return id;
	}
	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	/** 
	 * @return
	 * @see java.lang.Object#toString()
	 **/
	    
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", money=" + money + "]";
	}

	/**
	 * @return name
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return money
	 */
	
	public double getMoney() {
		return money;
	}
	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setMoney(double money) {
		this.money = money;
	} 
}	
