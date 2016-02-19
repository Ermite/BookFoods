package com.fifth.gyj.dao;

import com.fifth.bean.CustomerBean;

public interface RegisterDao {

	public int fetchIdByCemail(String cemail) throws Exception;

	public int register(CustomerBean customerBean) throws Exception;


}
