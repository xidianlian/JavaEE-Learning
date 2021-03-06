
/**  
 * @Title:  C3P0Util.java   
 * @Package com.webrelax.c3p0   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月30日 下午8:25:09   
 * @version V1.0  
 */
    
package com.webrelax.crud;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**   
 * @ClassName:  C3P0Util   
 * @TODO(另一个常用的数据源)   
 * @author: xidian_lian 
 * @date:   2018年7月30日 下午8:25:09       
 */

public class C3P0Util {
	//得到数据源
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//从数据源中得到一个连接对象
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("服务器错误");
		}
	}
	
	/**
	 * @return dataSource
	 */
	
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	public static void release(Connection conn,Statement stmt,ResultSet rs){
		//关闭资源
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn!=null){
			try {
				conn.close();//关闭,c3p0提供的包里已经处理好了
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
}
