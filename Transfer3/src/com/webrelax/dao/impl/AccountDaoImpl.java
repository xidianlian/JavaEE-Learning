
/**  
 * @Title:  AccountDaoImpl.java   
 * @Package com.webrelax.impl   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月31日 下午4:06:03   
 * @version V1.0  
 */
    
package com.webrelax.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.webrelax.dao.AccountDao;
import com.webrelax.domain.Account;
import com.webrelax.util.C3P0Util;
import com.webrelax.util.ManagerThreadLocal;

/**   
 * @ClassName:  AccountDaoImpl   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年7月31日 下午4:06:03       
 */

public class AccountDaoImpl implements AccountDao {
	

	
	/** 
	 * 第二个版本方法
	 * @param account
	 * @throws SQLException 
	 * @see com.webrelax.dao.AccountDao#updateAccount(com.webrelax.domain.Account)
	 **/
	    
	@Override
	public void updateAccount(Account account) throws SQLException {
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		Connection conn=ManagerThreadLocal.getConnection();//从当前线程取的conn,若当前线程里没存，则从连接池取
		qr.update(conn,"update account set money=? where name=?",account.getMoney(),account.getName());
	}
	
	/** 
	 * @param name
	 * @return
	 * @throws SQLException
	 * @see com.webrelax.dao.AccountDao#findAccountByName(java.lang.String)
	 **/

	@Override
	public Account findAccountByName(String name) throws SQLException {
		QueryRunner qr=new QueryRunner();
		Connection conn=ManagerThreadLocal.getConnection();//从当前线程取的conn,若当前线程里没存，则从连接池取
		return qr.query(conn,"select * from account where name=?",new BeanHandler<Account>(Account.class),name);
		
	}

}
