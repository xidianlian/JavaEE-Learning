
/**  
 * @Title:  Test.java   
 * @Package com.webrelax.crud   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月31日 上午9:06:34   
 * @version V1.0  
 */
    
package com.webrelax.crud;

import java.sql.SQLException;

/**   
 * @ClassName:  Test   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年7月31日 上午9:06:34       
 */

public class Test {

	/**@Title: main
	 * @TODO()
	 * @param args    参数
	 * @return void    返回类型
		*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		try {
			db.testSelect1();
			System.out.println("************************");
			db.testSelect2();
			
			db.testBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
