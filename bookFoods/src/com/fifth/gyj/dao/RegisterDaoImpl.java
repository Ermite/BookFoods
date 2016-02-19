package com.fifth.gyj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fifth.bean.CustomerBean;
import com.fifth.util.DBUtil;

public class RegisterDaoImpl implements RegisterDao {
	DBUtil dbUtil = new DBUtil();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public int fetchIdByCemail(String cemail) throws Exception {
		int cid = 0;
		connection = dbUtil.getConnection();
		String sql = "select cid from customers where cemail=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, cemail);

		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			cid = resultSet.getInt("cid");
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return cid;
	}

	@Override
	public int register(CustomerBean customerBean) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "insert into customers (cusername,cpassword,cemail) values(?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, customerBean.getCustomer_name());
		preparedStatement.setString(2, customerBean.getCustomer_password());
		preparedStatement.setString(3, customerBean.getCustomer_email());

		rows = preparedStatement.executeUpdate();
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return rows;
	}


}
