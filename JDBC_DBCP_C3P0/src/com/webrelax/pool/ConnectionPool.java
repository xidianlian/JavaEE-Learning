
/**  
 * @Title:  ConnectionPool.java   
 * @Package com.webrelax.pool   
 * @Description:    TODO()   
 * @author: xidian_lian
 * @date:   2018年7月29日 上午9:58:19   
 * @version V1.0  
 */
    
package com.webrelax.pool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import cn.webrelax.DBUtils;

/**
 * @ClassName:  ConnectionPool   
 * @TODO(模拟数据库连接池，不具备实际开发意义)   
 * @author: xidian_lian 
 * @date:   2018年7月29日 上午10:02:43
 */

public class ConnectionPool extends Thread {
	//创建一个存放连接的池子
	//Collections.synchronizedList()返回指定列表支持的同步（线程安全的）列表。
	//为了保证按顺序访问，必须通过返回的列表完成所有对底层实现列表的访问。
	private static List<Connection> pool =
			(List<Connection>) Collections.synchronizedList(new LinkedList<Connection>());
	public static void init()  {
		synchronized(pool) {
			//用于测试，仅用两个个连接
			for(int i=0;i<1;i++) {
				try {
					Connection conn=DBUtils.getConnection();
					pool.add(conn);
					
				} catch (Exception e) {
					throw new ExceptionInInitializerError("初始化数据库连接失败");
				}
			}
		}
	}
	public Connection getConnectionFromPool() {
		//不能把synchronized写在函数声明前
		//因为这里锁的不是this对象，而是pool（一个list）
		synchronized(pool) {
			if(pool.size()>0) {
				Connection conn= pool.get(0);
				pool.remove(0);
				return conn;
			}
			else {
				//先等待，如果超时，新创建连接
				throw new RuntimeException("服务器忙（真忙）");
			}
		}
		
	}
	//将使用完的连接放回连接池
	public void release(Connection conn) {
		pool.add(conn);
	}
	
	
	
	
	/*************线程测试的代码*************************/
	@Override
	public  void run() {
		
		synchronized(pool) {
			System.out.println(pool.size());
			if(pool.size()>0) {
				Connection conn= pool.get(0);
				pool.remove(0);
			}
			else {
				//先等待，如果超时，新创建连接
				throw new RuntimeException("服务器忙（真忙）");
			}
		}

		
	}
	public static void main(String[] args) {
		ConnectionPool.init();
		ConnectionPool test1= new ConnectionPool();
		ConnectionPool test2= new ConnectionPool();
		test1.start();
		test2.start();
		
	}
}
