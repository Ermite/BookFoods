package com.fifth.lqk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fifth.bean.RestaurantsBean;
import com.fifth.lqk.servlet.StringSql;
import com.fifth.util.DBUtil;

public class RestaurantsDaoImpl implements RestaurantsDao {
	DBUtil dbUtil = null;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	

	@Override
	public List<RestaurantsBean> findByLocation(String rsname,String location) throws Exception{
		List<RestaurantsBean> restaurantsBeanList = null;
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
		
		StringSql test = new StringSql();
		
		String hha=test.appendstring(rsname,location);
		
		System.out.println(hha);
		ps=conn.prepareStatement(hha);
		rs = ps.executeQuery();
		
		
		while(rs.next()){
			if(restaurantsBeanList==null){
				restaurantsBeanList = new ArrayList<RestaurantsBean>();
			}
			RestaurantsBean bean = new RestaurantsBean();
			bean.setRestaurant_id(rs.getInt("rid"));
			bean.setRestaurant_name(rs.getString("rname"));
			bean.setRestaurant_location(rs.getString("rlocation"));
			bean.setRestaurant_clickrate(rs.getInt("rclick_rate"));
			bean.setRestaurant_type(rs.getInt("rtype"));
			bean.setRestaurant_img(rs.getString("rimg"));
			
			restaurantsBeanList.add(bean);
		}
		dbUtil.closeDBSource(conn, ps, rs);
		return restaurantsBeanList;
	}


}
