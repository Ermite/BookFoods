package com.fifth.tyy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.fifth.bean.RestaurantsBean;
import com.fifth.util.DBUtil;
public class RestaurantsDaoImpl implements RestaurantsDao {
	DBUtil dbutil = new DBUtil();
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet= null;
	public List<RestaurantsBean> fetchSearchMeetingList(
			RestaurantsBean restaurantsBean) throws Exception {
		List<RestaurantsBean> restaurantsBeanList = null;
		connection = dbutil.getConnection();
		String sql = "select * from meetinginfo where meetingname like ? and capacity like ? and accountname like ? and adddate like ? and startdate like ? and enddate like ? limit ?,?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, "%" + restaurantsBean.getRestaurant_name()
				+ "%");
		preparedStatement.setString(2, "%" + restaurantsBean.getRestaurant_location()
				+ "%");
		preparedStatement.setString(3, "%" + restaurantsBean.getRestaurant_type()
				+ "%");
		preparedStatement
				.setString(4, "%" + restaurantsBean.getRestaurant_clickrate() + "%");
		preparedStatement.setString(5, "%" + restaurantsBean.getRestaurant_img()
				+ "%");
		
		resultSet = preparedStatement.executeQuery();

		restaurantsBeanList = new ArrayList<RestaurantsBean>();
		while (resultSet.next()) {
			RestaurantsBean restaurantsBean2 = new RestaurantsBean();
			restaurantsBean2.setRestaurant_id(resultSet.getInt("restaurant_id"));
			restaurantsBean2.setRestaurant_name(resultSet.getString("restaurant_name"));
			restaurantsBean2.setRestaurant_location(resultSet.getString("restaurant_location"));
			restaurantsBean2.setRestaurant_type(resultSet.getInt("restaurant_type"));
			restaurantsBean2.setRestaurant_clickrate(resultSet.getInt("restaurant_clickrate"));
			restaurantsBean2.setRestaurant_img(resultSet.getString("Restaurant_img"));
			
			restaurantsBeanList.add(restaurantsBean2);

		}
		dbutil.closeDBSource(connection, preparedStatement, resultSet);
		return restaurantsBeanList;
	}

}
