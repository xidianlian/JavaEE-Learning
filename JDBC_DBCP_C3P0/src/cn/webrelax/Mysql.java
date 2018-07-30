
package cn.webrelax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author lianWeiC
 *	
 */
public class Mysql {

	public static void main(String[] args) throws  ClassNotFoundException {
		
			Connection conn=null;
			Statement stm=null;
			ResultSet res=null; 
		try {
			//注册驱动
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());//注册两遍(看Driver底层代码)，依赖jar包，不建议使用
			//改进，实质上com.mysql.jdbc.Driver()方法里调用了DriverManager.registerDriver()
		
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接 connection  jdbc:mysql相当于协议，用的是jdbc,mysql数据库
			
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/android","root","root1234");
			//得到sql语句的对象Statement
			 stm = conn.createStatement();
			//执行sql语句，并返回结果
			 res = stm.executeQuery("select * from api where id<=10");
			//处理结果
			while(res.next()) {
				//res.getObject(1)，列值
				System.out.println(res.getObject(1));
				System.out.println(res.getObject(2));
				
				System.out.println("--------------");
			}
			//如果关闭资源写在此处，一旦某句程序出错，执行不到此处，资源关闭不了
			//关闭资源
			/*res.close();
			stm.close();
			conn.close();*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源,比较保险的方法
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				res=null;
			}
				
			if(stm!=null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stm=null;
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn=null;
			}
			

		}
		
	}

}
