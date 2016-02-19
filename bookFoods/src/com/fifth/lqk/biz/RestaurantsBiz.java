package com.fifth.lqk.biz;

import java.util.List;

import com.fifth.bean.RestaurantsBean;

public interface RestaurantsBiz {

	public List<RestaurantsBean> findByLocation(String rsname, String location);

}
