package com.fifth.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @功能 封装用于获取数据库连接和关闭数据库资源的通用类
 * @创建时间 2015-08-19
 * @作者 
 * @版本号 v1.0
 *
 */
public class DBUtil {
	/**
	 * @功能 用于创建数据库的连接
	 * @返回值 数据库的连接实例
	 * @throws Exception
	 *             若出现异常抛给上层调用者
	 */
	public Connection getConnection() throws Exception {
		Connection connection = null;
		String className = "com.mysql.jdbc.Driver";
		Class.forName(className).newInstance();
//		String url = "jdbc:mysql://192.168.207.51:3306/bookfoods";
		String url = "jdbc:mysql://localhost:3306/bookfoods";
		String user = "root";
		String password = "123456";
		connection = DriverManager.getConnection(url, user, password);

		return connection;
	}

	/**
	 * @功能 用于关闭数据库相关的资源
	 * @参数 connection 数据库连接实例对象
	 * @参数 preparedStatement 预编译语句的实例对象
	 * @参数 resultSet
	 * @throws Exception
	 *             若出现异常，抛给上层调用者
	 */

	public void closeDBSource(Connection connection,
			PreparedStatement preparedStatement, ResultSet resultSet)
			throws Exception {
		if (connection != null) {
			connection.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
	}

}
