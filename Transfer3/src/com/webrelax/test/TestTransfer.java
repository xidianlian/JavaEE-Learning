
/**  
 * @Title:  TestTransfer.java   
 * @Package com.webrelax.test   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月31日 下午4:20:44   
 * @version V1.0  
 */
    
package com.webrelax.test;

import java.sql.SQLException;

import com.webrelax.service.AccountService;
import com.webrelax.service.impl.AccountServiceImpl;

/**   
 * @ClassName:  TestTransfer   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年7月31日 下午4:20:44       
 */

public class TestTransfer {

	public static void main(String[] args) {
		AccountService as=new AccountServiceImpl();
		try {
			as.transfer("aaa", "bbb", 100);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
