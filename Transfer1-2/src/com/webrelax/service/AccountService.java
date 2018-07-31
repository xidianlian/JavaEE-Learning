
/**  
 * @Title:  AccountService.java   
 * @Package com.webrelax.service   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月31日 下午4:12:19   
 * @version V1.0  
 */
    
package com.webrelax.service;

import java.sql.SQLException;

/**   
 * @ClassName:  AccountService   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年7月31日 下午4:12:19       
 */

public interface AccountService {
	/**
	 * @Title: transfer
	 * @TODO(转账)
	 * @param fromName 转出用户
	 * @param toName   转入用户
	 * @param money    多少钱
	 * @return void    返回类型
	 */
	public void transfer(String fromName,String toName,double money) throws SQLException;
}
