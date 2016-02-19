package com.fifth.wcl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import com.fifth.bean.CartFoodBean;
import com.fifth.bean.FoodsBean;
import com.fifth.util.DBUtil;

public class FoodsDaoImpl implements FoodsDao {
	DBUtil dbutil = new DBUtil();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public Map<FoodsBean,Integer> fetchAllfoodsbByMenu_id(int menu_id)
			throws Exception {
		Map<FoodsBean,Integer> map=new IdentityHashMap<FoodsBean,Integer>();
		try {
			conn = dbutil.getConnection();
			String sql = "select * from foods where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,menu_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FoodsBean foodsBean=new FoodsBean();
				foodsBean.setFood_id(rs.getInt("fid"));
				foodsBean.setFood_charge(rs.getDouble("fcharge"));
				foodsBean.setFood_delivery_type(rs.getInt("fdelivery_type"));
				foodsBean.setFood_img(rs.getString("fimg"));
				foodsBean.setFood_name(rs.getString("fname"));
				foodsBean.setFood_number(rs.getInt("fnumber"));
				foodsBean.setFood_price(rs.getDouble("fprice"));
				foodsBean.setFood_sale(rs.getInt("fsale"));
				foodsBean.setMenu_id(rs.getInt("mid"));
				map.put(foodsBean,(Integer)menu_id);
				//foodsBean.setShoppingCart_id(rs.getInt("sid"));
				
			}
			dbutil.closeDBSource(conn, pstmt, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public FoodsBean fetchFoodById(int food_id) throws Exception {
		FoodsBean foodsBean=null;
		conn = dbutil.getConnection();
		String sql = "select * from foods where fid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,food_id);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			foodsBean=new FoodsBean();
			foodsBean.setFood_id(rs.getInt("fid"));
			foodsBean.setFood_charge(rs.getDouble("fcharge"));
			foodsBean.setFood_delivery_type(rs.getInt("fdelivery_type"));
			foodsBean.setFood_img(rs.getString("fimg"));
			foodsBean.setFood_name(rs.getString("fname"));
			foodsBean.setFood_number(rs.getInt("fnumber"));
			foodsBean.setFood_price(rs.getDouble("fprice"));
			foodsBean.setFood_sale(rs.getInt("fsale"));
			foodsBean.setMenu_id(rs.getInt("mid"));
			//foodsBean.setShoppingCart_id(rs.getInt("sid"));
			
	}
		dbutil.closeDBSource(conn, pstmt, rs);
		return foodsBean;
 }

	@Override
	public List<FoodsBean> fetchAllfoodsbByRestaurant_id(int restaurant_id)
			throws Exception {
		List<FoodsBean> list=new ArrayList<FoodsBean>();
		conn = dbutil.getConnection();
		String sql = "select * from foods f,restaurants r,menus m where r.rid=? AND m.rid=r.rid AND f.mid=m.mid ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,restaurant_id);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			FoodsBean foodsBean=new FoodsBean();
			foodsBean.setFood_id(rs.getInt("fid"));
			foodsBean.setFood_charge(rs.getDouble("fcharge"));
			foodsBean.setFood_delivery_type(rs.getInt("fdelivery_type"));
			foodsBean.setFood_img(rs.getString("fimg"));
			foodsBean.setFood_name(rs.getString("fname"));
			foodsBean.setFood_number(rs.getInt("fnumber"));
			foodsBean.setFood_price(rs.getDouble("fprice"));
			foodsBean.setFood_sale(rs.getInt("fsale"));
			foodsBean.setMenu_id(rs.getInt("mid"));
			list.add(foodsBean);
		}
		dbutil.closeDBSource(conn, pstmt, rs);
		return list;
	}

	@Override
	public List<CartFoodBean> fetchACartFoodByCustomer_id(int customer_id)
			throws Exception {
		List<CartFoodBean> list=new ArrayList<CartFoodBean>();
		conn = dbutil.getConnection();
		String sql = "select * from foods f,shoppingcart s,shoppingcartitem sct"
				+ " where s.cid=? AND s.sid=sct.sid AND f.fid=sct.fid";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,customer_id);
		rs = pstmt.executeQuery();
		rs = pstmt.executeQuery();
		while (rs.next()) {
			CartFoodBean cartFoodBean=new CartFoodBean();
			cartFoodBean.setFood_id(rs.getInt("fid"));
			cartFoodBean.setFood_img(rs.getString("fimg"));
			cartFoodBean.setFood_name(rs.getString("fname"));
			cartFoodBean.setFood_price(rs.getDouble("fprice"));
			cartFoodBean.setFood_booktime(rs.getString("sci_booktime"));
			cartFoodBean.setFood_count(rs.getInt("fcount"));
			cartFoodBean.setShoppingCart_id(rs.getInt("sid"));
			cartFoodBean.setShoppingCartItem_id(rs.getInt("sci_id"));
			list.add(cartFoodBean);
		}
		dbutil.closeDBSource(conn, pstmt, rs);
		return list;
	}	
}
