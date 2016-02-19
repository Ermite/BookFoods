package com.fifth.wcl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fifth.bean.ShoppingCartBean;
import com.fifth.bean.ShoppingCartItemBean;
import com.fifth.util.DBUtil;

public class ShoppingCartDaoImpl implements ShoppingCartDao {
	DBUtil dbutil = new DBUtil();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	@Override
	public ArrayList<ShoppingCartItemBean> fetchshoppingCartItemByCustomer_id(
			int current_id) throws Exception {
		ArrayList<ShoppingCartItemBean> shoppingCartItemBeanList=new ArrayList<ShoppingCartItemBean>();
		conn = dbutil.getConnection();
		String sql = "select * from shoppingcart sc,shoppingcartitem sci where sc.sid=sci.sid and sc.cid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,current_id);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			ShoppingCartItemBean shoppingCartItemBean=new ShoppingCartItemBean();
			shoppingCartItemBean.setCustomer_id(rs.getInt("cid"));
			shoppingCartItemBean.setFood_count(rs.getInt("fcount"));
			shoppingCartItemBean.setFood_booktime(rs.getString("sci_booktime"));
			shoppingCartItemBean.setFood_id(rs.getInt("fid"));
			shoppingCartItemBean.setShoppingCart_id(rs.getInt("sid"));
			shoppingCartItemBean.setShoppingCartItem_id(rs.getInt("sci_id"));
			shoppingCartItemBeanList.add(shoppingCartItemBean);
			
			
		}
		dbutil.closeDBSource(conn, pstmt, rs);
		return shoppingCartItemBeanList;
	}
	@Override
	public void changeFoodNumById(int food_id) throws Exception {
		conn = dbutil.getConnection();
		String sql = "update shoppingcartitem  set fcount =fcount+1 where fid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,food_id);
		pstmt.executeUpdate();
		dbutil.closeDBSource(conn, pstmt, rs);
		
	}
	@Override
	public void addNewShoppingCartItem(ShoppingCartItemBean shoppingCartItemBean)
			throws Exception {
		conn = dbutil.getConnection();
		String sql = "insert into shoppingcartitem(sid,fid,cid,sci_booktime) value(?,?,?,NOW()) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,shoppingCartItemBean.getShoppingCart_id());
		pstmt.setInt(2,shoppingCartItemBean.getFood_id());
		pstmt.setInt(3, shoppingCartItemBean.getCustomer_id());
		pstmt.executeUpdate();
		dbutil.closeDBSource(conn, pstmt, rs);
		
	}
	@Override
	public ShoppingCartBean fetchshoppingCartByCustomer_id(int current_id)
			throws Exception {
		ShoppingCartBean shoppingCartBean=null;
		conn = dbutil.getConnection();
		String sql = "select * from shoppingcart where cid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,current_id);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			shoppingCartBean=new ShoppingCartBean();
			shoppingCartBean.setShoppingCart_id(rs.getInt("sid"));
			shoppingCartBean.setCustomer_id(rs.getInt("cid"));
			shoppingCartBean.setShoppingCart_type(rs.getInt("stype"));
			shoppingCartBean.setShoppingCart_count(rs.getInt("scount"));
			
			
		}
		dbutil.closeDBSource(conn, pstmt, rs);
		return shoppingCartBean;
	}
	@Override
	public void addShoppingCartByCustomer_id(int current_id) throws Exception {
		conn = dbutil.getConnection();
		String sql = "insert into shoppingcart(cid) value(?) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,current_id);
		pstmt.executeUpdate();
		dbutil.closeDBSource(conn, pstmt, rs);
		
	}
	@Override
	public int clearShoppingCartByCid(int customer_id) throws Exception {
		int row=0;
		conn = dbutil.getConnection();
		String sql = "delete from shoppingcartitem where cid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,customer_id);
		row=pstmt.executeUpdate();
		dbutil.closeDBSource(conn, pstmt, rs);
		return row;
	}
	@Override
	public void changeFoodNumById(int shoppingCartItem_id, int buy_number)
			throws Exception {
		conn = dbutil.getConnection();
		String sql = "update shoppingcartitem  set fcount =? where sci_id=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,buy_number);
		pstmt.setInt(2,shoppingCartItem_id);
		pstmt.executeUpdate();
		dbutil.closeDBSource(conn, pstmt, rs);
		
	}
	@Override
	public void deleteCartItemById(int shoppingCartItem_id) throws Exception {
		conn = dbutil.getConnection();
		String sql = "delete from shoppingcartitem where sci_id=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,shoppingCartItem_id);
		pstmt.executeUpdate();
		dbutil.closeDBSource(conn, pstmt, rs);
		
	}

}
