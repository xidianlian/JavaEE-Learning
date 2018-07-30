
/**  
 * @Title:  Test.java   
 * @Package com.webrelax.pool   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月30日 上午11:32:23   
 * @version V1.0  
 */
    
package com.webrelax.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

/**   
 * @ClassName:  Test   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年7月30日 上午11:32:23       
 */

public class Test {
	
	public static void main(String[] args) {
		//所有程序员都知道DataSource，并不知道你自己写的MyDataSource
		DataSource ds=new MyDataSource();
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//先调用MyDataSource.getgetConnection()，在此方法中将连接池中的conn包装成MyConnection。
			//返回来的是MyConnection的对象，因此可以调它重写的close();
			 conn=ds.getConnection();
			 ps=conn.prepareStatement("...");//这个方法没重写，还是原来的
			 //...
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//不能直接用Api自带的conn.close(); 需要装饰
			//因为在连接池中创建了十个连接，如果关闭就会少一个
			//应该将此连接放回池中，但是放回去过程中如果在MyDataSource写
			//那么，用ds对象调用不到（转换为父类的对象了）
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
