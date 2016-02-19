package com.fifth.wcl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fifth.util.DBUtil;

public class RestaurantsDaoImpl implements RestaurantsDao {
	DBUtil dbutil = new DBUtil();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

}
