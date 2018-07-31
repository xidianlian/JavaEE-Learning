
/**  
 * @Title:  AccountServiceImpl.java   
 * @Package com.webrelax.service.impl   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月31日 下午4:13:59   
 * @version V1.0  
 */
    
package com.webrelax.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.webrelax.dao.AccountDao;
import com.webrelax.dao.impl.AccountDaoImpl;
import com.webrelax.domain.Account;
import com.webrelax.service.AccountService;
import com.webrelax.util.C3P0Util;

/**   
 * @ClassName:  AccountServiceImpl   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年7月31日 下午4:13:59       
 */

public class AccountServiceImpl implements AccountService {

	
	/** 
	 * @param fromName
	 * @param toName
	 * @param money
	 * @throws SQLException
	 * @see com.webrelax.service.AccountService#update(java.lang.String, java.lang.String, double)
	 **/
	@Override
	public void transfer(String fromName, String toName, double money)  {
		//第一版本
		//ad.updateAccount(fromName, toName, money);
		
		
		//第二版本,先得到账户、修改金额、更新
		//将connection提出来，不在DAO里生成,但它理论上应该在DAO层，不应该在业务层,进一步解决看Transfer2
		Connection conn=C3P0Util.getConnection();
		AccountDao ad= new AccountDaoImpl(conn);
		try {
			conn.setAutoCommit(false);//begin
			
			Account fromAccount=ad.findAccountByName(fromName);
			Account toAccount=ad.findAccountByName(toName);
			
			fromAccount.setMoney(fromAccount.getMoney()-money);
			toAccount.setMoney(toAccount.getMoney()+money);
			ad.updateAccount(fromAccount);
//			int i=10/0; //因此要事务管理
			//由于每次调updateAccount中，会得到一个C3P0连接池中的连接（两个连接不同）
			//所以要想办法，把C3P0Util.getConnection()提出来,让两次更新用同一个connection
			ad.updateAccount(toAccount);
			conn.commit();//提交
		} catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
