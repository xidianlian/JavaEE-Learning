
/**  
 * @Title:  UUIDUtil.java   
 * @Package com.webrelax.util   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年8月1日 上午11:28:04   
 * @version V1.0  
 */
    
package com.webrelax.util;

import java.util.UUID;

/**   
 * @ClassName:  UUIDUtil   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年8月1日 上午11:28:04       
 */

public class UUIDUtil {
	public static String getUUID() {
		//生成一个id,十亿分之一的概率重名
		return UUID.randomUUID().toString();
	}
}
