package com.fifth.wcl.biz;

import java.util.List;

import com.fifth.bean.MenusBean;
import com.fifth.wcl.dao.MenusDao;
import com.fifth.wcl.dao.MenusDaoImpl;

public class MenusBizImpl implements MenusBiz {
	MenusDao menusDao=new MenusDaoImpl();

	@Override
	public List<MenusBean> fetchAllMenusByrestaurant_id(int restaurant_id) {
		List<MenusBean> MenusBeanList=null;
		try {
			MenusBeanList=menusDao.fetchAllMenusByrestaurant_id(restaurant_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MenusBeanList;
	}

}
