
/**  
 * @Title:  DBCPutil.java   
 * @Package com.webrelax.dbcputil   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月30日 下午4:44:12   
 * @version V1.0  
 */
    
package com.webrelax.dbcputil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**   
 * @ClassName:  DBCPutil   
 * @TODO(利用apache公司提供的dbcp包和pool包写连接池的工具类)   
 * @author: xidian_lian 
 * @date:   2018年7月30日 下午4:44:12       
 */

public class DBCPutil {
	private static DataSource ds=null;
	static {
		Properties prop=new Properties();
		try {
			//加载文件
			InputStream is=DBCPutil.class.getClassLoader().getResourceAsStream("dbcp.properties");
			//或者（没有试）is=new FileInputStream("src/dbcpconfig.properties")；
			prop.load(is);
			//得到一个数据源（连接池看配置文件中的设置）
			//相当于自写的MyDataSource
			ds=BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("服务器忙。。。。");
		}
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
				conn.close();//关闭,apache提供的包里已经处理好了
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
}
