
/**  
 * @Title:  MyDataSource.java   
 * @Package com.webrelax.pool   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月30日 上午11:24:31   
 * @version V1.0  
 */
    
package com.webrelax.pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import cn.webrelax.DBUtils;

/**   
 * @ClassName:  MyDataSource   
 * @TODO(装饰模式，使用官方提供的接口写close()，实现DataSource接口)   
 * @author: xidian_lian 
 * @date:   2018年7月30日 上午11:24:31       
 */

public class MyDataSource implements DataSource{
	
	private static LinkedList<Connection> pool =
			(LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());
	public void MyDataSource()  {
		synchronized(pool) {
			//用于测试，仅用两个个连接
			for(int i=0;i<1;i++) {
				try {
					//通过DBUtils工具类创建
					Connection conn=DBUtils.getConnection();
					pool.add(conn);
					
				} catch (Exception e) {
					throw new ExceptionInInitializerError("初始化数据库连接失败");
				}
			}
		}
	}
	/** 
	 * @return
	 * @throws SQLException
	 * @see javax.sql.DataSource#getConnection()
	 **/
	    
	
	public Connection getConnection() throws SQLException {
		//不能把synchronized写在函数声明前
		//因为这里锁的不是this对象，而是pool（一个list）
		synchronized(pool) {
			if(pool.size()>0) {
				Connection conn= pool.removeFirst();
				MyConnection myconn=new MyConnection(conn,pool);
				return myconn;
			}
			else {
				//先等待，如果超时，新创建连接
				throw new RuntimeException("服务器忙（真忙）");
			}
		}
	
	}

	
	
	    

	/****************一下方法先不管**************/
	/** 
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 * @see javax.sql.DataSource#getConnection(java.lang.String, java.lang.String)
	 **/
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	/** 
	 * @return
	 * @throws SQLException
	 * @see javax.sql.CommonDataSource#getLogWriter()
	 **/
	    
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/** 
	 * @param out
	 * @throws SQLException
	 * @see javax.sql.CommonDataSource#setLogWriter(java.io.PrintWriter)
	 **/
	    
	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	/** 
	 * @param seconds
	 * @throws SQLException
	 * @see javax.sql.CommonDataSource#setLoginTimeout(int)
	 **/
	    
	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	/** 
	 * @return
	 * @throws SQLException
	 * @see javax.sql.CommonDataSource#getLoginTimeout()
	 **/
	    
	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	/** 
	 * @return
	 * @throws SQLFeatureNotSupportedException
	 * @see javax.sql.CommonDataSource#getParentLogger()
	 **/
	    
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/** 
	 * @param iface
	 * @return
	 * @throws SQLException
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 **/
	    
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/** 
	 * @param iface
	 * @return
	 * @throws SQLException
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 **/
	    
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

}
