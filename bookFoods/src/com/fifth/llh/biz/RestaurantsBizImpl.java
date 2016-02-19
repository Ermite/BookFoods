package com.fifth.llh.biz;

import java.util.List;

import com.fifth.bean.FoodsBean;
import com.fifth.bean.RestaurantsBean;
import com.fifth.llh.dao.RestaurantsDao;
import com.fifth.llh.dao.RestaurantsDaoImpl;

public class RestaurantsBizImpl implements RestaurantsBiz{

	RestaurantsDao  restaurantsDao = new RestaurantsDaoImpl();
	@Override
	public List<RestaurantsBean> fetchAll() {
		List<RestaurantsBean> restaurantsBeanList = null;
		try {
			restaurantsBeanList = restaurantsDao.fetchAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restaurantsBeanList;
	}
	@Override
	public List<RestaurantsBean> fetchAll(int pageno) {
		List<RestaurantsBean> restaurantsBeanListPage = null;
		try {
			restaurantsBeanListPage = restaurantsDao.fetchAll(pageno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restaurantsBeanListPage;
	}
	@Override
	public List<FoodsBean> fetchRemai() {
		List<FoodsBean> beans=null;
		try {
			beans =restaurantsDao.fetchRemai();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beans;
	}

}
