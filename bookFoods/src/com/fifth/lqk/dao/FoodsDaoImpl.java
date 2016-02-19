package com.fifth.lqk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fifth.bean.FoodsBean;
import com.fifth.util.DBUtil;

public class FoodsDaoImpl implements FoodsDao {
	DBUtil dbutil = new DBUtil();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fifth.lqk.dao.FoodsDao#findFoodById(int)
	 */
	@Override
	public FoodsBean findFoodById(int food_id) {
		
		FoodsBean foodsBean = null;
		try {

			conn = dbutil.getConnection();
			String sql = "select * from foods where fid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, food_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				foodsBean = new FoodsBean();
				foodsBean.setFood_charge(rs.getDouble("fcharge"));
				foodsBean.setFood_delivery_type(rs.getInt("fdelivery_type"));
				foodsBean.setFood_img(rs.getString("fimg"));
				foodsBean.setFood_name(rs.getString("fname"));
				foodsBean.setFood_price(rs.getDouble("fprice"));
				foodsBean.setMenu_id(rs.getInt("mid"));
				foodsBean.setFood_sale(rs.getInt("fsale"));
				foodsBean.setFood_id(rs.getInt("fid"));
				
			}

			dbutil.closeDBSource(conn, pstmt, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return foodsBean;
	}

	@Override
	public int fetchNumber() {
		int number = 0;
		try {

			conn = dbutil.getConnection();
			String sql = "select count(*) from foods";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = rs.getInt(1);
			}

			dbutil.closeDBSource(conn, pstmt, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return number;
	}

}
