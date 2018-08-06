
/**  
 * @Title:  User.java   
 * @Package com.webrelax.domain   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年8月5日 下午8:49:43   
 * @version V1.0  
 */
    
package com.webrelax.domain;

import java.util.Date;

/**   
 * @ClassName:  User   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年8月5日 下午8:49:43       
 */

public class User {
private String username;
private String password;
private Date birthday; 
private String email;

/**
 * @return username
 */

public String getUsername() {
	return username;
}

/**
 * @param paramtheparamthe{bare_field_name} to set
 */

public void setUsername(String username) {
	this.username = username;
}

/**
 * @return password
 */

public String getPassword() {
	return password;
}

/**
 * @param paramtheparamthe{bare_field_name} to set
 */

public void setPassword(String password) {
	this.password = password;
}

/**
 * @return birthday
 */

public Date getBirthday() {
	return birthday;
}

/**
 * @param paramtheparamthe{bare_field_name} to set
 */

public void setBirthday(Date birthday) {
	this.birthday = birthday;
}

/**
 * @return email
 */

public String getEmail() {
	return email;
}

/**
 * @param paramtheparamthe{bare_field_name} to set
 */

public void setEmail(String email) {
	this.email = email;
}
}
