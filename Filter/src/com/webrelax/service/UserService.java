
/**  
 * @Title:  UserService.java   
 * @Package com.webrelax.service   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年8月5日 下午8:47:51   
 * @version V1.0  
 */
    
package com.webrelax.service;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.webrelax.domain.User;
import com.webrelax.util.C3P0Util;

/**   
 * @ClassName:  UserService   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年8月5日 下午8:47:51       
 */

public class UserService {
	
	public User findUser(User user) {
		QueryRunner qr=new QueryRunner( C3P0Util.getDataSource());
		try {
			return qr.query("select * from users where username=? and password=?", 
					new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
