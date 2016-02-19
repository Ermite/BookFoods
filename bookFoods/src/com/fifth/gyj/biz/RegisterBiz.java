package com.fifth.gyj.biz;

import com.fifth.bean.CustomerBean;

public interface RegisterBiz {

	public int fetchIdByCemail(String cemail);

	public int register(CustomerBean customerBean);


}
