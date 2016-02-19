package com.fifth.wcl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fifth.bean.MenusBean;
import com.fifth.bean.ShoppingCartItemBean;
import com.fifth.util.DBUtil;

public class MenusDaoImpl implements MenusDao {
	DBUtil dbutil = new DBUtil();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public List<MenusBean> fetchAllMenusByrestaurant_id(int restaurant_id)
			throws Exception {
		List<MenusBean> menusBeanList = new ArrayList<MenusBean>();
		MenusBean menusBean = null;
		try {

			conn = dbutil.getConnection();
			String sql = "select * from menus where rid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,restaurant_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				menusBean = new MenusBean();
				menusBean.setMenu_id(rs.getInt("mid"));
				menusBean.setMenu_name(rs.getString("mname"));
				menusBean.setMenu_type(rs.getInt("mtype"));
				menusBean.setRestaurant_id(rs.getInt("rid"));
				menusBeanList.add(menusBean);
			}

			dbutil.closeDBSource(conn, pstmt, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return menusBeanList;
	}

}
