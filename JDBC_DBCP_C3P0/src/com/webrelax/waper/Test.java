
/**  
 * @Title:  Test.java   
 * @Package com.webrelax.waper   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月30日 下午5:13:08   
 * @version V1.0  
 */
    
package com.webrelax.waper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.webrelax.dbcputil.DBCPutil;

/**   
 * @ClassName:  Test   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年7月30日 下午5:13:08       
 */

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=DBCPutil.getConnection();
			ps=conn.prepareStatement("...");
//			...
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCPutil.release(conn, ps, null);
		}
	}

}
