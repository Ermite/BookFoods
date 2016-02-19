package com.fifth.lqk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.fifth.bean.CustomerBean;
import com.fifth.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao {
	DBUtil dbutil = new DBUtil();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public CustomerBean findCustomerById(int customer_id) {
		CustomerBean customerBean = null;
		try {

			conn = dbutil.getConnection();
			String sql = "select * from customers where cid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				customerBean = new CustomerBean();
				customerBean.setCustomer_email(rs.getString("cemail"));
				customerBean.setCustomer_name(rs.getString("cusername"));
			}

			dbutil.closeDBSource(conn, pstmt, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return customerBean;
	}

}
