package com.fifth.wcl.dao;

import java.util.List;

import com.fifth.bean.MenusBean;

public interface MenusDao {

	public List<MenusBean> fetchAllMenusByrestaurant_id(int restaurant_id) throws Exception;

}
