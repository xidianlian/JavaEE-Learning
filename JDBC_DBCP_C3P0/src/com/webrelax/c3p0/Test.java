
/**  
 * @Title:  Test.java   
 * @Package com.webrelax.waper   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月30日 下午5:13:08   
 * @version V1.0  
 */
    
package com.webrelax.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		//从连接池中取出一个连接
		
		try {
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement("insert into users(username,password) values('c3p0','123456')");
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("哈哈a");
		} finally {
			C3P0Util.release(conn, ps, null);
		}
		
	}

}
