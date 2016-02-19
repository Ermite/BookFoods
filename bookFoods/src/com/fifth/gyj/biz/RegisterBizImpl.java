package com.fifth.gyj.biz;

import com.fifth.bean.CustomerBean;
import com.fifth.gyj.dao.RegisterDao;
import com.fifth.gyj.dao.RegisterDaoImpl;

public class RegisterBizImpl implements RegisterBiz {
	RegisterDao registerDao = new RegisterDaoImpl();

	@Override
	public int fetchIdByCemail(String cemail) {
		int id = 0;
		try {
			id = registerDao.fetchIdByCemail(cemail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public int register(CustomerBean customerBean) {
		int rows = 0;
		try {
			rows = registerDao.register(customerBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}


}
