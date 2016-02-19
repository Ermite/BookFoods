package com.fifth.tyy.biz;

import java.util.List;
import com.fifth.bean.RestaurantsBean;
import com.fifth.tyy.dao.RestaurantsDao;


public class RestaurantsBizImpl implements RestaurantsBiz {

	@Override
	public List<RestaurantsBean> fetchSearchRestaurantsList(
			//RestaurantsDao restaurantsDao =new Res
		RestaurantsBean restaurantsBean) {
			List<RestaurantsBean> restaurantsBeanList = null;
			try {
				restaurantsBeanList = RestaurantsDao.fetchSearchMeetingList(
						restaurantsBean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return restaurantsBeanList;
	}

}
