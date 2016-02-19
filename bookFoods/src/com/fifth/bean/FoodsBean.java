package com.fifth.bean;

public class FoodsBean {
	private int food_id;//食物id
	private String food_name;//食物名称
	private String food_img;//食物图片描述
	private int food_number;//食物库存
	private double food_price;//食物价格
	private int shoppingCart_id;//购物车id
	private int menu_id;//菜单id
	private int food_sale;//食物销售量
	private int food_delivery_type;//配送类型 0 免费，1 收费
	private double food_charge;//配送费
	
	public int getFood_sale() {
		return food_sale;
	}
	public void setFood_sale(int food_sale) {
		this.food_sale = food_sale;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_img() {
		return food_img;
	}
	public void setFood_img(String food_img) {
		this.food_img = food_img;
	}
	public int getFood_number() {
		return food_number;
	}
	public void setFood_number(int food_number) {
		this.food_number = food_number;
	}
	public double getFood_price() {
		return food_price;
	}
	public void setFood_price(double food_price) {
		this.food_price = food_price;
	}
	public int getShoppingCart_id() {
		return shoppingCart_id;
	}
	public void setShoppingCart_id(int shoppingCart_id) {
		this.shoppingCart_id = shoppingCart_id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	
	public int getFood_delivery_type() {
		return food_delivery_type;
	}
	public void setFood_delivery_type(int food_delivery_type) {
		this.food_delivery_type = food_delivery_type;
	}
	public double getFood_charge() {
		return food_charge;
	}
	public void setFood_charge(double food_charge) {
		this.food_charge = food_charge;
	}
	
	
	

}
