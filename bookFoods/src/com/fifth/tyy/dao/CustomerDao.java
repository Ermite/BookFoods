package com.fifth.tyy.dao;

import com.fifth.bean.CustomerBean;

public interface CustomerDao {

	public int login(CustomerBean customerBean) throws Exception;

	public CustomerBean fetchCustomerByEmail(String cemail) throws Exception;

	public CustomerBean loginapp(CustomerBean bean)throws Exception;

}
