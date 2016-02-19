package com.fifth.wcl.dao;

import java.util.List;
import java.util.Map;

import com.fifth.bean.CartFoodBean;
import com.fifth.bean.FoodsBean;

public interface FoodsDao {

	public Map<FoodsBean,Integer> fetchAllfoodsbByMenu_id(int menu_id) throws Exception;

	public FoodsBean fetchFoodById(int food_id) throws Exception;

	public List<FoodsBean> fetchAllfoodsbByRestaurant_id(int restaurant_id)throws Exception;

	public List<CartFoodBean> fetchACartFoodByCustomer_id(int customer_id)throws Exception;

}
