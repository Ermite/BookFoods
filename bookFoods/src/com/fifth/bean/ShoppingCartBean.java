package com.fifth.bean;

public class ShoppingCartBean {
	private int shoppingCart_id;//购物车ID
	private int customer_id;//顾客id
	private int shoppingCart_type;//购物车类型 0未提交，1已提交
	private int shoppingCart_count;//购物车中的项目数
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
	public int getShoppingCart_type() {
		return shoppingCart_type;
	}
	public void setShoppingCart_type(int shoppingCart_type) {
		this.shoppingCart_type = shoppingCart_type;
	}
	public int getShoppingCart_count() {
		return shoppingCart_count;
	}
	public void setShoppingCart_count(int shoppingCart_count) {
		this.shoppingCart_count = shoppingCart_count;
	}

}
