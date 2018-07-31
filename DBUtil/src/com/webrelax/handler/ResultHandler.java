
/**  
 * @Title:  Handler.java   
 * @Package com.webrelax.handler   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月31日 上午10:27:56   
 * @version V1.0  
 */
    
package com.webrelax.handler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.webrelax.crud.C3P0Util;
import com.webrelax.crud.User;

/**   
 * @ClassName:  Handler   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年7月31日 上午10:27:56       
 */

public class ResultHandler {
	//ArrayHandler:适合取1条记录。把该条记录的每列值封装到一个数组中Object[]
	public void test1() throws SQLException{
		//不建议将这句话写到全局（线程安全考虑）
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		//默认取第一行
		Object[] arr  = qr.query("select * from users", new ArrayHandler());
		
		for (Object o : arr) {
			System.out.print(o+" ");
		}
		System.out.println();
	}
	
	//ArrayListHandler:适合取多条记录。把每条记录的每列值封装到一个数组中Object[]，把数组封装到一个List中
	public void test2() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<Object[]> query = qr.query("select * from users", new ArrayListHandler());
		
		for (Object[] os : query) {
			for (Object o : os) {
				System.out.print(o+" ");
			}
			System.out.println("");
		}
	}
	
	 //ColumnListHandler:取某一列的数据。封装到List中。
	public void test3() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		//根据查询语句中的第几列
		List<Object> list = qr.query("select username,password from users", new ColumnListHandler(1));
		
		for (Object o : list) {
			System.out.println(o);
		}
	}
	
	 //KeyedHandler:取多条记录，每一条记录封装到一个Map中，再把这个Map封装到另外一个Map中，key为指定的字段值。
	public void test4() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		//大Map的key是表中的某列数据，小Map中的key是表的列名，所以大Map的key是Object类型，小Map的key是String类型
		//每一行结果集的对应列名的映射
		Map<Object,Map<String,Object>> map = qr.query("select * from users", new KeyedHandler(1));
		
		for (Map.Entry<Object, Map<String,Object>> m : map.entrySet()) {
			System.out.println(m.getKey());//大Map中key值就是id列的值
			for (Map.Entry<String, Object> mm : m.getValue().entrySet()) {
				System.out.println(mm.getKey()+"\t"+mm.getValue());//取出小Map中的列名和列值
			}
			System.out.println("---------------------");
		}
		
	}
	
	
	//MapHandler:适合取1条记录。把当前记录的列名和列值放到一个Map中
	public void test5() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Map<String,Object> map = qr.query("select * from users where id=?", new MapHandler(),2);
		
		for (Map.Entry<String, Object> m : map.entrySet()) {
			System.out.println(m.getKey()+"\t"+m.getValue());
		}
		
	}
	
	
	//MapListHandler:适合取多条记录。把每条记录封装到一个Map中，再把Map封装到List中
	public void test6() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<Map<String,Object>> list = qr.query("select * from users", new MapListHandler());
		
		for (Map<String, Object> map : list) {
			for (Map.Entry<String, Object> m : map.entrySet()) {
				System.out.println(m.getKey()+"\t"+m.getValue());
			}
			System.out.println("---------------");
		}
	}
	
	 //ScalarHandler:适合取单行单列数据
	public void test7() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Object o = qr.query("select count(*) from users", new ScalarHandler(1));
		System.out.println(o.getClass().getName()+" "+o);
	}
	
	 //BeanHandler:适合取单行单列数据
	public void test8() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		User user = qr.query("select * from users where id=?", new BeanHandler<User>(User.class),1);
		System.out.println(user);
	}
	
	
	 //BeanListHandler 
	public void test9() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<User> list = qr.query("select * from users where id=?", new BeanListHandler<User>(User.class),1);
		
		System.out.println(list.size());
	}
}
