package com.webrelax.domain;

import java.io.Serializable;

public class Book implements Serializable{
	private String id;
	private String name;
	private double price;
	private int pnum;
	private String category;
	private String description;
	private String imgurl;
	

	

	
	/**
	 * @return imgurl
	 */
	
	public String getImgurl() {
		return imgurl;
	}

	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	/** 
	 * map<Book,String>,Book作为key,可根据id判断两本书相不相等
	 * @return
	 * @see java.lang.Object#hashCode()
	 **/
	    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	/** 
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 **/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
