package com.fifth.bean;

public class CustomerBean {
	private int customer_id;//用户id
	private String customer_name;//用户名
	private String customer_password;//用户密码
	private String customer_email;//用户Email
	private int customer_type;
	private int shoppingCart_id;//购物车ID
	public int getShoppingCart_id() {
		return shoppingCart_id;
	}
	public void setShoppingCart_id(int shoppingCart_id) {
		this.shoppingCart_id = shoppingCart_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_password() {
		return customer_password;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public int getCustomer_type() {
		return customer_type;
	}
	public void setCustomer_type(int customer_type) {
		this.customer_type = customer_type;
	}
	
}
