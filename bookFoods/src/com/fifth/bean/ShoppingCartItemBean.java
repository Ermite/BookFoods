package com.fifth.bean;

public class ShoppingCartItemBean {
	private int shoppingCartItem_id;//购物车项目id
	private int shoppingCart_id;//购物车id
	private int food_id;//食物id
	private int food_count;//食物数量
	private String food_booktime;//预定时间
	private int customer_id;//顾客id
	public int getShoppingCartItem_id() {
		return shoppingCartItem_id;
	}
	public void setShoppingCartItem_id(int shoppingCartItem_id) {
		this.shoppingCartItem_id = shoppingCartItem_id;
	}
	public int getShoppingCart_id() {
		return shoppingCart_id;
	}
	public void setShoppingCart_id(int shoppingCart_id) {
		this.shoppingCart_id = shoppingCart_id;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public int getFood_count() {
		return food_count;
	}
	public void setFood_count(int food_count) {
		this.food_count = food_count;
	}
	public String getFood_booktime() {
		return food_booktime;
	}
	public void setFood_booktime(String food_booktime) {
		this.food_booktime = food_booktime;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	

}
