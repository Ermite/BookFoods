package com.fifth.gyj.biz;

import com.fifth.bean.MessagesBean;
import com.fifth.gyj.dao.ContactDao;
import com.fifth.gyj.dao.ContactDaoImpl;

public class ContactBizImpl implements ContactBiz {
	ContactDao contactDao = new ContactDaoImpl();

	@Override
	public int contact(MessagesBean messagesBean) {
		int rows = 0;
		try {
			rows = contactDao.contact(messagesBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

}
