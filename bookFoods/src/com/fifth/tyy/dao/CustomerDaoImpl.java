package com.fifth.tyy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fifth.bean.CustomerBean;
import com.fifth.util.DBUtil;
public class CustomerDaoImpl implements CustomerDao {
	DBUtil dbUtil = new DBUtil();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public int login(CustomerBean customerBean) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "select * from customers  where cemail=? and cpassword=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, customerBean.getCustomer_email());
		preparedStatement.setString(2, customerBean.getCustomer_password());

		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			rows = resultSet.getInt(1);
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public CustomerBean fetchCustomerByEmail(String cemail) throws Exception {
		CustomerBean customerBean=null;
		connection = dbUtil.getConnection();
		String sql = "select * from customers  where cemail=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, cemail);
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			customerBean = new CustomerBean();
			customerBean.setCustomer_email(resultSet.getString("cemail"));
			customerBean.setCustomer_name(resultSet.getString("cusername"));
			customerBean.setCustomer_id(resultSet.getInt("cid"));
			customerBean.setCustomer_password(resultSet.getString("cpassword"));
			customerBean.setCustomer_type(resultSet.getInt("ctype"));
			
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return customerBean;
	}

	@Override
	public CustomerBean loginapp(CustomerBean bean) throws Exception {
		CustomerBean bean2 = null;
		connection = dbUtil.getConnection();
		String sql = "select * from customers c,shoppingcart s  where c.cemail=? and c.cpassword=? and c.cid=s.cid";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, bean.getCustomer_email());
		preparedStatement.setString(2, bean.getCustomer_password());

		resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
			bean2 = new CustomerBean();
			bean2.setCustomer_email(resultSet.getString("cemail"));
			bean2.setCustomer_name(resultSet.getString("cusername"));
			bean2.setCustomer_id(resultSet.getInt("cid"));
			bean2.setCustomer_password(resultSet.getString("cpassword"));
			bean2.setCustomer_type(resultSet.getInt("ctype"));
			bean2.setShoppingCart_id(resultSet.getInt("sid"));
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return bean2;
	}

}
