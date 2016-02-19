package com.fifth.llh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fifth.bean.FoodsBean;
import com.fifth.bean.PagingBean;
import com.fifth.bean.RestaurantsBean;
import com.fifth.util.DBUtil;

public class RestaurantsDaoImpl implements RestaurantsDao{

	DBUtil dbUtil = null;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<RestaurantsBean> fetchAll() throws Exception {
		List<RestaurantsBean> restaurantsBeanList = null;
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
		String sql = "select * from restaurants";
		ps=conn.prepareStatement(sql );
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

	@Override
	public List<RestaurantsBean> fetchAll(int pageno) throws Exception {
		List<RestaurantsBean> restaurantsBeanList = null;
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
		String sql = "select * from restaurants order by rclick_rate limit ?,?";
		ps=conn.prepareStatement(sql );
		int startIndex = (pageno-1)*PagingBean.MAX_PAGE_SIZE;
		ps.setInt(1, startIndex);
		ps.setInt(2, PagingBean.MAX_PAGE_SIZE);
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

	@Override
	public List<FoodsBean> fetchRemai() throws Exception {
		List<FoodsBean> beans = null;
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
		String sql = "select * from foods order by fsale desc ";
		ps=conn.prepareStatement(sql );
		rs = ps.executeQuery();
		
		while(rs.next()){
			if(beans==null){
				beans = new ArrayList<FoodsBean>();
			}
			FoodsBean bean = new FoodsBean();
			bean.setFood_id(rs.getInt("fid"));
			bean.setFood_name(rs.getString("fname"));
			bean.setFood_number(rs.getInt("fnumber"));
			bean.setFood_img(rs.getString("fimg"));
			bean.setFood_price(rs.getDouble("fprice"));
			bean.setFood_sale(rs.getInt("fsale"));
			bean.setMenu_id(rs.getInt("mid"));
			bean.setFood_delivery_type(rs.getInt("fdelivery_type"));
			bean.setFood_charge(rs.getDouble("fcharge"));
			
			beans.add(bean);
		}
		dbUtil.closeDBSource(conn, ps, rs);
		return beans;
	}

}
