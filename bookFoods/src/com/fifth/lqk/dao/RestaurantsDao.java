package com.fifth.lqk.dao;

import java.util.List;

import com.fifth.bean.RestaurantsBean;

public interface RestaurantsDao {

	public List<RestaurantsBean> findByLocation(String rsname, String location) throws Exception;

}
