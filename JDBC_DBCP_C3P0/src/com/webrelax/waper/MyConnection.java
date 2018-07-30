
/**  
 * @Title:  MyConnection.java   
 * @Package com.webrelax.waper   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月30日 下午3:49:52   
 * @version V1.0  
 */
    
package com.webrelax.waper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

/**   
 * @ClassName:  MyConnection   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年7月30日 下午3:49:52       
 */

public class MyConnection extends MyConnectionWarper{

	private Connection oldcon;
    private LinkedList<Connection> pool;
	public MyConnection(Connection oldConnection, LinkedList<Connection> pool) {
		super(oldConnection);
		this.oldcon=oldConnection;
		this.pool=pool;
	}
	//这里就专注重写的方法就行了
	@Override
	public void close() throws SQLException {
		
		pool.addLast(oldcon);
	}
	
}
