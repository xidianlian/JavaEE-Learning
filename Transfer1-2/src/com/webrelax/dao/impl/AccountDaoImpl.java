
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

/**   
 * @ClassName:  AccountDaoImpl   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年7月31日 下午4:06:03       
 */

public class AccountDaoImpl implements AccountDao {

	//为事务提供同一个connection
	private Connection conn;
	public AccountDaoImpl(Connection conn) {
		this.conn=conn;
	}


	/** 第一个 版本方法
	 * @param fromName
	 * @param toName
	 * @param money
	 * @throws SQLException 
	 * @see com.webrelax.dao.AccountDao#transfer(java.lang.String, java.lang.String, double)
	 **/
	@Override
	public void updateAccount(String fromName, String toName, double money) throws SQLException {
		//创建一个QueryRunner对象
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		qr.update("update account set money=money-? where name=?",money,fromName);
		qr.update("update account set money=money+? where name=?",money,toName);
		
	}

	
	/** 
	 * 第二个版本方法
	 * @param account
	 * @throws SQLException 
	 * @see com.webrelax.dao.AccountDao#updateAccount(com.webrelax.domain.Account)
	 **/
	    
	@Override
	public void updateAccount(Account account) throws SQLException {
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		//取一个内存池的连接，控制事务
		//修改：qr.update(C3P0Util.getConnection(),"update account set money=? where name=?",account.getMoney(),account.getName());
		//这样写就可实现同一个conn
		qr.update(this.conn,"update account set money=? where name=?",account.getMoney(),account.getName());
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
		//return qr.query(C3P0Util.getConnection(),"select * from account where name=?",new BeanHandler<Account>(Account.class),name);
		return qr.query(conn,"select * from account where name=?",new BeanHandler<Account>(Account.class),name);
		
	}

}
