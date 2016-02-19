package com.fifth.lqk.biz;

import java.util.List;

import com.fifth.bean.RestaurantsBean;
import com.fifth.lqk.dao.RestaurantsDao;
import com.fifth.lqk.dao.RestaurantsDaoImpl;


public class RestaurantsBizImpl implements RestaurantsBiz {
	RestaurantsDao  restaurantsDao = new RestaurantsDaoImpl();
	@Override
	public List<RestaurantsBean> findByLocation(String rsname,String location) {
		List<RestaurantsBean> restaurantsBeanList = null;
		try {
			restaurantsBeanList = restaurantsDao.findByLocation(rsname,location);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restaurantsBeanList;
	}

}
