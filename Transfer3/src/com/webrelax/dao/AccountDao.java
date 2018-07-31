
/**  
 * @Title:  AccountDao.java   
 * @Package com.webrelax.dao   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月31日 下午4:03:49   
 * @version V1.0  
 */
    
package com.webrelax.dao;

import java.sql.SQLException;

import com.webrelax.domain.Account;

/**   
 * @ClassName:  AccountDao   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年7月31日 下午4:03:49       
 */

public interface AccountDao {
	/**
	 * @Title: transfer
	 * @TODO(转账)
	 * @param fromName 转出用户
	 * @param toName   转入用户
	 * @param money    多少钱
	 * @return void    返回类型
	 */
	
	//第二个版本,直接修改账户，在业务层把钱算好再更新，这样取钱/转账/存钱都可调此方法
	public void updateAccount(Account account)throws SQLException;
	public  Account findAccountByName(String name)throws SQLException;
}
