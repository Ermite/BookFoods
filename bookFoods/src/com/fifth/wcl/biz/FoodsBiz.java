package com.fifth.wcl.biz;

import java.util.List;
import java.util.Map;

import com.fifth.bean.CartFoodBean;
import com.fifth.bean.FoodsBean;

public interface FoodsBiz {

	public Map<FoodsBean,Integer> fetchAllfoodsbByMenu_id(int menu_id);
	public FoodsBean fetchFoodById(int food_id);
	public List<FoodsBean> fetchAllfoodsbByRestaurant_id(int restaurant_id);
	public List<CartFoodBean> fetchACartFoodByCustomer_id(int customer_id);

}
