
/**  
 * @Title:  DButil.java   
 * @Package com.webrelax.crud   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月31日 上午9:06:21   
 * @version V1.0  
 */
    
package com.webrelax.crud;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**   
 * @ClassName:  DButil   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年7月31日 上午9:06:21       
 */

public class DBUtil {
	public void testSelect1() throws SQLException {
		//创建一个DataSource对象
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		
		//ResultSetHandler 接口
		List<User> list=qr.query("select * from users", new ResultSetHandler<List<User>>() {
			//当query方法执行select语句后，将结果集以参数的形式传递过来
			@Override
			public List<User> handle(ResultSet rs) throws SQLException {
				List<User> list=new ArrayList<User>();
				while(rs.next()) {
					User u=new User();
					u.setId(rs.getInt(1));
					u.setUsername(rs.getString(2));
					u.setPassword(rs.getString(3));
					u.setBirthday(rs.getDate(4));
					u.setEmail(rs.getString(5));
					list.add(u);
				}
				return list;
			}
		});
	
		for(User u:list) {
			System.out.println(u.getId()+" "+u.getUsername()+" "+u.getPassword()+" "+u.getEmail()+" "+u.getBirthday());
		}
	}
	public void testSelect2() throws SQLException {
		//创建一个DataSource对象
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		 //List<User>list=qr.query("select * from users", new BeanListHandler<User>(User.class));
		 List<User>list=qr.query("select * from users where id=? and username=?",
				 new BeanListHandler<User>(User.class),8,"test");
		 for(User u:list) {
				System.out.println(u.getId()+" "+u.getUsername()+" "+u.getPassword()+" "+u.getEmail()+" "+u.getBirthday());
		 }
	}
	public void testBatch() throws SQLException {
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		Object[][] params=new Object[10][];
		for(int i=0;i<params.length;i++) {
			params[i]=new Object[]{"蔡依林"+i,987,"ca@163.com",new Date()};
		}
		//执行十次语句，参数有params给出
		qr.batch("insert into users(username,password,email,birthday) values(?,?,?,?)", params);
	}
}
