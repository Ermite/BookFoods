package com.fifth.llh.biz;

import java.util.List;

import com.fifth.bean.FoodsBean;
import com.fifth.bean.RestaurantsBean;

public interface RestaurantsBiz {

	public List<RestaurantsBean> fetchAll();

	public List<RestaurantsBean> fetchAll(int pageno);

	public List<FoodsBean> fetchRemai();


}
