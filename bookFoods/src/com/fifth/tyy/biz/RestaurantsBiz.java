package com.fifth.tyy.biz;

import java.util.List;

import com.fifth.bean.RestaurantsBean;

public interface RestaurantsBiz {

	List<RestaurantsBean> fetchSearchRestaurantsList(
			RestaurantsBean restaurantsBean);

}
