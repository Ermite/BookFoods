package com.fifth.tyy.biz;

import com.fifth.bean.CustomerBean;
import com.fifth.tyy.dao.CustomerDao;
import com.fifth.tyy.dao.CustomerDaoImpl;
public class CustomerBizImpl implements CustomerBiz {
	CustomerDao customerDao =(CustomerDao) new CustomerDaoImpl();
	public int login(CustomerBean customerBean) {
		int i = 0;
		try {
			i = customerDao.login(customerBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public CustomerBean fetchCustomerByEmail(String cemail) {
		CustomerBean customerBean =null;
		try {
			customerBean=customerDao.fetchCustomerByEmail(cemail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerBean;
	}
	@Override
	public CustomerBean loginapp(CustomerBean bean) {
		CustomerBean bean2  = null;
		try {
			bean2 = customerDao.loginapp(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean2;
	}
	
}
