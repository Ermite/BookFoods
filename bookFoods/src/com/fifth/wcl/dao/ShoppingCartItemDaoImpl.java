package com.fifth.wcl.dao;

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
	

}
