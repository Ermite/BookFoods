package com.fifth.wcl.biz;

import java.util.List;
import java.util.Map;

import com.fifth.bean.CartFoodBean;
import com.fifth.bean.FoodsBean;
import com.fifth.wcl.dao.FoodsDao;
import com.fifth.wcl.dao.FoodsDaoImpl;

public class FoodsBizImpl implements FoodsBiz {
	FoodsDao foodsDao=new FoodsDaoImpl();

	@Override
	public Map<FoodsBean,Integer> fetchAllfoodsbByMenu_id(int menu_id) {
		Map<FoodsBean,Integer> map=null;
		try {
			map=foodsDao.fetchAllfoodsbByMenu_id(menu_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public FoodsBean fetchFoodById(int food_id) {
		FoodsBean foodsBean=null;
		try {
			foodsBean=foodsDao.fetchFoodById(food_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foodsBean;
	}

	@Override
	public List<FoodsBean> fetchAllfoodsbByRestaurant_id(int restaurant_id) {
		List<FoodsBean> list=null;
		try {
			list=foodsDao.fetchAllfoodsbByRestaurant_id(restaurant_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CartFoodBean> fetchACartFoodByCustomer_id(int customer_id) {
		List<CartFoodBean> list=null;
		try {
			list=foodsDao.fetchACartFoodByCustomer_id(customer_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
