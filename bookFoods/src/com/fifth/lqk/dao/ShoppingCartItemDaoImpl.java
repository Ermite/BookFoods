package com.fifth.lqk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fifth.bean.ShoppingCartItemBean;
import com.fifth.util.DBUtil;

public class ShoppingCartItemDaoImpl implements ShoppingCartItemDao {
	DBUtil dbutil = new DBUtil();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	@Override
	public ArrayList<ShoppingCartItemBean> findAllShoppingCartItem() {
		ArrayList<ShoppingCartItemBean> list=new ArrayList<ShoppingCartItemBean>();
		ShoppingCartItemBean shoppingCartItemBean = null;
		try {
			
			conn = dbutil.getConnection();
			String sql = "select * from shoppingcartitem";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				shoppingCartItemBean = new ShoppingCartItemBean();
				shoppingCartItemBean.setShoppingCartItem_id(rs.getInt("sci_id"));
				shoppingCartItemBean.setFood_booktime(rs.getString("sci_booktime"));
				shoppingCartItemBean.setFood_count(rs.getInt("fcount"));
				shoppingCartItemBean.setFood_id(rs.getInt("fid"));
				shoppingCartItemBean.setShoppingCart_id(rs.getInt("sid"));
				list.add(shoppingCartItemBean);
			}
	
			dbutil.closeDBSource(conn, pstmt, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}

}
