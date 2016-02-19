package com.fifth.lqk.biz;

import com.fifth.bean.CustomerBean;
import com.fifth.lqk.dao.CustomerDao;
import com.fifth.lqk.dao.CustomerDaoImpl;

public class CustomerBizImpl implements CustomerBiz {
	CustomerDao customerDao = new CustomerDaoImpl();
	@Override
	public CustomerBean findCustomerById(int customer_id) {
		CustomerBean customerBean=null;
		try {
			customerBean=customerDao.findCustomerById(customer_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customerBean;
	}

}
