package com.fifth.llh.dao;

import java.util.List;

import com.fifth.bean.FoodsBean;
import com.fifth.bean.RestaurantsBean;

public interface RestaurantsDao {

	public List<RestaurantsBean> fetchAll()throws Exception;

	public List<RestaurantsBean> fetchAll(int pageno)throws Exception;

	public List<FoodsBean> fetchRemai()throws Exception;


}
