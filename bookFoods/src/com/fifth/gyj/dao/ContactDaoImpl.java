package com.fifth.gyj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fifth.bean.MessagesBean;
import com.fifth.util.DBUtil;

public class ContactDaoImpl implements ContactDao {
	DBUtil dbUtil = new DBUtil();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public int contact(MessagesBean messagesBean) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "insert into messages (cname,cemail,cphone,cityname,message_info) values(?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, messagesBean.getCname());
		preparedStatement.setString(2, messagesBean.getCemail());
		preparedStatement.setInt(3, messagesBean.getCphone());
		preparedStatement.setString(4, messagesBean.getCityname());
		preparedStatement.setString(5, messagesBean.getMessage_info());

		rows = preparedStatement.executeUpdate();
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return rows;
	}

}
