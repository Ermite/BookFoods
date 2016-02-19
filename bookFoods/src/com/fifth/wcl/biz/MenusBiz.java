package com.fifth.wcl.biz;

import java.util.List;
import java.util.Map;

import com.fifth.bean.FoodsBean;
import com.fifth.bean.MenusBean;

public interface MenusBiz {

	public List<MenusBean> fetchAllMenusByrestaurant_id(int restaurant_id);

	

}
