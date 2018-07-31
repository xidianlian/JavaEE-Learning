
/**  
 * @Title:  ManagerThreadLocal.java   
 * @Package com.webrelax.util   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月31日 下午8:21:15   
 * @version V1.0  
 */
    
package com.webrelax.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.C3P0Registry;

/**   
 * @ClassName:  ManagerThreadLocal   
 * @TODO(处理事务的类，并使用同一个connection[利用当前线程存储])   
 * @author: xidian_lian 
 * @date:   2018年7月31日 下午8:21:15       
 */

public class ManagerThreadLocal {
	//每次get()只取当前线程的
	private static ThreadLocal<Connection>tl=new ThreadLocal<Connection>();
	public static Connection getConnection() {
		Connection conn = tl.get();//从当前线程中取连接
		if(conn==null) {
			//如果没有则从连接池中取
			conn=C3P0Util.getConnection();
			tl.set(conn);//放到线程里
		}
		return conn;
	}
	//开始事务
	public static void statTranscacation() { 
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//提交事务
	public static void commit() {
		try {
			getConnection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//回滚
	public static void rollback() {
		try {
			getConnection().rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//把连接放回池
	public static void release() {
		try {
			getConnection().close();
			tl.remove();//把当前线程对象中的conn移除
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
