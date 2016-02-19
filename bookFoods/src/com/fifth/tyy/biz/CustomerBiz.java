package com.fifth.tyy.biz;

import com.fifth.bean.CustomerBean;

public interface CustomerBiz {

	public int login(CustomerBean customerBean);


	public CustomerBean fetchCustomerByEmail(String cemail);


	public CustomerBean loginapp(CustomerBean bean);

	

}
