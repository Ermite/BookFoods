package com.fifth.bean;

public class RestaurantsBean {
	private int restaurant_id;//餐厅id
	private String restaurant_name;//餐厅名称
	private String restaurant_location;//餐厅地理位置
	private int restaurant_type;//餐厅类型 0未营业，1营业
	private int restaurant_clickrate;//餐厅点击量
	private String restaurant_img;//餐厅图片
	
	public String getRestaurant_img() {
		return restaurant_img;
	}
	public void setRestaurant_img(String restaurant_img) {
		this.restaurant_img = restaurant_img;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public String getRestaurant_location() {
		return restaurant_location;
	}
	public void setRestaurant_location(String restaurant_location) {
		this.restaurant_location = restaurant_location;
	}
	public int getRestaurant_type() {
		return restaurant_type;
	}
	public void setRestaurant_type(int restaurant_type) {
		this.restaurant_type = restaurant_type;
	}
	public int getRestaurant_clickrate() {
		return restaurant_clickrate;
	}
	public void setRestaurant_clickrate(int restaurant_clickrate) {
		this.restaurant_clickrate = restaurant_clickrate;
	}

}
